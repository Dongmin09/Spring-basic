package kr.or.ddit.mapper;

import kr.or.ddit.vo.MemberVO;

public interface MemberMapper {
	//회원 로그 확인
	public MemberVO read(String memId);

}
