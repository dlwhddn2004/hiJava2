package kr.or.ddit.basic;

public class T03_LamdaTest {
	static int stVar =9;
	
	public void testMethod(/* final */ int temp) {
		/* final */ int localVar = 50;
		int kor = 100;
		
		/*
		 	 람다식 내부에서 사용되는 지역변수는 모두 final 이어야 한다.
		 	 보통은 final을 붙이지 않으면 컴파일러가 자동으로 붙여준다.
		 	 단, 지역변수의 값을 변경하는 식이 있을 경우에는 자동으로 
		 	 final을 붙여주지 않는다. //메소드 안에서 람다식일경우 메소드 안에서만 상수인식
		 	 		조심해야할건 지역변수에 있는애들만 한정이다 (메서드 내에서) 그위 전역변수는 상관 없
		 */
		
		// temp = 500;
		//localVar = 2000;
		kor = 400;
		stVar +=20;
		//람다식에서 지역변수 사용하가
		LamdaTestInterface1 lt =
				() -> {
					System.out.println(stVar);
					System.out.println("temp =" + temp);
					System.out.println("localVar = " + localVar);
					//System.out.println("kor = " + kor);
					System.out.println("stVar = "+ stVar);
				};
				lt.test();

	}
		public static void main(String[] args) {
			new T03_LamdaTest().testMethod(200);
		}
		
}
