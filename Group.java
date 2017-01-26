

/**
 * The Class Group.
 * @author Hawiar Hussein
 */
public class Group {

	/** The name of the group. */
	private String name; // Name of group
	
	/** The number of people in the group. */
	private int numPeople; // Size of the party
	
	/** True if child under 12
	 *  False if no children under 12. */
	private boolean haveChild; // true = child under 12
	
	/** The name of the group's movie choice. */
	private String nameMovie; // Interstellar or Maleficent

	/**
	 * Instantiates a new group.
	 *
	 * @param String name - the group name
	 * @param int numPeople - the number of people
	 * @param boolean haveChild - True if child under 12, False otherwise
	 * @param String nameMovie - the name of the movie
	 */
	public Group(String name, int numPeople, boolean haveChild, String nameMovie) {
		this.name = name;
		this.numPeople = numPeople;
		this.haveChild = haveChild;
		this.nameMovie = nameMovie;
	}

	/**
	 * Gets the name.
	 *
	 * @return String name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Number of people.
	 *
	 * @return int numPeople
	 */
	public int getNumPeople() {
		return numPeople;
	}

	/**
	 * Gets the child under 12 boolean.
	 *
	 * @return boolean haveChild
	 */
	public boolean getChild() {
		return haveChild;
	}

	/**
	 * Gets the movie choice
	 *
	 * @return String nameMovie
	 */
	public String getMovie() {
		return nameMovie;
	}

	/**
	 * Set the movie choice
	 * @param String movie - name of movie
	 */
	public void setMovie(String movie)
	{
		nameMovie = movie;
	}
	
	/** 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String child;
		if (haveChild = true) {
			child = "yes";
		} else {
			child = "no";
		}
		String result = "Customer " + name + " party of " + numPeople + " for " 
				+ nameMovie + " movie.\n";
		return result;
	}
}
