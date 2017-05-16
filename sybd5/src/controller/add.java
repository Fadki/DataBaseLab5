package controller;

import java.sql.Statement;

public class add {

	connecting con = new connecting();
	Statement stmt;

	private boolean add(String table, String cmdEnd) {
		try {
			String cmd = "INSERT INTO " + table + " VALUES(" + cmdEnd + ");";
			stmt = con.getConn().createStatement();
			stmt.executeUpdate(cmd);

			stmt.close();

			FindAll fa = new FindAll();
			fa.get(table);

			return true;

		} catch (Exception e) {
	
			//e.printStackTrace();
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

	public boolean addPhoto(String working_id, String date_photo, String name) {
		String str = "nextval('photo_id_seq'), " + working_id + ", '" + date_photo + "', '" + name + "'";
		if (add("photo", str)) {
			return true;
		}
		return false;
	}

	public boolean addPhotographer(String name, String fename, String middle_name, String date_birth) {
		String str = "nextval('photographer_id_seq'), '" + name + "', '" + fename + "', '" + middle_name + "', '" + date_birth + "'";
		if (add("photographer", str)) {
			return true;
		}
		return false;
	}

	public boolean addRoom(String floor, String worker) {
		String str ="nextval('room_id_seq'), " + floor + ", " + worker;
		if (add("room", str)) {
			return true;
		}
		return false;
	}

	public boolean addWorker(String name, String fename, String middle_name, String date_birth, String function) {
		String str = "nextval('worker_id_seq'), '" + name + "', '" + fename + "', '" + middle_name + "', '" + date_birth + "', "
				+ function;
		if (add("worker", str)) {
			return true;
		}
		return false;
	}

	public boolean addWorking(String date_working, String subject, String photographer, String room) {
		String str ="nextval('working_id_seq'), '" + date_working + "', '" + subject + "', " + photographer + ", " + room;
		if (add("working", str)) {
			return true;
		}
		return false;
	}
}
