package crudOperation;

import java.sql.SQLException;
import java.util.Scanner;

public class OperationOnProduct {
	
	public static void  selectBasedOnChoice() throws ClassNotFoundException, SQLException {
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("****Enter your Choice****");
			
			System.out.println("\t1.AddProduct"+"\n\t2.ViewAllProduct"+"\n\t3.UpdateProduct"+"\n\t4.DeleteOperationOnProduct"+"\n\t5.Stop Operation");
			int choice= Integer.parseInt(sc.nextLine());
			 
			switch(choice) {
			case 1:
				AddAndViewProduct.addProduct();
				break;
			case 2:
				AddAndViewProduct.viewProductDetails();
				break;
			case 3:
				ProductUpdation.updateProductBasedOnChoice();
				break;
			case 4:
				DeleteOperation.deleteProductDetails();
				break;
			case 5:
				System.out.println("Operation stop Sucessfully!!");
				System.exit(0);
			default:
				System.out.println("Invalid Input please Try Again!!");
			 
			 }
		}
		
	}

}
