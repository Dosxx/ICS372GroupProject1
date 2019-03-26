package Test;

import edu.metrostate.ics372groupproject1.scientificDataCollectionApp.Item;
import edu.metrostate.ics372groupproject1.scientificDataCollectionApp.Site;
import junit.framework.TestCase;

public class SiteTest extends TestCase{
	Item item1 = new Item("12345", "Temp", "Fahrenheight", "12547g", 25d, 0);
	Item item2 = new Item("46678", "Humidity", "", "56789", 30d, 0);
	Site site1 = new Site("99999");
	Site site2 = new Site();	
	
	//Test to ensure siteId will return the correct value
	public void testGetSiteID() {
		assertEquals("99999",site1.getSiteID());
		assertNull(null,site2.getSiteID());	}

	//Test to ensure SiteID will be set to the value assigned
	public void testSetSiteID() {
		site2.setSiteID("testingSetSiteID");
		assertEquals("testingSetSiteID",site2.getSiteID());	
	}
	

	//Test to ensure that the item is successfully added
	//when the recording is true
	public void testAddItem() {
		site1.setRecording(true);		
		site1.addItem(item1);
		for(Item i:site1.getItems()) {			
			assertEquals(i,item1);
		}  
	}

	//Testing isRecording method
	public void testIsRecording() {
		site1.setRecording(true);
		assertTrue(site1.isRecording());
		
		site1.setRecording(false);
		assertFalse(site1.isRecording());
	}	
	
	public void testSitecontainsAnItem() {
		Item item1 = new Item("12345", "Humidity", "percent", "12547g", 25, 0);
		Site site = new Site("12345");
		site.setRecording(true);
		assertFalse("site should not contains item1", site.getItems().contains(item1));
		
		site.addItem(item1);
		assertTrue("site should contains item1", site.getItems().contains(item1));
	}
	
	public void testSiteAddDuplicateItem() {
		Item item1 = new Item("12345", "Humidity", "percent", "12547g", 25, 0);
		Item item2 = new Item("12345", "Humidity", "percent", "12547g", 25, 0);
		Site site = new Site("12345");
		site.setRecording(true);
		site.addItem(item1);
		assertEquals(1, site.getItems().size());
		
		assertEquals(true, item1.equals(item2));
		
		site.addItem(item2);
		assertEquals(1, site.getItems().size());
		
		Item item3 = new Item("12345", "Humidity", "", "111111", 25, 0);
		site.addItem(item3);
		
		assertEquals(2, site.getItems().size());
	}

}
