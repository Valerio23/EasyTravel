package Logic;


import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		try {
			Stage window = primaryStage;
			window.setTitle("Easy Travel");
			Parent root = FXMLLoader.load(getClass().getResource("/Logic/Views/MainPage.fxml"));
			
			Scene scene = new Scene(root, 1800, 1080);
			scene.getStylesheets().add(getClass().getResource("/Logic/Views/MyStyle.css").toExternalForm());
			window.setScene(scene);
			window.show();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
