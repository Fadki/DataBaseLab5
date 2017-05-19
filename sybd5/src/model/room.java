package model;

public class Room {

	private int id;
	private int floor;
	private int worker;

	public Room(int id, int floor, int worker) {
		this.id = id;
		this.floor = floor;
		this.worker = worker;
	}

	public int getId() {
		return id;
	}

	public int getFloor() {
		return floor;
	}

	public int getWorker() {
		return worker;
	}
	
	public String toString(){
		return "" + id;
	}
}
