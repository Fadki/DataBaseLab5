package controller;

import java.sql.ResultSet;
import java.sql.Statement;

public class Delete {
	private Connecting con = new Connecting();
	private Statement stmt;

	public boolean delete(String table, int id) {
		try {
			String cmd = "DELETE FROM " + table + " WHERE id = " + id + ";";
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
