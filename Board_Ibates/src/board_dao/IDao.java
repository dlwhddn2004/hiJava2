package board_dao;

import java.util.List;

import board_vo.BoardVO;

public interface IDao {

	public int insert_board(BoardVO board_num);
	
	public int delete_board(int board_num);
	
	public int update_board(BoardVO bv);
	
	public List<BoardVO> search_board(BoardVO bv);
	
	public List<BoardVO> All_board();
	
	public boolean get_board(int board_num);
	
}
