package CinemaSystem.Vo;

public class RecordsTest extends junit.framework.TestCase{
   public void testCreate(){
	   String seat[]= {"A1","A2","A3","A4"};
	   PurchasingRecords records = new PurchasingRecords(1, "LOGAN", "120", "Student", 12.8, seat, "1");
	   records.setFilmID(2);
	   records.setFilmName("LOGAN");
	   records.setPrice(12.8);
	   records.setScreenName("1");
	   records.setSeat(seat);
	   records.setTicketType("Student");
	   records.setTime("120");
	   assertEquals(2, records.getFilmID());
	   assertEquals("LOGAN", records.getFilmName());
	   assertEquals("120", records.getTime());
	   assertEquals(seat, records.getSeat());
	   assertEquals(12.8, records.getPrice());
	   assertEquals("1", records.getScreenName());
	   assertEquals("Student", records.getTicketType());
   }
}
