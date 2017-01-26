
import java.io.*;


/**
 * Holds the Express Line, Regular Line 1, and Regular Line 2
 * Holds information about ticket sales for each movie and total earnings.
 * @author Hawiar Hussein and Yusef Cardona
 * @version Date 12/07/2014
 */
public class MovieTheater {

	private static ListArrayBasedPlus<String> allCustomerNames = new ListArrayBasedPlus<String>();
	private QueueArrayBased<Group> regLine1 = new QueueArrayBased<Group>();
	private QueueArrayBased<Group> regLine2 = new QueueArrayBased<Group>();
	private QueueArrayBased<Group> expressLine = new QueueArrayBased<Group>();
	private static QueueArrayBased<Group> booth = new QueueArrayBased<Group>();
	
	private final double ticketPrice; 
	private static int placeHolder = 0; 
	private static int interstellarTickets = 0;
	private static int maleficentTickets = 0;
	private static double totalEarnings = 0.00;

	private Group group;
	
	public MovieTheater(double ticketPrice) 
	{
	    this.ticketPrice = ticketPrice;
	}
	
	//ACCESSORS
	/**
	 * 
	 *	@author Joe	 
	 *	@return ListArrayBasedPlus<String> 
	 *				Returns a list of the names of all the people that have gone into the theater
	 */
	public ListArrayBasedPlus<String> getCustomerNames()
	{
		return allCustomerNames;
	}
	
	/**
	 * @author Hawiar Hussein
	 * @return double - ticketPrice
	 */
	public double getTicketPrice()
	{
	    return ticketPrice;
	}
	
	/**
	 * @author Hawiar Hussein
	 * @return int - total Interstellar tickets sold
	 */
	public int getInterstellarTickets()
	{
	    return interstellarTickets;
	}
	
	/**
	 * @author Hawiar Hussein
	 * @return int - total Maleficent tickets sold
	 */
	public int getMaleficentTickets()
	{
		return maleficentTickets;
	}
	
	/**
	 * @author Hawiar Hussein
	 * @return double - total earnings
	 */
	public double getTotalEarnings()
	{
	    return totalEarnings;
	}
	
	/**
	 * @author Hawiar Hussein
	 * @param int place - Place in Round Robin  
	 */
	public void setPlaceHolder(int place)
	{
		placeHolder = place;
	}
	/**
	 * Searches the new customer's name against the current list of names.
	 * If the name exists, customer tries a new name. Otherwise, customer
	 * is accepted into a line.
	 * 
	 * @authors Hawiar Hussein
	 * @param String name - name of customer or party
	 * @return boolean - true: Customer can now be added to a line.
	 * 					 false: Name already exists, Customer needs a new name
	 * 
	 *
	 */
	public boolean nameCheck(String name) { 
		if (allCustomerNames.isEmpty()) {
			int size = allCustomerNames.size();
			allCustomerNames.add(size, name);
			return true;
		} 
		else {
			int duplicate = 0;
				for (int i = 0; i < allCustomerNames.size(); i++) {
					Object curr = allCustomerNames.get(i);
					String currName = curr.toString();
					if (name.equals(currName)) {
						duplicate += 1;
					}
				}
			
			if (duplicate == 1)
			{
				return false;
			} else {
				int size = allCustomerNames.size();
				allCustomerNames.add(size, name);
				return true;
			}
		}
	}
	/**
	 * Takes the new Group and adds one of the three lines.
	 * If the group has a child under 12 they are added to 
	 * the Express Line, unless one of the other two lines
	 * is twice as short.
	 * Otherwise, the group is added to the shorter of the 
	 * two regular lines. 
	 * 
	 * @author Hawiar Hussein
	 * @param Group g - New group to add to one of the three lines.
	 * 
	 */
	public void addToLine(Group g)
	{
	    group = g;
	    String shorter; //Holds name of shortest line
	    if(group.getChild() == false)
	    {
	    	if(regLine2.size() >= regLine1.size())
	    	{
		    	shorter = "first";
	    	}
	    	else{
	    		shorter = "second";
	    	}
	    }
	    else{
	    	if(regLine1.size() < expressLine.size()*(0.5))
	    	{
		    	shorter = "first";
	    	}
	    	else if(regLine2.size() < expressLine.size()*(0.5))
	    	{
	    		shorter = "second";
	    	}
	    	else{
	    		shorter = "express";
	    	}
	    }
	    if(shorter.equals("express"))
	    {
	    expressLine.enqueue(group);
	    }
	    else if(shorter.equals("first"))
	    {
	    	regLine1.enqueue(group);
	    }
	    else{
	    	regLine2.enqueue(group);
	    }
	    System.out.println("Customer " + group.getName() + " is in " 
	    		+ shorter + " ticket line.");
	    }
	
	/**
	 * Retrieves the name of the movie the current group wants to watch
	 * so that they can be added to their respective movie theater.
	 * 
	 * @author Hawiar Hussein
	 * @param QueueArrayBased<Group> serve 
	 * @return String movieChoice - Name of movie current group wants to watch.
	 */
	public String serveCustomer(QueueArrayBased<Group> serve)
	{
	 Group currentParty = (Group)serve.peek();
	 String movieChoice = currentParty.getMovie();	
	 return movieChoice;
	 
	}
	
