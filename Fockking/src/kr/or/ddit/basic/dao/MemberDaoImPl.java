package kr.or.ddit.basic.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.basic.vo.MemberVO;

public class MemberDaoImPl implements IMemberDao {
  private static IMemberDao Instance;
  private SqlMapClient smc;
  
  private MemberDaoImPl() {
	  Reader rd;
	  try {
		rd=Resources.getResourceAsReader("SqlMapConfig.xml");
		smc= SqlMapClientBuilder.buildSqlMapClient(rd);
		rd.close();
	  } catch (IOException e) {
		e.printStackTrace();
	}
	  
  }
  
  
  public static  IMemberDao getInstance(){
	if(Instance == null) {
		Instance = new MemberDaoImPl();
	}
	return Instance;
}
	

  
	@Override
	public int InsertMemVO(MemberVO memid) {
		int cnt=0;
		
		try {
			Object obj = smc.insert("member.insertMember",memid);
			if(obj ==null) {
				cnt= 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(String mem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;
		try {
			list = smc.queryForList("member.selectAll");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return list;
	}

	@Override
	public boolean getMember(String mem) {
	 boolean chk=false;
	  try {
		MemberVO mv = (MemberVO) smc.queryForObject("member.selectmember", mem);
		if(mv == null) {
			chk= true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return chk;
	}

	@Override
	public MemberVO seachMemer(String mv) {
		 MemberVO mv2 = null;
		try {
			mv2 = (MemberVO) smc.queryForObject("member.seach", mv);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return mv2;
	}

	
	

}
