
public class ScientificStudyDriver {
	public static void main(String[] args) {
		
		/// The following codes can be used in GUI to display the items read from JSON file.
		
		String filePathString="C:\\Users\\sashi\\Desktop\\SASHI METROSTATE\\ICS 372 - OOAD\\Group Assignment 1\\example.json";
		
		//Creating JSONReaderGSON object to initiate reading JSON file
		JSONReaderGSON readFromJSON=new JSONReaderGSON();

		//Storing objects read from JSON file into collection class of Site object
		//readJsonFile method inside JSONReaderGSON class is being invoked
		Site site=readFromJSON.readJsonFile(filePathString);		
		
		//Displaying objects read from JSON file using ITERATOR design pattern
		for (Reading i : site.getReadings()) {			
			System.out.println("Site ID:"+i.getSiteID()+"\tReading Type:"+i.getReadingType()+"\tReading ID:"+i.getReadingID()+"\tReading Value:"+i.getReadingValue()+"\tReading Date"+i.getReadingDate());					
		}		
	}
}
