package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dao.CustomerDao;
import kr.or.ddit.mapper.CustomerMapper;
import kr.or.ddit.service.CustomerService;
import kr.or.ddit.util.FileUploadUtil;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.CustomerVO;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	@Inject
	FileUploadUtil fileUploadUtil;
	
	@Autowired
	CustomerMapper customerMapper;
	
	// customer 테이블 insert
	@Transactional
	@Override
	public int insert(CustomerVO customerVO) {
		// 처리 결과 (0 또는 1)
		//customer 테이블에 insert
		this.customerMapper.insert(customerVO);
		
		//FileUploadUtil활용 -> 업로드, ATTACH 테이블 에 insert
		return this.fileUploadUtil.fileUploadAction(
				customerVO.getPictureArray(),
				customerVO.getCumId());
	}
	
	// customer 테이블 list
	@Override
	public List<CustomerVO> list(Map<String,String> map){
		return this.customerMapper.list(map);
	}
	
	//ATTACH 테이블에 다중 insert
	@Override
	public int insertAttach(List<AttachVO> attachVOList) {
		return this.customerMapper.insertAttach(attachVOList);
	}
	
	// CUSTOMER 테이블의 전체 행 수 구함 
	@Override
	public int getTotal(Map<String,String> map) {
		return this.customerMapper.getTotal(map);
	}
	
	// 아이디 ㅣ중복체크
	@Override
	public int chkDup(String cumId) {
		return this.customerMapper.chkDup(cumId);
	}
	
	// 상세 보기 (board/detail)
	@Override
	public CustomerVO detail(String cumId){
		return this.customerMapper.detail(cumId);
	}
	
}
