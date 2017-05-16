package controller;

import java.sql.ResultSet;
import java.sql.Statement;

public class delete {
	connecting con = new connecting();
	Statement stmt;

	public boolean delete(String table, int id) {
		try {
			String cmd = "DELETE FROM " + table + " WHERE id = " + id + ";";
			stmt = con.getConn().createStatement();
			stmt.executeUpdate(cmd);

			stmt.close();

			FindAll fa = new FindAll();
			fa.get(table);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
