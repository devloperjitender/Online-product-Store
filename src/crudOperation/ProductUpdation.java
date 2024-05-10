package crudOperation;
import java.sql.*;
import java.util.*;
import DataBaseInformation.DbConnection;
import oracle.jdbc.proxy.annotation.Pre;

public class ProductUpdation {
	/*based on this function Admin can Able to change ProductName,price,Quantity etc */
	public static void updateProductBasedOnChoice() throws SQLException, SQLException, ClassNotFoundException {
		Scanner sc= new Scanner(System.in);
		Connection con=DbConnection.getConnection();
		PreparedStatement ps1= con.prepareStatement("Update productDetails set product_name=? where product_id=?");
		PreparedStatement ps2= con.prepareStatement("Update productDetails set product_price=? where product_id=?");
		PreparedStatement ps3= con.prepareStatement("Update productDetails set product_qty=product_qty+? where product_id=?");
		PreparedStatement ps4= con.prepareStatement("Update productDetails set product_qty=product_qty-? where product_id=?");
		PreparedStatement ps5= con.prepareStatement("Update productDetails set company_name=? where product_id=?");

		while(true) {
		System.out.println("****Enter Your Choice****");
		System.out.println("\t1.UpdateProductName"+"\n\t2.UpdateProductPrice"+"\n\t3.UpdateProductQuantity"+"\n\t4.Update CompanyName Of the Product"+"\n\t5.Back To MainPAge");
		int choice= Integer.parseInt(sc.nextLine());
		switch(choice){
		//with this Admin can change the name of the product
		case 1:
			System.out.println("Enter the New Product Name ");
			String productName= sc.nextLine();
			System.out.println("Enter the ProductId which you want to change");
			String productId= sc.nextLine();
			ps1.setString(1, productName);
			ps1.setString(2, productId);
			int k=ps1.executeUpdate();
			if(k>0) {
				System.out.println("Product Updated Successfully");
			}
			else {
				System.out.println("InvalidId/No Product Find With This ID"+productId);
			}
			break;
			//with this Admin can change the price of the product
		case 2:
			System.out.println("Enter the New Price of the Product");
			double productPrice= Double.parseDouble(sc.nextLine());
			System.out.println("Enter the ProductId which you want to change");
			 productId= sc.nextLine();
			ps2.setDouble(1, productPrice);
			ps2.setString(2, productId);
			 k=ps2.executeUpdate();
			if(k>0) {
				System.out.println("Product Updated Successfully");
			}
			else {
				System.out.println("InvalidId/No Product Find With This ID"+productId);
			}
			
			break;
			//with this Admin can increase or decrease quantity of the product
		case 3:
			System.out.println("Enter how much quantity you want to increase/decrease");
			int productQuantity= Integer.parseInt(sc.nextLine());
			System.out.println("Enter the ProductId which you want to change");
			productId= sc.nextLine();
			System.out.println("Increase press1/decrease Press2");
			int ans= Integer.parseInt(sc.nextLine());
			//checking that admin increasing or decreasing the Quantity
			switch(ans) {
			//for Quantity Increasing
			case 1:
				ps3.setInt(1, productQuantity);
				ps3.setString(2, productId);
				k=ps3.executeUpdate();
				if(k>0) {
					System.out.println("Product Quantity Increase Sussesfully!!");
				}else {
					System.out.println("Invalid ProductId");
				}
				break;
				// For decreasing the Quantity
			case 2:
				ps4.setInt(1, productQuantity);
				ps4.setString(2, productId);
				k=ps4.executeUpdate();
				if(k>0) {
					System.out.println("Product Quantity Decreases Sussesfully!!");
				}else {
					System.out.println("Invalid ProductId");
				}
				break;
			}//case 3 break here
			
			break;
			//Updating the Company name of the product Using PreparedStatement(ps5)
		case 4:
			System.out.println("Enter the New company Name ");
			String companyName= sc.nextLine();
			System.out.println("Enter the ProductId which you want to change");
			 productId= sc.nextLine();
			ps5.setString(1, companyName);
			ps5.setString(2, productId);
			k=ps5.executeUpdate();
			if(k>0) {
				System.out.println("Product Company name  Updated Successfully");
			}
			else {
				System.out.println("InvalidId/No Product Find With This ID"+productId);
			}
			
			break;
			//Admin can go back to the main page (AddProduct, viewProdcut,updateProduct....)
		case 5:
			OperationOnProduct.selectBasedOnChoice();
					
		}
	  }
	} 

}
