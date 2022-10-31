package kr.or.ddit.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kr.or.ddit.vo.Member1VO;

@Repository
public class MemberDao1 {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 책목록보기
	public List<Member1VO> list(String keyword){
		// select 결과를 목록으로 받음. selectList("namespace.id", 파라미터)
		return this.sqlSessionTemplate.selectList("member1.list", keyword);
	}
}
