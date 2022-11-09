package kr.or.ddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import lombok.extern.slf4j.Slf4j;
/*
 	/notice/register -> loginForm -> 로그인 -> CustomLoginSuccessHandler ->
 	-> 사용자 작업.. -> /notice/register 로 다이렉트 해줌
 	(스프링 시큐리티에서 기본적으로 사용되는 구현 클래스)
 */


@Slf4j
public class CustomLoginSuccessHandler2 implements 
	AuthenticationSuccessHandler{
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	
	public void onAuthenticationSuccess(HttpServletRequest request,
		HttpServletResponse response,
		Authentication auth) throws IOException{
		
		User customUser = (User)auth.getPrincipal();
		
		log.info("username :" + customUser.getUsername());
		log.info("password :" + customUser.getPassword());
		
		SavedRequest saveRequest = requestCache.getRequest(request, response);
		String targetUrl = saveRequest.getRedirectUrl();
		
		log.info("Login Success targetUrl : " + targetUrl);
		
		response.sendRedirect(targetUrl);
		
		
	}
	// 인증 오류가 세션에 담겨있다면 인증이 성공했으므로 초기화 해주어야함
	private void onAuthenticationAttribute(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			return;
		}
		
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
	
	
	
}
