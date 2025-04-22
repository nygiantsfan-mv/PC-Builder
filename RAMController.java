package com.example.pcbuilderfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RAMController {

    private PCBuild currentBuild;

    public void setBuild(PCBuild build){
        this.currentBuild = build;
    }
    @FXML
    private TextField brandField;

    @FXML
    private TextField capacityField;

    @FXML
    private TextField modelField;

    @FXML
    private TextArea outputArea;

    @FXML
    private TextField priceField;

    @FXML
    private TextField typeField;

    @FXML
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
