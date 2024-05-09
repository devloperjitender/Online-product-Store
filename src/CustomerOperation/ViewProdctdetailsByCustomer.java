package CustomerOperation;
import java.sql.*;
import java.util.*;
import DataBaseInformation.DbConnection;
public class ViewProdctdetailsByCustomer {
	
   static Scanner sc= new Scanner(System.in);
   
	 public static void getProductdetails(int customerId) throws SQLException {

			

			Connection con= DbConnection.getConnection();
			PreparedStatement ps1= con.prepareStatement("Select * from ProductDetails");
			
			PreparedStatement ps3= con.prepareStatement("Select * from ProductDetails where Upper(product_name)=?");
			PreparedStatement ps4= con.prepareStatement("Select * from ProductDetails where product_price=?");
			PreparedStatement ps5= con.prepareStatement("Select * from ProductDetails where product_qty=?");
			PreparedStatement ps6= con.prepareStatement("Select * from ProductDetails where Lower(company_name)=?");
			while(true) {
				System.out.println("**Enter Your Choice To View the Product **");
				System.out.println("\t1.ViewAllProduct"+"\n\t2.ViewProductByName"+
				"\n\t3.ViewProductByPrice"+"\n\t4.ViewProductByQuantity\n\t5.ViewProductByCompanyName"+"\n\t6.GoBack To Main Page");
				
				int choice= Integer.parseInt(sc.nextLine());
				
				System.out.println();
				switch(choice) {
				case 1:
					ResultSet rs =ps1.executeQuery();
					ResultSetMetaData metaData= rs.getMetaData();
					int columnCount=metaData.getColumnCount();
					//print table header
					for (int i = 1; i <= columnCount; i++) {
		                System.out.printf("%-20s", metaData.getColumnName(i));
		            }
		            System.out.println();

		            // Print table data
		            while (rs.next()) {
		                for (int i = 1; i <= columnCount; i++) {
		                    System.out.printf("%-20s", rs.getString(i));
		                }
		                System.out.println();
		            }
					break;
				
				case 2:
					System.out.println("Enter the Product Name ");
					String pName= sc.nextLine();
					String productName= pName.toUpperCase();
					
					ps3.setString(1, productName);
					rs=ps3.executeQuery();
					metaData= rs.getMetaData();
					columnCount=metaData.getColumnCount();
					for(int i=1;i<=columnCount;i++) {
						System.out.printf("%-20s", metaData.getColumnName(i));
					}
					System.out.println();
						while(rs.next()) {
							for(int i=1;i<=columnCount;i++) {
								System.out.printf("%-20s", rs.getString(i));
							}
							System.out.println();
							
						}
						break;
				case 3:
					System.out.println("Enter the price Of The Product");
					double productprice= Double.parseDouble(sc.nextLine());
					ps4.setDouble(1, productprice);
					rs= ps4.executeQuery();
					metaData= rs.getMetaData();
					columnCount=metaData.getColumnCount();
					for(int i=1;i<=columnCount;i++) {
						System.out.printf("%-20s", metaData.getColumnName(i));
					}
					System.out.println();
						while(rs.next()) {
							for(int i=1;i<=columnCount;i++) {
								System.out.printf("%-20s", rs.getString(i));
							}
							System.out.println();
							
						}
						break;
				case 4:
					System.out.println("Enter the Quantity of Product");
					int productQty= Integer.parseInt(sc.nextLine());
					ps5.setInt(1, productQty);
					rs=ps5.executeQuery();
				    metaData=rs.getMetaData();
				    columnCount=metaData.getColumnCount();
				    for(int i=1;i<=columnCount;i++) {
				    	System.out.printf("%-20s", metaData.getColumnName(i));
				    }
				    System.out.println();
				    while(rs.next()) {
				    	for(int i=1;i<columnCount;i++) {
				    		System.out.printf("%-20s", rs.getString(i));
				    	}
				    	System.out.println();
				    }
				    break;
				case 5:
					System.out.println("Enter the Company Name Of the Product");
					String companyName= sc.nextLine().toLowerCase();
					ps6.setString(1, companyName);
					rs=ps6.executeQuery();
					metaData=rs.getMetaData();
					columnCount= metaData.getColumnCount();
					for(int i=1;i<columnCount;i++) {
						System.out.printf("%-20s", metaData.getColumnName(i));
					}
					System.out.println();
					
					while(rs.next()) {
						for(int i=1;i<columnCount;i++) {
							System.out.printf("%-20s", rs.getString(i));
						}
						System.out.println();
					}
					break;
					
				case 6:
					CustomerChoice.customerChoice( customerId);
				       
					
					break;
					default:
						System.out.println("Please Enter Valid Choice !!");

	                }

		
			}


	 }

}
