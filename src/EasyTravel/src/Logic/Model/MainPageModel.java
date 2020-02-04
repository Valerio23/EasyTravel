package Logic.Model;



public class MainPageModel {
		
	private boolean isCreateble;
	
	public MainPageModel() {
		isCreateble = true;
	}
	
	public void createNewUser(String email, String username, String password) {
		if(isCreateble == true) {
			User new_user = new User(email, username, password);
			System.out.println("Created new user: " + username);
			
		}else {
			System.out.println("Enable to create a new user");
		}
		
	}	
		
	
	
}
