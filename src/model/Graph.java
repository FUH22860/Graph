package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
	private ArrayList<Graph> values;
	
	public Graph() {
		values = new ArrayList<Graph>();
	}
	
	public boolean receiveValues() throws GraphException {
		try (BufferedReader br = new BufferedReader(new FileReader(""))) { // filePath von application.RootBorderPane.importCSV()
			String zeile;
			String[] zeilenTeile;
			String sep = ";"; // erwartetes Trennzeichen in der csv-Datei

			
			zeile = br.readLine(); // wenn keine Zeile gefunden, dann return null

			while (zeile != null) {
				zeilenTeile = zeile.trim().split(sep);
			}
			
		} catch (FileNotFoundException e) {
			throw new GraphException("Datei-Fehler bei receiveValues(): " + e.getMessage());
		} catch (IOException e) {
			throw new GraphException("Datei-Fehler bei receiveValues(): " + e.getMessage());
		}
		return false;
	}
	
}
