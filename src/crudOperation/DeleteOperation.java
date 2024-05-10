package crudOperation;

import DataBaseInformation.DbConnection;
import java.sql.*;
import java.util.*;
public class DeleteOperation {
	 static Scanner sc= new Scanner(System.in);
	//All the deletd operation perform with this function
	public static void deleteProductDetails() throws SQLException, ClassNotFoundException {
		
		Connection con= DbConnection.getConnection();
		PreparedStatement ps1= con.prepareStatement("DELETE FROM PRODUCTDETAILS WHERE product_id=?");

		PreparedStatement ps2= con.prepareStatement("DELETE FROM PRODUCTDETAILS WHERE product_name=?");
		PreparedStatement ps3= con.prepareStatement("DELETE FROM PRODUCTDETAILS WHERE product_price=?");
		PreparedStatement ps4= con.prepareStatement("DELETE FROM PRODUCTDETAILS WHERE product_qty=?");
		PreparedStatement ps5= con.prepareStatement("DELETE FROM PRODUCTDETAILS WHERE company_name=?");
		
		while(true) {
		System.out.println("****Enter your Choice****");
		System.out.println("\n\t1.DeleteProductBasedOnProductId"+"\n\t2.DeleteProductByName"+
				"\n\t3.deleteProductByPrice"+"\n\t4.deleteProductByQuantity\n\t5.deleteProductByCompanyName"+"\n\t6.GoBack To Main Page");
		int choice= Integer.parseInt(sc.nextLine());
		switch(choice) {
		//deleting product based on ProductId using PreparedStatement (ps1)
		case 1 :
			System.out.println("Enter the Id of the product you want to delete!!");
			String productId= sc.nextLine();
			ps1.setString(1, productId);
			int k=ps1.executeUpdate();
			if(k>0) {
				System.out.println("product with id ="+productId+" deleted Successfully!!");
			}
			else {
				System.out.println("Invalid Product ID");
			}
			break;
			//deleting product based on ProductName using PreparedStatement (ps2)
		case 2:
			System.out.println("Enter the Name Of the Product !!!");
			String productName= sc.nextLine();
			ps2.setString(1, productName);
			k=ps2.executeUpdate();
			if(k>0) {
				System.out.println("Product with Name :="+productName+" deleted sussesfully!!");
			}
			else {
				System.out.println("No product find with name :="+productName);
			}
			break;
			//deleting product based on ProductPrice using PreparedStatement (ps3)
		case 3:
			System.out.println("Enter the price of the product");
			double productPrice= Double.parseDouble(sc.nextLine());
			ps3.setDouble(1, productPrice);
			k=ps3.executeUpdate();
			if(k>0) {
				System.out.println("Product Deleted based on price");
			}
			else {
				System.out.println("No product Found with price :="+productPrice);
			}
			break;
			//deleting product based on ProducctQuantity using PreparedStatement (ps4)
		case 4:
			System.out.println("Enter the Quantity of the product you want to delete");
			int productQty= Integer.parseInt(sc.nextLine());
			ps4.setInt(1, productQty);
			k=ps4.executeUpdate();
			if(k>0) {
				System.out.println("Product deleted with Quantity:="+productQty);
			}
			else {
				System.out.println("No Prodcut having the Quantity :="+productQty);
			}
			break;
			//deleting product based on Product company name  using PreparedStatement (ps5)
		case 5:
			System.out.println("Enter the Product Company Name :");
			String productCompany= sc.nextLine();
			ps5.setString(1, productCompany);
			k=ps5.executeUpdate();
			if(k>0) {
				System.out.println("Product Deleted Whosec ompany name =:"+productCompany);
			}
			else {
				System.out.println("No product Found with Company Name :="+productCompany);
			}
			break;
			//Admin can go back to the main page (AddProduct, viewProdcut,updateProduct....)
		case 6:
			OperationOnProduct.selectBasedOnChoice();
			break;
		}
		
		

		}
	}

}
