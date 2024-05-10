package CustomerOperation;

import DataBaseInformation.DbConnection;
import java.sql.*;
import java.util.*;
public class CancelOrder {
	
	
	
	public static void cancelOrder(int customerId) throws SQLException {
		Connection con= DbConnection.getConnection();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Order id ");
		int orderId= Integer.parseInt(sc.nextLine());
		PreparedStatement ps1= con.prepareStatement("Delete from order_Details where order_id=?");
		ps1.setInt(1, orderId);
		int k=ps1.executeUpdate();
		if(k>0) {
			System.out.println("****Order with OrderId :="+orderId+" is deleted Successfully!!!****");
			CustomerChoice.customerChoice(customerId);
		}
		else {
			System.out.println("No Order Find with this orderId : "+orderId);
			CustomerChoice.customerChoice(customerId);
		}
		
		
	}

}
