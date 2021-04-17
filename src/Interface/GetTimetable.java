package Interface;

import java.util.ArrayList;

import CinemaSystem.Vo.FilmTimetable;

public interface GetTimetable {
	public ArrayList<FilmTimetable> getTimeTableByID(int ID);
	
}
