package com.example.pcbuilderfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CPUController {

    private PCBuild currentBuild;

    public void setBuild(PCBuild build){
        this.currentBuild = build;
    }
    @FXML
    private TextField brandField;

    @FXML
    private TextField modelField;

    @FXML
    private TextArea outputArea;

    @FXML
    private TextField priceField;

    @FXML
    private TextField socketTypeField;

    @FXML
    private TextField speedField;

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
