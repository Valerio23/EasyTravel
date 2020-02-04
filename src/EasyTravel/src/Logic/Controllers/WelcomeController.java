package Logic.Controllers;



import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class WelcomeController{
	
	@FXML
    private Button btn_mainMenu;
	
	@FXML
	public Label lbl_username;


    @FXML
    public void ShowMainMenu(ActionEvent event) throws Exception{
    	
    	
    	Stage primaryStage = new Stage();
    	
    	Parent root = FXMLLoader.load(getClass().getResource("/Logic/Views/Choice.fxml"));
    	
    	Scene scene = new Scene(root, 1800, 1080);
		scene.getStylesheets().add(getClass().getResource("/Logic/Views/MyStyle.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

    }
    
    
}    
