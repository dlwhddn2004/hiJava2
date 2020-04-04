package kr.or.ddit.basic;

/**
 * 애너테이션 사용 예제
 */
public class Service {
	@PrintAnnotation()
	public void method1() {
		System.out.println("메서드1에서 출력되었습니다.");
	}

	@PrintAnnotation(value = "%") //는 정석이나 유일하게 value 혼자만있을경우 "%"만 써줘도 된다
	public void method2() {
		System.out.println("메서드2에서 출력되었습니다.");
	}

	@PrintAnnotation(value = "#", count = 25) 
	public void method3() {
		System.out.println("메서드3에서 출력되었습니다.");
	}
}
