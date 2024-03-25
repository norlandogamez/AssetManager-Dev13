package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

// If you can see this, my push worked! - Dylan
		
		
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
        
        
        FlowPane root2 = new FlowPane();
        // Category Name text field
        TextField category_name = new TextField();
        
        // Location Name text field
        TextField location_name= new TextField();
        
        // Location Description text field
        TextField location_desc = new TextField();
        
        // Save button
        Button add_category_save = new Button("Save");
        
        // Cancel button 
        Button add_category_cancel = new Button("Cancel");
        
        // Title and labels
        Label add_category_title = new Label("Add New Category");
        Label catname_label = new Label("Category Name:");
        Label locname_label = new Label("Location Name:");
        Label locdesc_label = new Label("Location Description:");
        
        root2.getChildren().addAll(add_category_title, catname_label, category_name, locname_label, location_name, locdesc_label, location_desc, add_category_save, add_category_cancel);
        Scene secondScene = new Scene(root2, 500, 500);
        Stage secondStage = new Stage();
        
        secondStage.setScene(secondScene);
        secondStage.setTitle("Add New Category");
        
        // Opens Add Category page
        add_new_category.setOnAction(e -> {
            secondStage.show(); });
            
        // Closes Add Category page
        add_category_cancel.setOnAction(e -> {
            ((Stage) (add_category_cancel.getScene().getWindow())).close(); });
        
        // Checks to see if category name and location name are filled, then closes page if so
        add_category_save.setOnAction(e -> {
        	if (category_name.getText() == null || category_name.getText().trim().isEmpty() || location_name.getText() == null || location_name.getText().trim().isEmpty()) {
        	     return;
        	}
            ((Stage) (add_category_save.getScene().getWindow())).close(); });
        
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
