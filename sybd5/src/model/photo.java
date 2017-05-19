package model;

public class Photo {

	private int id;
	private int workingId;
	private String datePhoto;
	private String name;

	public Photo(int id, int workingId, String datePhoto, String name) {
		this.id = id;
		this.workingId = workingId;
		this.datePhoto = datePhoto;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public int getWorkingId() {
		return workingId;
	}

	public String getDatePhoto() {
		return datePhoto;
	}

	public String getName() {
		return name;
	}

}
