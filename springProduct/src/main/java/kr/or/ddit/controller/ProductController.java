package kr.or.ddit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.ProductService;
import kr.or.ddit.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView products(ModelAndView mav) {
		
		//Model
		List<ProductVO> data = this.productService.list();
		mav.addObject("data", data);
		//View
		mav.setViewName("product/products");
		
		return mav;
		
	}
	
	//URI : /addProduct
	//파라미터 : none
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("product/addProduct");
		//forwarding
		return mav;
		
	}
	
	// 상품 추가
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProductPost(ModelAndView mav, @ModelAttribute ProductVO productVO) {
		log.info("ProductVO : " + productVO.toString());
		log.info("여기는 옴");
		//PRODUCT 테이블에 insert
		//result > 0 => insert 성공, result == 0 => 실패
		int result = this.productService.insertProduct(productVO);
		
		log.info("result : " + result);
		
		if(result > 0) {//입력 성공
			mav.setViewName("redirect:/deltail?productId=" + productVO.getProductId());
		}else {//입력 실패
			mav.setViewName("redirect:/addproduct");
		}
		
		return mav;
		
	}
	
	// 상품정보
	@RequestMapping(value = "/product" , method = RequestMethod.GET)
	public ModelAndView product(ModelAndView mav, @ModelAttribute ProductVO productVO) {
		log.info("product에 왔다.");
		
		log.info("ProductVO : " + productVO.toString());
		
		ProductVO data = this.productService.selectDetail(productVO);
		
		mav.setViewName("product/product");
		mav.addObject("data", data);
		mav.addObject("productId", data.getProductId());
		return mav;
	}
	
	
}
