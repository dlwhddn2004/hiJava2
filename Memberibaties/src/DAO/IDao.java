package DAO;

import java.util.List;

import VO.MemberVO;

public interface IDao {
	
	public int insert(MemberVO member);
	
	public int delete(String mem_id);
	
	public int update(MemberVO member);
	
	public List<MemberVO> search(String mem_id);
	
	public boolean duplicate(String mem_id);
	
	public List<MemberVO> showAll();
	
}
