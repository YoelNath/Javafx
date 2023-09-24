import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class KeyStore extends Application{

	Stage stage; 
	Scene scene1, scene2; // Login page, Register page
	Label JKStore, email, password, pwConfirm;
	TextField emailF;
	PasswordField pwF, pwF2;
	Button regist, login;
	BorderPane borderP;
	GridPane GP;
//	FlowPane FP;
//	TilePane TP;
	HBox HB;
	VBox VB;
	Alert warn;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void loginWindow() {
		// Label utama
		JKStore = new Label("Jee Keyboard Store");
		JKStore.setFont(Font.font("Jee Keyboard Store", FontWeight.BOLD, 30));
		JKStore.setAlignment(Pos.TOP_CENTER);
		
		// Label email dan password
		email = new Label("Email");
		password = new Label("Password");
		email.setFont(Font.font(15));
		password.setFont(Font.font(15));
		
		// Text field untuk email dan password
		emailF = new TextField();
		pwF = new PasswordField();
		
		// Button untuk register dan login
		regist = new Button("Register");
		login = new Button("Login");
		regist.setStyle("-fx-background-color: #555555; -fx-text-fill: #e5f0f5;");
		login.setStyle("-fx-background-color: #555555; -fx-text-fill: #e5f0f5;");
		regist.setPrefSize(120, 30);
		login.setPrefSize(120, 30);
		
		// Buat horizontal box
		HB = new HBox ();
		HB.getChildren().addAll(regist, login);
		HB.setSpacing(10.0);
		
		// Buat gridpane
		GP = new GridPane();
		GP.add(email, 0, 0);
		GP.add(password, 0, 1);
		GP.add(emailF, 1, 0);
		GP.add(pwF, 1, 1);
		GP.add(HB, 1, 2);
		GP.setHgap(5);
		GP.setVgap(7);
		GP.setAlignment(Pos.CENTER);
		
		// Buat vertical box
		VB = new VBox(JKStore, GP);
		VB.setSpacing(20);
		VB.setAlignment(Pos.CENTER);
		
		// Masukkan vBox kedalam Borderpane
		borderP = new BorderPane(VB);
		borderP.setCenter(VB);
		
		// Masukkan kedalam scene
		scene1 = new Scene(borderP, 800, 500);
	}
	
	public void registWindow() {
		JKStore = new Label("Register");
		JKStore.setFont(Font.font("Register", FontWeight.BOLD, 25));
		JKStore.setAlignment(Pos.TOP_CENTER);
		
		// Label email dan password
		email = new Label("Email");
		password = new Label("Password");
		pwConfirm = new Label("Confirm Password");
		
		email.setFont(Font.font(15));
		password.setFont(Font.font(15));
		pwConfirm.setFont(Font.font(15));
		
		// Text field untuk email dan password
		emailF = new TextField();
		pwF = new PasswordField();
		pwF2 = new PasswordField();
		
		// Button untuk register dan login
		regist = new Button("Register");
		login = new Button("Login");
		regist.setStyle("-fx-background-color: #555555; -fx-text-fill: #e5f0f5;");
		login.setStyle("-fx-background-color: #555555; -fx-text-fill: #e5f0f5;");
		regist.setPrefSize(120, 30);
		login.setPrefSize(120, 30);
		
		// Buat horizontal box
		HB = new HBox ();
		HB.getChildren().addAll(login, regist);
		HB.setSpacing(10.0);
		
		// Buat gridpane
		GP = new GridPane();
		GP.add(email, 0, 0);
		GP.add(password, 0, 1);
		GP.add(emailF, 1, 0);
		GP.add(pwF, 1, 1);
		GP.add(pwConfirm, 0, 2);
		GP.add(pwF2, 1, 2);
		GP.add(HB, 1, 3);
		GP.setHgap(5);
		GP.setVgap(7);
		GP.setAlignment(Pos.CENTER);
		
		// Buat vertical box
		VB = new VBox(JKStore, GP);
		VB.setSpacing(20);
		VB.setAlignment(Pos.CENTER);  
		
		// Masukkan vBox kedalam Borderpane
		borderP = new BorderPane(VB);
		borderP.setCenter(VB);
		
		// Masukkan kedalam scene
		scene2 = new Scene(borderP, 800, 500);
	}
	
	public void actionLogin() {
		warn = new Alert(AlertType.NONE);
		String email = emailF.getText();
		String password = pwF.getText();
		login.setOnAction(e->{
			if(email.isBlank()) {
				warn.setAlertType(AlertType.ERROR);
				warn.setContentText("Email field can't be empty");
				warn.setTitle("Login Failed");
				warn.setHeaderText("");
				warn.show();
			}
			else if(password.isBlank()) {
				warn.setAlertType(AlertType.ERROR);
				warn.setContentText("Password field can't be empty");
				warn.setTitle("Login Failed");
				warn.setHeaderText("");
				warn.show();
			}
//			else if(emailF.getText() == "admin" && pwF.getText() == "admin") {
				
//			}
			else {
				warn.setAlertType(AlertType.INFORMATION);
				warn.setHeaderText("Login Success");
				warn.setTitle("");
				warn.show();
//				login.setOnAction(e-> switchScene(null));
			}
		});
		
		regist.setOnAction(e -> switchScene(scene2));
		
	}
	
	public void RegistAction() {
		login.setOnAction(e -> switchScene(scene1));
		warn = new Alert(AlertType.NONE);
		regist.setOnMouseClicked(e -> {
			if(emailF.getText().isEmpty() || pwF.getText().isEmpty() || pwF2.getText().isEmpty()) {
				warn.setAlertType(AlertType.ERROR);
				warn.setTitle("Error");
				warn.setHeaderText("");
				warn.setContentText("Please fill username, password, or confirm password!");
			}
			else if(emailF.getText().endsWith("@email") == false || emailF.getText().indexOf("@") != emailF.getText().lastIndexOf("@") || emailF.getText().contains(" ") || emailF.getText().startsWith("@")) {
				warn.setAlertType(AlertType.ERROR);
				warn.setTitle("Error");
				warn.setHeaderText("");
				warn.setContentText("Invalid Email!");
			}
			else if(pwF2.getText().equals(pwF.getText()) == false) {
				warn.setAlertType(AlertType.ERROR);
				warn.setTitle("Error");
				warn.setHeaderText("");
				warn.setContentText("Password and Confirm Password don't match!");
			}
			else {
				String email = emailF.getText().toString();
				String password = pwF.getText().toString();
				
				saveData(email, password);
				openLoginWindow();
				stage.setScene(scene1);
			}
		});
	}
	
	private void saveData(String email, String password) {
        // Save the registration data here
        System.out.println("Registration data saved:\nEmail: " + emailF.getText().toString() + "\nPassword: " + pwF.getText().toString());
    }

    private void openLoginWindow() {
        // Open the login window here
        System.out.println("Opening Login Window...");
    }
	
	public void switchScene(Scene scene) {
		stage.setScene(scene);
	}
	
	@Override
	public void start(Stage stg) throws Exception {
		stage = stg;
		stage.setTitle("Login");
		loginWindow();
		actionLogin();
		registWindow();
		RegistAction();
		stage.setScene(scene1);
		stage.show();
	}

}
