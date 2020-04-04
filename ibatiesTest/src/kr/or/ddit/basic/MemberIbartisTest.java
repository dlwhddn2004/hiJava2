package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MemberIbartisTest {

	public static void main(String[] args) {
		//ibatis를 이용하여 DB자료를 처리하는 작업 순서
		//1. ibatis의 환경설정 파일을 읽어와 실행시킨다.
		try {
			// 1-1 xml문서 읽어오기
			Charset charset = Charset.forName("UTF-8"); // 설정파일 인코딩 정보
			
			Resources.setCharset(charset);
			
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			//1 -2 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close(); // Reader 객체 닫기
			
			//2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
			//2-1 insert 작업 연습
			System.out.println("insert작업 시작....");
			
			//1) 저장할 데이터를 VO에 담는다.
			MemberVO mv = new MemberVO();
			mv.setMem_id("d001");
			mv.setMem_name("강감찬");
			mv.setMem_tel("010-1111-1111");
			mv.setMem_addr("대전시 중구 대흥동");
			
			//2) sqlMapClient 객체 변수를 이용하여 해당 쿼리문을 실행한다.
			//형식) smc.insert("namespace값.id값", 파라미터클래스);
			//	반환값 : 성공하면 null이 반환된다.
			Object obj = smc.insert("memberTest.insertMember", mv);
			if(obj ==null) {
				System.out.println("insert작업 성공");
			}else {
				System.out.println("insert작업 실패!!");
			}
			
			
			System.out.println("----------------------------------");
			// 2-2 update 작업 연습
			// update()메서드의 반환값 => 성공한 레코드 수이다.
			System.out.println("update작업 시작");
			MemberVO mv2 = new MemberVO();
			mv2.setMem_id("d001");
			mv2.setMem_name("이순신");
			mv2.setMem_tel("010-2499-6002");
			mv2.setMem_addr("서울시 강남구 빠끄동");
			
			int cnt = smc.update("memberTest.updateMember", mv2);
			if(cnt >0) {
				System.out.println("update 작업 성공!@#!@#!");
			}else {
				System.out.println("업데이트 작업 실패다 임마");
			}
			
			
			//2-3 delete 연습
			System.out.println("delete 작업 시작...");
			
			//delete에서 반환값: 성공한 레코드 수
			int cnt2 = smc.delete("memberTest.deleteMember","d001"); //vo에 넣어도 됨 그럴떈 ##으로 꺼내와서쓰면됨
			if(cnt > 0) {
				System.out.println("delete 성공");
			}else {
				System.out.println("delete 작업 실패다 임마");
			}
			
			/*
			 * //2-4. select 연습 //1) 응답의 결과 여러개인 경우
			 * System.out.println("select 연습 시작(결과가 여러개일 경우)..."); List<MemberVO> memList;
			 * 
			 * //응답의 결과가 여러개일 경우에는 queryForList메서드를 이용한다. //이 메서드는 여러개의 레코드를 VO에 담은 후 이
			 * VO데이터를 //List에 추가해 주는 작업을 자동으로 수행한다. memList =
			 * smc.queryForList("memberTest.getMemberAll"); //전체 조회할경우 파라미터 필요 x
			 * 
			 * for(MemberVO vo : memList) { System.out.println("ID : " + vo.getMem_id());
			 * System.out.println("NAME : " + vo.getMem_name()); System.out.println("Tel : "
			 * + vo.getMem_tel()); System.out.println("Addr : " + vo.getMem_addr()); }
			 * 
			 * System.out.println("출력 끝....");
			 */
			
			//2) 응답이 1개인 경우
			System.out.println("select 연습 시작 (결과가 1개일 경우)..");
			
			//응답 결과가 1개가 확실할 경우에는 queryForObject메서드를 사용한다.
			
			MemberVO mv4 = (MemberVO) smc.queryForObject("memberTest.getMember","d001");
			System.out.println("");
			
				System.out.println("ID : " + mv4.getMem_id());
			  System.out.println("NAME : " + mv4.getMem_name());
			  System.out.println("Tel : " + mv4.getMem_tel());
			  System.out.println("Addr : " + mv.getMem_addr()); 
			  
			  System.out.println("출력 끝....");
			 
			
			
			
			
			
			
			
			}catch(IOException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
}
