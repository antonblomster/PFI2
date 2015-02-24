package se.mah.k3lara.skaneAPI.view;

import java.util.ArrayList;

import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class StationsThread extends Thread {
	
	private Parser parser;
	private JourneyGUI gui;
	public StationsThread(Parser p, JourneyGUI g) {
		this.parser = p;
		this.gui = g;
	}
	public void run() {
		// code for searching stations
		gui.guiSearch.clear();
		gui.resultArea.setText(null);
		gui.resultArea.setText("Searching... \n");
		gui.guiSearch.addAll(Parser.getStationsFromURL(gui.searchStationText.getText()));
		//ResultArea.setText("");
		gui.resultArea.setText(null);

		for (int i = 0; i < gui.guiSearch.size(); i++){
			gui.resultArea.append(gui.guiSearch.get(i).getStationNbr() + " " +  gui.guiSearch.get(i).getStationName() + "\n");

		}
	}
}
