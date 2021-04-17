package xml_Operation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

import CinemaSystem.Vo.PurchasingRecords;

public class RecordsOperationImpl {
	public void generateRecords(PurchasingRecords record, String row, String colomn){
		String now=getDate();
		String Date=null;
		System.out.println(now);
		boolean flag = true;
		Document document = readFile();
		NodeList Rootlist = document.getElementsByTagName("Records");
		Node RootNode = Rootlist.item(0);
		NodeList Records  = document.getElementsByTagName("Record");
		Element Ticket = document.createElement("Ticket");
		Ticket.setAttribute("FilmID", ""+record.getFilmID());
		Ticket.setAttribute("FilmName", record.getFilmName());
		Ticket.setAttribute("Time", record.getTime());
		Ticket.setAttribute("TicketType", record.getTicketType());
		Ticket.setAttribute("Price", ""+record.getPrice());
		Ticket.setAttribute("ScreenName", ""+record.getScreenName());
		Ticket.setAttribute("Row",row);
		Ticket.setAttribute("Col", colomn);
		for(int i=0;i<Records.getLength();i++){
			Node Record = Records.item(i);
			if(Record.getNodeType()==Node.ELEMENT_NODE){
				Element Single_Record = (Element) Record;
				Date=Single_Record.getAttribute("Date");
				if(Date.equals(now)){
					flag=false;
					Record.appendChild(Ticket);
				}
					
			}
		}
		if(flag){	
			Element newRecord = document.createElement("Record");
			newRecord.setAttribute("Date", now);
			newRecord.appendChild(Ticket);
			RootNode.appendChild(newRecord);
		}
		writeFile(document);
		
	}
	public ArrayList<PurchasingRecords> getRecordsByDate(String date){
		ArrayList<PurchasingRecords> list = new ArrayList<PurchasingRecords>();
		String Date=null;
		Document document = readFile();
		
		NodeList nodelist = document.getElementsByTagName("Record");
		for(int i=0;i<nodelist.getLength();i++){
			Node record = nodelist.item(i);
			if(record.getNodeType()==Node.ELEMENT_NODE){
				Element singleRecord = (Element) record;
				Date=singleRecord.getAttribute("Date");
				if(Date.equals(date)){					
					NodeList tickets = record.getChildNodes();
					for(int j=0;j<tickets.getLength();j++){
						Node ticket = tickets.item(j);
						if(ticket.getNodeType()==Node.ELEMENT_NODE){
							Element Ticket = (Element) ticket;
							int id = Integer.parseInt(Ticket.getAttribute("FilmID"));
							String filmName = Ticket.getAttribute("FilmName");
							String ticketType =Ticket.getAttribute("TicketType");
							String time = Ticket.getAttribute("Time");
							String screenName = Ticket.getAttribute("ScreenName");
							double price = Double.parseDouble(Ticket.getAttribute("Price"));
							String[] seat = {Ticket.getAttribute("Row"),Ticket.getAttribute("Col")};
							PurchasingRecords records = new PurchasingRecords(id, filmName, time, ticketType, price, seat, screenName);
							list.add(records);
						}
					}
				}
			}
		}
		return list;
	}
	public String getDate(){
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String hehe = dateFormat.format( now ); 
		return hehe;
	}
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
	public Document readFile(){
		DocumentBuilder db = getDocumentBuilder();
		Document document=null;
		try {
			document = db.parse("PurchasingRecords.xml");
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
		
	}
	
	@SuppressWarnings("unused")
	public void writeFile(Document doc){

		TransformerFactory tf= TransformerFactory.newInstance();
		try {
			Transformer tff = tf.newTransformer();
			DOMSource doms = new DOMSource();
			tff.transform(new DOMSource(doc),new StreamResult(new File("PurchasingRecords.xml")));
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}
