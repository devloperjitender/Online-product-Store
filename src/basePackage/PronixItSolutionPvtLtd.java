package basePackage;

import java.sql.SQLException;
import java.util.*;

import LoginAndSignUpDetailsOfCustomer.CustomerDetails;
import LoginAndSignupDetailsOfAdmin.*;



public class PronixItSolutionPvtLtd {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
	   System.out.println("Enter Your Choice !!");
	   System.out.println("\t 1.Admin \n\t 2.Customer");
	   int choice= Integer.parseInt(sc.nextLine());
	   switch(choice) {
	   case 1:
		   AdminClass.getAdminDetails();
		   break;
	   case 2:
		   CustomerDetails.sigUpAndLoginCustomer();
		   break;
	    default:
	    	System.out.println("Invalid Choice Please Try Again");
	   }
	   
	}

}
