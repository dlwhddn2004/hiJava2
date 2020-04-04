package kr.or.ddit.basic.dao;

import java.util.List;

import kr.or.ddit.basic.vo.MemberVO;

public interface IMemberDao {

	public int InsertMemVO(MemberVO memid);
	
	public int updateMember(String mem);
	
	public int deleteMember(String memid);
	
	public List<MemberVO> selectAll();
	
	public boolean getMember(String mem);
	
	public MemberVO seachMemer(String mv);
}
