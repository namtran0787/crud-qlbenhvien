package ConnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCData {
	
/*
 * Connect to sql sever	
 */
	public static Connection getConnection() throws SQLException {
		
		Connection conn = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=HoSoBenhAn;user=sa;password=040503");
			System.out.println("thanhcong");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
}
/*
 * end
 */
}
