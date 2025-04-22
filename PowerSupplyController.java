package com.example.pcbuilderfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
*@author: Group 2
* CSC 331
* 04/22/25
* Purpose: Creates an interface for the user to input specifications for a new Power Supply object
*/
    
public class PowerSupplyController {

    //Object to hold current build of the PC
    private PCBuild currentBuild;

    
    /**
    *Sets a new build for the PCBuild object
    *@param build - new build to be set for the PCBuild
    */
    public void setBuild(PCBuild build){
        this.currentBuild = build;
    }
    //GUI Components

    //Text Field for brand
    @FXML
    private TextField brandField;

    //Text Field for efficiency rating
    @FXML
    private TextField efficiencyField;

    //Text Field for model
    @FXML
    private TextField modelField;

    //Text Field for modularity
    @FXML
    private TextField modularField;

    //Text Field for output
    @FXML
    private TextArea outputArea;

    //Text Field for price
    @FXML
    private TextField priceField;

    //Text Field for wattage
    @FXML
    private TextField wattageField;
    //end of components

    /**
     * Handles the event when the user adds a PowerSupply component to the current build.
     * Retrieves input from the appropriate text fields, creates a new PowerSupply object,
     * and adds it to the current build. Displays the PowerSupply details in the output area.
     * 
     * @param event The ActionEvent is triggered when the add PowerSupply button is clicked
     * @throws NumberFormatException If the price or capacity fields contain non-numeric values
     * @throws Exception If any other unexpected error occurs during processing
     */
    @FXML
    void handleAddPowerSupply(ActionEvent event) {
        //Accepts input from a window populated by the user, asks for new inputs if input types don't fit
        try{
            String brand = brandField.getText();
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int wattage = Integer.parseInt(wattageField.getText());
            boolean modular = modularField.getText().equalsIgnoreCase("yes");//other input is false
            String efficiency = efficiencyField.getText();

            PowerSupply newPowerSupply = new PowerSupply(brand, model, price, wattage, modular, efficiency);
            currentBuild.setPowerSupply(newPowerSupply);
            outputArea.setText("Power Supply: \n" + newPowerSupply.getDetails());
        } catch (NumberFormatException e){
            outputArea.setText("Please ensure the price and wattage fields have the proper input.");
        } catch (Exception d){
            outputArea.setText("There was an unexpected Error. Please try again!");
        }
    }//end handle method

}
