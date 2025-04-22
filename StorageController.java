package com.example.pcbuilderfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import com.example.pcbuilderfx.Storage;

public class StorageController {

    private PCBuild currentBuild;

    public void setBuild(PCBuild build){
        this.currentBuild = build;
    }
    @FXML private TextField brandField;
    @FXML private TextField modelField;
    @FXML private TextField priceField;
    @FXML private TextField capacityField;
    @FXML private TextField typeField;
    @FXML private TextField readSpeedField;
    @FXML private TextField writeSpeedField;
    @FXML private TextArea outputArea;

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
