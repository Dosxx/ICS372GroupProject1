import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ItemJsonResult {
	
	@SerializedName("site_readings")
	@Expose
	private List<Item> items=new ArrayList<Item>();
	
	public List<Item> getItems(){
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items=items;
	}

}
