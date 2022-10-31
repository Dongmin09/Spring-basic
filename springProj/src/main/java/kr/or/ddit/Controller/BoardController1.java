package kr.or.ddit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.MemberService1;
import kr.or.ddit.vo.Member1VO;
import lombok.extern.slf4j.Slf4j;

// 프링아 이거 자자빈 객체로 관리해줘
@RequestMapping("/board")
@Slf4j
@Controller
public class BoardController1 {
	@Autowired
	MemberService1 memberService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav,
			@RequestParam(value = "keyword", required = false) String keyword) {

		List<Member1VO> list = this.memberService.list(keyword);
		log.info("list: " + list);
		
		for(Member1VO vo:list) {
			log.info("vo : " + vo.toString());
		}
		
		//forwarding
		mav.setViewName("board/list");
		// select 결과 목록을 데이터로 넣어줌
		mav.addObject("data", list);
		
	
		return mav;
	}
}

