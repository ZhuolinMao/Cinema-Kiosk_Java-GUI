package xml_Operation;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import CinemaSystem.Vo.Film;
import Interface.GetFilms;

public class GetFilmsImpl implements GetFilms{
	public DocumentBuilder getDocumentBuilder(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db=null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return db;
		
	}
	
	public ArrayList<Film> parse(){
		
		ArrayList<Film> films = new ArrayList<Film>();
		DocumentBuilder db = getDocumentBuilder();
		try {
			Document document = db.parse("movies.xml");
			NodeList list = document.getElementsByTagName("movies");
			//System.out.println(list.getLength());
			
			for(int i =0;i<list.getLength();i++){
				Node movie = list.item(i);
				Element Movie = (Element) movie;
				String id = Movie.getAttribute("id");
				int ID = Integer.parseInt(id);
				NodeList childlist = movie.getChildNodes();
				//System.out.println(childlist.getLength());
				String[] value = new String[childlist.getLength()];
				for(int j =0;j<childlist.getLength();j++){
					if(childlist.item(j).getNodeType()==Node.ELEMENT_NODE){
						value[j]=childlist.item(j).getFirstChild().getNodeValue();
						//System.out.println(value[j]);
					}
				}
				Film info = new Film(ID, value[1], Integer.parseInt(value[3]), value[5]);
				/*info.setFilmID(ID);
				info.setName(value[0]);
				info.setTimeLength(Integer.parseInt(value[1]));
				info.setImagSrc(value[2]);*/
				films.add(info);
			}
			
		
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return films;
	}

}
