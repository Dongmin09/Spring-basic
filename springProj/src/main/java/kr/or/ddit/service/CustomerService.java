package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.CustomerVO;

public interface CustomerService {

	// CUSTOMER 테이블에 INSERT
	public int insert(CustomerVO customerVO);

	// CUSTOMER 테이블에 List
	public List<CustomerVO> list(Map<String,String> map);

	////ATTACH 테이블에 다중 insert
	public int insertAttach(List<AttachVO> attachVOList);

	// CUSTOMER 테이블의 전체 행 수 구함 
	public int getTotal(Map<String,String> map);

	// 아이디 중복 체크
	public int chkDup(String cumId);
	
	
	
}
