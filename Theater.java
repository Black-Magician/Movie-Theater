
/**
 * This class is used to store all the information of 
 * the theaters themselves.
 * includes the names of the movies, a list of the 
 * groups that are within the theater, the seats and rows
 * as well as information of how many seats are open and the total amount 
 * of seats that are within the entire theater
 * @author Joe Cardona
 *
 */
public class Theater {

	/** The amount of rows of seats. */
	private int rows;
	
	/** The amount of seats per row. */
	private int seats;
	
	/** The total number of seats. */
	private int totalSeats;
	
	/** The open seats. */
	private int openSeats;
	
	/** The theater name. */
	private String theaterName;
		
	/** Static variable used whenever 
	 * replacing a person in the theater
	 */
	private static Group FREE_SEAT = new Group("Free",1,false," ");
	
	/** list containing the seats that are in the theater
	 *  */
	private ListArrayBasedPlus<Seat> theaterGoers = new ListArrayBasedPlus<Seat>();
	//class constructor
	/**
	 * Class constructor that is called in the Menu class
	 * Instantiates all the variables that the class has.
	 * builds up the list of seats as well
	 * 
	 * @param name name of the movie in the theater
	 * @param rows how many rows are in the theater
	 * @param seats how many seats per row are in the theater
	 */
	public Theater(String name, int rows, int seats)
	{
		theaterName = name;
		this.rows = rows;
		this.seats = seats;
		totalSeats = (rows * seats);
		openSeats = totalSeats;
		fillSeats();
	}
	//+++++++++++++++++++++++++++++++++++++++++
	//ACESSORS
	/**
	 * Gets the rows.
	 * 
	 * @author Joe Cardona
	 * @return number of rows in theater
	 */
	public int getRows()
	{
		return rows;
	}
	
	/**
	 * Gets the seats.
	 *
	 * @author Joe Cardona
	 * @return number of seats per row in theater
	 */
	public int getSeats()
	{
		return seats;
	}
	
	/**
	 * Gets the total seats.
	 *
	 * @author Joe Cardona
	 * @return number total number of seats in theater
	 */
	public int getTotalSeats()
	{
		return totalSeats;
	}
	
	/**
	 * this can be used to quickly check if there are enough open seats 
	 * for a new group to come in and sit down.
	 *
	 * @author Joe Cardona
	 * @return total number of open seats in theater
	 */
	public int getOpenSeats()
	{
		return openSeats;
	}
	
	/**
	 * Gets the theater name.
	 *
	 * @author Joe
	 * @return String of the name of the movie in the theater
	 */
	public String getTheaterName()
	{
		return theaterName;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//MUTATORS
	/**
	 * changes the name of the movie in the theater.
	 *
	 * @author Joe
	 * @param name new name of the movie
	 */
	public void setTheaterName(String name)
	{
		this.theaterName = name;
	}
	/**
	 * if the number of seats in the theater changes this will be used to change
	 * the number of seats per row
	 * it will also update the total number of seats in the theater.
	 *
	 * @author Joe Cardona
	 * @param seats the new seats
	 */
	public void setSeats(int seats)
	{
		this.seats = seats;
		this.totalSeats = (this.seats*this.rows);
	}
	
	/**
	 * if the number of rows in the theaters change this will change
	 * the number of rows
	 * it will also update the total number of seats in the theater.
	 *
	 * @author Joe Cardona
	 * @param rows the new rows
	 */
	public void setRows(int rows)
	{
		this.rows = rows;
		this.totalSeats = (this.seats*this.rows);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * this method checks to see if there are enough open seats 
	 * for a new group to enter the theater
	 * if not it will throw a TooManyPeopleException with a message
	 * that there are not enough seats for their group
	 * otherwise it will add the group to the theater while adjusting
	 * the number of open seats.
	 *
	 * @author Joe Cardona
	 * @param newGroup group that is entering the theater
	 * @throws TooManyPeopleException if there are too many people in the group	
	 */
	public void addGroup(Group newGroup)
	{	
		int numPeople = newGroup.getNumPeople();
			if(numPeople > openSeats)
			{
				throw new TooManyPeopleException("Not enough seats");
			}	
			else
			{	
				
				for(int i = newGroup.getNumPeople(); i > 0; i--)
				{
					int freespot = search("Free");
					theaterGoers.get(freespot).setOccupant(newGroup);
				}
				this.openSeats = this.openSeats - numPeople;
			}
	}
	
	/**
	 * fills the array theaterGoers with seats based on the amount 
	 * of rows and seats that were specified by the input when creating
	 * the theater class.
	 *
	 * @author Joe Cardona
	 */
	public void fillSeats()
	{
		int x = 0;//index used for the location in the theaterGoers list
		//i is the row number
		for(int i = 1;i<= this.rows;i++)
		{//j is the seat number
			for(int j = 1;j<=this.seats;j++)
			{
				theaterGoers.add(x, new Seat(i,j,FREE_SEAT));
				x++;
			}
		}
	}
	
	/**
	 * sequential search used to look through the names of the
	 * groups within the theater so to remove them from the theater 
	 * when they wish to leave.
	 * using sequential search because the plan is to find an open seat
	 * as quickly as possible, this can also be used for lists that contain
	 * more than one of the same item
	 *
	 * @author Joe Cardona
	 * @param item the item
	 * @return int value of the location of the item that was searched for
	 */
	public int search(String item)
	{
		int result = 0;
		int size = theaterGoers.size();
		boolean done = false;
		for(int i = 0; i < size && done == false; i++)
		{
			if(item.equals(theaterGoers.get(i).getOccupant().getName()))
				{
					done = true;
					result = i;
				}
			else
			{
				result = -1;
			}
		}
        return result;
    }
	
	/**
	 * removeGroup 
	 * this method uses a binary search to look through the 
	 * theater for the group that is specified by the name of the group.
	 *
	 * @author Joe Cardona
	 * @param groupName the group name
	 * @return String of the result of the operation
	 */
	public String removeGroup(String groupName)
	{
		String result = "";

		int searchIndex = search(groupName.toUpperCase());
		//if the search returns a result of -1 then the person was not found in the theater
		if(searchIndex < 0)
		{
			result = "No group found";
		}
		else
		{
			result = "Group has been found and has left the theater";
			Group removeGroup = theaterGoers.get(searchIndex).getOccupant();
			//an update of the amount of open seats so we can still use the variable
			this.openSeats += removeGroup.getNumPeople();
			int numPeople = removeGroup.getNumPeople();
			for(int i = 0; i < numPeople;i++)
			//loop used to get all of the seats that the group has occupied out of the theater
			{
				searchIndex = search(groupName.toUpperCase());
				theaterGoers.get(searchIndex).setOccupant(FREE_SEAT);
			}
		}
		return result;

	}
	
	/** 
	 * @return String a list of the seats that are in the theater
	 * as well as who is occupying them 
	 * @author Joe Cardona
	 */
	public String toString()
	{
		String result = "";
		result += theaterGoers.toString();	
		return result;
	}
}
