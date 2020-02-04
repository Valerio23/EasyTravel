package Logic.Controllers;

import Logic.Model.MainPageModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainPageController{
	
	
	@FXML
    private TextField fd_email;

    @FXML
    private TextField fd_username;

    @FXML
    private TextField fd_password;

    @FXML
    private Button btn_signUp2;
    
    @FXML
    private Button btn_signUp1;
    
    @FXML
    private Button LogIn_button;
  
    

    @FXML
    public void SignUp1_button(ActionEvent event) throws Exception{
    	
    	String email;
    	String username;
    	String password;
    	
    	email = fd_email.getText();
    	username = fd_username.getText();
		password = fd_password.getText();
    	
    	
    	System.out.println("Email: " + email + ", Username: " + username + ", Password: " + password);
    	
    	MainPageModel model = new MainPageModel();
    	model.createNewUser(email, username, password);
    	
    	Stage primaryStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/Logic/Views/Welcome.fxml"));
    	
    	Scene scene = new Scene(root, 1800, 1080);
		scene.getStylesheets().add(getClass().getResource("/Logic/Views/MyStyle.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    
    @FXML
    public void SignUp2_button(ActionEvent event) throws Exception{
    	
    	String email;
    	String username;
    	String password;
    	
    	email = fd_email.getText();
    	username = fd_username.getText();
    	password = fd_password.getText();
    	
    	System.out.println("Email: " + email + ", Username: " + username + ", Password: " + password);
    	
    	MainPageModel model = new MainPageModel();
    	model.createNewUser(email, username, password);
    	
    	Stage primaryStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/Logic/Views/Welcome.fxml"));
    	
    	Scene scene = new Scene(root, 1800, 1080);
		scene.getStylesheets().add(getClass().getResource("/Logic/Views/MyStyle.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    
    @FXML
    void LogIn_button(ActionEvent event) {

    }
    

   
	
}
