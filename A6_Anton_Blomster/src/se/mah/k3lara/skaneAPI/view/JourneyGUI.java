package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTextArea;

import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class JourneyGUI extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField searchStationText;
	ArrayList<Station> guiSearch = new ArrayList<Station>();
	private JTextArea resultArea;
	private JPanel panel_1;
	private JTextField fromTextField;
	private JTextField toTextField;
	private JTextArea resultJourney;
	   


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JourneyGUI frame = new JourneyGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JourneyGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 197, 289);
		contentPane.add(panel);
		panel.setLayout(null);
		
		searchStationText = new JTextField();
		searchStationText.setBounds(25, 6, 134, 28);
		panel.add(searchStationText);
		searchStationText.setColumns(10);
		
		JButton searchButton = new JButton("Sök hållplats");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			guiSearch.clear();
			resultArea.setText(null);
			guiSearch.addAll(Parser.getStationsFromURL(searchStationText.getText()));
			//ResultArea.setText("");
			
			for (int i = 0; i < guiSearch.size(); i++){
				resultArea.append(guiSearch.get(i).getStationName() + "\n");

			}
			
			//for (Station s: guiSearch){
				//ResultArea.append(s.getStationName() +" number:" +s.getStationNbr() + "\n");
			//}
			}
		});
		searchButton.setBounds(31, 38, 125, 29);
		panel.add(searchButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 71, 185, 212);
		panel.add(scrollPane);
		
		resultArea = new JTextArea();
		scrollPane.setViewportView(resultArea);
		
		panel_1 = new JPanel();
		panel_1.setBounds(197, 0, 391, 289);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		fromTextField = new JTextField();
		fromTextField.setBounds(6, 24, 134, 28);
		panel_1.add(fromTextField);
		fromTextField.setColumns(10);
		
		toTextField = new JTextField();
		toTextField.setBounds(6, 85, 134, 28);
		panel_1.add(toTextField);
		toTextField.setColumns(10);
		
		JLabel lblFrn = new JLabel("Från:");
		lblFrn.setBounds(6, 6, 61, 16);
		panel_1.add(lblFrn);
		
		JLabel lblTill = new JLabel("Till:");
		lblTill.setBounds(6, 64, 61, 16);
		panel_1.add(lblTill);
		
		JButton searchJourney = new JButton("Sök resa");
		searchJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultJourney.setText(null);
				
			}
		});
		searchJourney.setBounds(16, 125, 117, 29);
		panel_1.add(searchJourney);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(149, 13, 236, 270);
		panel_1.add(scrollPane_1);
		
		resultJourney = new JTextArea();
		scrollPane_1.setViewportView(resultJourney);
		

	}
}
