package kr.or.ddit.basic.service;

import java.util.List;

import kr.or.ddit.basic.dao.IMemberDao;
import kr.or.ddit.basic.vo.MemberVO;

public interface IMemberService {
	
	public void InsertMember();
	public void updateMember();
	public void deleteMember();
	public void selectAll();
	public void getMember();
	public void seachMember();
	
	
	
}
