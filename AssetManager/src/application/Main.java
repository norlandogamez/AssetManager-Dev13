/*
 * CS 151 Section 6
 * Project: Track It!
 * Dev Team 13: Henry Choy, Dylan Huang, & Norlando Gamez
 * 
 */

package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		//Home page
	    
	    //Creates GridPane
	    GridPane root = new GridPane();
	    
        // View Assets button
	    Button view_assets = new Button("View Assets");
	    
        // Add New Asset button
	    Button new_asset = new Button("Add New Asset");
	    
        // View Categories button
        Button define_new_location = new Button("Define New Location");
        
        // Add New Category button
        // This button will lead to a new stage/page
        Button add_new_category = new Button("Add New Category");
                
        // Add icon image
        Image logo = new Image(getClass().getResource("trackit-logo.png").toString());
        ImageView img1 = new ImageView(logo);
        //Set image size
        img1.setFitHeight(100);
        img1.setFitWidth(100);
        
        //Grid positioning
        root.add(view_assets, 0, 1, 1, 1);
        root.add(new_asset, 2, 1, 1, 1);
        root.add(define_new_location, 0, 2, 1, 1);
        root.add(add_new_category, 2, 2, 1, 1);
        root.add(img1, 1, 0, 1, 1);
        root.setHgap(0);
        root.setVgap(40);
        
        //Sets alignment of nodes to the center and sets background color
        root.setStyle("-fx-background-color: #9BDDF2");
        root.setAlignment(Pos.CENTER);
        
        //Set home page to the scene
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Home Page");
        primaryStage.show();
	
        // Add new category page
        VBox root2 = new VBox();
        // Category Name text field
        TextField category_name = new TextField();
    
        // Save button
        Button add_category_save = new Button("Save");
        
        // Cancel button 
        Button add_category_cancel = new Button("Cancel");
        
        // Labels for textfields
        Label catname_label = new Label("Category Name:");
        
        // Add image for second page
        Image logo2 = new Image(getClass().getResource("trackit-logo.png").toString());
        ImageView img2 = new ImageView(logo2);
        img2.setFitHeight(100);
        img2.setFitWidth(100);
        
        // Grab all children for add new category page
        root2.getChildren().addAll(img2, catname_label, category_name,add_category_save, add_category_cancel);
        Scene secondScene = new Scene(root2, 500, 500);
        Stage secondStage = new Stage();
        
        // Setting scene for Add New Category page
        secondStage.setScene(secondScene);
        secondStage.setTitle("Add New Category");
        
        // Aligns the VBox to the center and sets the background color
        root2.setAlignment(Pos.CENTER);
        root2.setStyle("-fx-background-color: #9BDDF2");
        
        // Add New Location button, opens New Location page
        define_new_location.setOnAction(e -> {
            DefineNewLocation();
        });
        
        // Add New Category button, opens Add Category page
        add_new_category.setOnAction(e -> {
            secondStage.show(); });
            
        // Cancel button closes Add Category page
        add_category_cancel.setOnAction(e -> {
            ((Stage) (add_category_cancel.getScene().getWindow())).close(); });
        
        // Save button checks to see if category name is filled out, then closes page if so
        // If the input isn't empty, it will save the location Name and the optional location details to .txt files
        add_category_save.setOnAction(e -> {
        	String catName = category_name.getText();
        	if (category_name.getText() == null || category_name.getText().trim().isEmpty()){
        	     return;
        	} else {
        		writeToFile(catName, "category.txt");
            }
            ((Stage) (add_category_save.getScene().getWindow())).close(); });
	    
	}
	
	public void DefineNewLocation() {
        // Add Define New Location Page
	    VBox locRoot = new VBox();
	    // Location Name text field
	    TextField locationName_field = new TextField(); 
	    
	    Label location_label = new Label("Location's name:");
	    // Location Description text field
	    TextField locationDesc_field = new TextField();
	    
	    Label locationDesc_label = new Label("Location Description (optional)");
	    // Save button
	    Button save = new Button("Save");
	    
	    // Cancel button 
	    Button cancel = new Button("Cancel");
	    
	    //Grab all children for the Define New Location page
	    locRoot.getChildren().addAll(location_label, locationName_field, locationDesc_label, locationDesc_field, save, cancel);
	    
	    Scene newScene = new Scene(locRoot, 500, 500);
	    Stage newStage = new Stage();
	    
	    //Setting scene for the Define New Location page
	    newStage.setScene(newScene);
	    newStage.setTitle("New Location");
	    
	    //Aligns the VBox to the center and sets the background color
	    locRoot.setAlignment(Pos.CENTER);
	    locRoot.setStyle("-fx-background-color: #9BDDF2");
	    
	    newStage.show();
	    
	    // Cancel button closes New Location page
	    cancel.setOnAction(e -> {
	        ((Stage) (cancel.getScene().getWindow())).close(); 
	    });
	    
	    // Save button checks to see if location name is filled out, then closes page if so
	    // If the input isn't empty, it will save the location Name and the optional location details to .txt files
	    save.setOnAction(e -> {
	    	String locName = locationName_field.getText();
	    	String locDesc = locationDesc_field.getText();
            if (locationName_field.getText() == null || locationName_field.getText().trim().isEmpty()){
                 return;
            } else {
            	writeToFile(locName, "location.txt");
            	 if (locationDesc_field.getText() != null || !locationName_field.getText().trim().isEmpty()) {
            		 writeToFile(locDesc, "locationDesc.txt");
                }
            }
            ((Stage) (save.getScene().getWindow())).close(); });
        
	}
	
	// Writes a passed String with a newline to each text file
	public static String writeToFile (String info, String txtName) {
		try {
			FileWriter fw = new FileWriter(txtName, true);
			BufferedWriter bw = new BufferedWriter (fw);
			bw.write(info + "\n");
			bw.close(); // close the BufferWriter object
		}
		catch (IOException e) { //catches an IOexception error if the file is corrupt 
			e.printStackTrace();
		}
		return info;
	}
	
	// Reads a passed filename and stores each read line into a String
	public static String readFile (String fileName) throws FileNotFoundException, IOException {
		try {
			FileReader fileObj = new FileReader (fileName);
			String data = "";
			BufferedReader inputData = new BufferedReader(fileObj);
			//System.out.println("Text data in file: ");
			while ((data = inputData.readLine()) != null) {
				//data = in.readLine();
				//System.out.println("\nThis data was read: " + data + "\n");
			};
			inputData.close(); //close the BufferReader object
		} catch (FileNotFoundException f) {  //catch an error if the file is not found
			System.out.println("Error: File was not found!");
		} catch (IOException e) { //catch an error if the file is corrupt 
			e.printStackTrace();
		}
		return fileName;
	}
	
	public static void main(String[] args) throws IOException {
		launch(args);
	}
}
