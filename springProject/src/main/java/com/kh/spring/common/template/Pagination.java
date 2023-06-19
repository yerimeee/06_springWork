package com.kh.spring.common.template;

import com.kh.spring.common.model.vo.PageInfo;

public class Pagination {	//PageInfo에서 만든 변수들에 담아서 보내줄 것임
	public static PageInfo getPageInfo(int totalRecord, int nowPage, int numPerPage, int pagePerBlock) {
		//totalPage, startPage, endPage 계산
		int totalPage = (int)Math.ceil((double)totalRecord / numPerPage); 
			//만약 게시글수가 54개면 10개씩 담을 때, [6]까지 페이지가 있어야 되므로 double변환
		int startPage = (nowPage-1) / pagePerBlock * pagePerBlock+1;
			// [2][3][4]처럼 [2]부터 시작이면 1/3 * 3 +1  = 2
		int endPage = startPage + pagePerBlock-1;
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		/* PageInfo pi = new PageInfo(totalRecord, nowPage, numPerPage, pagePerBlock,
		 * totalPage, startPage, endPage); return pi;
		 * 밑에서 한줄로 씀 */
		return new PageInfo(totalRecord, nowPage, numPerPage, pagePerBlock, totalPage, startPage, endPage);
	}
	
	
}
