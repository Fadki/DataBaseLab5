package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connecting {

	private static Connection conn;

	public static Connection getConn() {
		return conn;
	}

	public boolean connect(String host, String port, String dbName, String user, String password) {
		try {

			String strcon = String.format("jdbc:postgresql://%s:%s/%s", host, port, dbName);
			conn = DriverManager.getConnection(strcon, user, password);

			if (conn == null) {
				return false;
			}
			return true;

			// Statement stmt = conn.createStatement();
			// ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			//
			// while (rs.next()) {
			// System.out.println(rs.getRow() + ". " + rs.getString("firstname")
			// + "\t" + rs.getString("lastname"));
			// }
			//
			// /**
			// * stmt.close();
			// * При закрытии Statement автоматически закрываются
			// * все связанные с ним открытые объекты ResultSet
			// */
			// stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void disconnect() {
		if (conn != null)
			try {
				conn.isClosed();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
