package CinemaSystem.Vo;
/**
 * 
 * @author Group 73
 * @version 3.0
 */
public class FilmTimetable {
	private int filmID;
	private String filmName;
	private String time;
	private String screenName;
	
	/**
	 * 
	 * @return Integer Film ID
	 */
	public int getFilmID() {
		return filmID;
	}
	/**
	 * 
	 * @param filmID, the ID set by the customer
	 */
	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}
	/**
	 * 
	 * @return String filmName
	 */
	public String getFilmName() {
		return filmName;
	}
	/**
	 * 
	 * @param filmName, the name set by the customer
	 */
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	/**
	 * 
	 * @return String time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * 
	 * @param time, the time according to the document
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * 
	 * @return String screen name
	 */
	public String getScreenName() {
		return screenName;
	}
	/**
	 * 
	 * @param screenName, the screen set by the customer
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	/**
	 * 
	 * @param ID, the film ID
	 * @param filmName, the name of the film
	 * @param time, the time of the film
	 * @param screenName, the screen name of the film
	 */
	public FilmTimetable(int ID,String filmName, String time, String screenName){
		this.filmID = ID;
		this.filmName=filmName;
		this.time= time;
		this.screenName= screenName;
	}
}
