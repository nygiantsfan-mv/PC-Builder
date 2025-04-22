/**
*@author Group 2
*4/22/2025
*CSC-331
*/
package com.example.pcbuilderfx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
/**
* This is the class of the MotherBoard controller set
* for the buttons and input of the user
*
*/
public class MotherboardController {

    private PCBuild currentBuild;

    public void setBuild(PCBuild newBuild){
        this.currentBuild = newBuild;
    }

    /**
    * This sets the attributes of the text fields 
    * enabling the user to enter into the field
    */
    //attributes
    @FXML

    /**
    * text field for the brand of the motherboard
    */
    private TextField brandField;
    @FXML
    /**
    * Text field for the chipset of the motherboard
    */
    private TextField chipsetField;
    @FXML
    /**
    * Text field for the formFactor of the motherboard
    */
    private TextField formFactorField;
    @FXML
    /**
    * Text field for the model of the motherboard
    */
    private TextField modelField;
    @FXML
    /**
    * Text field for the price of the motherboard
    */
    private TextField priceField;
    @FXML
    /**
    * Text field for the socketType of the motherboard
    */
    private TextField socketTypeField;
    @FXML
    /**
    * Text field for the supportedRAMType
    */
    private TextField supportedRAMTypeField;
    @FXML
    /**
    * Text field for the details of the motherboard
    */
    private TextArea motherboardDetails;

    @FXML

    /**
    * HandleAddMotherboard sets the column fields and stores the motherboard
    * in a shared PCBuild object between the components before catching 
    * exceptions
    */
    void handleAddMotherboard(ActionEvent event) {
        try{
            String brand = brandField.getText();
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            String socketType = socketTypeField.getText();
            String chipset = chipsetField.getText();
            String supportedRAMType = supportedRAMTypeField.getText();
            String formFactor = formFactorField.getText();

            Motherboard newMotherboard = new Motherboard(brand, model, price, socketType, chipset,
                    supportedRAMType, formFactor);
            currentBuild.setMotherboard(newMotherboard); //stores motherboard in a shared PCBuild object between the components
            motherboardDetails.setText(newMotherboard.getDetails());

        } catch(NumberFormatException a) {
            motherboardDetails.setText("Please enter a number like 99.99 for price.");
        }catch (Exception b){
            motherboardDetails.setText("There was an error. Try again.");
        }//end catch
    }//end handleAddMotherboard method

}
