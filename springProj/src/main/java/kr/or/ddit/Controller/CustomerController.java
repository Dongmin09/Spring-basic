package kr.or.ddit.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.CustomerService;
import kr.or.ddit.util.ArticlePage;
import kr.or.ddit.util.FileUploadUtil;
import kr.or.ddit.vo.CustomerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	// DI
	@Inject
	FileUploadUtil fileUploadUtil;
	
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
	
	// 요청URI : /board/chkDup
	// 요청파라미터 : {"cumId":"abc001"}
	// 방식 : post
	// jSON 데이터로 리턴. 중복이 있으면{"result":"1"}, 중복이 없으면 {"result":"0"}
	//String cumId, => 문제발생
	//@RequestParam Map<String, String> map, => 문제발생
	// 결론 : ajax로 요청된 json데이터는 무조건 RequestBody로 받자
	@ResponseBody
	@PostMapping("/board/chkDup")
	public Map<String, String> chkDup(
			@RequestBody Map<String, String> json) {
		
		log.info("json :" + json);
		
		Map<String, String> rsltmap = new HashMap<String, String>();
		
		//int result = this.customerService.chkDup(cumId);
		int result = this.customerService.chkDup(json.get("cumId"));
		
		rsltmap.put("result", result+"");
		
		return rsltmap;
		
	}
	
	/* 8. 파일 업로드 폼 방식 요청 처리
	 	파일 업로드 폼 파일 <input type="file"... 요소(=태그 ) 값을
	 	스프링 MVC가 지원하는 MultipartFile 매개변수로 처리함
	 */
	
	@GetMapping("/board/register06")
	public String register06() {
		//log.info("register06에 왓다");
		return "/board/register06";
	}
	
	// <input type="file" name="picture" />
	//MultipartFile     picture
	
	@PostMapping("/board/registerFile01")
	public String registerFile01Post(MultipartFile picture) {
		//log.info("MultipartFile01");
		//log.info("originName : " + picture.getOriginalFilename());
		//log.info("size : " + picture.getSize());
		//log.info("contentType : " + picture.getContentType());
		
		//forwarding
		return "board/success";
		
	}
	//	<p>userId : <input type="text" name="cumId" value="gegegebebe" /></p>
	//<p>password : <input type="text" name="cumId" value="java" /></p>
	// <input type="file" name="picture" />
	//MultipartFile     picture
	@PostMapping("/board/registerFile02")
	public String registerFile02Post(String userId,
			String password,
			MultipartFile picture) {
		//log.info("MultipartFile02");
		//log.info("userId : " + userId);
		//log.info("password : " + password);
		
		//log.info("originName : " + picture.getOriginalFilename());
		//log.info("size : " + picture.getSize());
		//log.info("contentType : " + picture.getContentType());
		
		//forwarding
		return "board/success";
		
	}
	//	<p>userId : <input type="text" name="cumId" value="gegegebebe" /></p>
	//<p>password : <input type="text" name="cumId" value="java" /></p>
	// <input type="file" name="picture" />
	//MultipartFile     picture
	@PostMapping("/board/registerFile03")
	public String registerFile03Post(CustomerVO customerVO,
			MultipartFile picture) {
		//log.info("registerFile03");
		//log.info("customerVO : " +customerVO.toString()  );
		
		
		//log.info("originName : " + picture.getOriginalFilename());
		//log.info("size : " + picture.getSize());
		//log.info("contentType : " + picture.getContentType());
		
		//forwarding
		return "board/success";
		
	}
	
	//	<p>userId : <input type="text" name="cumId" value="gegegebebe" /></p>
	//<p>password : <input type="text" name="cumId" value="java" /></p>
	// <input type="file" name="picture" />
	// <input type="file" name="picture2" />
	//MultipartFile     picture
	@PostMapping("/board/registerFile05")
	public String registerFile05Post(CustomerVO customerVO,
			MultipartFile picture, MultipartFile picture2) {
		//log.info("registerFile05");
		//log.info("customerVO : " +customerVO.toString()  );
		
		//log.info("originName : " + picture.getOriginalFilename());
		//log.info("size : " + picture.getSize());
		//log.info("contentType : " + picture.getContentType());
		
		//log.info("originName : " + picture2.getOriginalFilename());
		//log.info("size : " + picture2.getSize());
		//log.info("contentType : " + picture2.getContentType());
		
		//forwarding
		return "board/success";
		
	}
	//	<p>userId : <input type="text" name="cumId" value="gegegebebe" /></p>
	//<p>password : <input type="text" name="cumId" value="java" /></p>
	// <input type="file" name="picture" />
	// <input type="file" name="picture2" />
	//MultipartFile     picture
	
	// List<MultipartFile>  pictureList;
	@PostMapping("/board/registerFile06")
	public String registerFile06(CustomerVO customerVO,
			List<MultipartFile>  pictureList) {
		//log.info("registerFile06");
		//log.info("customerVO : " +customerVO.toString()  );
		
		for(MultipartFile picture : pictureList) {
			//log.info("originName : " + picture.getOriginalFilename());
			//log.info("size : " + picture.getSize());
			//log.info("contentType : " + picture.getContentType());
		}
		
		//forwarding
		return "board/success";
		
	}
	//	<p>userId : <input type="text" name="cumId" value="gegegebebe" /></p>
	//<p>password : <input type="text" name="cumId" value="java" /></p>
	// <input type="file" name="picture" />
	// <input type="file" name="picture2" />
	//MultipartFile     picture
	
	// List<MultipartFile>  pictureList;
	@PostMapping("/board/registerFile07")
	public String registerFile07(CustomerVO customerVO,
			MultipartFile[]  pictureList) {
		log.info("registerFile07");
		log.info("customerVO : " +customerVO.toString()  );
		
		MultipartFile[] pictureArray = customerVO.getPictureArray();
		
		for(MultipartFile picture : pictureArray) {
			log.info("originName : " + picture.getOriginalFilename());
			log.info("size : " + picture.getSize());
			log.info("contentType : " + picture.getContentType());
		}
		
		//forwarding
		return "board/success";
		
	}
	
	// ajax로 파일 업로드 하기
	@GetMapping("/board/register07")
	public String register07Get() {
		//forwarding
		return "board/register07";
	}
	
	//요청 URI : /board/uploadAjax
	@RequestMapping(value = "/board/uploadAjax", method = RequestMethod.POST,
			produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile[] file){
		String originalFileName =  file[0].getOriginalFilename();
		log.info("originalFileName : " + originalFileName);
		ResponseEntity<String> entity =
				new ResponseEntity<String>("SUCCESS"+originalFileName,HttpStatus.OK);
		
		UUID uid = UUID.randomUUID();
		
		this.fileUploadUtil.fileUploadAction(file, uid.toString());

		return entity;
	}
	
	
	

}
