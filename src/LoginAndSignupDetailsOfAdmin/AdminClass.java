package LoginAndSignupDetailsOfAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import DataBaseInformation.DbConnection;
import crudOperation.OperationOnProduct;

public class AdminClass {
	
	
	// from that Function admin can Login(Switch(case2)) And Signup (Switch(case1))
	public static void  getAdminDetails() throws ClassNotFoundException, SQLException {
		Scanner  sc= new Scanner(System.in);
		try(sc;){
			 Connection con= DbConnection.getConnection();
			 PreparedStatement ps1= con.prepareStatement("Insert into AdminDetails Values(?,?,?,?,?,?,?)");
			 PreparedStatement ps2= con.prepareStatement("Select * from AdminDetails where username=? And password=?");

			  while(true) {
			  System.out.println("******CHOICE******");
			  System.out.println("\t 1.SignUp"+"\n\t 2.Login");
			  System.out.println("Enter your choice");
			  
			  int choice= Integer.parseInt(sc.nextLine());
			  
			  switch(choice) {
			  //Admin can signup for this use case
			  case 1:
				  
				  System.out.println("Enter Admin UserName");
				  String username= sc.nextLine();
				 
				  System.out.println("Enter Admin firstName");
				  String fName= sc.nextLine();
				  System.out.println("Enter Admin lastName");
				  String lName= sc.nextLine();
				  System.out.println("Enter Admin email");
				  String email= sc.nextLine();
				  System.out.println("Enter Admin password");
				  String password= sc.nextLine();
				  System.out.println("Enter Admin salary");
				  double salary= Double.parseDouble(sc.nextLine());
				  System.out.println("Enter Admin ContactNumber");
				  long contactNumber= Long.parseLong(sc.nextLine());
				  //Loading Data to Prepared Statement
				  ps1.setString(1, username);
				  ps1.setString(2, fName);
				  ps1.setString(3, lName);
				  ps1.setString(4, email);
				  ps1.setString(5, password);
				  ps1.setDouble(6, salary);
				  ps1.setLong(7, contactNumber);
				  int k= ps1.executeUpdate();
				  if(k>0) {
					  System.out.println("Admin SignUp Succesfully");
					  
					  
				  }
				  else {
					  System.out.println("Some Problem Occur Please Try Again!");
				  }
				  break;
				  // Admin can Login based On username and password
			  case 2:
				  System.out.println("Admin Please Enter Username");
				  String userName= sc.nextLine();
				  System.out.println("Enter the Password");
				  String passWord= sc.nextLine();
				  // loading data to preparedStatement
				 ps2.setString(1, userName);
				 ps2.setString(2, passWord);
				ResultSet rs= ps2.executeQuery();
				if(rs.next()) {
					System.out.println("Welcome Admin = :"+rs.getString(2)+" "+rs.getString(3));
					System.out.println("UserName= "+rs.getString(1)+"\tFirstName :"+rs.getString(2)+"\tLastName= "+rs.getString(3)+"\tEmail:= "+rs.getString(4)+
							"\tPassword:"+rs.getString(5)+"\tSalay:"+rs.getFloat(6)+"\tContact:"+rs.getLong(7));
					
					/*After Succcessfully login now admin can Done the operation on product
					with the help of selectBasedOnChoice function which is available in
					crudOperation package under OperationOnProduct class
					*/
					
					OperationOnProduct.selectBasedOnChoice();
					
					
				}
				else {
					System.out.println("Invalid UserName/Password :Login Denied");
				}
				 break;
				 default:
					 System.out.println("Invalid Choice Please Choice Correctly!!");
				  
			  }
		  
		}
	}
	}

}
