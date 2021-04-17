package CinemaSystem.Vo;

import java.io.File;
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

import xml_Operation.GetFilmsImpl;
import xml_Operation.RecordsOperationImpl;

public class Statistics {
	private String filmName[];
	private int sale[];
	private int Student[];
	private int Adult[]; 
	private int Senior[];
	private int Child[];
	@SuppressWarnings("unused")
	private double price;
	public Statistics(String filmName[],int sale[],int Student[],int Adult[],int Senior[],int Child[]){
		this.filmName=filmName;
		this.sale=sale;
		this.Senior=Senior;
		this.Student = Student;
		this.Child=Child;
		this.Adult = Adult;
		this.price = 16;
	}
	public Statistics analyse(){
		String date = getDate();
		PurchasingRecords record;
		ArrayList<PurchasingRecords> records;
		ArrayList<Film> filmlist;
		RecordsOperationImpl op = new RecordsOperationImpl();
		records=op.getRecordsByDate(date);
		GetFilmsImpl film  = new GetFilmsImpl();
		filmlist = film.parse();
		int size = filmlist.size();
		String filmName[] = new String[size];
		for(int i=0;i<size;i++){
			filmName[i] = filmlist.get(i).getName();
		}
		
		int sale[] = new int[size];
		int Student[]= new int[size];
		int Adult[] = new int[size];
		int Senior[] = new int[size];
		int Child[]= new int[size];
		for(int i =0;i<records.size();i++){
			record = records.get(i);
			int id = record.getFilmID()-1;
			sale[id]++;
			switch(record.getTicketType()){
			case "Student":
				Student[id]++;
				break;
			case "Adult":
				Adult[id]++;
				break;
			case "Child":
				Child[id]++;
				break;
			case "Senior":
				Senior[id]++;
				break;
				
			}
		}
		Statistics s = new Statistics(filmName, sale, Student, Adult, Senior, Child);
		for(int i = 0;i < size;i++){
			System.out.println(""+Adult[i]);
		}
		
		return s;
	}
	 public void writefile(Statistics s){
		 String filename = "report.xml";
		 DocumentBuilder db = getDocumentBuilder();
		 Document document=db.newDocument();
		 Element Report = document.createElement("Report");
		 Report.setAttribute("Date", getDate());
		 
		 for(int i=0;i<s.filmName.length;i++){
			 Element Film = document.createElement("FilmName");
			 Film.setAttribute("filmName", s.filmName[i]);
			 Element data = document.createElement("Data");
			 data.setAttribute("TotalSale", ""+s.sale[i]);
			 data.setAttribute("Student", ""+s.Student[i]);
			 data.setAttribute("Senior", ""+s.Senior[i]);
			 data.setAttribute("Adult", ""+s.Adult[i]);
			 data.setAttribute("Child", ""+s.Child[i]);
			 Film.appendChild(data);
			 Report.appendChild(Film);
		 }
		 document.appendChild(Report);
		 TransformerFactory tff = TransformerFactory.newInstance();
			try {
				Transformer tf = tff.newTransformer();
				tf.transform(new DOMSource(document),new StreamResult(new File(filename))); 
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	 public String getDate(){
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");//可以方便地修改日期格式
			String hehe = dateFormat.format( now ); 
			return hehe;
		}

}
