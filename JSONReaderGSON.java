import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class JSONReaderGSON {
	private String filePath;
	
	/**
	 * Constructor
	 */
	public JSONReaderGSON() {		
	}
	
	/**
	 * A method to read a JSON file
	 * @param filePath - physical location of the JSON file in the disk.
	 * @return - returns a Site object that holds the collection of objects read from JSON file
	 */
	public Site readJsonFile(String filePath){
		this.filePath=filePath;
		Site site=null;
		
		Gson gson=new Gson();
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader(this.filePath));
			Site reading=gson.fromJson(br,Site.class);
			if(reading!=null) {
				site=reading;
			}
		}
		catch (FileNotFoundException e) {
		    e.printStackTrace();
		} 
		finally {
		    if (br != null) {
		    	try {
		    		br.close();
		    	} 
		    	catch (IOException e) {
		    		e.printStackTrace();
		    	}
		    }
		
		}
		return site;
	}
	
	/*
	//The following line of code is to demonstrate how to implement inside the main method directly
	//
	//
	public static void main(String[] Args) throws IOException {		
		
		///constructor
		//variable will get the file path		
		
		Gson gson = new Gson();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\sashi\\Desktop\\SASHI METROSTATE\\ICS 372 - OOAD\\Group Assignment 1\\example.json"));
			ItemJsonResult result=gson.fromJson(br, ItemJsonResult.class);					
			if (result != null) {				
				for (Item i : result.getItems()) {
					System.out.println("Site ID:"+i.getSiteID()+"\tReading Type:"+i.getReadingType()+"\tReading ID:"+i.getReadingID()+"\tReading Value:"+i.getReadingValue()+"\tReading Date"+i.getReadingDate());					
				}
			}
		} 
		catch (FileNotFoundException e) {
		    e.printStackTrace();
		} 
		finally {
		    if (br != null) {
		    	try {
		    		br.close();
		    	} 
		    	catch (IOException e) {
		    		e.printStackTrace();
		    	}
		    }
		
		}
	}*/
}
