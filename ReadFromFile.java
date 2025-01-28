package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ReadFromFile extends Scene {
	static VBox readVb = new VBox();
	File file;
	MyButton cancelB = new MyButton();
	TextArea fileTa = new TextArea("No file selected");
	StringBuilder content;

	public ReadFromFile() {
		super(readVb, 800, 600);
		readVb.setStyle("-fx-background-color: #F5EFFF;");

        // Create a layout for the file selection button and label.
		HBox buttonChose = new HBox();
		MyLabel choseLabel = new MyLabel("Select a text file: ");
		MyButton choseB = new MyButton();
		choseB.setPrefWidth(80);
		choseB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\upload.png", 20, 20);
		buttonChose.getChildren().addAll(choseLabel, choseB);
		buttonChose.setSpacing(565);
		buttonChose.setPadding(new Insets(15, 0, 0, 0));
		buttonChose.setAlignment(Pos.CENTER);

        // Create a layout to display the file content in the text area.
		HBox fileTaP = new HBox();
		fileTa.setEditable(false);
		fileTa.setStyle("-fx-background-color: #E5D9F2; " + "-fx-border-color:#A294F9; " + "-fx-border-width: 2px; "
				+ "-fx-font-size: 13.5px; " + "-fx-text-fill: #A294F9; "
				+ " -fx-pref-height: 480px ;-fx-font-family: 'Montserrat'; -fx-border-radius: 4px; ");
		fileTaP.getChildren().add(fileTa);
		fileTaP.setPrefWidth(600);
		fileTa.setPrefWidth(770);
		fileTaP.setAlignment(Pos.CENTER);

        // Create a layout for the action buttons (Cancel and Upload).
		HBox buttomHb = new HBox();
		cancelB.setText("Cancel");
		MyButton uploadB = new MyButton();
		uploadB.setText("Upload");
		buttomHb.setSpacing(600);
		buttomHb.setPadding(new Insets(0, 0, 0, 16));
		buttomHb.getChildren().addAll(cancelB, uploadB);

		readVb.getChildren().addAll(buttonChose, fileTaP, buttomHb);
		readVb.setSpacing(10);

        // Event handler for the "Choose File" button.
		choseB.setOnAction(e -> {
			fileChooser();
			content = new StringBuilder();
			try {
				Scanner in = new Scanner(file);
				while (in.hasNext()) {
					String line = in.nextLine();
					content.append(line + "\n");

				}
				fileTa.setText(String.valueOf(content));

			} catch (FileNotFoundException | NullPointerException e1) {
				System.out.println("Error: File not found!");
			}
		});
		
        // Event handler for the "Upload" button.
		uploadB.setOnAction(e -> addEmployee());
	}
	
	
    // Opens a file chooser dialog to select a text file.
	public void fileChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
		file = fileChooser.showOpenDialog(new Stage());
	}

    // Parses the file content and adds employees to the system.
	public void addEmployee() {
		String[] lines = (String.valueOf(content)).split("\n");
		StringBuilder errorString = new StringBuilder();
		int lineCount = 0;
		boolean isAdded = false;

		try {
			for (String line : lines) {
				System.out.println(line);
				String[] data = line.split(",");
				try {
					lineCount++;
					if (data[0].equalsIgnoreCase("Salaried Employee")) {
						Main.employees.add(new SalariedEmployee(data[1], data[2], data[3],
								new Address(data[4], data[5], data[6]), data[7], data[8], data[9], data[10], data[11],
								Main.defultImage, Double.parseDouble(data[12])));
						isAdded = true;
					} else if (data[0].equalsIgnoreCase("Hourly Employee")) {
						Main.employees.add(new HourlyEmployee(data[1], data[2], data[3],
								new Address(data[4], data[5], data[6]), data[7], data[8], data[9], data[10], data[11],
								Main.defultImage, Short.parseShort(data[12]), Float.parseFloat(data[13])));
						isAdded = true;

					} else if (data[0].equalsIgnoreCase("Commession Employee")) {
						Main.employees.add(new CommessionEmployee(data[1], data[2], data[3],
								new Address(data[4], data[5], data[6]), data[7], data[8], data[9], data[10], data[11],
								Main.defultImage, Double.parseDouble(data[12])));
						isAdded = true;

					} else if (data[0].equalsIgnoreCase("Employee based Comession")) {
						Main.employees.add(new EmployeeBasedComession(data[1], data[2], data[3],
								new Address(data[4], data[5], data[6]), data[7], data[8], data[9], data[10], data[11],
								Main.defultImage, Double.parseDouble(data[12]), Double.parseDouble(data[13])));
						isAdded = true;

					} else {
						throw new InvalidInputException("Invalid Input");
					}
                    // Append error details for invalid or incomplete input.
				} catch (NumberFormatException | InvalidInputException | ArrayIndexOutOfBoundsException e1) {
					if (!String.valueOf(errorString).contains("Error On line: ")) {
						errorString.append("Error On line: " + lineCount + "   ");
					} else
						errorString.append(lineCount + "   ");

				}
			}
			if (isAdded)
				showSuccAlert();
			if (!errorString.isEmpty())
				throw new InvalidInputException(String.valueOf(errorString));

		} catch (InvalidInputException | NumberFormatException e1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Wrong information");
			alert.setHeaderText("There is empty or invalid informatiot");
			alert.setContentText(String.valueOf(errorString));
			alert.showAndWait();
		}
	}

    // Shows a success alert when employees are added successfully.
	public void showSuccAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Done!");
		alert.setHeaderText("Employees Added Successfully!");
		alert.showAndWait();
	}

}
