package model;

public class Function {

	private int id;
	private String function;
	private int pay;

	public Function(int id, String function, int pay) {
		this.id = id;
		this.function = function;
		this.pay = pay;
	}

	public int getId() {
		return id;
	}

	public String getFunction() {
		return function;
	}

	public int getPay() {
		return pay;
	}
	
	public String toString(){
		return "" + function;
	}

}
