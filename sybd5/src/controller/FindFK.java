package controller;

import java.sql.ResultSet;
import java.sql.Statement;

public class FindFK {
	private Connecting con = new Connecting();
	private ResultSet rs;
	private Statement stmt;

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
	
	public int getIdFromFK(String table, String column, String value){
		try {
			if(value.equals("null")){
				return 0;
			}
			stmt = con.getConn().createStatement();
			String cmd = "SELECT id FROM " + table + " WHERE " + column + "='" + value + "';";
			rs = stmt.executeQuery(cmd);
			int a = 0;
			while(rs.next()){
			a = rs.getInt(1);
			}
			// stmt.close();
			return a;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
