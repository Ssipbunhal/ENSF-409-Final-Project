package final_project;

import java.util.Map;
import java.util.Scanner;

import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.LoginModule;
import javax.security.auth.Subject;


public class LoginUserModule {
	public static void main (String [] args) throws LoginException {
    //Arbitrary Employees created only for testing purposes.
		Employee employeeOne = new Employee("Jack", "1234", "Admin");
		Employee employeeTwo = new Employee("Max", "124", "Cashier");
		Employee employeeThree = new Employee("James", "1471", "Employee");
		Employee employeeFour = new Employee("Cole", "1234", "Employee");
		Employee employeeFive = new Employee("Hailey", "1234", "Employee");
		Employee employeeSix = new Employee("Belle", "1234", "Employee");
		Employee [] employees = {employeeOne, employeeTwo, employeeThree, employeeFour, employeeFive, employeeSix};
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = scn.next();
		System.out.print("Enter password: ");
		String password = scn.next();
		TheLoginModule loginMod = new TheLoginModule();
		loginMod.init(employees);
		boolean loginStatus = loginMod.login(username, password);
		if (loginStatus == false) {
			while (loginStatus == false) {
				System.out.print("\nEnter username: ");
				username = scn.next();
				System.out.print("Enter password: ");
				password = scn.next();
				loginMod.init(employees);
				loginStatus = loginMod.login(username, password);
			}
		}
		LoggedIn.display(TheLoginModule.type);
		loginMod.logout();
		System.out.println("\nLogout Succesful");
	}
}
class LoggedIn {
	public static void display(String type) {
		Scanner scn = new Scanner(System.in);
		if ("Admin".compareTo(type) == 0) {
			System.out.println("\nLogged in as Admin.");
			System.out.println("0 - Logout and Exit program.\n"
					+ "1 - Search ticket(s).\n"
					+ "2 - Reserve ticket(s).\n"
					+ "3 - Print ticket(s).\n"
					+ "4 - Modify master data.\n");
			System.out.print("Select the number of the action you want to proceed with: ");
			int action = scn.nextInt();
			while (action != 0) {
				switch (action) {
				case 1:
					//call to ticket search
					break;
				case 2:
					//call to ticket reserve
					break;
				case 3:
					//call to ticket printing
					break;
				case 4:
					//call to modify master data
					break;
				default:
					System.out.println("The number entered corresponds to no action.");
				}
				System.out.println("0 - Logout and Exit program.\n"
						+ "1 - Search ticket(s).\n"
						+ "2 - Reserve ticket(s).\n"
						+ "3 - Print ticket(s).\n"
						+ "4 - Modify master data.\n");
				System.out.print("Select the number of the action you want to proceed with: ");
				action = scn.nextInt();
			}
			
		}
		else if ("Cashier".compareTo(type) == 0) {
			System.out.println("\nLogged in as Cashier.\n");
			System.out.println("0 - Logout and Exit program.\n"
					+ "1 - Process payment of ticket(s).\n");
			System.out.print("Select the number of the action you want to proceed with: ");
			int action = scn.nextInt();
			while (action != 0) {
				switch (action) {
				case 1:
					//call to update status function
					break;
				default:
					System.out.println("The number entered corresponds to no action.");
				}
				System.out.println("0 - Logout and Exit program.\n"
						+ "1 - \n");
				System.out.print("Select the number of the action you want to proceed with: ");
				action = scn.nextInt();
			}
		}
		else if ("Employee".compareTo(type) == 0) {
			System.out.println("\nLogged in as Employee.");
			System.out.println("0 - Logout and Exit program."
					+ "1 - Search ticket(s).\n"
					+ "2 - Reserve ticket(s).\n"
					+ "3 - Print ticket(s).\n");
			System.out.print("Select the number of the action you want to proceed with: ");
			int action = scn.nextInt();
			while (action != 0) {
				switch (action) {
				case 1:
					//call to ticket search
					break;
				case 2:
					//call to ticket reserve
					break;
				case 3:
					//call to ticket printing
					break;
				default:
					System.out.println("The number entered corresponds to no action.");
				}
				System.out.println("0 - Logout and Exit program.\n"
						+ "1 - Search ticket(s).\n"
						+ "2 - Reserve ticket(s).\n"
						+ "3 - Print ticket(s).\n");
				System.out.print("Select the number of the action you want to proceed with: ");
				action = scn.nextInt();
			}
		}
	}
}
class TheLoginModule implements LoginModule{
	private Employee [] employees;
	public static String type;
	@Override
	public boolean abort() throws LoginException {
		return false;
	}
	@Override
	public boolean commit() throws LoginException {
		return false;
	}
	@Override
	public void initialize(Subject arg0, CallbackHandler arg1, Map<String, ?> arg2, Map<String, ?> arg3) {
		
	}
	public void init(Employee [] employees) {
		this.employees = employees;
	}
	public boolean login(String username, String password) throws LoginException {
		for (int i = 0; i < employees.length; i++) {
			if (username.compareTo(employees[i].userID) == 0 && password.compareTo(employees[i].password) == 0) {
				System.out.println("\nLogin Succesful!");
				type = employees[i].type;
				return true;
			}
		}
		System.out.println("\nError logging in.");
		return false;
	}
	@Override
	public boolean login() throws LoginException {
		return false;
	}
	
	@Override
	public boolean logout() throws LoginException {
		return false;
	}
	
	
}
