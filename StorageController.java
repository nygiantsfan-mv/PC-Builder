/**
 * @author: Group2
 * Date: 4/22/2025
 * Class: CSC331
 * Purpose: Represents storage component. Inherits from the component class
 */
package com.example.pcbuilderfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import com.example.pcbuilderfx.Storage;

/**
* Controller class for handling user input and adding to the build in the application
*
*/

public class StorageController {

    /**
    *The current PC build that this controller will modify
    */
    private PCBuild currentBuild;
    
    /**
    * Sets the current PC build for the controller to modify
    *
    *@param build the current PCBuild instance
    */
    public void setBuild(PCBuild build){
        this.currentBuild = build;
    }
    /**
    *TextField for entering the storage brand.
    */
    @FXML private TextField brandField;
    /**
    *TextField for entering the storage model.
    */
    @FXML private TextField modelField;
    /**
    *TextField for entering the storage price.
    */
    @FXML private TextField priceField;
    /**
    *TextField for entering the storage capacity.
    */
    @FXML private TextField capacityField;
    /**
    *TextField for entering the storage type.
    */
    @FXML private TextField typeField;
    /**
    *TextField for entering the storage read speed.
    */
    @FXML private TextField readSpeedField;
    /**
    *TextField for entering the storage write speed.
    */
    @FXML private TextField writeSpeedField;
    /**
    *TextField for entering the storage output area.
    */
    @FXML private TextArea outputArea;

    /**
    *Handles the action of adding to the current PC build
    * Reads input, creates a storage object, updates the build, and displays 
    * Uses try and catch 
    */
    @FXML
    private void handleAddStorage() {
        try {
            String brand = brandField.getText();
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int capacity = Integer.parseInt(capacityField.getText());
            String type = typeField.getText();
            int readSpeed = Integer.parseInt(readSpeedField.getText());
            int writeSpeed = Integer.parseInt(writeSpeedField.getText());

            Storage storage = new Storage(brand, model, price, capacity, type, readSpeed, writeSpeed);
            currentBuild.setStorage(storage);
            outputArea.setText(storage.getDetails());

        } catch (NumberFormatException e) {
            outputArea.setText("Please enter valid numeric values.");
        }
    }
}
