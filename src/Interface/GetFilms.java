package Interface;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;

import CinemaSystem.Vo.Film;

public interface GetFilms {
	public DocumentBuilder getDocumentBuilder();
	public ArrayList<Film> parse();
	
}
