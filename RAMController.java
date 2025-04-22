package com.example.pcbuilderfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for handling RAM component input and interaction.
 * Manages the UI elements for adding RAM to a PC build.
 */
public class RAMController {

    /**
    * References to the current PC build being configured
    */

    private PCBuild currentBuild;

    /**
     * Sets the current PC build reference
     * 
     * @param build The PCBuild object to associate with this controller
     */

    public void setBuild(PCBuild build){
        this.currentBuild = build;
    }
    @FXML
    /**
    * Text field for entering RAM brand 
    */
    private TextField brandField;

    @FXML

    /**
    * Text field for entering RAM capacity
    */
    private TextField capacityField;
    
    @FXML
    /**
    * Text field for entering RAM model
    */
    private TextField modelField;

    @FXML
    /**
    * Text area for entering and displaying RAM details
    */
    private TextArea outputArea;

    @FXML
    /**
    * Text for entering RAM price
    */
    private TextField priceField;

    @FXML
    /**
    * Text field for entering RAM type
    */
    private TextField typeField;

    @FXML

    /**
     * Handles the event when the user adds a RAM component to the current build.
     * Retrieves input from the appropriate text fields, creates a new RAM object,
     * and adds it to the current build. Displays the RAM details in the output area.
     * 
     * @param event The ActionEvent is triggered when the add RAM button is clicked
     * @throws NumberFormatException If the price or capacity fields contain non-numeric values
     * @throws Exception If any other unexpected error occurs during processing
     */
    void handleAddRam(ActionEvent event) {
        try{
            String brand = brandField.getText();
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int capacity = Integer.parseInt(capacityField.getText());
            String type = typeField.getText();

            RAM newRam = new RAM(brand, model, price, capacity, type);
            currentBuild.setRam(newRam);
            outputArea.setText(newRam.getDetails());

        }catch(NumberFormatException e){
            outputArea.setText("Please ensure price and capacity fields have proper input.");
        }catch(Exception d){
            outputArea.setText("An unexpected error happened. Please try again.");
        }
    } // end handleAddRam method

}
