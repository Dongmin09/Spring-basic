package kr.or.ddit.mapper;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

public interface CustomerMapper {
	
	// customer 테이블  목록
	public List<CustomerVO> list(Map<String,String> map);
	
	// customer 테이블 insert
	public int insert(CustomerVO customerVO);
		
	//ATTACH 테이블에 다중 insert
	public int insertAttach(List<AttachVO> attachVOList);
		
	// CUSTOMER 테이블의 전체 행 수 구함 
	//<select id="getTotal" resultType="int">
	public int getTotal(Map<String,String> map);	
		
	// 아이디 ㅣ중복체크
	public int chkDup(String cumId); 
			
	
	// 상세 보기 (board/detail)
	public CustomerVO detail(String cumId);
}
