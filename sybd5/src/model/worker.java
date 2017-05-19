package model;

public class Worker {

	private int id;
	private String name;
	private String fename;
	private String middleName;
	private String dateBirth;
	private int function;

	public Worker(int id, String name, String fename, String middleName, String dateBirth, int function) {
		this.id = id;
		this.name = name;
		this.fename = fename;
		this.middleName = middleName;
		this.dateBirth = dateBirth;
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

	public String getMiddleName() {
		return middleName;
	}

	public int getFunction() {
		return function;
	}

	public String getDateBirth() {
		return dateBirth;
	}
	
	public String toString(){
		return "" + fename;
	}
	
	
}
