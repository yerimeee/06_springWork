package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.kh.spring.member.model.vo.Member;

public class LoginInterceptor implements HandlerInterceptor {
	/*
	 * Interceptor(HandlerInterceptor)
	 * 해당 controller가 실행되기 전/후에 낚아채서 실행할 내용 작성
	 * 로그인 유무 판단, 회원 권한 체크
	 * 
	 * preHandle(전처리) : Dispatcherservlet이 컨트롤러를 호출하기 전에 낚아채는 영역
	 * postHandle(후처리): 컨트롤러 요청처리 후 Dispatcherservlet으로 뷰정보다 리턴되는 순간 낚아채는 영역
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception { 
		//로그인했는지 안 했는지 확인하는 전처리 구현
		// true 리턴시 기존 요청 흐름대로 해당 컨트롤러 실행
		// false 리턴시 컨트롤러 실행되지 않음
		
		HttpSession session = request.getSession(); //세션 사용하려고 세션 얻어옴
		Member loginMember = (Member)session.getAttribute("loginMember"); //세션에서 loginMember 값 얻어와 Member Bean에 넣어줌
		
		if(loginMember == null) {
			FlashMap flashMap = new FlashMap(); //한번만 쓰고 버릴 Map(키와 값 쌍)을 사용하기 위해 FlashMap
			flashMap.put("msg", "로그인 후 이용할 수 있습니다.");
			FlashMapManager manager = RequestContextUtils.getFlashMapManager(request); //Map에 들어있는 값 보내주기 위함
			manager.saveOutputFlashMap(flashMap, request, response); //모든 값 담아서 보내줌
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		} else {
			return true;
		}
	}
}
