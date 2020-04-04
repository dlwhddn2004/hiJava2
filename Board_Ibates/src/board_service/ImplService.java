package board_service;

import java.util.List;

import board_dao.IDao;
import board_dao.ImplDao;
import board_vo.BoardVO;

public class ImplService implements IService{

	private static ImplService Instance;
	private IDao dao;
	
	private ImplService() {
		dao = ImplDao.getInstance();
	}
	
	public static ImplService getInstance() {
		if(Instance ==null) {
			Instance = new ImplService();
		}
		return Instance;
	}
	

	@Override
	public int insertMember(BoardVO bv) {
		
		return dao.insert_board(bv);
	}

	@Override
	public boolean getBoard(int num) {
		// TODO Auto-generated method stub
		return dao.get_board(num);
	}

	@Override
	public List<BoardVO> BoardAllList() {
		
		return dao.All_board();
	}

	@Override
	public int update(BoardVO bv) {
		// TODO Auto-generated method stub
		return dao.update_board(bv);
	}

	@Override
	public int deleteBoard(int num) {
		// TODO Auto-generated method stub
		return dao.delete_board(num);
	}

	@Override
	public List<BoardVO> SearchBoard(BoardVO board_num) {
		
		return dao.search_board(board_num);
	}
	
}
