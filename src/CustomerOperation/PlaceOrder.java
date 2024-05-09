



package CustomerOperation;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import DataBaseInformation.DbConnection;

public class PlaceOrder {
	
	public static void getorder(int customerId) throws SQLException {
		Scanner sc= new Scanner(System.in);
		Connection con= DbConnection.getConnection();
				
				
				PreparedStatement ps1= con.prepareStatement("Select * from cart where customer_id= ?");
				PreparedStatement ps2= con.prepareStatement("INSERT INTO ORDER_DETAILS (product_id, customer_id, product_name, product_price, product_quantity, order_date, total_amount)VALUES (?,?,?,?,?,?,?)");
				PreparedStatement ps3= con.prepareStatement("DELETE FROM CART WHERE customer_id=?");
				PreparedStatement ps4= con.prepareStatement("SELECT * FROM ORDER_DETAILS WHERE customer_id=?");
				ps1.setInt(1, customerId);
			
				double total_amount=0;
				ResultSet rs= ps1.executeQuery();
				while(rs.next()) {
				    String productName= rs.getString("product_name");
				    double productPrice= rs.getDouble("product_price");
				    String productId= rs.getString("product_id");
				    int quantity= rs.getInt("Quantity");
				    total_amount= quantity*productPrice;
				    //Loading data to order_details table by using preparedStatement(ps2)
				    ps2.setString(1, productId);
				    ps2.setInt(2, customerId);
				    ps2.setString(3, productName);
				    ps2.setDouble(4, productPrice);
				    ps2.setInt(5, quantity);
				    ps2.setDate(6, new Date(System.currentTimeMillis()));
				    ps2.setDouble(7, total_amount);
				    
				    ps2.executeUpdate();
				}
				//delete cart item based on customer-id using preparedStatement(ps3)
				ps3.setInt(1, customerId);
				ps3.executeUpdate();
				
				System.out.println("Order Orderd Successfully!!");
				// View customer order what he placed
				ps4.setInt(1, customerId);
				rs=ps4.executeQuery();
				ResultSetMetaData rsmd= rs.getMetaData();
				int  columnCount= rsmd.getColumnCount();
				for(int i=1;i<=columnCount;i++) {
					System.out.printf("%-30s", rsmd.getColumnName(i));
				}
				System.out.println();
				while(rs.next()) {
					for(int i=1;i<=columnCount;i++) {
						System.out.printf("%-30s", rs.getString(i));
					}
					System.out.println();
				}
				CustomerChoice.customerChoice(customerId);
				
				
				
		
				
			
		}
	}


