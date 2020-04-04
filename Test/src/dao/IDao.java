package dao;

import java.util.List;

import vo.MemberVO;

public interface IDao {

	public int insert(MemberVO mv);
	public List<MemberVO> selectALL();
	public List<MemberVO> search(String mem_id);
}
