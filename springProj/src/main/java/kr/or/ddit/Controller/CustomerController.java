package kr.or.ddit.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.CustomerService;
import kr.or.ddit.util.ArticlePage;
import kr.or.ddit.vo.CustomerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/board/create",method = RequestMethod.GET)
	public ModelAndView create() {

		ModelAndView mav = new ModelAndView();
		
		//WEB-INF/views/book/create.jsp
		mav.setViewName("board/create");
		// forwarding
		return mav;
	} 

	@RequestMapping(value="/board/create",method=RequestMethod.POST)
	public ModelAndView createPost(ModelAndView mav, 
			@ModelAttribute CustomerVO customerVO) {
		// INFO : kr.or.ddit.Controller.BookController - bookVO :BookVO 
		//        [bookId=0, title=123, category=123, price=333, insertDate=null]
		//log.info("customerVO :" + customerVO.toString());
		// System.out.println() 대신 로고인복을 활용하여 사용 이제부터
		
		int result = this.customerService.insert(customerVO);
		
		log.info("result : " + result);
		
		if(result<1) { // 등록 실패
			// /create(get방식) URI를 재요청
			// 책 입력 화면으로 이동
			mav.setViewName("redirect:/board/create");
		} else {
			mav.setViewName("redirect:/board/list");
		}
		return mav;
	}

	// 요청 URL : /board/list?currentPage=2
	// 요청파라미터 : currentPage =2
	@RequestMapping(value="/board/list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav,@RequestParam(defaultValue = "1", required = false) int currentPage,
			@RequestParam Map<String,String> map) {

		log.info("currentPage : " + currentPage);
		
		String cPage = map.get("currentPage");
		String show = map.get("show");
		String keyword = map.get("keyword");
		
		if(cPage==null) {
			map.put("currentPage", "1");
		}
		
		if(show==null) {
			map.put("show", "10");
		}
		if(keyword==null) {
			map.put("keyword", "");
		}
		
		
		log.info("map : " + map);
		
		List<CustomerVO> list = this.customerService.list(map);
		
		// customer 테이블의 전체 행 수 구함
		int total = this.customerService.getTotal(map);
		
		// 한 화면에 보여질 행 수
		int size = Integer.parseInt(map.get("show"));
		
		for(CustomerVO vo:list) {
			//log.info("vo : " + vo.toString());
		}
		
		//forwarding
		mav.setViewName("board/list");
		//(전체 글 수, 현재 페이지, 한화면에 보여질 행 수, select 결과 list)
		
		// select 결과 목록을 데이터로 넣어줌
		mav.addObject("data", new ArticlePage<CustomerVO>(total, currentPage, size, list));
		return mav;
	}

}
