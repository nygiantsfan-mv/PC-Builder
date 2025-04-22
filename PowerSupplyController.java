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

    private PCBuild currentBuild;

    
    /**
    *Sets a new build for the PCBuild object
    *@param build - new build to be set for the PCBuild
    */
    public void setBuild(PCBuild build){
        this.currentBuild = build;
    }
    //GUI Components
    @FXML
    private TextField brandField;

    @FXML
    private TextField efficiencyField;

    @FXML
    private TextField modelField;

    @FXML
    private TextField modularField;

    @FXML
    private TextArea outputArea;

    @FXML
    private TextField priceField;

    @FXML
    private TextField wattageField;
    //end of components

    /**
    *Method to handle a button press in the PowerSupply application
    *@param event - triggered when the button is pressed in the window
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
