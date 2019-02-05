package edu.metrostate.ics372groupproject1.scientificDataCollectionApp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;


public class GraphicalUserInterface {

	private JFrame frame;
	private JTextField textField;
	private File JSONFile = new File("");
	private String siteID;
//	private IOInterface myInterface;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicalUserInterface window = new GraphicalUserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GraphicalUserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Scientific Data Recorder");
		frame.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().setName("panel");
		frame.setBounds(100, 100, 600, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JTextArea textArea = new JTextArea();
		JTextArea display = new JTextArea();
		
		JLabel header = new JLabel("To start recording , choose a JSON file to be read...");
		header.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		header.setBounds(147, 11, 272, 25);
		frame.getContentPane().add(header);
		
		JButton UploadButton = new JButton("Upload JSON");
		UploadButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		UploadButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		UploadButton.setBounds(40, 74, 114, 23);
		frame.getContentPane().add(UploadButton);
		UploadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
//					JSONFile = myInterface.chooseFile();
//					textArea.setText(myInterface.getFileName());
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		textArea.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textArea.setFont(new Font("Tahoma", Font.ITALIC, 13));
		textArea.setBounds(190, 74, 229, 22);
		frame.getContentPane().add(textArea);
		
		JLabel siteId = new JLabel("Site ID:");
		siteId.setFont(new Font("Tahoma", Font.BOLD, 12));
		siteId.setBounds(40, 122, 63, 25);
		frame.getContentPane().add(siteId);
		
		//Definition of the text field that takes the site ID
		textField = new JTextField();
		textField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBounds(191, 120, 139, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				siteID = textField.getText();
				display.setText("locationID: "+siteID);
			}
		});
		
		//this functional button allow a site collection to start saving
		JButton startButton = new JButton("Start Collection");
		startButton.setBackground(Color.GREEN);
		startButton.setForeground(Color.BLACK);
		startButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		startButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		startButton.setBounds(190, 174, 114, 23);
		frame.getContentPane().add(startButton);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This is where the call to the method to stop saving will go
				JOptionPane.showMessageDialog(null, "Start collecting!");
			}
		});
		
		JButton stopButton = new JButton("Stop Collection");
		stopButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		stopButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		stopButton.setBackground(Color.RED);
		stopButton.setBounds(361, 175, 114, 23);
		frame.getContentPane().add(stopButton);
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This is where the call to the method to stop saving will go
				JOptionPane.showMessageDialog(null, "Stopped collecting!");
			}
		});
		
		//This functional button will read the input JSON file
		JButton readingButton = new JButton("Add Reading");
		readingButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		readingButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		readingButton.setBounds(40, 233, 114, 23);
		frame.getContentPane().add(readingButton);
		readingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This is where the call to the method to read the JSON will go
				try {
					
				}catch(Exception event) {
					JOptionPane.showMessageDialog(null, event.getMessage());
				}
			}
		});
		//this Text area will contain the recorded collection at a specified site
		
		display.setLineWrap(true);
		display.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		display.setBounds(40, 280, 506, 274);
		frame.getContentPane().add(display);
		//this is where the output to the dispay will be coded
		display.setText("string representation of the site collections");
		
		//this function will export the site collection in a JSON format
		JButton exportButton = new JButton("Export JSON");
		exportButton.setAutoscrolls(true);
		exportButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		exportButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, null));
		exportButton.setBounds(40, 565, 114, 23);
		frame.getContentPane().add(exportButton);
		exportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This is where the call to the method to write the JSON to a file will go
				try {
					
					JOptionPane.showMessageDialog(null, "Output file created!");
				}catch(Exception event) {
					JOptionPane.showMessageDialog(null, event.getMessage());
				}
			}
		});
	}
}
