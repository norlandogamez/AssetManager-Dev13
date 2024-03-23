package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	//Home page
	    FlowPane root = new FlowPane();
	    
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
	    
        
        root.getChildren().addAll(view_assets, new_asset, view_categories, add_new_category);
        
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Home Page");
        primaryStage.show();
	//Add new category page
        
        
        add_new_category.setOnAction(e->{
            
            StackPane root2 = new StackPane();
        
            Label label = new Label("Add New category page");
            root2.getChildren().add(label);
            Scene secondScene = new Scene(root2, 500, 500);
            Stage secondStage = new Stage();
            
            secondStage.setScene(secondScene);
            secondStage.setTitle("Add New Category Page");
            secondStage.show();
        });
        
        //Category name textfield
            //error if left empty after pressing save
        
    
        //Category Description textfield
            //error if left empty after pressing save
        
        //save button
            //When pressed, will close this page and lead back to homepage
//        Button save = new Button("Save");
//        //cancel button
//        Button cancel = new Button("Cancel");
	    
	    
	    
	    
	    
	    
	    
	    
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
