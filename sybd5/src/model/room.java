package model;

public class room {

	int id;
	int floor;
	int worker;

	public room(int id, int floor, int worker) {
		super();
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
