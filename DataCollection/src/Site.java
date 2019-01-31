import java.util.*;

public class Site {
	String id;
	ArrayList<Item> readings = new ArrayList<Item>();
	
	public Site(String id) {
		this.id = id;
	}
	
	public void addReading(Item r) {
		readings.add(r);
	}
	
	public void startSiteCollection() {
		
	}
	
	public void endSiteCollection() {
		
	}
}
