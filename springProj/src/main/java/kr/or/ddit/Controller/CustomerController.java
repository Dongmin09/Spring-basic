package kr.or.ddit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.CustomerService;
import kr.or.ddit.vo.CustomerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
//	@RequestMapping(value = "/create",method = RequestMethod.GET)
//	public ModelAndView create() {
//
//		ModelAndView mav = new ModelAndView();
//		
//		//WEB-INF/views/book/create.jsp
//		mav.setViewName("board/create");
//		// forwarding
//		return mav;
//	} 
//
//	@RequestMapping(value="/create",method=RequestMethod.POST)
//	public ModelAndView createPost(ModelAndView mav, 
//			@ModelAttribute CustomerVO customerVO) {
//		// INFO : kr.or.ddit.Controller.BookController - bookVO :BookVO 
//		//        [bookId=0, title=123, category=123, price=333, insertDate=null]
//		log.info("customerVO :" + customerVO.toString());
//		// System.out.println() 대신 로고인복을 활용하여 사용 이제부터
//		
//		int result = this.customerService.insert(customerVO);
//		
//		log.info("result : " + result);
//		
//		if(result<1) { // 등록 실패
//			// /create(get방식) URI를 재요청
//			// 책 입력 화면으로 이동
//			mav.setViewName("redirect:/create");
//		}
//		return mav;
//	}

	@RequestMapping(value="/board/list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav,
			@RequestParam(value = "keyword", required = false) String keyword) {

		List<CustomerVO> list = this.customerService.list(keyword);
		
		for(CustomerVO vo:list) {
			log.info("vo : " + vo.toString());
		}
		
		//forwarding
		mav.setViewName("board/list");
		// select 결과 목록을 데이터로 넣어줌
		mav.addObject("data", list);
		
	
		return mav;
	}

}
