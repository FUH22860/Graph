package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public class RootBorderPane extends BorderPane {
	private Label title, data;
	private TextField tfInput;
	private Button btInput, btImport;
	private GridPane gpInput;
	
	public RootBorderPane() {
		initComponents();
		addComponents();
		addHandler();
	}
	
	private void initComponents() {
		title = new Label("Do stuff");
		tfInput = new TextField();
		btInput = new Button("Absenden");
		btImport = new Button("Importieren");
		gpInput = new GridPane();
		data = new Label();
		
		tfInput.setPromptText("test");
	}
	
	private void addComponents() {
		gpInput.add(btInput, 0, 0);
		gpInput.add(tfInput, 1, 0);
		gpInput.add(btImport, 2, 0);
		gpInput.add(data, 1, 1);
		
		setTop(title);
		setCenter(gpInput);
	}
	
	private void addHandler() {
		btImport.setOnAction(event -> importCSV());
	}
	
	private void importCSV() {
		FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        
		if(selectedFile.getName().endsWith(".csv")) {
	    	try {
				Scanner myReader = new Scanner(selectedFile);
				
				tfInput.setText(selectedFile.getAbsolutePath());
				while (myReader.hasNextLine()) {
					data.setText(myReader.nextLine());
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not Found");
				e.printStackTrace();
			}
		} else {
			Main.showAlert("The file is not a csv file.");
		}
	}
}
