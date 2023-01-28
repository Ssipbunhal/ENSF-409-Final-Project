package final_project;

class Customer{
	//no password to login to the system
	private int id;
	private double balance;
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}


class Ticket {
	private double price;
	private String status = "available";
	private String airlineName;
	private String reservationNum;
	private Routes route;
	
	public Ticket(Routes route) {
		this.airlineName = route.getAirline();
		this.route = route;
	}
	
	public void changeStatus (Customer customer, String status, Airline [] airlines) {
		this.status = status;
		
		if (status == "booked") {
			Scanner scn = new Scanner(System.in);
			System.out.print("Enter preferred payment method (Cash or Bank): ");
			String paymentType = scn.next();
			paymentType = paymentType.toLowerCase();
			
			while (paymentType != "cash" || paymentType != "bank") {
				System.out.println("Payment method entered invalid. Try again.");
				System.out.print("Enter preferred payment method (Cash or Bank): ");
				paymentType = scn.next();
				paymentType = paymentType.toLowerCase();
			}
			int temp = 0;
			for (int i = 0; i < airlines.length; i++) {
				if (airlines[i].getAirlineName().compareTo(airlineName) == 0) {
					temp = i;
				}
			}
			
			Cashier.payment(this.price, customer, paymentType, airlines[temp]);
		}
			
	}
}

class Airline {
	private double balance = 0;
	private String airlineName, alias, iata, icao, callsign, country, active;
	private int airlineId;
	
	public String getAirlineName() {
		return airlineName;
	}	
	public double getBalance () {
		return balance;
	}
	public void setBalance (double balance) {
		this.balance = balance;
	}
}


class Cashier extends Employees{
	static double cashRegister = 0;
	static double bankBalance = 0;
	
	public Cashier(String userID,String password){
		super(userID, password);
		type = "Cashier";
	}
	
	public void updateStatus (Ticket ticket, Customer customer, String status, Airline [] airlines) {
		ticket.changeStatus(customer, status, airlines);
	}
	public void updateStatus (Ticket [] reservation, Customer customer, String status, Airline [] airlines) {
		for (int i = 0; i < reservation.length; i++) {
			reservation[i].changeStatus(customer, status, airlines);
		}
	}
	
	public static void payment(double ticketPrice, Customer customer, String paymentType, Airline airlineOne) {
		customer.setBalance(customer.getBalance() - ticketPrice);	
		airlineOne.setBalance(airlineOne.getBalance() + (ticketPrice * 0.95));
		if (paymentType.compareTo("cash") == 0) {
			cashRegister += (ticketPrice * 0.05);
		}
		else if (paymentType.compareTo("bank") == 0) {
			bankBalance += (ticketPrice * 0.05);

		}
		System.out.println("Customer Balance: " + customer.getBalance() + "\nCash Register Balance: " + cashRegister + "\nBank Balance: " + bankBalance + "\n Airline Balance: " + airlineOne.getBalance());
	}
}
