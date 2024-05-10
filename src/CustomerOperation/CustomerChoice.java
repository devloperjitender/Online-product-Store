package CustomerOperation;

import java.sql.SQLException;
import java.util.*;

import LoginAndSignUpDetailsOfCustomer.CustomerDetails;

public class CustomerChoice {
  static Scanner sc= new Scanner(System.in);
    /* based On this Function Customer can ViewProduct,AddproductToCart, viewCart,Place Order etc. */
	public static void customerChoice(int customerId) throws SQLException {
		System.out.println("****Enter your Choice****");
		System.out.println("\t1.ViewProduct"+"\n\t2.AddProductToCart"+"\n\t3.ViewMyCart"+"\n\t4.PlaceOrder"+"\n\t5.CancelOrder"+"\n\t6.ViewOrderHistory"+"\n\t7.LogOff");
		int choice= Integer.parseInt(sc.nextLine());
		switch(choice) {
		//to View All The product Available in Product Store 
		case 1:
			ViewProdctdetailsByCustomer.getProductdetails(customerId);
			break;
			//Customer can Add the Product to cart
		case 2:
			
			CartClass.addProductToCart(customerId);
			break;
			//Customer can see their cart
		case 3:
			ViewMyCart.seeMyCartdetails(customerId);
			break;
			//Customer can Buy the Product 
		case 4:
			PlaceOrder.getorder(customerId);
			break;
			//Customer can Cancel their Order
		case 5:
			CancelOrder.cancelOrder(customerId);
			break;
			//Customer can View the History of their order
		case 6:
			OrderHistory.viewOrderHistory(customerId);
			break;
		case 7:
			System.out.println("LogOff Successfully");
			System.exit(0);
			break;
		}
		
	
  }
	
}
