
/**
 * Purpose: Data Structure and Algorithms Project
 * Status: complete
 * Last update: 12/06/14
 * Submitted:  12/08/14
 * Comment: text based menu class
 * @author: Yusef(Joe) Cardona, Hawiar Hussein
 * @version: 2014.12.08
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {

	/**
	 *  The reader that will be used for all of the user input.
	 */
	protected static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

	/**
	 *  String used for taking input from the user
	 */
	private static String checkString = "";

	/**
	 *  The movie theater that will be used for the application 
	 */
	
	private static MovieTheater movieTheater;
	/**
	 * boolean used for the round robin method of the second case
	 * for when a customer goes to purchase a ticket
	 */
	private static boolean firstOption2 = true;
	
	/**
	 * theater class variable used to represent the interstellar movie theater
	 */
	private static Theater interstellar;
	/**
	 * theater class variable used to represent the maleficent movie theater
	 */
	private static Theater maleficent;
	

	/**
	 * The main method.
	 * 
	 * @author Hawiar Hussein, Yusef (Joe) Cardona 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(String args[]) throws IOException {
		System.out.println("Welcome to the Wonderful Movie Theater Program!");
		System.out.println("   Tonight's features are:");
		System.out.println("        'Interstellar' and 'Maleficent' ");

		formTheaters();
		boolean done = false;
		do {
			System.out
					.println("Select an operation from the following menu: "
							+ "\n     1. Customer(s) enter(s) movie theater"
							+ "\n     2. Customer buys ticket(s)."
							+ "\n     3. Customer(s) leave(s) the theater."
							+ "\n     4. Display info about customers waiting for tickets."
							+ "\n     5. Display seating chart for Interstellar movie theater."
							+ "\n     6. Display seating chart for Maleficent movie theater."
							+ "\n     7. Display number of tickets sold and total earnings"
							+ "\n     8. End the program.\n");
			System.out.print(">>Make your menu selection now: ");
			checkString = br.readLine();
			System.out.println(checkString);

			switch (checkString) {
			case "1":
				newCustomer();
				break;

			case "2":
				if (firstOption2) 
				{
					firstTime();
				}
				emptyLine();
				break;

			case "3":			
			System.out.println(customerLeaves());
				break;
			case "4":
				movieTheater.printLines();
				break;
				
			case "5":
				System.out.println("The status of the Interstellar movie theater");
				System.out.println(interstellar.toString());
				break;
			case "6":
				System.out.println("The status of the Maleficent movie theater");
				System.out.println(maleficent.toString());
				break;
			case "7":
				System.out.println(movieTheater.getInterstellarTickets() 
						+ " tickets sold for the Interstellar movie.");
				System.out.println(movieTheater.getMaleficentTickets() 
						+ " tickets sold for the Maleficent movie.");
				System.out.println("Total earnings: " + movieTheater.getTotalEarnings());
			    break;
				
			case "8":
				done = true;
				break;
			}// end switch
		} while (done != true);
	}

	/**
	 * This is called first in the main method to construct the theaters that
	 * are going to contain the groups for the movie it constructs the theaters
	 * based on the input from the user asking for the amount of rows and seats
	 * for each theater.
	 *
	 * @author Joe, Hawiar
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void formTheaters() throws IOException {
		int intSeats = 0;
		int malSeats = 0;
		int intRows = 0;
		int malRows = 0;
		double ticketPrice = 0;
		// Maleficent: Rows
		boolean rowDone = false;
		System.out.println("Please specify the size of the movie theaters.");
		System.out.println("Enter information about the Maleficent movie theater: ");
		do {
			System.out.print(">>Enter number of rows: ");
			String maleficentRows = br.readLine();
			try {
				malRows = Integer.parseInt(maleficentRows);
				if (malRows > 0) {
					System.out.println(malRows);
					rowDone = true;
				} else {
					System.out.println("\n Please enter a positive number.");
				}
			} catch (NumberFormatException e) {
				System.out
						.println("Maleficent input is not a "
								+ "number please input a number for the amount of rows");

			}
		} while (rowDone != true);
		rowDone = false;
		// +++++++++++++++++++++++++++++++++++++++++++++++
		// Maleficent: Seats per row
		// +++++++++++++++++++++++++++++++++++++++++++++++
		do {
			System.out.print(">> Enter number of seats in a row: ");
			String maleficentSeatS = br.readLine().trim();

			try {
				malSeats = Integer.parseInt(maleficentSeatS);
				if (malSeats > 0) {
					System.out.println(malSeats);
					rowDone = true;
				} else {
					System.out.println("\n Please enter a positive number.");
				}
			} catch (NumberFormatException e) {
				System.out
						.println("Maleficent input is not a "
								+ "number please input a number for the amount of rows");

			}

		} while (rowDone != true);
		rowDone = false;
		// +++++++++++++++++++++++++++++++++++++++++++++++
		// Interstellar: Rows
		// +++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(">>Enter information about the Interstellar movie theater: ");
		do {
			System.out
					.print(">>Enter number of rows: ");
			String interstellarRows = br.readLine();

			try {
				intRows = Integer.parseInt(interstellarRows);
				if (intRows > 0) {
					System.out.println(intRows);
					rowDone = true;
				} else {
					System.out.println("\n Please enter a positive number.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Interstellar seat number input is not a n"
						+ "umber please input a number for the amount of rows");

			}

		} while (rowDone != true);
		rowDone = false;
		// +++++++++++++++++++++++++++++++++++++++++++++++
		// Interstellar: Seats per row
		// +++++++++++++++++++++++++++++++++++++++++++++++
		do {
			System.out.print(">>Enter number of seats in a row: ");
			String InterstellarSeatS = br.readLine();

			try {
				intSeats = Integer.parseInt(InterstellarSeatS);
				if (intSeats > 0) {
					System.out.println(intSeats);
					rowDone = true;
				} else {
					System.out.println("\n Please enter a positive number.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Interstellar seat number input is not a n"
						+ "umber please input a number for the amount of rows");

			}

		} while (rowDone != true);
		rowDone = false;
		// +++++++++++++++++++++++++++++++++++++++++++++++
		// Price of a ticket
		// +++++++++++++++++++++++++++++++++++++++++++++++
		do {
			System.out.print(">>Enter the price of a ticket: ");
			String ticketS = br.readLine();

			try {
				ticketPrice = Double.parseDouble(ticketS);
				if (ticketPrice > 0) {
					System.out.println(ticketPrice);
					rowDone = true;
				} else {
					System.out.println("\n Please enter a positive number.");
				}
			} catch (NumberFormatException e) {
				System.out.println("input for ticket price is not a n"
						+ "umber please input a number for the amount of rows");

			}

		} while (rowDone != true);

		interstellar = new Theater("Interstellar", intRows, intSeats);
		maleficent = new Theater("Maleficent", malRows, malSeats);
		movieTheater = new MovieTheater(ticketPrice);

	}

	/**
	 * Called when using the first option in the menu it will ask for input from
	 * the user for the customer name how many are within the group which movie
	 * they wish to watch and if they have a child in their group.
	 *
	 * @author Joe, Hawiar
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void newCustomer() throws IOException {
		String name;
		String nameMovie = null;
		int numPeople = 0;
		boolean haveChild = false;
		boolean done = false;
		boolean blank = true; 
		
		// Size of party
		System.out.print(">>Enter customer name: ");
		name = br.readLine().toUpperCase();
		while(blank)
		{
		if(name.equals("")){
	       System.out.println("Please enter a name containing at least one character.");
	       System.out.println("Enter customer name: ");
	       name = br.readLine().trim().toUpperCase();
	    }
	    else{
	    blank = false;
	    }			
		}
		while (!movieTheater.nameCheck(name))
		{
			System.out.println("That name has already been used!");
			
			System.out.println("Enter customer name: ");
			name = br.readLine().toUpperCase();
		}
		System.out.println(name);

		do {
			System.out.println(">>Enter party size: ");
			String sizeString = br.readLine().trim();
			try {
				numPeople = Integer.parseInt(sizeString);
				
				if (numPeople > 0) 
				{
					System.out.println(numPeople);
					done = true;
				} else {
					System.out.println("Please enter a positive number.");
				}
			} catch (NumberFormatException e) {
				System.out
						.println("Please input a positive number for the party size.");
			}
		} while (done != true);

		// Name of movie
		done = false;
		do {
			System.out.print(">>Enter movie name: ");
			nameMovie = br.readLine().trim().toUpperCase();
			if (nameMovie.equals("INTERSTELLAR")
					|| nameMovie.equals("MALEFICENT")) {
				System.out.println(nameMovie);
				done = true;
			} else {
				System.out
						.println("\n Please enter Interstellar or Maleficent");
			}
		} while (done != true);

		// Child under 12 years old?
		done = false;
		do {
			System.out.print(">>Is a child 12 or younger in this party(Y/N)? ");
			String twelve = br.readLine().trim().toUpperCase();
			if (twelve.equals("Y")) {
				haveChild = true;
				System.out.println(twelve);
				done = true;
			} else if (twelve.equals("N")) {
				haveChild = false;
				System.out.println(twelve);
				done = true;
			} else {
				System.out.println("Please enter Y or N.");
			}
		} while (done != true);

		Group party = new Group(name, numPeople, haveChild, nameMovie);
		movieTheater.addToLine(party);

	}
	
	/**
	 * This method is called upon if it is the first time 
	 * menu option 2 is chosen. 
	 * It asks user which line they would like to be served first,
	 * and then all lines are served in a round robin order as follows:
	 * ExpressLine->RegLine1->RegLine2->ExpressLine
	 * Calls setPlaceHolder() in the Movie Theater class to initiate
	 * the order of the Round Robin line serving method. 
	 * 
	 * @author Hawiar
	 * @throws IOException 
	 */
	public static void firstTime() throws IOException
	{
		boolean finish = true;
		String roundRobin;

		do {
			System.out
					.println("Which line would you like to serve"
							+ " customers first? (express,reg1, reg2): ");
			roundRobin = br.readLine().trim();
			if (roundRobin.equals("express")) {
				firstOption2 = false;
				finish = false;
				movieTheater.setPlaceHolder(0);
			} else if (roundRobin.equals("reg1")) {
				firstOption2 = false;
				finish = false;
				movieTheater.setPlaceHolder(1);
			} else if (roundRobin.equals("reg2")) {
				firstOption2 = false;
				finish = false;
				movieTheater.setPlaceHolder(2);
			}
			else {}
		} while (finish);
		System.out.println(roundRobin);
	}
	

	/**
	 * Called upon by menu option 2
	 * Checks to see if there are any empty lines.
	 * If all the lines are empty, it prints out a message saying so.
	 * Otherwise:
	 * 1. A call is made to serveCustomer() in the movieTheater class
	 * to obtain which movie the group currently in line would like to see.
	 * 2. The current group is added to the movie theater of their choice
	 * if space is available, otherwise an error message tells them that there
	 * is not space available. They can choose to either see the other 
	 * film, if space permits, or leave the movie theater. 
	 * 3. The group is removed from their line through removeCustomer()
	 * 
	 * @author Hawiar Hussein
	 */
	public static void emptyLine() throws IOException {
		boolean empty = true;

		int lineCount = 0;
		QueueArrayBased<Group> currLine = null;
		String answer;
		
		while (empty && lineCount <= 2) {
			currLine = movieTheater.currentLine();
			if (!currLine.isEmpty()) {
				empty = false;
			} else {
				lineCount++;
			}
		}
		if (empty) {
			System.out.println("There are no customers waiting in any line.");
		} else {
			String theaterChoice = movieTheater.serveCustomer(currLine);
			Group currGroup = (Group) currLine.peek();
			int groupSize = currGroup.getNumPeople();
			if (theaterChoice.equals("Interstellar")) {
				if(groupSize > interstellar.getOpenSeats())
				{
					System.out.println("Sorry this movie is sold out.");
					System.out.println("Would you like to see the other movie(Y/N)?");
					answer = br.readLine().toUpperCase().trim();
					if(answer.equals("Y"))
					{
						if(groupSize > maleficent.getOpenSeats())
						{
							System.out.println("Sorry. Both movies are sold out. Good bye!");
							movieTheater.removeCustomer(false);
						}
						else{
							currGroup.setMovie("Maleficent");
							maleficent.addGroup(currGroup);
							movieTheater.removeCustomer(true);
						}
					}
					else{
						movieTheater.removeCustomer(false);
					}
				}
				else{
				interstellar.addGroup(currGroup);
				movieTheater.removeCustomer(true);
				}
			}
			else {
				if(groupSize > maleficent.getOpenSeats())
				{
					System.out.println("Sorry this movie is sold out.");
					System.out.println("Would you like to see the other movie(Y/N)?");
					answer = br.readLine().toUpperCase().trim();
					if(answer.equals("Y"))
					{
						if(groupSize > interstellar.getOpenSeats())
						{
							System.out.println("Sorry. Both movies are sold out. Good bye!");
							movieTheater.removeCustomer(false);
						}
						else{
							currGroup.setMovie("Interstellar");
							interstellar.addGroup(currGroup);
							movieTheater.removeCustomer(true);
						}
					}
					else{
						movieTheater.removeCustomer(false);
					}
				}
				else{
				maleficent.addGroup(currGroup);
				movieTheater.removeCustomer(true);
				}
			}
		}
	}
	
	/**
	 * Customerleaves.
	 * this method asks for a customers name first, searches through the 
	 * list of people within the theaters, if the name is not found it will
	 * print a message saying so, it will then
	 *  search for the name of the person within the theaters 
	 * and remove them from the theater and print a message saying that the customer has left
	 * 
	 * @author Joe Cardona 
	 * @throws IOException 
	 */
	public static String customerLeaves() throws IOException
	{
		String name;
		String message;
		if(movieTheater.getCustomerNames().isEmpty())
		{
			message = "There is no one in any of the theaters right now";
		}
		else
		{
			System.out.print("What is the name of the customer that is going to leave?");
			name = br.readLine().toUpperCase();
			if(movieTheater.nameCheck(name))
			{
				message = "That person is not in this movie theater";
			}	
			else
			{
				message = interstellar.removeGroup(name);
				if(!message.equals("No group found"))
				{
					message = "Group has been found and has left the theater";
				}
				else
				{
					message = maleficent.removeGroup(name);
				}
			}
		}
		return message;
		
	}

}
