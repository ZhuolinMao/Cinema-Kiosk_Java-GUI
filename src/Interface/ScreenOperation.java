package Interface;

import org.w3c.dom.Document;

import CinemaSystem.Vo.Screen;

public interface ScreenOperation {
	public Screen getSeats(String filmName,String time,String ScreenName);
	public void initializeSeat(Document doc,String fileName);
	public void setSeat(String filmName, String time, String screenName,String seat, String seat1);
	public Document getSingleScreen(String filmName, String time, String screenName);
}
