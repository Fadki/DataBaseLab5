package model;

public class photographer {
	int id;
	String name;
	String fename;
	String middle_name;
	String date_birth;

	public photographer(int id, String name, String fename, String middle_name, String date_birth) {
		super();
		this.id = id;
		this.name = name;
		this.fename = fename;
		this.middle_name = middle_name;
		this.date_birth = date_birth;
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

	public String getDate_birth() {
		return date_birth;
	}
	
	public String toString(){
		return "" + name;
	}

}
