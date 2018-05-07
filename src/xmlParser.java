import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.*;
import java.util.List;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.*;
import java.io.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

import com.mysql.jdbc.StringUtils;

public class xmlParser extends DefaultHandler{
	
	List<SingleMoviePage> tempMovList;
	
	List<SingleStarPage> tempStarList;
	
	private String tempVal;
	
	private SingleMoviePage tempMov;
	
	private SingleStarPage tempStar;
	
	public void SAXParser(){
		tempMovList = new ArrayList<SingleMoviePage>();
		tempStarList = new ArrayList<SingleStarPage>();
	}
	
	public void runExample() {
		parseDocument();
		printData();
	}
	
	
	private void parseDocument() {
		
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
		
			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			
			
			//parse the file and also register this class for call backs
			sp.parse("mains243.xml", this);

			//sp.parse("casts124", this);
			
			updateStar(tempMovList);

			
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	
	private void printData(){
		System.out.println("Numbers of records inputted " + tempMovList.size() + tempStarList.size() + ".");
		
	}
	
	//Event Handlers
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		tempVal="";
		if(qName.equalsIgnoreCase("film"))
		{
			tempMov = new SingleMoviePage();
		}else if (qName.equalsIgnoreCase("casts"))
			tempStar = new SingleStarPage();
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException{
		tempVal = new String(ch, start, length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if (qName.equalsIgnoreCase("film")){
			tempMovList.add(tempMov);
		}else if (qName.equalsIgnoreCase("T")){
			tempMov.setMovieName(tempVal);
			System.out.println(tempMov);
		//}else if (qName.equalsIgnoreCase("fid")){
			//tempMov.setId(Integer.parseInt(tempVal));
		}else if (qName.equalsIgnoreCase("year")){
			tempMov.setYear(tempVal);
		}else if (qName.equalsIgnoreCase("dirn")){
			tempMov.setDirector(tempVal);
		}else if (qName.equalsIgnoreCase("cat")){
			tempMov.setGenre(tempVal);
		}
	
		
		/*if (qName.equalsIgnoreCase("casts")){
			tempStarList.add(tempStar);
		}else if (qName.equalsIgnoreCase("a")){
			String split[] = tempVal.split("\\s+");
			tempStar.setFirstName(split[0]);
			tempStar.setLastName(split[1]);
		}else if (qName.equalsIgnoreCase("t")){
			tempStar.setMovies(tempVal);
		}*/
	}
	
	public static void main(String[] args){
		xmlParser spe = new xmlParser();
		spe.runExample();
		
	}
	
	public void updateStar(List TempStarList)
	{
		
	}
	
	public void updateMovie(List TempMovList)
	{
		
	}
}
