package model;

public class working {

	int id;
	String date_working;
	String subject;
	int photographer;
	int room;

	public working(int id, String date_working, String subject, int photographer, int room) {
		super();
		this.id = id;
		this.date_working = date_working;
		this.subject = subject;
		this.photographer = photographer;
		this.room = room;
	}

	public int getId() {
		return id;
	}

	public String getDate_working() {
		return date_working;
	}

	public String getSubject() {
		return subject;
	}

	public int getPhotographer() {
		return photographer;
	}

	public int getRoom() {
		return room;
	}
	
	public String toString(){
		return "" + id;
	}
}
