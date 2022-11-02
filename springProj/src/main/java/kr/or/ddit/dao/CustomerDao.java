package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.CustomerVO;

@Repository
public class CustomerDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// customer 테이블 insert
	public int insert(CustomerVO customerVO) {
		return this.sqlSessionTemplate.insert("customer.create",customerVO);
	}
	
	// customer 테이블  목록
	public List<CustomerVO> list(Map<String,String> map){
		return this.sqlSessionTemplate.selectList("customer.list",map);
	}
	
	//ATTACH 테이블에 다중 insert
	public int insertAttach(List<AttachVO> attachVOList) {
		return this.sqlSessionTemplate.insert("customer.insertAttach", attachVOList);
	}
	
	// CUSTOMER 테이블의 전체 행 수 구함 
	//<select id="getTotal" resultType="int">
	public int getTotal(Map<String,String> map) {
		return this.sqlSessionTemplate.selectOne("customer.getTotal", map);
	}
}
