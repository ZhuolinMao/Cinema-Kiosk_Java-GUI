package CinemaSystem.Vo;

public class Screen {
	private String screenName;
	private String time;
	private int[][] seats;
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int[][] getSeats() {
		return seats;
	}
	public void setSeats(int[][] seats) {
		this.seats = seats;
	}
	public Screen(String name, String time, int[][] seats){
		this.screenName = name;
		this.time=time;
		this.seats = seats;
	}
	

}
