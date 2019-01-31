import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter the id of the site you'd like to collect data from");
		String s = scanner.nextLine();
		scanner.close();
		
		Site newSite = new Site(s);
		
		String path = "C:\\Users\\Ryan\\eclipse-workspace\\DataCollection\\src\\readings.json";
		JsonReader reader = new JsonReader(new FileReader(path));	
		JsonObject obj = new JsonParser().parse(reader).getAsJsonObject();
		JsonArray items = obj.getAsJsonArray("site_readings");
		Item readings[] = new Item[items.size()];
		Gson gson = new Gson();
		
		for(int i = 0; i < items.size(); i++) {
			readings[i] = gson.fromJson(items.get(i), Item.class);
			if(readings[i].getSite_id().equals(newSite.id)) {
				newSite.addReading(readings[i]);
			}
		}
		
		if(!newSite.readings.isEmpty()) {
			System.out.println(newSite.readings.toString());
		}
		else {
			System.out.println("No readings for this site");
		}
	}

}
