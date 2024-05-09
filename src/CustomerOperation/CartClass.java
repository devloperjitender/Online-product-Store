package CustomerOperation;
import java.sql.*;
import java.util.*;

import DataBaseInformation.DbConnection;
public class CartClass {
	static Scanner sc= new Scanner(System.in);
	
	public static void addProductToCart(int customerId) throws SQLException {
	Connection con=	DbConnection.getConnection();
	
	PreparedStatement ps1= con.prepareStatement("Select product_name ,product_price from  ProductDetails where product_id=?");
	PreparedStatement cartItem= con.prepareStatement("Select * from cart where product_id=?");
	PreparedStatement ps2= con.prepareStatement("Insert into cart values(?,?,?,?,?,?)");
	System.out.println("Enter the product id ");
	String productId= sc.nextLine();
	   ps1.setString(1, productId);
	  ResultSet rs=ps1.executeQuery();
	  while(rs.next()) {
		  String productName= rs.getString("product_name");
		  double productPrice= rs.getDouble("product_price");
		  System.out.println("Enter the cartId");
		  String cartId= sc.nextLine();
		 // System.out.println("Enter the customer Id");
		 // customerId= Integer.parseInt(sc.nextLine());
		  System.out.println("Enter the Quantity of the Product>(LESS THAN) 9");
		  int qty= Integer.parseInt(sc.nextLine());
		  //loading data to cart id,name,price,custid,productid,qty
		  ps2.setString(1, cartId);
		  ps2.setString(2, productName);
		  ps2.setDouble(3, productPrice);
		  ps2.setInt(4, customerId);
		  ps2.setString(5, productId);
		  ps2.setInt(6, qty);
		  
		 int k=ps2.executeUpdate();
		 if(k>0) {
			 System.out.println("Product Added To Cart successfully ");
			 cartItem.setString(1, productId);
			 rs=cartItem.executeQuery();
			 ResultSetMetaData rsmd= rs.getMetaData();
			int colCount= rsmd.getColumnCount();
			for(int i=1;i<=colCount;i++) {
				System.out.printf("%-20s", rsmd.getColumnName(i));
			}
			System.out.println();
			while(rs.next()) {
				for(int i=1;i<=colCount;i++) {
					System.out.printf("%-20s", rs.getString(i));
				}
				System.out.println();
			}
			CustomerChoice.customerChoice(customerId);
			 
		 }
		 else {
			 System.out.println("Product With Product ID= :"+productId+" Not Found");
		 }
	  }
	}

}
