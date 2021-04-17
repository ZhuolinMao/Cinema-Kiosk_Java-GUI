package CinemaSystem.Vo;

public class ScreenTest extends junit.framework.TestCase{
	 public void testCreate(){
		   int[] [] seat = {{1,2,3},{4,5,6}};
		   Screen screen = new Screen(null,null,null);
		   screen.setScreenName("2");
		   screen.setSeats(seat);
		   screen.setTime("20.00");
		   assertEquals("2", screen.getScreenName());
		   assertEquals("20.00",screen.getTime());
		   assertEquals(seat,screen.getSeats());
	   }
}

