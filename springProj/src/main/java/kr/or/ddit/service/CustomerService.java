package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.CustomerVO;

public interface CustomerService {

	// CUSTOMER 테이블에 INSERT
	public int insert(CustomerVO customerVO);

	// CUSTOMER 테이블에 List
	public List<CustomerVO> list(String keyword);

	////ATTACH 테이블에 다중 insert
	public int insertAttach(List<AttachVO> attachVOList);
	
}
