package xml_Operation;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import CinemaSystem.Vo.FilmTimetable;
import Interface.GetTimetable;

public class GetTimetableImpl implements GetTimetable {
	public ArrayList<FilmTimetable> getTimeTableByID(int ID){
		GetFilmsImpl pre = new GetFilmsImpl();
		DocumentBuilder db = pre.getDocumentBuilder();
		ArrayList<FilmTimetable> tblist = new ArrayList<FilmTimetable>();
		FilmTimetable tb = new FilmTimetable(0, null, null, null);
		String Name=null;
		try {
			Document document = db.parse("FilmTimeTable.xml");
			NodeList list = document.getElementsByTagName("movie");
			//System.out.println(list.getLength());
			
			for(int i =0;i<list.getLength();i++){
				Node movie = list.item(i);
				Element Movie = (Element) movie;
				String id = Movie.getAttribute("id");
				int ID1 = Integer.parseInt(id);
				if(ID1==ID){				
				
				NodeList childlist = movie.getChildNodes();
				//System.out.println(childlist.getLength());
				//String[] value = new String[childlist.getLength()];
				for(int j =0;j<childlist.getLength();j++){
					
					if(childlist.item(j).getNodeType()==Node.ELEMENT_NODE){
						
						Node film = childlist.item(j);
						Element name = (Element) film;
						Name =name.getAttribute("name");
						NodeList childList = film.getChildNodes();
						//System.out.println(childList.getLength());
						for(int m=0;m<childList.getLength();m++){
							if(childList.item(m).getNodeType()==Node.ELEMENT_NODE){
								Element time = (Element) childList.item(m);
								tb=new FilmTimetable(Integer.parseInt(id),Name,time.getAttribute("time"),time.getAttribute("screen"));
								tblist.add(tb);							
								//System.out.println(time.getAttribute("time"));
								//System.out.println(time.getAttribute("screen"));
							}
						}
						
					}
				}				
				}
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tblist;
		
	}

}
