package com.example.pcbuilderfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
*@author: Group 2
*CSC-331
*04/22/25
*Purpose: Creates an interface for the user to enter specifications for a new CPU object.
* Controller class for handling user interaction with the CPU in the PC Builder application.
* This class allows the user to input CPU specifications and add a CPU to the current build.
*/

public class CPUController {

    /** Current PC  build to which the CPU will be added */
    private PCBuild currentBuild;

    /**
    * Sets the current PC instance
    * 
    * @param build the PCBuild instance to associate with this controller
    */

    public void setBuild(PCBuild build){
        this.currentBuild = build;
    }
    
    /** Textfield for entering the CPU brand */
    @FXML
    private TextField brandField;

    /** Textfield for entering the CPU model */
    @FXML
    private TextField modelField;

    /** Textfield for entering the CPU outputArea */
    @FXML
    private TextArea outputArea;

    /** Textfield for entering the CPU priceField */
    @FXML
    private TextField priceField;

    /** Textfield for entering the CPU socketTypeField */
    @FXML
    private TextField socketTypeField;

    /** Textfield for entering the CPU speedField */
    @FXML
    private TextField speedField;

    /** Handles the action of adding a CPU to the current build when user submits
    * Validates input fields, creates new CPU object, updates the build, displays
    *
    * @param event the ActionEvent triggered by the user
    */
    @FXML
    void handleAddCpu(ActionEvent event) {
        try{
            String brand = brandField.getText();
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            String socketType = socketTypeField.getText();
            double speed = Double.parseDouble(speedField.getText());
            CPU addCpu = new CPU(brand, model, price, socketType, speed);
            currentBuild.setCPU(addCpu);
            outputArea.setText("CPU added: \n" + addCpu.getDetails());
        } catch (NumberFormatException e){
            outputArea.setText("Please check the Price and Speed fields are entered correctly.");
        } catch (Exception d){
            outputArea.setText("There was an unexpected error. Please try again.");
        }

    }

}
