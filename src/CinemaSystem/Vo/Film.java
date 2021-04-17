package CinemaSystem.Vo;
/**
 * 
 * @author Group 73
 * @version 3.0
 */

public class Film {
	private int filmID;
	private String name;
	private int TimeLength;
	private String imagSrc;
	
	/**
	 * 
	 * @return Integer Film ID
	 */
	public int getFilmID() {
		return filmID;
	}
	/**
	 * 
	 * @param filmID, ID of the film
	 */
	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}
	/**
	 * 
	 * @return String Film name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name, name of the film
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return Integer Time Length
	 */
	public int getTimeLength() {
		return TimeLength;
	}
	/**
	 * 
	 * @param timeLength, the time length of the film
	 */
	public void setTimeLength(int timeLength) {
		TimeLength = timeLength;
	}
	/**
	 * 
	 * @return String image address
	 */
	public String getImagSrc() {
		return imagSrc;
	}
	/**
	 * 
	 * @param imagSrc, image address
	 */
	public void setImagSrc(String imagSrc) {
		this.imagSrc = imagSrc;
	}
	/**
	 * 
	 * @param filmID, the ID of the film
	 * @param name, the Name of the film
	 * @param TimeLength, the time length of the film
	 * @param imagSrc, the address of the image
	 */
	public Film(int filmID,String name, int TimeLength, String imagSrc){
		this.filmID=filmID;
		this.name=name;
		this.TimeLength=TimeLength;
		this.imagSrc=imagSrc;
	}
}
