package LoginAndSignUpDetailsOfCustomer;

import java.sql.*;
import java.util.*;

import CustomerOperation.CustomerChoice;
import DataBaseInformation.DbConnection;
public class CustomerDetails {
	public  int customerId;
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	static Scanner sc= new Scanner(System.in);
	
	public static  void sigUpAndLoginCustomer() throws SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement ps1=con.prepareStatement("Insert into customer Values(?,?,?,?,?,?,?)");
		PreparedStatement ps2=con.prepareStatement("Select * from  customer  where customer_id=? And password=?");
		
		while(true) {
			System.out.println("****Enter your choice****");
			System.out.println("\t1.SinnUp\n\t2.Login");
			int choice= Integer.parseInt(sc.nextLine());
			switch(choice) {
			
			case 1:
		System.out.println("Enter the Customer Id");
		int custumerId= Integer.parseInt(sc.nextLine());
		System.out.println("Enter the customer First Name :");
		String firstName= sc.nextLine();
		System.out.println("Enter the customer Last Name :");
		String lastName= sc.nextLine();
		System.out.println("Enter the customer email");
		String email= sc.nextLine();
		System.out.println("Enter the Password ");
		String password= sc.nextLine();
		System.out.println("Enter the Mobile Number");
		long mobileNumber= Long.parseLong(sc.nextLine());
		System.out.println("Enter the Address");
		String address= sc.nextLine();
		//Loading data to prepared Statement
		ps1.setInt(1, custumerId);
		ps1.setString(2, firstName);
		ps1.setString(3, lastName);
		ps1.setString(4, email);
		ps1.setString(5, password);
		ps1.setLong(6, mobileNumber);
		ps1.setString(7, address);
		
		int k=ps1.executeUpdate();
		if(k>0) {
			System.out.println("Customer SigUp Successfully!!");
		}
		else {
			System.out.println("Failed to SignUp Please Try Again Later!!");
		}
		break;
			case 2:
				System.out.println("Enter the customerId");
				int customerId= Integer.parseInt(sc.nextLine());
				System.out.println("Enter the Password !!");
				String custPassword= sc.nextLine();
				//Loading Data
				ps2.setInt(1, customerId);
				ps2.setString(2, custPassword);
				k=ps2.executeUpdate();
				if(k>0) {
					System.out.println("****User Login Successfully****");
					CustomerChoice.customerChoice(customerId);
				}
				else {
					System.out.println("Invalid CustomerId/password Logon Denied");
				}
				break;
	}
	
	 }
	}

}
