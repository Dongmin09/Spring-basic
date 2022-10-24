package filter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

//필터 클래스
public class LogFilter implements Filter {
	//필터 시작. 초기화
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("WebMarket 초기화...");
	}
	//필터 실행
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("접속한 클라이언트 IP : " + request.getRemoteAddr());
		//시스템 현재 시간(시작시간)
		long start = System.currentTimeMillis();
		System.out.println("접근한 URL 경로 : " + getURLPath(request));
		System.out.println("요청 처리 시작 시각 : " + getCurrentTime());
		
		//필터가 연속적으로 있다면 다음 필터로 제어 및 요청/응답 정보를 넘겨줌
		chain.doFilter(request, response);
		
		//시스템 현재시간(종료시간)
		long end = System.currentTimeMillis();
		System.out.println("요청 처리 종료 시각 : " + getCurrentTime());
		System.out.println("요청 처리 소요 시간 : " + (end - start) + "ms");	//1000분의 1초 단위
		System.out.println("======================================");
	}
	
	//필터 종료
	@Override
	public void destroy() {
		
	}
	
	// http://localhost/ch03/readParameterNoErrorPage.jsp?name=개똥이
	private String getURLPath(ServletRequest requst) {
		//HttpServletRequest 는 ServletRequest 를 상속
		HttpServletRequest req;
		//currentPath : URL경로 => http://localhost/ch03/readParameterNoErrorPage.jsp
		String currentPath = "";
		//queryString : 요청파라미터 => name=개똥이
		String queryString = "";
		//instanceOf 연산자는 객체가 어떤 클래스인지, 어떤 클래스를 상속받았는지 확인하는데 사용하는 연산자입니다
		if(requst instanceof HttpServletRequest) {
			req = (HttpServletRequest)requst;
			currentPath = req.getRequestURI();//http://localhost/ch03/readParameterNoErrorPage.jsp
			System.out.println("currentPath : " + currentPath);
			queryString = req.getQueryString();	//name=개똥이
			System.out.println("queryString : " + queryString);
			queryString = queryString == null?"":"?" + 	queryString; 	//?name=개똥이	
		}
		//http://localhost/ch03/readParameterNoErrorPage.jsp?name=개똥이
		return currentPath + queryString;
	}//end getURLPath()
	
	//현재 시간을 얻어오는 메소드
	private String getCurrentTime() {
		//2022/07/11 10:35:12
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//캘린더 객체 생성(싱글톤:메모리에 1번 생성하고 전역변수처럼 사용할 수 있음)
		Calendar calendar = Calendar.getInstance();
		//톰캣서버에서 제공해주는 시스템 현재 시간을 구해서 캘린더 객체에 세팅
		calendar.setTimeInMillis(System.currentTimeMillis());
		//2022/07/11 10:35:12 이러한 포맷을 준수하면서 리턴
		return formatter.format(calendar.getTime());
	}
}

















