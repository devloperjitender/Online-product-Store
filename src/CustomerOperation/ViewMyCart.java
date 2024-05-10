package CustomerOperation;

import java.sql.*;

import DataBaseInformation.DbConnection;

public class ViewMyCart {

	
	
	// To See the item Which Are Available on Customer cart
	public static void seeMyCartdetails(int customerId) throws SQLException {
		Connection con= DbConnection.getConnection();
		PreparedStatement ps1= con.prepareStatement("Select * from cart where customer_id=?");
		ps1.setInt(1, customerId);
		
		ResultSet resultSet =ps1.executeQuery();
		ResultSetMetaData rsmd= resultSet.getMetaData();
		int columnCount=  rsmd.getColumnCount();
		for(int i=1;i<=columnCount;i++) {
			System.out.printf("%-20s", rsmd.getColumnName(i));
		}
		System.out.println();
		while(resultSet.next()) {
			for(int i=1;i<columnCount;i++) {
				System.out.printf("%-20s", resultSet.getString(i));
			}
			System.out.println();
		}
		/* based On this Function Customer can go back to main page  ViewProduct,AddproductToCart,
		  viewCart,Place Order etc. */
		CustomerChoice.customerChoice(customerId);
	}
}
