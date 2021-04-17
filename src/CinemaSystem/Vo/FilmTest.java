package CinemaSystem.Vo;

public class FilmTest extends junit.framework.TestCase{
    public void testCreate(){
    	Film film = new Film(1, "LOGAN", 120, "LOGAN.jpg");
    	int id = film.getFilmID();
    	String name = film.getName();
    	int time = film.getTimeLength();
    	String image = film.getImagSrc();
    	assertEquals(1, id);
    	assertEquals("LOGAN", name);
    	assertEquals(120, time);
    	assertEquals("LOGAN.jpg", image);
    }
}
