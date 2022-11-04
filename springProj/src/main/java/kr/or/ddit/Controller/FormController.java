package kr.or.ddit.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.vo.CustomerVO;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/form")
@Slf4j
@Controller
public class FormController {
	//<form:form modelAttribute="member" method="post" action="register">
	@GetMapping("/registerForm01")
	public String registerForm01(Model model) {
		log.info("registerForm01");
		
		//<form:input path="cumId"/>
		model.addAttribute("member", new CustomerVO());
		
		return "form/registerForm";
	}
	//<form:form modelAttribute="CustomerVO" method="post" action="register">
	@GetMapping("/registerForm02")
	public String registerForm02(@ModelAttribute CustomerVO customerVO) {
		log.info("registerForm02");

		return "form/registerForm02";
	}
	
	//<form:form modelAttribute="CustomerVO" method="post" action="register">
	//골뱅이ModelAttribute 에너테이션으로 폼 객체의 속성명을 직접 지정할수 있음
	@GetMapping("/registerForm03")
	public String registerForm03(@ModelAttribute ("custVO") CustomerVO customerVO,
				Model model) {
		log.info("registerForm03");
		
		// 폼 객체의 프로퍼티에 값을 미리 지정해 놓음
		customerVO.setCumId("gaeddong");
		customerVO.setCumName("개똥이");
		
		// password는 값을 설정하여 view에 전달하더라도 password 필드에 반영이 되지 않음
		customerVO.setPassword("java");
		
		// 체크 박스
		Map<String, String> hobbyMap = new HashMap<String, String>();
		hobbyMap.put("Sports", "Sports");
		hobbyMap.put("Music", "Music");
		hobbyMap.put("Movie", "Movie");
		
		//라디오 버튼
		Map<String, String> genderMap = new HashMap<String, String>();
		genderMap.put("Male", "Male");
		genderMap.put("Female", "Female");
		genderMap.put("Other", "Other");
		
		//셀렉트 박스
		Map<String, String> nationalityMap = new HashMap<String, String>();
		nationalityMap.put("korea", "korea");
		nationalityMap.put("Germany", "Germany");
		nationalityMap.put("Australia", "Australia");
		
		
		model.addAttribute("hobbyMap",hobbyMap);
		model.addAttribute("genderMap",genderMap);
		model.addAttribute("nationalityMap", nationalityMap);
		
		return "form/registerForm03";
	}
	
	// 요청 URI : /form/register
	// 방식 : post
	// 파라미터 : {"cumId":"gaeddong","cumName":"개똥이"}
	@PostMapping("/register")
	public String registerPost(@Validated CustomerVO customerVO, Model model,
			BindingResult result) {
		log.info("customerVO : " + customerVO.toString());
		
		//registerForm03.jsp 에서 post 요청 시 Validated 확인 후
		// 문제 발생시 폼 화면으로 돌아감
		String nextPage="";

		if(result.hasErrors()) {
	         nextPage = "form/registerForm03";
	         return nextPage;

		}
		
		String[] hobbyList = customerVO.getHobbyList();
		
		if(hobbyList!=null) {
			for(String hobby : hobbyList) {
				log.info("hobby : " +hobby);
			}
		}
		
		model.addAttribute("hobbyList", hobbyList);
		
	      nextPage = "form/success";
	      return nextPage;

		
	}
	
	
}
