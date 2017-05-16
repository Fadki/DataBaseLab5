package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class FindAll {
	connecting con = new connecting();
	ResultSet rs;
	Statement stmt;
	model.DB db = new model.DB();

	private boolean getTables(String command) {
		try {

			stmt = con.getConn().createStatement();
			rs = stmt.executeQuery(command);

			// stmt.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private void getFunction() {
		if (getTables("SELECT * FROM function;")) {
			model.DB.listFunction.clear();
			try {
				while (rs.next()) {
					db.listFunction.add(new model.function(rs.getInt(1), rs.getString(2), rs.getInt(3)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void getPhoto() {
		if (getTables("SELECT * FROM photo;")) {
			model.DB.listPhoto.clear();
			try {
				while (rs.next()) {
					db.listPhoto.add(new model.photo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void getPhotographer() {
		if (getTables("SELECT * FROM photographer;")) {
			model.DB.listPhotographer.clear();
			try {
				while (rs.next()) {
					db.listPhotographer.add(new model.photographer(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void getRoom() {
		if (getTables("SELECT * FROM room;")) {
			model.DB.listRoom.clear();
			try {
				while (rs.next()) {
					db.listRoom.add(new model.room(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void getWorker() {
		if (getTables("SELECT * FROM worker;")) {
			model.DB.listWorker.clear();
			try {
				while (rs.next()) {
					db.listWorker.add(new model.worker(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void getWorking() {
		if (getTables("SELECT * FROM working;")) {
			model.DB.listWorking.clear();
			try {
				while (rs.next()) {
					db.listWorking.add(new model.working(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
							rs.getInt(5)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void get(String table) {
		switch (table) {
		case "function":
			getFunction();
			break;
		case "photo":
			getPhoto();
			break;
		case "photographer":
			getPhotographer();
			break;
		case "room":
			getRoom();
			break;
		case "worker":
			getWorker();
			break;
		case "working":
			getWorking();
			break;
		default:
			break;
		}
	}
}
