package prob3;

public abstract class Bird {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void fly();
	public abstract void sing();
	
	@Override
	public String toString() {
		//참새의 이름은 짹짹 입니다.
		String str = "참새의 이름은 " +this.name +" 입니다.";
		return str;
	}
}