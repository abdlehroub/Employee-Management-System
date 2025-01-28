package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HomePage extends Scene {
	static BorderPane bp = new BorderPane();
	static MenuItem exitM = new MyMenuItem("Exit");
	BorderPane statPane = new BorderPane();
	MaxSalaryPane maxPane = new MaxSalaryPane();
	SortPane sort = new SortPane();

	public HomePage() {
		super(bp);
		bp.setStyle("-fx-background-color: #E5D9F2");

		// Employee Menu
		Menu employeeMenu = new Menu("Employee");
		employeeMenu.setStyle(
				"-fx-background-color: #E5D9F2; -fx-text-fill: white; -fx-font-family: 'Montserrat';-fx-font-size: 12px;");
		MenuItem addEmployee = new MyMenuItem("    Add Employee    ");
		MenuItem viewEmployeeM = new MyMenuItem("   View Employees  ");
		MenuItem UpdateEmployee = new MyMenuItem(" Update Employee ");
		MenuItem removeEmployee = new MyMenuItem("Remove Employee");
		employeeMenu.getItems().addAll(addEmployee, viewEmployeeM, UpdateEmployee, removeEmployee);

		// Report Menu
		Menu reportMenu = new Menu("Statistical Report");
		reportMenu.setStyle(
				"-fx-background-color: #E5D9F2; -fx-text-fill: white; -fx-font-family: 'Montserrat';-fx-font-size: 12px;");
		MenuItem maxEmployee = new MyMenuItem("Maximum Salary");
		MenuItem totalPayment = new MyMenuItem("  Total payment  ");
		Menu sortBy = new MyMenu("   Sort By  ");
		MenuItem firstName = new MyMenuItem("First Name ");
		MenuItem lastName = new MyMenuItem("Last Name ");
		MenuItem education = new MyMenuItem(" Education ");
		MenuItem salaryM = new MyMenuItem("      Salary    ");

		addEmployee.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+A"));
		viewEmployeeM.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+V"));
		UpdateEmployee.setAccelerator(KeyCombination.keyCombination("Ctrl+U"));
		removeEmployee.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
		maxEmployee.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
		totalPayment.setAccelerator(KeyCombination.keyCombination("Ctrl+T"));
		firstName.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+F"));
		lastName.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+L"));
		education.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+E"));
		salaryM.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+S"));
		exitM.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));

		sortBy.getItems().addAll(firstName, lastName, education, salaryM);
		reportMenu.getItems().addAll(maxEmployee, totalPayment, sortBy);

		// Exit Menu
		Menu exitMenu = new Menu("Exit");
		exitMenu.setStyle(
				"-fx-background-color: #E5D9F2; -fx-text-fill: white; -fx-font-family: 'Montserrat';-fx-font-size: 12px;");
		exitMenu.getItems().add(exitM);

		// Menu Bar
		MenuBar menuBar = new MenuBar(employeeMenu, reportMenu, exitMenu);
		menuBar.setStyle("-fx-background-color: #E5D9F2;");

		bp.setTop(menuBar);

		// Tabs
		TabPane tabs = new TabPane();
		Tab emploeeRecordTab = new Tab("Employee Record");
		emploeeRecordTab.setClosable(false);
		Tab statisticalReportTap = new Tab(" Statistical Report");
		statisticalReportTap.setClosable(false);
		tabs.getTabs().addAll(emploeeRecordTab, statisticalReportTap);
		tabs.setStyle(
				"-fx-background-color: #F5EFFF;-fx-text-fill: white; -fx-font-family: 'Montserrat';-fx-font-size: 12px;");
		emploeeRecordTab.setStyle("-fx-background-color: #F5EFFF;");
		statisticalReportTap.setStyle("-fx-background-color: #F5EFFF;");
		bp.setCenter(tabs);

		// Employee Record Layout
		HBox employeerecordP = new HBox();
		GridPane employeeRecordButtns = new GridPane();

		// Add Employee Button
		MyButton addB = new MyButton();
		addB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\plus (1).png", 80, 80);
		addB.setPrefWidth(200);
		addB.setPrefHeight(200);
		addB.setFont(new Font(30));

		// View Employees Button
		MyButton viewB = new MyButton();
		viewB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\overview (1).png", 80, 80);
		viewB.setPrefWidth(200);
		viewB.setPrefHeight(200);
		viewB.setFont(new Font(30));

		// Read and Save Buttons
		MyButton readB = new MyButton();
		readB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\document.png", 80, 80);
		readB.setPrefWidth(200);
		readB.setPrefHeight(200);
		readB.setFont(new Font(30));
		MyButton saveB = new MyButton();
		saveB.setIcon("file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\folder-download.png", 80, 80);
		saveB.setPrefWidth(200);
		saveB.setPrefHeight(200);
		saveB.setFont(new Font(30));

		// Add buttons to grid
		employeeRecordButtns.add(addB, 0, 0);
		employeeRecordButtns.add(saveB, 0, 1);
		employeeRecordButtns.add(readB, 1, 0);
		employeeRecordButtns.add(viewB, 1, 1);
		employeeRecordButtns.setVgap(10);
		employeeRecordButtns.setHgap(10);

		// Statistical Report Layout
		ImageView bigImage = new ImageView(
				new Image("file:C:\\Users\\Abdelrahman Lehroub\\Desktop\\Project Icons\\EmpManag.png"));
		bigImage.setFitHeight(441);
		bigImage.setFitWidth(618);
		employeeRecordButtns.setAlignment(Pos.CENTER);
		employeerecordP.getChildren().addAll(employeeRecordButtns, bigImage);
		employeerecordP.setAlignment(Pos.CENTER);
		emploeeRecordTab.setContent(employeerecordP);

		HBox statHbox = new HBox();
		ToggleGroup group = new ToggleGroup();
		RadioButton maxRb = new MyRadioButton("Max Salary");
		RadioButton totalRb = new MyRadioButton("Total Payment");
		RadioButton sortRb = new MyRadioButton("Sort");

		maxRb.setToggleGroup(group);
		totalRb.setToggleGroup(group);
		sortRb.setToggleGroup(group);
		statHbox.getChildren().addAll(maxRb, totalRb, sortRb);
		statHbox.setAlignment(Pos.CENTER);
		statHbox.setSpacing(20);
		Label statRep = new Label("Welcome to Statistical Report\n    Please Select Your Choice");
		statRep.setStyle("-fx-font-size: 80px;" + "-fx-alignment: center; -fx-font-weight: bold; " + // Font weight //
																										// (bold)
				"-fx-text-fill: #A294F9; " + // Text color (white)
				"-fx-font-style: italic;");
		statPane.setCenter(statRep);
		statPane.setBottom(statHbox);
		statPane.setPadding(new Insets(40, 0, 20, 0));

		statisticalReportTap.setContent(statPane);

		// Add actions and functionality for buttons and menu items
		maxRb.setOnAction(e -> {
			maxEmp();

		});
		totalRb.setOnAction(e -> {
			totalPayment();
		});
		sortRb.setOnAction(e -> {
			sort();
		});

		AddPage addPage = new AddPage();
		Stage addStage = new Stage();
		addStage.setScene(addPage);
		addStage.setTitle("Add Employee");
		addStage.setResizable(false);
		addStage.getIcons().add(new Image("file:C:\\Users\\Abdelrahman Lehroub\\Desktop\\Project Icons\\projIcon.png"));

		ViewPage viewPage = new ViewPage();
		Stage viewStage = new Stage();
		viewStage.setScene(viewPage);
		viewStage.setTitle("View Employees");
		viewStage.setResizable(false);
		viewStage.getIcons()
				.add(new Image("file:C:\\Users\\Abdelrahman Lehroub\\Desktop\\Project Icons\\projIcon.png"));

		Stage readStage = new Stage();
		ReadFromFile readPage = new ReadFromFile();
		readStage.setScene(readPage);
		readStage.setTitle("Read From File");
		readStage.setResizable(false);
		readStage.getIcons()
				.add(new Image("file:C:\\Users\\Abdelrahman Lehroub\\Desktop\\Project Icons\\projIcon.png"));

		Stage updateStage = new Stage();
		UpdatePage update = new UpdatePage();
		updateStage.setScene(update);
		updateStage.setTitle("Read From File");
		updateStage.setResizable(false);
		updateStage.getIcons()
				.add(new Image("file:C:\\Users\\Abdelrahman Lehroub\\Desktop\\Project Icons\\projIcon.png"));

		Stage removeStage = new Stage();
		RemovePage removeScene = new RemovePage();
		removeStage.setScene(removeScene);
		removeStage.setTitle("Read From File");
		removeStage.setResizable(false);
		removeStage.getIcons()
				.add(new Image("file:C:\\Users\\Abdelrahman Lehroub\\Desktop\\Project Icons\\projIcon.png"));

		addB.setOnAction(e -> {
			viewStage.close();
			addStage.show();
			new ClearEvent().handle(e);
		});

		addPage.backB.setOnAction(e -> addStage.close());

		addEmployee.setOnAction(e -> {
			addStage.show();
			new ClearEvent().handle(e);
		});

		viewB.setOnAction(e -> {
			addStage.close();
			ViewPage.employeesTv.setItems(Main.employees);
			ViewPage.empNoTf.setText(null);
			viewPage.updateB.setDisable(true);
			viewPage.deleteB.setDisable(true);
			viewPage.searchB.setDisable(true);
			viewStage.show();

		});

		viewPage.backB.setOnAction(e -> {
			viewStage.close();
		});

		viewEmployeeM.setOnAction(e -> {
			addStage.close();
			ViewPage.employeesTv.setItems(Main.employees);
			ViewPage.empNoTf.setText(null);
			viewPage.updateB.setDisable(true);
			viewPage.deleteB.setDisable(true);
			viewPage.searchB.setDisable(true);
			viewStage.show();
		});
		viewPage.deleteB.setOnAction(e -> {
			if (Integer.parseInt(viewPage.empNoTf.getText()) - 1 < Main.employees.size()) {
				Main.empCounter = Integer.parseInt(viewPage.empNoTf.getText()) - 1;
				new PreRemoveEvent().handle(e);
				if (Main.employees.size() != 0)
					removeStage.show();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error: No Employees");
				alert.setHeaderText("There is no employee has this number");
				alert.setContentText(null);
				alert.showAndWait();
			}

		});
		viewPage.updateB.setOnAction(e -> {
			if (Integer.parseInt(viewPage.empNoTf.getText()) - 1 < Main.employees.size()) {
				Main.empCounter = Integer.parseInt(viewPage.empNoTf.getText()) - 1;
				new PreUpdateEvent().handle(e);
				if (Main.employees.size() != 0)
					updateStage.show();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error: No Employees");
				alert.setHeaderText("There is no employee has this number");
				alert.setContentText(null);
				alert.showAndWait();
			}

		});

		readB.setOnAction(e -> {
			readPage.fileTa.setText("No file selected");
			if (readPage.file != null)
				readPage.file.delete();
			if (readPage.content != null)
				readPage.content.delete(0, readPage.content.length() - 1);
			readStage.show();
		});

		saveB.setOnAction(new SaveOnFileEvent());

		readPage.cancelB.setOnAction(e -> {
			readStage.close();
		});

		UpdateEmployee.setOnAction(e -> {
			Main.empCounter = 0;
			new PreUpdateEvent().handle(e);
			if (Main.employees.size() != 0)
				updateStage.show();
		});
		update.backB.setOnAction(e -> {
			updateStage.close();
		});
		removeEmployee.setOnAction(e -> {
			Main.empCounter = 0;
			new PreRemoveEvent().handle(e);
			if (Main.employees.size() != 0)
				removeStage.show();
		});

		removeScene.backB.setOnAction(e -> {
			removeStage.close();
		});
		maxEmployee.setOnAction(e -> {
			tabs.getSelectionModel().select(statisticalReportTap);
			maxRb.setSelected(true);
			maxEmp();

		});
		totalPayment.setOnAction(e -> {
			tabs.getSelectionModel().select(statisticalReportTap);
			totalRb.setSelected(true);
			totalPayment();
		});
		firstName.setOnAction(e -> {
			tabs.getSelectionModel().select(statisticalReportTap);
			sortRb.setSelected(true);
			sortByFirstName();
		});
		lastName.setOnAction(e -> {
			tabs.getSelectionModel().select(statisticalReportTap);
			sortRb.setSelected(true);
			sortByLastName();
		});
		education.setOnAction(e -> {
			tabs.getSelectionModel().select(statisticalReportTap);
			sortRb.setSelected(true);
			sortByEducation();
		});
		salaryM.setOnAction(e -> {
			tabs.getSelectionModel().select(statisticalReportTap);
			sortRb.setSelected(true);
			sortBySalary();
		});
		statisticalReportTap.setOnSelectionChanged(e -> {
			maxRb.setSelected(true);
			maxEmp();
		});

	}

	// Display max salary pane
	public void maxEmp() {
		HBox max = new HBox();
		maxPane = new MaxSalaryPane();
		max.getChildren().add(maxPane);
		max.setAlignment(Pos.CENTER);
		statPane.setCenter(max);
		BorderPane.setAlignment(maxPane, Pos.CENTER);
	}

	// Display sort pane
	public void sort() {
		HBox sortHb = new HBox();
		sort = new SortPane();
		sortHb.getChildren().add(sort);
		sortHb.setAlignment(Pos.CENTER);
		statPane.setCenter(sortHb);
	}

	// Sort types functionality
	public void sortByFirstName() {
		HBox sortHb = new HBox();
		sort = new SortPane();
		sortHb.getChildren().add(sort);
		sortHb.setAlignment(Pos.CENTER);
		sort.sortByCb.setValue("First Name");
		sort.sortByFirstName();
		statPane.setCenter(sortHb);
	}

	public void sortByLastName() {
		HBox sortHb = new HBox();
		sort = new SortPane();
		sortHb.getChildren().add(sort);
		sortHb.setAlignment(Pos.CENTER);
		sort.sortByCb.setValue("Last Name");
		sort.sortByLastName();
		statPane.setCenter(sortHb);
	}

	public void sortByEducation() {
		HBox sortHb = new HBox();
		sort = new SortPane();
		sortHb.getChildren().add(sort);
		sortHb.setAlignment(Pos.CENTER);
		sort.sortByCb.setValue("Education");
		sort.sortByEducation();
		statPane.setCenter(sortHb);
	}

	public void sortBySalary() {
		HBox sortHb = new HBox();
		sort = new SortPane();
		sortHb.getChildren().add(sort);
		sortHb.setAlignment(Pos.CENTER);
		sort.sortByCb.setValue("Salary");
		sort.sortBySalary();
		statPane.setCenter(sortHb);
	}

	// Calculate total salary
	public void totalPayment() {
		HBox total = new HBox();
		SumPayment sum = new SumPayment("Total Payement");
		total.getChildren().add(sum);
		total.setAlignment(Pos.CENTER);
		statPane.setCenter(total);
		BorderPane.setAlignment(sum, Pos.CENTER);
	}

}
