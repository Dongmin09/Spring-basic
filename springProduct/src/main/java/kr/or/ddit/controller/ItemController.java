package kr.or.ddit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.vo.ItemVO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

@RequestMapping("/item")
@Slf4j
@Controller
public class ItemController {
	
	private String uploadPath = "C:\\eclipse-jee-2020-06-R-win32-x86_64\\workspace\\springProduct\\src\\main\\webapp\\resources\\upload";
	
	// 상품등록 폼
	@GetMapping("/register")
	public String registerForm() {
		return "item/register";
	}
	
	// 요청 URI : /register
	// 방식 : post
	// 상품 등록 실행
	@PostMapping("/register")
	public String register(ItemVO itemVO, Model model) {
		//itemVO : ItemVO [itemId=0, itemName=샥스핀, price=10000, 
		//description=33, pictureUrl=null, pictureUrl2=null, 
		//picture=org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile@8bde980, itemAttachVOList=null]
		log.info("itemVO : " + itemVO.toString());
		
		// 파일 객체
		MultipartFile file = itemVO.getPicture();
		
		//실제 파일명
		log.info("originalName : " + file.getOriginalFilename());
		
		//파일크키
		log.info("size : " + file.getSize());
		
		//MINE Type?
		log.info("contentType : " + file.getContentType());
		
		String careateFileName = uploadFile(file.getOriginalFilename(), file);
		
		model.addAttribute("msg", "등록이완료되엇습니다.");
		return "item/success";
		
	}
	
	// 다중이미지 업로드
	//  요청 URI : /uploadFormAction
	//<input type="file" name="uploadFile" multiple>
	// *************name="uploadFile"과 MultipartFile[] uploadFile은 동일해야함
	@PostMapping("/uploadFormAction")
	public String uploadFormAction(MultipartFile[] uploadFile, Model model) {
		//MultipartFile : 스프링에서 제공해주는 타입
		/*
		 	-- 잘 쓰는 방법
		 	String.. file.getOriginalFileName() : 업로드 되는 파일의 이름(실제 팡리명)
		 	boolean.. = file.isEmpty() : 파일이 없다면 true
		 	long.. = file.getSize() : 업로드 되는 파일의 크기
		 	file.transferTo(File f): 파일을 저장
		 	
		 	--잘 안쓰는 방법
		 	String.. = file.getName()
		 	byte[].. = file.getBytes() : btte[]로 파일로 데이터 변환
		 	InputStream.. = getInputStream(); : 파일 데이터와 연결된 InputStream을 반환
		 */
		// make folder 시작 연/월/일--------------
		File uploadFolder = new File(uploadPath, getFolder());
		log.info("uploadFolder : " + uploadFolder);
		
		// 만약에.. upload >  연 > 월 > 일 폴더가 없다면 생성
		if(uploadFolder.exists()==false) {
			uploadFolder.mkdirs();
		}
		
		
		// make folder 끝--------------
		for(MultipartFile multipartFile : uploadFile) {
			log.info("================");
			//이미지 명
			log.info("Upload File Name : " + multipartFile.getOriginalFilename());
			log.info("Upload File size : " + multipartFile.getSize());
			// 서버의 어느폴더로 복사할것인지?
			// 파일명은 어떻게 되는지?
			String uploadFileName = multipartFile.getOriginalFilename();
			// before : C:_upload\test.jpg
			//after : test.jpg
			uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			
			log.info("only file name : " + uploadFileName);
			
			//----------------같은 날 같은 이미지 업로드 시 파일 중복 방지 시작-------------
			//java.util.UUID => 랜던 값 생성
			UUID uuid = UUID.randomUUID();
			//원래의 파일이름과 구분하기 위해 _를 붙임
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			
			//----------------같은 날 같은 이미지 업로드 시 파일 중복 방지 끝-------------
			// File 객체 설계(복사할 대상 경로(서버쪽), 파일명(uuid가 붙음)
			//uploadFolder : C:\\eclipse-jee-2020-06-R-win32-x86_64\\workspace\\springProduct\\src\\main\\webapp\\resources\\upload
			// 2022\\10\\28
			
			File saveFile = new File(uploadFolder, uploadFileName);
			
			// 파일 복사 실행
			try {
				multipartFile.transferTo(saveFile);
				
				
				//썸네일 처리시작---------------------------------------
				// 이미지인지 체킹
				if(checkImageType(saveFile)) { // 이미지라면
					FileOutputStream thumbnail = 
							new FileOutputStream(new File(uploadFolder, "s_" + uploadFileName));
					// 섬네일 생성
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),
							thumbnail,100,100);
					thumbnail.close();
					
				}
				
				//썸네일 처리 끝---------------------------------------
				
			} catch (IllegalStateException | IOException e) {
				log.error(e.getMessage());
			}
		}// end for
		
		model.addAttribute("message","업로드성공");
		//forwarding
		return "item/success";
		
	}
	
	@GetMapping("/uploadForm")
	public String uploadForm() {
		//forwarding
		return "item/uploadForm";
		
	}
	
	//연/월/일 폴더를 생성
	public String getFolder() {
		//2022-10-28 형식(format) 지정
		// 간단한 날짜 형식
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//날짜 객체 생성(java.util 패키지)
		Date date = new Date();
		//2022-10-28
		String str = sdf.format(date);
		//File.serparator 는 폴더 형식으 로 만듬
		return str.replace("-", File.separator);
	}
	
	//이미지인지 체킹
	// 모바일과 같은 환경에서 많은 데이터를 소비해야 하므로
	// 이미지의 경우 특별한 경우가 아니면 섬네일을 제작해줘야함
	public boolean checkImageType(File file) {
		/*	
		 	.jpeg / .jpg(JPEG 이미지)의 MINE 타입 : image/jpeg
		 */
		// MINE 타입을 통해 이미지 여부 확인
		// file.toPath() : 파일 객체를 path객체로 변환
		String contentType;
		try {
			contentType = Files.probeContentType(file.toPath());
			log.info("contentType :" + contentType);  //image/jpeg, image/png, image/gif
			//MIME 타입 정보가 image 타입으로 시작하는지 여부를 알아보자 return
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 파일을 복사(client 파일 -> 서버로 복사)
	// 파라미터 : 파일명, 파일객체의 바이트s
	private String uploadFile(String originalName, MultipartFile multipartFile) {
		// 랜덤수를 생성
		UUID uid = UUID.randomUUID();
		// 동일 이름의 파일 덮어쓰기 방지
		String createFileName = uid.toString() + "_" + originalName;
		
		// 복사 준비..
		File target = new File(uploadPath, createFileName);
		
		//복사 실행
		try {
			multipartFile.transferTo(target);
		} catch (IllegalStateException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		
		return createFileName;
		
	}
	
}
