package board_dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import board_vo.BoardVO;


public class ImplDao implements IDao {

	private SqlMapClient smc;
	private static ImplDao Instance;
	Scanner sc = new Scanner(System.in);

	   private static final Logger sqlLogger = Logger.getLogger("log4jexam.sql.Query"); //로거 생성
	   private static final Logger paramLogger = Logger.getLogger("log4jexam.sql.Query"); //로거 생성
	   private static final Logger resultLogger = Logger.getLogger(ImplDao.class); //로거 생성
	   
	
	private ImplDao() {
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ibaties 들어가기 실패!");
		}
	}

	public static ImplDao getInstance() {
		if (Instance == null) {
			Instance = new ImplDao();
		}
		return Instance;
	}

	@Override
	public int insert_board(BoardVO board_num) {
		int cnt = 0;
		try {
			Object obj = smc.insert("board.insertBoard", board_num);
			if (obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int delete_board(int board_num) {
		int cnt =0;
		try {
			cnt = smc.delete("board.deleteboard",board_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int update_board(BoardVO bv) {
		int cnt =0;
		
		try {
			cnt = smc.update("board.updateboard", bv);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> search_board(BoardVO bv) {
		List<BoardVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("board.searchboard");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BoardVO> All_board() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			list = smc.queryForList("board.Allboard");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean get_board(int board_num) {
		boolean chk = false;

		try {
			BoardVO bv = (BoardVO) smc.queryForObject("board.getboard", board_num);
			if(bv != null) {
				chk = true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return chk;
	}

}
