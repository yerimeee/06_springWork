package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.common.SpringUtils;
import com.kh.spring.common.model.vo.PageInfo;
import com.kh.spring.common.template.Pagination;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@GetMapping("boardList.bo")
	public void boardList(@RequestParam(defaultValue="1") int nowPage, Model model) {
						//만약 앞에서 값이 안 넘어왔으면 디폴트값
		int totalRecord = boardService.selectTotalRecord(); //전체 페이지 수(13개)
		int limit = 5; //한 페이지당 게시글 5개씩 보여짐
		int offset = (nowPage -1 ) * limit; // 다음 페이지에서 불러올 게시글의 시작 숫자(2페이지는 5번부터 보여져야됨)

		RowBounds rowBounds = new RowBounds(offset, limit);
		
		PageInfo pi = Pagination.getPageInfo(totalRecord, nowPage, limit, 3); 
		//Bean 파일인 pi에 페이징 정보들 넣어줌					3은 페이징 번호의 개수 [1][2][3]...

		List<Board> boardList = boardService.selectBoardList(rowBounds);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pi", pi); //Bean pi에 들어가있는 데이터들 모두 넣어줌
	}
	
	@GetMapping("/boardForm.bo")
	public void boardForm() {}
	
	@PostMapping("/boardEnroll.bo")
	public String boardEnroll(Board board, @RequestParam MultipartFile upFile) { //사용자가 폼으로 넣은 값 Bean에 넣어줌
		String saveDirectory = application.getRealPath("/resources/upload/board");
		System.out.println(saveDirectory);
		
		if(upFile.getSize() > 0) { //파일이 없어도 빈 껍데기가 들어오므로 if처리
			String originalFilename = upFile.getOriginalFilename();
			
			//common.SpringUtils 파일 -> 파일명 바꾸기
			String changeFilename = SpringUtils.changeMultipartFile(upFile);
			
			File destFile = new File(saveDirectory, changeFilename);
			
			try {
				upFile.transferTo(destFile); //실제 저장 
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} 
			
			board.setOriginalFilename(originalFilename);
			board.setChangeFilename(changeFilename);
		} // if end
		
		int result = boardService.insertBoard(board);
		return "redirect:/board/boardList.bo";
	}
	
	@GetMapping("/boardDetail.bo")
	public void boardDetail(@RequestParam int boardNo, Model model) {
		int result = boardService.updateCountBoard(boardNo);
		
		Board board = boardService.selectOneBoard(boardNo);

		model.addAttribute("board", board);
	}
	
	/*
	 * Resource 인터페이스
	 * -UriResource : 인터넷상의 파일
	 * -ClassPathResource : classpath의 파일
	 * -FileSystemResource : 서버컴퓨터의 파일
	 * -ServletContextResource : 웹루트디렉토리의 파일
	 * -ByteArrayResource : 이전데이터
	 * 
	 * @ResponseBody: 핸들러의 반환객체를 응답메시지 바디에 직접 넣음(출력)
	 */
	@ResponseBody
	@GetMapping("/fileDownLoad.bo")
	public Resource fileDownload(@RequestParam int boardNo, HttpServletResponse response) { 
		//파일의 형태로 받아야 해서 Resource임				파일은 헤더 안에 넣어서 보내줘야 돼서 Http사용
		Board board = boardService.selectOneBoard(boardNo);
		
		String oFilename = board.getOriginalFilename();
		String cFilename = board.getChangeFilename();
		
		//한글 깨짐 방지
		try {
			oFilename = new String(oFilename.getBytes("UTF-8"), "iso-8859-1"); //톰캣의 기본인코딩을 utf-8로 변환
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		
		String saveDirectory = application.getRealPath("/resources/upload/board"); //어느 디렉토리에 있는지(여기선 save)
		File downFile = new File(saveDirectory, cFilename);
		
		// FileSystemResource에서 파일을 받을 때 - file:경로사용
		String location = "file:" + downFile; //downfile의 절대경로에 가서 파일을 가져올 수 있음
		Resource resource = resourceLoader.getResource(location);
		
		response.setContentType("appliacation/octet-stream; charset=UTF-8");
		response.addHeader("Content-Disposition", "attachment; filename=" + oFilename); //oFilename으로 사용자가 다운받을 수 있음
		
		return resource;
	}
}