	/**
	 * Returns the line that is currently ready to be served
	 * in the Round Robin order.
	 * 
	 * @author Hawiar Hussein
	 * @return QueueArrayBased<Group> thisQueue 
	 */
	public QueueArrayBased<Group> currentLine()
	{
		QueueArrayBased<Group> thisQueue = new QueueArrayBased<Group>();
		if(placeHolder == 0)
		{
		 thisQueue = expressLine;
		 placeHolder = 1;
		}
		else if(placeHolder == 1)
		{
			thisQueue = regLine1;
			placeHolder = 2;
		}
		else{
			placeHolder = 0;
			thisQueue = regLine2;
		}
		return thisQueue;
		}
	
	/**
	 * Removes a group from their line and updates the total number of tickets and
	 * earnings if they were seated in a movie theater. Otherwise, they are just removed.
	 * 
	 * @author Hawiar Hussein
	 * @param boolean seated - true: Number of tickets and Total Earnings are updated
	 * 								 and customer is removed from the line.
	 * 						   false: Customer is removed from the line. 
	 */
	public void removeCustomer(boolean seated)
	{
		Group tickets;
		String choice;
		int partySize = 0;
		String cust;
		if(seated){
		if(placeHolder == 0)
		{
			tickets = (Group)regLine2.peek();
			choice = tickets.getMovie();
			cust = tickets.getName();
			partySize = tickets.getNumPeople();
			System.out.println("Serving customer " + cust);
			if(choice.equals("Interstellar"))
			{
				interstellarTickets += partySize;
			}
			else{
				maleficentTickets += partySize;
			}
			System.out.println(cust + ", party of " + partySize + " has been seated in the " 
					+ choice + " movie theater.");
		 regLine2.dequeue();
		}
		else if(placeHolder == 1)
		{
			tickets = (Group)expressLine.peek();
			choice = tickets.getMovie();
			cust = tickets.getName();
			partySize = tickets.getNumPeople();
			System.out.println("Serving customer " + cust);
			if(choice.equals("Interstellar"))
			{
				interstellarTickets += partySize;
			}
			else{
				maleficentTickets += partySize;
			}
			System.out.println(cust + ", party of " + partySize + " has been seated in the " 
					+ choice + " movie theater.");
			expressLine.dequeue();
		}
		else{
			tickets = (Group)regLine1.peek();
			choice = tickets.getMovie();
			partySize = tickets.getNumPeople();
			cust = tickets.getName();
			System.out.println("Serving customer " + cust);
			if(choice.equals("Interstellar"))
			{
				interstellarTickets += partySize;
			}
			else{
				maleficentTickets += partySize;
			}
			System.out.println(cust + ", party of " + partySize + " has been seated in the " 
					+ choice + " movie theater.");
			regLine1.dequeue();
		}
		totalEarnings += partySize*ticketPrice;
		}
		else{
			if(placeHolder == 0)
			{
				tickets = (Group)regLine2.peek();
				cust = tickets.getName();
				System.out.println("Customer " + cust + " has left the movie theater.");
			    regLine2.dequeue();
			}
			else if(placeHolder == 1)
			{
				tickets = (Group)expressLine.peek();
				cust = tickets.getName();
				System.out.println("Customer " + cust + " has left the movie theater.");
				expressLine.dequeue();
			}
			else{
				tickets = (Group)regLine1.peek();
				cust = tickets.getName();
				System.out.println("Customer " + cust + " has left the movie theater.");
				regLine1.dequeue();
			}
		}
	}
	
	/**
	 * Checks each queue for emptiness. If they are all empty it prints out
	 * an all empty message. 
	 * Otherwise, it prints out the info about the groups in each line.
	 * 
	 * @author Hawiar Hussein
	 */
	public void printLines()
	{
		
		if(regLine1.isEmpty())
		{
			System.out.println("No customers in the first line!");
		}
		else{
			if(expressLine.size() == 1)
			{
				System.out.println("The following customer is in the first line: ");
				System.out.println(regLine1.toString());
			}
			else{
				System.out.println("The following customers are in the first line: ");
				System.out.println(regLine1.toString());
			}
		}
		
		if(regLine2.isEmpty())
		{
			System.out.println("No customers in the second line!");
		}
		else{
			if(expressLine.size() == 1)
			{
				System.out.println("The following customer is in the second line: ");
				System.out.println(regLine2.toString());
			}
			else{
				System.out.println("The following customers are in the second line: ");
				System.out.println(regLine2.toString());
			}
		}
		
	if(expressLine.isEmpty())
	{
		System.out.println("No customers in the express line!");
	}
	else{
		if(expressLine.size() == 1)
		{
			System.out.println("The following customer is in the express line: ");
			System.out.println(expressLine.toString());
		}
		else{
			System.out.println("The following customers are in the express line: ");
			System.out.println(expressLine.toString());
		}
	}
			

	}
	}
	    	
	    
	    
	
