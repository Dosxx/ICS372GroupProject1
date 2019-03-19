package Test;

import static org.junit.Assert.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.function.ThrowingRunnable;

import junit.framework.TestCase;

import edu.metrostate.ics372groupproject1.scientificDataCollectionApp.JSONFile;
import edu.metrostate.ics372groupproject1.scientificDataCollectionApp.Readings;


public class JSONFileTest extends TestCase{
	File testJson = new File("../ICS372GroupProject1/src/Test/jsonTest.json");
	JSONFile jf = new JSONFile();
	Readings rd = new Readings();
	
	//test the read method of JSONFile
	public void testReadJSON() throws Exception{
		rd = jf.readJSON(testJson);
		assertEquals(1, rd.getReadings().size());
		
		String actual = rd.getReadings().get(0).getSiteID();
		assertEquals("12513", actual);
		
		double value = rd.getReadings().get(0).getReadingValue();
		assertEquals(84d, value);
		
	}

	//test the write method of JSONFile
	public void testWriteToFile() throws Exception{
		
	}

}