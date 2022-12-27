package collection;

public class Gugudan {
	private int lValue;
	private int rValue;
	
	public Gugudan(int lValue,int rValue) {
		this.lValue = lValue;
		this.rValue = rValue;
	}

	public int getlValue() {
		return lValue;
	}

	public void setlValue(int lValue) {
		this.lValue = lValue;
	}

	public int getrValue() {
		return rValue;
	}

	public void setrValue(int rValue) {
		this.rValue = rValue;
	}
	
	public int setvalue() {
		return this.rValue *this.lValue;
	}
	@Override
    public boolean equals(Object t){
        if(t instanceof Gugudan){
            return this.lValue*this.rValue == ((Gugudan)t).lValue * ((Gugudan)t).rValue;
        } else {
            return false;
        }
    }
	@Override
    public int hashCode(){
        return this.lValue*this.rValue;
    }
}
