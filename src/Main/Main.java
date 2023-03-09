package Main;

import java.sql.SQLException;

import ConnJDBC.JDBCData;

public class Main {
	public static void main(String[] args) throws SQLException {
		JDBCData conn = new JDBCData();
		JDBCData.getConnection();
	}
}
