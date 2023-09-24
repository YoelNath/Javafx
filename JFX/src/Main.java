import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	// Objects
	Scene scene1, scene2;
	GridPane grid;
	BorderPane border;
	Label rForm, uName, pw, gender;
	TextField nameF;
	PasswordField pwF;
	RadioButton RB1, RB2;
	CheckBox CB;
	MenuBar Menubar, returnmenu;
	MenuItem item1, item2;
	Menu menu;
	ToggleGroup tg;
	HBox box;
	Button x, y;
	
	public MenuBar menuBarMaker() {
		// Create the menu bar
		// Inisialisasi menu
		Menubar = new MenuBar();
		menu = new Menu("Menu");
		item1 = new MenuItem("Login");
		item2 = new MenuItem("Register");
		
		// Memasukkan menu ke dalam menu bar
		menu.getItems().addAll(item1, item2);
		Menubar.getMenus().add(menu);
//		scene1 = new Scene(Menubar, 500, 500);
		
		return Menubar;
	}
	
	public void form() {
		returnmenu = menuBarMaker();
		grid = new GridPane();
		
		// Register
		rForm = new Label("Register Form");
		rForm.setFont(Font.font("Register Form", FontWeight.BOLD, 30));
		// Username
		uName = new Label("Username");
		
		nameF = new TextField();
		
		// Password
		pw = new Label("Password");
		
		pwF = new PasswordField();
		
		// Gender
		gender = new Label("Gender");
		
		RB1 = new RadioButton("Male");
		RB2 = new RadioButton("Female");
		
		tg = new ToggleGroup();
		RB1.setToggleGroup(tg);
		RB2.setToggleGroup(tg);
		box = new HBox();
		x = new Button("Butt");
		y = new Button("Ass");
//		box.getChildren().addAll(RB1, RB2);
		box.getChildren().addAll(x, y);
		
		// Create Checkbos
		CB = new CheckBox("Agree to terms and conditions");
		
		
		//Add to Gridpane
		grid.add(rForm, 0, 0);
		grid.add(uName, 0, 1);
		grid.add(nameF, 1, 1);
		grid.add(pw, 0, 2);
		grid.add(pwF, 1, 2);
		grid.add(gender, 0, 3);
		grid.add(box, 1, 3);
		grid.add(CB, 0, 4);
		
		// Make grid and menu as one using borderpane
		border = new BorderPane();
//		border.getChildren().addAll(Menubar, grid);
		border.setTop(Menubar);
		border.setCenter(grid);
		
		
		scene1 = new Scene(border, 500, 500);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stg) throws Exception {
		stg.setTitle("Latihan Quiz");
//		menuBar();
		form();
		
		stg.setScene(scene1);
//		stg.setScene(scene2);
		stg.show();
	}

	
}
