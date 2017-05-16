package model;

public class photo {

	int id;
	int working_id;
	String date_photo;
	String name;

	public photo(int id, int working_id, String date_photo, String name) {
		super();
		this.id = id;
		this.working_id = working_id;
		this.date_photo = date_photo;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public int getWorking_id() {
		return working_id;
	}

	public String getDate_photo() {
		return date_photo;
	}

	public String getName() {
		return name;
	}

}
