package controller;

import java.sql.Statement;

public class update {
	connecting con = new connecting();
	Statement stmt;

	public boolean update(String table, String column, int id, String value) {
		try {
			String cmd = "UPDATE " + table + " SET " + column + " = '" + value + "' WHERE id = " + id + ";";
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
