package crudOperation;

import java.sql.*;
import java.util.*;

import DataBaseInformation.DbConnection;

public class AddAndViewProduct {
	
	static Scanner sc= new Scanner(System.in);
	
	//with the help of this function admin can add Product
	public static void  addProduct() throws ClassNotFoundException, SQLException {
		
		Connection con= DbConnection.getConnection();
		PreparedStatement ps1= con.prepareStatement("Insert into ProductDetails values(?,?,?,?,?,?)");
		System.out.println("Enter the Product_Id");
		String productId= sc.nextLine();
		System.out.println("Enter the Product_Name");
		String productName= sc.nextLine();
		System.out.println("Enter the Product_price");
		double productPrice= Double.parseDouble(sc.nextLine());
		System.out.println("Enter the Product_qty");
		int productQty= Integer.parseInt(sc.nextLine());
		System.out.println("Enter the CompanyName of The Product");
		String companyName=sc.nextLine();
		System.out.println("Enter the Description About Product");
		String desc=sc.nextLine();
		//Loading Data To prepareStatement
		ps1.setString(1, productId);
		ps1.setString(2, productName);
		ps1.setDouble(3, productPrice);
		ps1.setInt(4, productQty);
		ps1.setString(5, companyName);
		ps1.setString(6, desc);
		
		int res=ps1.executeUpdate();
		if(res>0) {
			System.out.println("****Product Inserted SuccessFully****");
		}
		else {
			System.out.println("****Product Not Inserted Please Try Again!!");
		}
	}
	
	/*  **********************************************************************************************************/
	
	// With the help of this function Admin can view the product on diffrent functionality
	
	public static void viewProductDetails() throws SQLException, ClassNotFoundException {
		Connection con= DbConnection.getConnection();
		PreparedStatement ps1= con.prepareStatement("Select * from ProductDetails order by product_id ASC");
		PreparedStatement ps2= con.prepareStatement("Select * from ProductDetails where product_id=?");
		PreparedStatement ps3= con.prepareStatement("Select * from ProductDetails where Upper(product_name)=?");
		PreparedStatement ps4= con.prepareStatement("Select * from ProductDetails where product_price=?");
		PreparedStatement ps5= con.prepareStatement("Select * from ProductDetails where product_qty=?");
		PreparedStatement ps6= con.prepareStatement("Select * from ProductDetails where Lower(company_name)=?");
		while(true) {
			System.out.println("**Enter Your Choice To View the Product **");
			System.out.println("\t1.ViewAllProduct"+"\n\t2.ViewProductBasedOnProductId"+"\n\t3.ViewProductByName"+
			"\n\t4.ViewProductByPrice"+"\n\t5.ViewProductByQuantity\n\t6.ViewProductByCompanyName"+"\n\t7.GoBack To Main Page");
			
			int choice= Integer.parseInt(sc.nextLine());
			
			System.out.println();
			switch(choice) {
			//Admin can view All The product 
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
				//Admin can view the product based on product_id
			case 2:
				 System.out.println("Enter the Product Id");
				 String productId= sc.nextLine();
				 ps2.setString(1, productId);
				rs= ps2.executeQuery();
			
			metaData=	rs.getMetaData();
			columnCount= metaData.getColumnCount();
			//print table header(it will print the column name of the table )
			for(int i=1;i<=columnCount;i++) {
				System.out.printf("%-20s", metaData.getColumnName(i));
			}
			System.out.println();
			// Print table data(it will print the table data)
				while(rs.next()) {
					for(int i=1;i<=columnCount;i++) {
						System.out.printf("%-20s", rs.getString(i));
					}
					System.out.println();
					
				}
			
				break;
			// Admin can view The product Based on Name of the product
			case 3:
				System.out.println("Enter the Product Name ");
				String pName= sc.nextLine();
				String productName= pName.toUpperCase();
				
				ps3.setString(1, productName);
				rs=ps3.executeQuery();
				metaData= rs.getMetaData();
				columnCount=metaData.getColumnCount();
				//print table header(it will print the column name of the table )
				for(int i=1;i<=columnCount;i++) {
					System.out.printf("%-20s", metaData.getColumnName(i));
				}
				System.out.println();
				// Print table data(it will print the table data)
					while(rs.next()) {
						for(int i=1;i<=columnCount;i++) {
							System.out.printf("%-20s", rs.getString(i));
						}
						System.out.println();
						
					}
					break;
			  // admin can view the product based on price
			case 4:
				System.out.println("Enter the price Of The Product");
				double productprice= Double.parseDouble(sc.nextLine());
				ps4.setDouble(1, productprice);
				rs= ps4.executeQuery();
				metaData= rs.getMetaData();
				columnCount=metaData.getColumnCount();
				//print table header(it will print the column name of the table )
				for(int i=1;i<=columnCount;i++) {
					System.out.printf("%-20s", metaData.getColumnName(i));
				}
				System.out.println();
				// Print table data(it will print the table data)
					while(rs.next()) {
						for(int i=1;i<=columnCount;i++) {
							System.out.printf("%-20s", rs.getString(i));
						}
						System.out.println();
						
					}
					break;
		 // admin can view the product based on quantity
			case 5:
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
			 // admin can view the product based on company name of the product
			case 6:
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
				
			
			//Admin can go back to the main page (AddProduct, viewProdcut,updateProduct....)	
			case 7:
				OperationOnProduct.selectBasedOnChoice();
			       
				
				break;
				default:
					System.out.println("Please Enter Valid Choice !!");
				
			}
		}
	}

}
