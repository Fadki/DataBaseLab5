package controller;

import java.sql.Statement;

public class Add {

	private Connecting con = new Connecting();
	private Statement stmt;

	private boolean add(String table, String cmdEnd) {
		try {
			String cmd = "INSERT INTO " + table + " VALUES(" + cmdEnd + ");";
			stmt = con.getConn().createStatement();
			stmt.executeUpdate(cmd);

			stmt.close();

			return true;

		} catch (Exception e) {
	
			e.printStackTrace();
			return false;
		}
	}

	public boolean addFunction(String function, String pay) {
		String str ="nextval('function_id_seq'), '" + function + "', " + pay;
		if (add("function", str)) {
			return true;
		}
		return false;
	}

	public boolean addPhoto(String workingId, String datePhoto, String name) {
		String str = "nextval('photo_id_seq'), " + workingId + ", '" + datePhoto + "', '" + name + "'";
		if (add("photo", str)) {
			return true;
		}
		return false;
	}

	public boolean addPhotographer(String name, String fename, String middleName, String dateBirth) {
		String str = "nextval('photographer_id_seq'), '" + name + "', '" + fename + "', '" + middleName + "', '" + dateBirth + "'";
		if (add("photographer", str)) {
			return true;
		}
		return false;
	}

	public boolean addRoom(String floor, String worker) {
		FindFK ffk = new FindFK();
		String str ="nextval('room_id_seq'), " + floor + ", " + ffk.getIdFromFK("worker", "fename", worker);
		if (add("room", str)) {
			return true;
		}
		return false;
	}

	public boolean addWorker(String name, String fename, String middleName, String dateBirth, String function) {
		FindFK ffk = new FindFK();
		String str = "nextval('worker_id_seq'), '" + name + "', '" + fename + "', '" + middleName + "', '" + dateBirth + "', "
				+ffk.getIdFromFK("function", "function", function);
		if (add("worker", str)) {
			return true;
		}
		return false;
	}

	public boolean addWorking(String dateWorking, String subject, String photographer, String room) {
		FindFK ffk = new FindFK();
		String str ="nextval('working_id_seq'), '" + dateWorking + "', '" + subject + "', " +ffk.getIdFromFK("photographer", "name", photographer) + ", " + room;
		if (add("working", str)) {
			return true;
		}
		return false;
	}
}
