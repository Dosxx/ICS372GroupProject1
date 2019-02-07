package edu.metrostate.ics372groupproject1.scientificDataCollectionApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Iterator;

import com.google.gson.Gson;


public class IOInterface {
	private String fileName;
	private JFileChooser chooser;
	private File outputFile;
	private Gson gson;
	private LinkedList<Site> listOfSite = new LinkedList<>();
	
	//File chooser constructor
	public IOInterface() {
		fileName = "";
	}
	
	//method to choose a file, it returns the chosen file
	public File chooseFile() throws IOException {
		//Specify the current directory for the file chooser()
        File currentDir = new File(System.getProperty("user.dir")+"/src");
        chooser = new JFileChooser(currentDir);
        
        //filter on files with .text extension
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".JSON files", "json");
        this.chooser.setFileFilter(filter);
        
        //open the file chooser dialog box
        int status = chooser.showOpenDialog(null);
        if(status == JFileChooser.APPROVE_OPTION) {
        	
            //Construct the output file name
            fileName =  chooser.getSelectedFile().getName();
        }
        return chooser.getSelectedFile();
	}
	
	//method to export JSON file
	public void writeToFile() {
		String outputFileName = JOptionPane.showInputDialog("Enter the name of the of the file...");
		try {
			//path and construct of the output file
			outputFile = new File(System.getProperty("user.dir")+"/src/"+ outputFileName + ".json");
			//Instantiate a PrintWriter object
			PrintWriter writer = new PrintWriter(outputFile);
			//Write JSON object to the specified file on the disk
//			writer.write(gson.toJson(mySite)); //mySite will be the site with start collection on
			writer.close();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		//Message to display after the operation are done
		String message = String.format("The %s has been written successfully! \n", outputFile.getName());
		JOptionPane.showMessageDialog(null, message);
	}
	

	//ReadJSON take a file and reads the content into Objects
	public void ReadJson(File input) {
	//local variables to the read method
	BufferedReader reader = null;
	Site mySite = new Site();
		try {
			reader = new BufferedReader(new FileReader(input));
			mySite = gson.fromJson(reader, Site.class);
			//If mySite is not null, add it to the collection on sites
			if(mySite!=null) {
				listOfSite.add(mySite);
			}
			reader.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	//method to get the input file name
	public String getFileName() {
		return fileName;
	}
	
	//get specified site from collection 
//	public Site getSite(String siteID) {
//		Iterator<Site> iterate = listOfSite.iterator();
//		while(iterate.hasNext()) {
//			Site currentSite = iterate.next();
//			if(currentSite.getSiteID().equal(siteID)) {
//				return currentSite;
//			}
//		}
//	}
	
	//get all the site collections
	public void getListOfSite() {
		//to be implemented
	}
	
	// The method set up the path and name of the output file to write to
	public String getOutputFile () {
		return outputFile.getAbsolutePath();
	}
}

