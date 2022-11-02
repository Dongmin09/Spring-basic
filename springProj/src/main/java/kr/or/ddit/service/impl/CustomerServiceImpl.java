package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.CustomerDao;
import kr.or.ddit.service.CustomerService;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.CustomerVO;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	// customer 테이블 insert
	@Override
	public int insert(CustomerVO customerVO) {
		// 처리 결과 (0 또는 1)
		return this.customerDao.insert(customerVO);
	}
	
	// customer 테이블 list
	@Override
	public List<CustomerVO> list(Map<String,String> map){
		return this.customerDao.list(map);
	}
	
	//ATTACH 테이블에 다중 insert
	@Override
	public int insertAttach(List<AttachVO> attachVOList) {
		return this.customerDao.insertAttach(attachVOList);
	}
	
	// CUSTOMER 테이블의 전체 행 수 구함 
	@Override
	public int getTotal(Map<String,String> map) {
		return this.customerDao.getTotal(map);
	}
	
}
