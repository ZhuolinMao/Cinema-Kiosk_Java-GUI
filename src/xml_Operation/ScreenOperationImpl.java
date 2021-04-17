package xml_Operation;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import CinemaSystem.Vo.Screen;
import Interface.ScreenOperation;

public class ScreenOperationImpl implements ScreenOperation {
	
	@SuppressWarnings("unused")
	public Screen getSeats(String filmName,String time,String ScreenName){
		Screen sc =null;
		
		Document document = getSingleScreen(filmName, time, ScreenName);
		NodeList screen =document.getElementsByTagName("screen");
		Node Screen = screen.item(0);
		NodeList rows = Screen.getChildNodes();
		int rowNumber = rows.getLength()/2;
		int colNumber = rows.item(1).getChildNodes().getLength()/2;
		System.out.println("row:"+rowNumber+"col"+colNumber);
		int Seats[][] = new int[rowNumber][colNumber];
		for(int i =0;i<rows.getLength();i++){
			Node row = rows.item(i);
			if(row.getNodeType()==Node.ELEMENT_NODE){
				Element theRow = (Element) row;
				String rowNum = theRow.getAttribute("No");
					NodeList cols = row.getChildNodes();
					for(int j=0;j<cols.getLength();j++){
						Node col = cols.item(j);
						if(col.getNodeType()==Node.ELEMENT_NODE){
							//System.out.println(""+j+""+i);
							Element theCol = (Element) col;
							String colNum = theCol.getAttribute("state");
							Seats[(i-1)/2][(j-1)/2] =Integer.parseInt(colNum);
						}
					}
				}
			}
		
		sc = new Screen(ScreenName,time,Seats);
		
		
	return sc;	
	}
	
	@SuppressWarnings("unused")
	public void initializeSeat(Document doc,String fileName){
		TransformerFactory tf= TransformerFactory.newInstance();
		try {
			Transformer tff = tf.newTransformer();
			DOMSource doms = new DOMSource();
			
			tff.transform(new DOMSource(doc),new StreamResult(new File(fileName)));
			
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@SuppressWarnings("unused")
	public void setSeat(String filmName, String time, String screenName,String seat, String seat1){
		GetFilmsImpl pre = new GetFilmsImpl();
		DocumentBuilder db = pre.getDocumentBuilder();
		Document document;
		String filename = (filmName+"-"+time+"-Screen"+screenName+".xml");
		TransformerFactory tf= TransformerFactory.newInstance();
			System.out.println("file ready to be read");
			try {
				document = db.parse(filename);
				NodeList screen =document.getElementsByTagName("screen");
				Node Screen = screen.item(0);
				NodeList rows = Screen.getChildNodes();
				for(int i =0;i<rows.getLength();i++){
					Node row = rows.item(i);
					if(row.getNodeType()==Node.ELEMENT_NODE){
						Element theRow = (Element) row;
						String rowNum = theRow.getAttribute("No");
						if(rowNum.equals(seat)){
							NodeList cols = row.getChildNodes();
							for(int j=0;j<cols.getLength();j++){
								Node col = cols.item(j);
								if(col.getNodeType()==Node.ELEMENT_NODE){
									if((j-1)/2==Integer.parseInt(seat1)){//这里取的值不太对 
										Element theCol = (Element) col;
										theCol.setAttribute("state", "-1");									
									}
									
								}
							}
						}
					}
				}
				Transformer tff;
				tff = tf.newTransformer();			
				DOMSource doms = new DOMSource();			
				tff.transform(new DOMSource(document),new StreamResult(new File(filename)));
				
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public Document getSingleScreen(String filmName, String time, String screenName){
		
		GetFilmsImpl pre = new GetFilmsImpl();
		DocumentBuilder db = pre.getDocumentBuilder();
		Document document=null;
		String filename = (filmName+"-"+time+"-Screen"+screenName+".xml");
		File file = new File(filename);
		if(!file.exists()){
			System.out.println("not exist");
			String ScreenName = null;
			try {
				file.createNewFile();
				try {
					document = db.parse("Screen.xml");
					NodeList Screens =document.getElementsByTagName("Screens");
					Node screens = Screens.item(0);
					NodeList screen = Screens.item(0).getChildNodes();
					for(int x=0;x<screen.getLength();x++){
						Node single_screen = screen.item(x);
						if(single_screen.getNodeType()==Node.ELEMENT_NODE){
							Element c = (Element) single_screen;
							ScreenName = c.getAttribute("screenName");
							
							if(!ScreenName.equals(screenName)){
								System.out.println(ScreenName);
								screens.removeChild(single_screen);
							}
						}
					}
					initializeSeat(document, filename);
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}else{
			System.out.println("file ready to be read");
			try {
				document = db.parse(filename);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	
		return document;
		
	}


}
