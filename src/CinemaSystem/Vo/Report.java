package CinemaSystem.Vo;

import java.util.TimerTask;

public class Report extends TimerTask{
	public void run(){
	String[] filmname = {"LOGAN","LA LA LAND","KONG. SKULL ISLAND","BEAUTY AND THE BEAST","MOONLIGHT"};
	Statistics s = new Statistics(filmname, null, null, null, null, null);
	s.writefile(s.analyse());
	}

}
