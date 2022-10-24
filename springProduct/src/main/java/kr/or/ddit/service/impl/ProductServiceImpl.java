package kr.or.ddit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.ProductDao;
import kr.or.ddit.service.ProductService;
import kr.or.ddit.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService{
	//의존성 주입(DI)
	//제어의 역전(IoC)
	@Autowired
	ProductDao productDao;
	
	//PRODUCT 테이블에 insert
	@Override
	public int insertProduct(ProductVO productVO) {	
		return this.productDao.insertProduct(productVO);
	}
	
	//상품 목록
	@Override
	public List<ProductVO> list(){
		return this.productDao.list();
	}

	//상품 정보
	@Override
	public ProductVO selectDetail(ProductVO productVO) {
		return this.productDao.selectDetail(productVO);
	}
	
}


