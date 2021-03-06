package kr.or.ddit.basic;

import java.awt.DisplayMode;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T02_FileTest {

	public static void main(String[] args) {

		File f1 = new File("c:/C_Other/sample.txt");
		File f2 = new File("c:/C_Other/test.txt");

		if (f1.exists()) {
			System.out.println(f1.getAbsolutePath() + " 은 존재합니다.");
		} else {
			System.out.println(f1.getAbsolutePath() + " 은 없는 파일 입니다.");
			try {
				if (f1.createNewFile()) {
					System.out.println(f1.getAbsolutePath() + " 파일을 새로 만들었습니다.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (f2.exists()) {
			System.out.println(f2.getAbsolutePath() + "은 존재합니다.");
		} else {
			System.out.println(f2.getAbsolutePath() + " 은 없는 파일입니다.");
		}
		System.out.println("--------------------------------");

		File f3 = new File("c:/C_Other");
		File[] files = f3.listFiles(); // C_Other 디렉토리안에 파일 and 디렉토리를 list형식으로 넣음
		
		for (int i = 0; i < files.length; i++) {
			System.out.print(files[i].getName() + " => ");
			if (files[i].isFile()) {
				System.out.println("파일");
			} else if (files[i].isDirectory()) {
				System.out.println("디렉토리");
			}
		}

		System.out.println("===============================");
		String[] strFiles = f3.list();
		for (String str : strFiles) {
			System.out.println(str);
		}
		System.out.println("==================================");
		// ===========================================================

		// 출력할 디렉토리 정보를 갖는 File 객체 생성
		File f4 = new File("C:/C_Lib");

		DisplayFileList(f4);

	}

	private static void DisplayFileList(File dir) {
		System.out.println("[ " + dir.getAbsolutePath() + " ] 디렉토리의 내용 ");

		// 디렉토리 안의 모든 파일 목록을 가져온다.
		File[] files = dir.listFiles();

		// 하위 디렉토리 정보를 저장할 ArrayList 생성(File배열의 첨자 저장)
		List<Integer> subDirList = new ArrayList<>();

		// 날짜를 출력하기 위한 형식 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");

		for (int i = 0; i < files.length; i++) {
			String attr = ""; // 파일의 속성(읽기,쓰기,히든디렉토리 구분)
			String size = ""; // 파일 용량

			if (files[i].isDirectory()) {
				attr = "<DIR>";
				subDirList.add(i); // 배열첨자를 List에 추가
			} else {
				size = files[i].length() + " ";
				attr = files[i].canRead() ? "R" : " "; //R은 읽을수 있음 , " "은 읽을수 없다.
				attr += files[i].canWrite() ? "W" : " "; //W 수정 가능 , " "수정 불가
				attr += files[i].isHidden() ? "H" : " ";
			}

			System.out.printf("%s %5s %12s %s\n",
					sdf.format(new Date(files[i].lastModified())), attr,
					size, files[i].getName());
		}//for문 끝
		
		int dirCnt = subDirList.size(); //폴더 안의 하위 폴더 개수 구하기
		int fileCnt = files.length - dirCnt; //폴더 안의 파일 개수 구하기
		
		System.out.println(fileCnt+ "개의 파일, "+ dirCnt+"개의 디렉토리");
		System.out.println();
		
		
		for(int i=0; i<subDirList.size(); i++) {
			//하위 폴더의 내용들도 출력하기 위해 현재 메서드를 재귀호출하여 처리한다.
			DisplayFileList(files[subDirList.get(i)]);
		}
	}
}
