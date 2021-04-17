package CinemaSystem.Vo;
/**
 * 
 * @author Group 73
 * @version 3.0
 * 
 */
public class PurchasingRecords {
	private int filmID;
	private String filmName;
	private String time;
	private String ticketType;
	private double price;
	private String[] seat;
	private String screenName;
	/**
	 * 
	 * @param filmID, the ID of the film
	 * @param filmName, the name of the film
	 * @param time, the time of the film
	 * @param ticketType, the ticket type chosen by the customer
	 * @param price, the price of the ticket
	 * @param seat, the seat chosen by the customer
	 * @param screenName, the screen chosen by the customer
	 */
	public PurchasingRecords(int filmID,String filmName,String time,String ticketType,double price,String[] seat, String screenName){
		this.filmID = filmID;
		this.filmName = filmName;
		this.time = time;
		this.screenName = screenName;
		this.ticketType = ticketType;
		this.price = price;
		this.seat = seat;
		
	}
	/**
	 * 
	 * @return String[] seat
	 */
	public String[] getSeat() {
		return seat;
	}
	/**
	 * 
	 * @param seat, the seat chosen by the customer
	 */
	public void setSeat(String[] seat) {
		this.seat = seat;
	}
	/**
	 * 
	 * @return Integer ID of the film
	 */
	public int getFilmID() {
		return filmID;
	}
	/**
	 * 
	 * @param filmID, the ID of the film
	 */
	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}
	/**
	 * 
	 * @return 	String Name of the film
	 */
	public String getFilmName() {
		return filmName;
	}
	/**
	 * 
	 * @param filmName, the name of the film
	 */
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	/**
	 * 
	 * @return String time of the film
	 */
	public String getTime() {
		return time;
	}
	/**
	 * 
	 * @param time, the time of the film
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * 
	 * @return String Screen name of the film
	 */
	public String getScreenName() {
		return screenName;
	}
	/**
	 * 
	 * @param screenName, the screen chosen by the customer
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	/**
	 * 
	 * @return String Type of the ticket the customer chosen
	 */
	public String getTicketType() {
		return ticketType;
	}
	/**
	 * 
	 * @param ticketType, the ticket type chosen by the customer
	 */
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	/**
	 * 
	 * @return double Price of the ticket
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * 
	 * @param price, the price of the ticket
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
