package CustomerOperation;
import java.sql.*;
import java.util.*;

import DataBaseInformation.DbConnection;
public class CartClass {
	static Scanner sc= new Scanner(System.in);
	
	public static void addProductToCart(int customerId) throws SQLException {
	Connection con=	DbConnection.getConnection();
	
	PreparedStatement ps1= con.prepareStatement("Select product_name ,product_price , company_name from  ProductDetails where product_id=?");
	PreparedStatement cartItem= con.prepareStatement("Select * from cart where product_id=?");
	PreparedStatement ps2= con.prepareStatement("Insert into cart values(?,?,?,?,?,?,?)");
	System.out.println("Enter the product id ");
	String productId= sc.nextLine();
	   ps1.setString(1, productId);
	  ResultSet rs=ps1.executeQuery();
	  while(rs.next()) {
		  String productName= rs.getString("product_name");
		  double productPrice= rs.getDouble("product_price");
		  String companyName= rs.getString("company_name");
		  System.out.println("Enter the cartId");
		  String cartId= sc.nextLine();
		  System.out.println("Enter the Quantity of the Product>(LESS THAN) 9");
		  int qty= Integer.parseInt(sc.nextLine());
		  //loading data to cart id,name,price,custid,productid,qty
		  
		  PreparedStatement ps3= con.prepareStatement("Select * from cart where product_name=? and product_id=?");
		  PreparedStatement ps4= con.prepareStatement("update cart set quantity=quantity+? where customer_id=? and product_id=?");
		  ps3.setString(1, productName);
		  ps3.setString(2, productId);
		  
		  rs=ps3.executeQuery();
		  if(rs.next()) {
			  ps4.setInt(1, qty);
			  ps4.setInt(2, customerId);
			  ps4.setString(3, productId);
			  
			  int k=ps4.executeUpdate();
			  if(k>0) {
				  System.out.println("product Added to cart Successfully!!");
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
			  
		  }
		  else {
		  ps2.setString(1, cartId);
		  ps2.setString(2, productName);
		  ps2.setDouble(3, productPrice);
		  ps2.setInt(4, customerId);
		  ps2.setString(5, productId);
		  ps2.setInt(6, qty);
		  ps2.setString(7, companyName);
		  
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

}
