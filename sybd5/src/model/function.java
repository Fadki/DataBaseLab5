package model;

public class function {

	int id;
	String function;
	int pay;

	public function(int id, String function, int pay) {
		super();
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
