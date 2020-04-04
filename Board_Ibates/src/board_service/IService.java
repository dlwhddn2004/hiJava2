package board_service;

import java.util.List;

import board_vo.BoardVO;

public interface IService {

	public int insertMember(BoardVO bv);
	
	public boolean getBoard(int num);
	
	public List<BoardVO> BoardAllList();
	
	public int update(BoardVO mv);
	
	public int deleteBoard(int num);
	
	public List<BoardVO> SearchBoard(BoardVO board_num);
	

	
}
