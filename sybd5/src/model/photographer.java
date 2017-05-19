package model;

public class Photographer {
	private int id;
	private String name;
	private String fename;
	private String middleName;
	private String dateBirth;

	public Photographer(int id, String name, String fename, String middleName, String dateBirth) {
		this.id = id;
		this.name = name;
		this.fename = fename;
		this.middleName = middleName;
		this.dateBirth = dateBirth;
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

	public String getDateBirth() {
		return dateBirth;
	}
	
	public String toString(){
		return "" + name;
	}

}
