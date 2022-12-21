package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		n = 10;
	}
	void f2() {
		StaticMethod.m =10;
	}
	void f3() {
		f2();
	}
	void f4() {
		StaticMethod.s1();
		
		s1();
	}
	
	static void s1() {
		//static method 에서는 인스턴스 변수 접근이 불가
		//n = 10;
	}
}

