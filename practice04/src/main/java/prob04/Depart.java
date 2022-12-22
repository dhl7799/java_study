package prob04;

public class Depart extends Employee {
	private String depart;
	public Depart() {
		// TODO Auto-generated constructor stub
	}

	public Depart(String name, int salary,String depart) {
		super(name, salary);
		this.depart = depart;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void getInformation() {
		System.out.println( "이름:" + getName() + "  연봉:" + getSalary() + "  부서:" + this.depart);
	}

}
