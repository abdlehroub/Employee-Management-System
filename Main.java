package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	static ObservableList<Employee> employees = FXCollections.observableArrayList();
	static Image defultImage = new Image(
			"file:C:\\Users\\Abdelrahman Lehroub\\Downloads\\norman_for_facebook_no_profile_by_crescentreiss_defdwmj-fullview.jpg");
	static int empCounter = 0;

	@Override
	public void start(Stage primaryStage) {
		try {
			HomePage scene = new HomePage();
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.setTitle("Employee Management System");
			primaryStage.show();
			primaryStage.getIcons()
					.add(new Image("file:C:\\Users\\Abdelrahman Lehroub\\Desktop\\Project Icons\\projIcon.png"));
			HomePage.exitM.setOnAction(e -> primaryStage.close());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
