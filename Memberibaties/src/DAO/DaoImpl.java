package DAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import VO.MemberVO;

public class DaoImpl implements IDao{
	
	private SqlMapClient smc;
	
	private static DaoImpl instance;
	
	private DaoImpl() {
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		}catch (IOException e) {
			System.out.println("SqlMapClient 객체 생성 실패!");
		}
		
	}
	
	public static DaoImpl getInstance() {
		if(instance == null) {
			instance = new DaoImpl();
		}
		return instance;
	}

	@Override
	public int insert(MemberVO member) {
		int chk = 0;
		
		try {
			Object var = smc.insert("Member.insert", member);
			
			if(var == null) {
				chk = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public int delete(String mem_id) {
		int chk = 0;
		
		try {
			chk = smc.delete("Member.delete", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public int update(MemberVO member) {
		int chk = 0;
		
		try {
			chk = smc.update("Member.update", member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<MemberVO> search(String mem_id) {

		List<MemberVO> member = null;
		
		try {
			member = smc.queryForList("Member.search", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public boolean duplicate(String mem_id) {
		
		boolean chk = false;
		
		try {
			MemberVO member = (MemberVO) smc.queryForObject("Member.duplicate", mem_id);
			
			if(member != null) {
				chk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public List<MemberVO> showAll() {
		List<MemberVO> list = null;
		
		try {
			list = smc.queryForList("Member.showAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
