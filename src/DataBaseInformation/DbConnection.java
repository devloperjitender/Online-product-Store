package DataBaseInformation;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static Connection con;
	public DbConnection() {
		
	}
	static {
		try {
			Class.forName(DbInfo.driver);
			con= DriverManager.getConnection(DbInfo.dbUrl,DbInfo.uName,DbInfo.pWord);
		}catch(Exception e) {e.printStackTrace();}
	}
	public static Connection getConnection() {
		return con;
	}

}
