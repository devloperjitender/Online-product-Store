package CustomerOperation;

import java.sql.SQLException;
import java.util.*;

import LoginAndSignUpDetailsOfCustomer.CustomerDetails;

public class CustomerChoice {
  static Scanner sc= new Scanner(System.in);
  
	public static void customerChoice(int customerId) throws SQLException {
		System.out.println("****Enter your Choice****");
		System.out.println("\t1.ViewProduct"+"\n\t2.AddProductToCart"+"\n\t3.PlaceOrder"+"\n\t4.CancelOrder"+"\n\t5.ViewOrderHistory"+"\n\t6.LogOff");
		int choice= Integer.parseInt(sc.nextLine());
		switch(choice) {
		case 1:
			ViewProdctdetailsByCustomer.getProductdetails(customerId);
			break;
		case 2:
			
			CartClass.addProductToCart(customerId);
			break;
		case 3:
			PlaceOrder.getorder(customerId);
			break;
		case 4:
			CancelOrder.cancelOrder(customerId);
			break;
		case 5:
			OrderHistory.viewOrderHistory(customerId);
			break;
		case 6:
			System.out.println("LogOff Successfully");
			System.exit(0);
			break;
		}
		
	
  }
	
}
