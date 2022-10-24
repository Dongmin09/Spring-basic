package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.ProductVO;

public interface ProductService {
	//메소드 시그니처
	
	//PRODUCT 테이블에 insert
	public int insertProduct(ProductVO productVO);

	//상품 목록
	public List<ProductVO> list();

	//상품 상세보기
	public ProductVO selectDetail(ProductVO productVO);
	
}
