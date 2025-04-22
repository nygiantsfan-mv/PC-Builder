package com.example.pcbuilderfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GPUController {

    private PCBuild currentBuild;

    public void setBuild(PCBuild build){
        this.currentBuild = build;
    }
    @FXML
    private TextField brandField;

    @FXML
    private TextField clockSpeedField;

    @FXML
    private TextField modelField;

    @FXML
    private TextArea outputArea;

    @FXML
    private TextField powerConsumptionField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField vRamField;

    @FXML
    void handleAddGPU(ActionEvent event) {
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
