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
	private Label title;
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
		
		tfInput.setPromptText("test");
	}
	
	private void addComponents() {
		gpInput.add(btInput, 0, 0);
		gpInput.add(tfInput, 1, 0);
		gpInput.add(btImport, 2, 0);
		
		setTop(title);
		setCenter(gpInput);
	}
	
	private void addHandler() {
		btImport.setOnAction(event -> importCSV());
	}
	
	public void importCSV() {
		String fileName = "";
		String filePath = "";
		
		FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        
        File readfile = selectedFile;
		if (readfile.exists()) {
			fileName = readfile.getName();
			filePath = readfile.getAbsolutePath();
		} else {
			System.out.println("The file does not exist.");
		}
		
		if(fileName.endsWith(".csv")) {
	    	try {
				File file = selectedFile;
				Scanner myReader = new Scanner(file);
				String data = "";
				while (myReader.hasNextLine()) {
					data += myReader.nextLine();
				}
				System.out.println(data);
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		} else {
			System.out.println("The file is not a csv file.");
		}

	}
}
