
// TODO: Auto-generated Javadoc
/**
 * Class Seat
 * used in the theater class to show
 * weather or not a seat is free for a
 * group member to occupy
 * @author Joe Cardona
 */
public class Seat {

	/** The row number of the seat. */
	private int rowNumber;

	/** The seat number of the seat. */
	private int seatNumber;

	/** The occupant
	 * this is the group that is occupying the seat currently
	 */
	private Group occupant;

	/**
	 * Instantiates a new seat.
	 * 
	 * @param rowNumber
	 *            the row number
	 * @param seatNumber
	 *            the seat number
	 * @param occupant
	 *            the occupant
	 * @author Joe Cardona
	 */
	public Seat(int rowNumber, int seatNumber, Group occupant) {
		this.rowNumber = rowNumber;
		this.seatNumber = seatNumber;
		this.occupant = occupant;
	}

	/**
	 * Gets the row Number of the seat.
	 * 
	 * @return int the row number
	 */
	public int getRowNumber() {
		return rowNumber;
	}

	/**
	 * Sets the row number of the seat
	 * unused in this project
	 * 
	 * @param int rowNumber
	 *            the new row number
	 */
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	/**
	 * Gets the seat number of the seat
	 * 
	 * 
	 * @return int seat number
	 */
	public int getSeatNumber() {
		return seatNumber;
	}

	/**
	 * Sets the seat number.
	 * unused in this project
	 * @param int seatNumber
	 *            the new seat number
	 */
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	/**
	 * Gets the occupant of the seat
	 * 
	 * @return Group the occupant
	 */
	public Group getOccupant() {
		return occupant;
	}

	/**
	 * Sets the occupant.
	 * 
	 * @param Group occupant
	 *            the new occupant
	 */
	public void setOccupant(Group occupant) {
		this.occupant = occupant;
	}

	@Override
	/**
	 * overridden toString method that 
	 * prints out in the fashion of
	 * "Row 1 seat 1 is occupied by Free"
	 * @author Joe Cardona
	 */
	public String toString() {
		return "Row " + rowNumber + " seat " + seatNumber
				+ " is occupied by " + occupant.getName() + "\n";
	}

	
	
}
