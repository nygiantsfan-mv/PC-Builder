package com.example.pcbuilderfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
*@author: Group 2
*CSC331
*04/22/25
*Purpose: Creates an interface for the user to enter specifications for a new GPU object
*/
public class GPUController {

    //Object used to hold the current components of the PC
    private PCBuild currentBuild;

    /**
    *Sets a new build for the PCBuild object
    *@param build - new build set for the PCBuild
    */
    public void setBuild(PCBuild build){
        this.currentBuild = build;
    }

    //Text Field for brand
    @FXML
    private TextField brandField;

    //Text Field for clock speed
    @FXML
    private TextField clockSpeedField;

    //Text field for model
    @FXML
    private TextField modelField;

    //Text Field for output
    @FXML
    private TextArea outputArea;

    //Text Field for power consumption
    @FXML
    private TextField powerConsumptionField;

    //Text Field for price
    @FXML
    private TextField priceField;

    //Text Field for vRAM
    @FXML
    private TextField vRamField;

    /**
    *Method used to handle the creation of a new GPU object using details entered in a GUI by the user
    *@param event - triggered when the user has entered all info and pressed the create button
    */
    @FXML
    void handleAddGPU(ActionEvent event) {
        //Creates a new GPU, prompts users to try again if an invalid input is entered
        try{
            String brand = brandField.getText();
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int vRam = Integer.parseInt(vRamField.getText());
            double clockSpeed = Double.parseDouble(clockSpeedField.getText());
            int power = Integer.parseInt(powerConsumptionField.getText());

            GPU newGpu = new GPU(brand, model, price, vRam, clockSpeed, power);
            currentBuild.setGpu(newGpu);
            outputArea.setText("GPU added: \n" + newGpu.getDetails());
        } catch (NumberFormatException e){
            outputArea.setText("Invalid number entered in one of the following: Price, vRAM, Clockspeed, or Power.");
        } catch (Exception d){
            outputArea.setText("An error has occurred. Please try again.");
        }
    }

}
