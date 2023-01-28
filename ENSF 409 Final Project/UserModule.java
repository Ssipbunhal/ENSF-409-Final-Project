package final_project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;



/*
class Activity{
	//Activity history information login,search, issuing a ticket, and logout must
	//be recorded in a log table in the database
}

class LinkedList{
	String activity;
	LinkedList next;
	
}
*/

class Employees{
	protected String userID;
	protected String password;
	protected String[] name;
	protected String[] contactInfo;
	protected String type = "Employee";
	
	public Employees(String userID, String password){
		this.userID = userID;
		this.password = password;
	}
	
	
}

class Admin extends Employees{
	public Admin(String userID, String password){
		super(userID,password);
		type = "Admin";
	}
	
}

public class UserModule {
	private String[] loginInformation;
	private String[] contactInformation;
	//private Activity person;
	
	
	
	public static void main (String[] args) {
		//SessionManagement lc = new
		
		
	}

}

