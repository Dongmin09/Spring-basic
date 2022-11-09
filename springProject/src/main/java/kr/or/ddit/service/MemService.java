package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemVO;

public interface MemService {

	//메소드 시그니처
	//회원번호 생성
	public int makeUserNo();
	//중복 아이디 체크
	public int dupChk(MemVO memVO);
	//회원 및 회원권한 insert
	public int insert(MemVO memVO);
	//회원 목록
	public List<MemVO> memList(Map<String,String> map);
	//회원 전체 수(검색 포함)
	public int memTotal(Map<String, String> map);
	// 회원등록
	public int memInsert(MemVO memVO);
	
	// 새로운MEM 테이블 LIST 
	public List<MemVO> memList2();
	
	// 새로운 회원상세
	public MemVO memDetail(String userNo);
	
	// 새로운 비밀번호 체크
	public int detailPwCheck(MemVO memVO);
	
	// 새로운 회원정보 변경
	public int memUpdate(MemVO memVO);
	
	// 새로우 회원정보 삭제
	public int memDelete(String userNo);
	
	// 선생님풀이
	//public int memDelete(int userNo);
}
