package prob03;

import prob01.Gugudan;

public class Money {
	private int amount;
	
	public Money(int amount) {
		this.amount = amount;
	}
	

    public boolean equals(int t){
        return t == this.amount;
    }
    
    public int add(Money m) {
    	return this.amount + m.amount;
    }

    public int minus(Money m) {
    	return this.amount - m.amount;
    }
    
    public int multiply(Money m) {
    	return this.amount * m.amount;
    }
    
    public int devide(Money m) {
    	return this.amount / m.amount;
    }


}
