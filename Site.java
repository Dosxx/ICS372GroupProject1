import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Site {
	
	private String siteID;	
	
	/**
	 * Creating collection class to store objects read from JSON file.
	 */
	@SerializedName("site_readings")
	@Expose
	private List<Reading> readings=new ArrayList<Reading>();
	
	
	
	public String getSiteID() {
		return siteID;
	}

	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}

	public List<Reading> getReadings() {
		return readings;
	}

	public void setReadings(List<Reading> readings) {
		this.readings = readings;
	}
	
	

}
