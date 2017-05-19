package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Function;
import model.Photo;
import model.Photographer;
import model.Room;
import model.Worker;
import model.Working;

public class FindAll {
	private Connecting con = new Connecting();
	private ResultSet rs;
	private Statement stmt;

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

	public List<Function> getFunction() {
		if (getTables("SELECT * FROM function;")) {
			List<Function> list = new ArrayList<Function>();
			try {
				while (rs.next()) {
					list.add(new model.Function(rs.getInt(1), rs.getString(2), rs.getInt(3)));
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public List<Photo> getPhoto() {
		if (getTables("SELECT * FROM photo;")) {
			List<Photo> list = new ArrayList<Photo>();
			try {
				while (rs.next()) {
					list.add(new model.Photo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public List<Photographer> getPhotographer() {
		if (getTables("SELECT * FROM photographer;")) {
			List<Photographer> list = new ArrayList<Photographer>();
			try {
				while (rs.next()) {
					list.add(new model.Photographer(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5)));
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public List<Room> getRoom() {
		if (getTables("SELECT * FROM room;")) {
			List<Room> list = new ArrayList<Room>();
			try {
				while (rs.next()) {
					list.add(new model.Room(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public List<Worker> getWorker() {
		if (getTables("SELECT * FROM worker;")) {
			List<Worker> list = new ArrayList<Worker>();
			try {
				while (rs.next()) {
					list.add(new model.Worker(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6)));
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public List<Working> getWorking() {
		if (getTables("SELECT * FROM working;")) {
			List<Working> list = new ArrayList<Working>();
			try {
				while (rs.next()) {
					list.add(new model.Working(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
							rs.getInt(5)));
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}


}
