package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	//Home page
	    StackPane root = new StackPane();
	    
        //view assets button
	    Button view_assets = new Button("View Assets");
	    
        //add new asset button
	    Button new_asset = new Button("Add New Asset");
        //view categories button
        Button view_categories = new Button("View Categories");
        //add new category button
            //This button will lead to a new stage/page
        Button add_new_category = new Button("Add New Category");
        //Add icon image
	        
	//Add new category page
        //Category name textfield
            //error if left empty after pressing save
        
    
        //Category Description textfield
            //error if left empty after pressing save
        
        //save button
            //When pressed, will close this page and lead back to homepage
        Button save = new Button("Save");
        //cancel button
        Button cancel = new Button("Cancel");
	    
	    
	    
	    
	    
	    
	    
	    
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
