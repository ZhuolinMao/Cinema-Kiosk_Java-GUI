package xml_Operation;

/**
 * @author Zhang Zifan
 * @date 2017.04.29
 * @version 1.0
 * @throws IOException
 */

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import CinemaSystem.Vo.PurchasingRecords;

public class GetTickets {
    PurchasingRecords records;
	public void getTickets(PurchasingRecords records, String[]seats, String stuID, String colomn) throws IOException {
		//New DocumentBuilderFactory Object
		DocumentBuilderFactory filmInfoDBF = DocumentBuilderFactory.newInstance();
		int mid = records.getFilmID();
		String Tktype = records.getTicketType();
		String ticketID="";
		RecordsOperationImpl recordsOper = new RecordsOperationImpl();
		recordsOper.generateRecords(records, seats[0], colomn);
		//New DocumentBuilder Object
		try {
			//Tickets
			for(int count = 0; count < 8; count++){
				ticketID = ticketID + ""+(int)(Math.random() *4+1);
			}
			String ticketName = ticketID+".txt";
			java.io.File file = new java.io.File(ticketName);
			
			try (java.io.PrintWriter output = new java.io.PrintWriter(file);
					){
			output.println("********Movie Ticket********");
			output.println("***Welcome to the Cinema!***");
			//DocumentBuilder
			DocumentBuilder filmInfoDB = filmInfoDBF.newDocumentBuilder();
			//Put the XML to the item by parser method of New DocumentBuilder Object
			Document filmInfo = filmInfoDB.parse("movies.xml");
			//Get the sets of all the lists of the name
			NodeList filmlist = filmInfo.getElementsByTagName("movies");
			//System.out.println(filmlist.getLength());
			//Go through all the nodes name
			for (int i = 0; i < filmlist.getLength(); i++){
				Node movies = filmlist.item(i);
			    //Go through attributes
				//NamedNodeMap attrs = movies.getAttributes();
				//Get all the attributes of film
		        Element movie = (Element) filmlist.item(i);
		        String attrValue = movie.getAttribute("id");
		        //Get the id
		        int stin = Integer.parseInt(attrValue);
		        NodeList childNodes = movies.getChildNodes();
		        for (int k = 0; k < childNodes.getLength(); k++){
		        	//Get the element nodes only
		        	if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
		        		//Get the names of element nodes
		        		if ( mid == stin ){
		        		//When find the same id
		        			if (childNodes.item(k).getNodeName()!= "imagSrc"){
		        		output.print(childNodes.item(k).getNodeName() + ": ");
		        		output.println(childNodes.item(k).getFirstChild().getNodeValue());
		        			}
		        		}
		        	}
		        	}
		        }
			//**********Screen & Random number for Time \ Seat**********
			output.println("Screen "+ records.getScreenName());
			output.print("Seat: Row "+ seats[0]);
			output.println(", "+"Colomn "+ colomn);
			output.println("Time: "+ records.getTime());
			//**********Type and Price**********
			output.println("Ticket Type: "+ records.getTicketType());
			output.println("Price: "+ records.getPrice()+" GBP");


			//8 random digits for Ticket ID
			output.print("Ticket ID: ");
			output.println(ticketID);
			//If Student Ticket, Display StuID
			if ( Tktype.equals("Student") ){
				output.print("Student ID: ");
				output.println(stuID);
			}
			output.println("*PAY ATTENTION TO YOUR TIME*");
			output.println("****************************");
			
			 
			}	
		} catch (ParserConfigurationException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	

}
