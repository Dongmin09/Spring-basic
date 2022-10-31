package kr.or.ddit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.MemberDao1;
import kr.or.ddit.service.MemberService1;
import kr.or.ddit.vo.Member1VO;

@Service
public class MemberServiceImpl1 implements MemberService1 {
	
	@Autowired
	MemberDao1 memberDao1;
	
	@Override
	public List<Member1VO> list(String keyword){
		return this.memberDao1.list(keyword);
	}
	
}
