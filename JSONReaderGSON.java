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
	public static void main(String[] Args) throws IOException {		
		
		
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
	}
}
