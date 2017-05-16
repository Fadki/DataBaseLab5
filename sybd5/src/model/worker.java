package model;

public class worker {

	int id;
	String name;
	String fename;
	String middle_name;
	String date_birth;
	int function;

	public worker(int id, String name, String fename, String middle_name, String date_birth, int function) {
		super();
		this.id = id;
		this.name = name;
		this.fename = fename;
		this.middle_name = middle_name;
		this.date_birth = date_birth;
		this.function = function;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFename() {
		return fename;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public int getFunction() {
		return function;
	}

	public String getDate_birth() {
		return date_birth;
	}
	
	public String toString(){
		return "" + fename;
	}
	
	
}
