package controller;

import java.sql.ResultSet;
import java.sql.Statement;

public class FindFK {
	connecting con = new connecting();
	ResultSet rs;
	Statement stmt;
	model.DB db = new model.DB();

	public String getFK(String table, String column, int value) {
		try {
			if(value == 0){
				return " ";
			}
			stmt = con.getConn().createStatement();
			String cmd = "SELECT " + column + " FROM " + table + " WHERE id=" + value + ";";
			rs = stmt.executeQuery(cmd);
			String str = "Œÿ»¡ ¿";
			while(rs.next()){
			str = rs.getString(1);
			}
			// stmt.close();
			return str;

		} catch (Exception e) {
			e.printStackTrace();
			return "Œÿ»¡ ¿";
		}
	}
}
