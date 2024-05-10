package CustomerOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import DataBaseInformation.DbConnection;

public class OrderHistory {
	
	
	
	public static void viewOrderHistory(int customerId) throws SQLException {
		Connection con=DbConnection.getConnection();
		PreparedStatement ps1 = con.prepareStatement("Select * from Order_Details Where customer_id=?");
		ps1.setInt(1, customerId);
		ResultSet rs=ps1.executeQuery();
		ResultSetMetaData rsmd= rs.getMetaData();
		int columnCount= rsmd.getColumnCount();
		for(int i=1;i<=columnCount;i++) {
			System.out.printf("%-20s", rsmd.getColumnName(i));
		}
		System.out.println();
		while(rs.next()) {
			for(int i=1;i<=columnCount;i++) {
				System.out.printf("%-20s", rs.getString(i));
			}
			System.out.println();
		}
		CustomerChoice.customerChoice(customerId);
	}

}
