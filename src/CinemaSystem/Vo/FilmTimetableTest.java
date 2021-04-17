package CinemaSystem.Vo;

public class FilmTimetableTest extends junit.framework.TestCase{

	public void testCreate(){
    	Film film = new Film(1, "LOGAN", 120, "LOGAN.jpg");
    	film.setFilmID(2);
    	film.setName("LA LA LAND");
    	film.setTimeLength(130);
    	film.setImagSrc("LAND.jpg");
    	int id = film.getFilmID();
    	String name = film.getName();
    	int time = film.getTimeLength();
    	String image = film.getImagSrc();
    	assertEquals(2, id);
    	assertEquals("LA LA LAND", name);
    	assertEquals(130, time);
    	assertEquals("LAND.jpg", image);
    }
}
