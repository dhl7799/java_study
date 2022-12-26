package prob04;

public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	
	public Person() {
		numberOfPerson++;
		this.age = 12;
		this.name = "";
	}
	
	Person(String name){
		numberOfPerson++;
		this.age = 12;
		this.name = name;
	}
	
	Person(int age, String name){
		numberOfPerson++;
		this.age = age;
		this.name = name;
	}
	
	public void selfIntroduce() {
		System.out.println("내 이름은 " + this.name +"이며," + "나이는 " + this.age +" 입니다");
		
	}
    
	public static int getPopulation() {
		return numberOfPerson;
	}

}
