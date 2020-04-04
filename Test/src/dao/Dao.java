package dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.MemberVO;

public class Dao implements IDao{
	private static Dao instance;
	private SqlMapClient smc;
	
	private Dao() {
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc =SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Dao getInstance() {
		if(instance==null) {
			instance = new Dao();
		}
		return instance;
	}
	
	@Override
	public int insert(MemberVO mv) {
		int chk=0;
		try {
			Object a = smc.insert("member.insert", mv);
			if(a == null){
				chk = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<MemberVO> selectALL() {
		List<MemberVO> list = null;
		try {
			list = smc.queryForList("member.selectAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberVO> search(String mem_id) {
		List<MemberVO> list = null;
		try {
			list = smc.queryForList("member.search", mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
