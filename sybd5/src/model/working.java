package model;

public class Working {

	private int id;
	private String dateWorking;
	private String subject;
	private int photographer;
	private int room;

	public Working(int id, String dateWorking, String subject, int photographer, int room) {
		this.id = id;
		this.dateWorking = dateWorking;
		this.subject = subject;
		this.photographer = photographer;
		this.room = room;
	}

	public int getId() {
		return id;
	}

	public String getDateWorking() {
		return dateWorking;
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
