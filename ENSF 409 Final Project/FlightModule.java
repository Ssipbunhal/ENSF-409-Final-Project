package final_project;

import java.sql.*;
import java.util.Scanner;

public class FlightModule {
	public static void main(String[] args) {
		SQL object1 = new SQL();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Source Airport: ");
		String sourceAirport = scn.next();
		System.out.println("Enter a Destination Airport: ");
		String destinationAirport = scn.next();
		object1.createConnection();
		object1.queryCommandFlight(sourceAirport, destinationAirport);
		scn.close();
		
	}

}

class SQL{
	private Connection dbConnect;
	private ResultSet results;
	
	public void createConnection(){
		try{
		this.dbConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ensf409","root", "Alex#1234");
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	
	public Ticket queryCommandFlight(String sourceAirport, String destinationAirport) {
		
	
			try {
			
			Statement myStmt = dbConnect.createStatement();
			results = myStmt.executeQuery("SELECT * FROM schedules WHERE Source Airport ='" + sourceAirport +"' AND" +",Destination Airport ='" + destinationAirport);
			if (results == null) {
				System.out.println("Selected Source Aiport to your Destination Airport was not found");
				System.exit(1);
			}
			results = myStmt.executeQuery("SELECT * FROM routes WHERE Source Airport ='" + sourceAirport +"' AND" +",Destination Airport ='" + destinationAirport);
			String airlineName = results.getString("Airline");
			Routes object1 = new Routes(airlineName, sourceAirport, destinationAirport);
			Ticket ticketObject = new Ticket(object1);
			
			
			
			
			return ticketObject;
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			closeConnection();
			return null;
		
}
	public void closeConnection() {
        try {
            this.results.close();
            this.dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        
	
}



class Countries{
	private String name;
	private String iso_Code;
	private String dafif_Code;
	
	public Countries(String name, String iso_Code, String dafif_Code){
		this.name = name;
		this.iso_Code =  iso_Code;
		this.dafif_Code = dafif_Code;
	}
	
	
	
	
}

//class airline is in another file

class Routes{
	private String airline, sourceAirport, destinationAirport, codeShare, equipement, Airline_ID, sourceAirportID, destinationAirportID;
	private int stops;
	
	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	
	public Routes(String airline,String sourceAirport, String destinationAirport) {
		this.airline = airline;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
	}
}
	
}