package controller;

import java.sql.Statement;

public class Update {
	private Connecting con = new Connecting();
	private Statement stmt;

	public boolean update(String table, String column, int id, String value) {
		try {
			String cmd = "UPDATE " + table + " SET " + column + " = '" + value + "' WHERE id = " + id + ";";
			stmt = con.getConn().createStatement();
			stmt.executeUpdate(cmd);

			stmt.close();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
