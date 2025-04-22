package com.example.pcbuilderfx; /**
 *
 * @author: Group2
 * Date: 4/16/2025
 * Class: CSC-331-001
 *
 * Purpose: PCBuilder is a PC building interface that allows users to view
 * available components, add selected components to a build, and calculate
 * the total cost.
 *
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class PCBuilderFX extends Application {

    // this object will be used to glue the user created components together
    private PCBuild currentBuild = new PCBuild();

    /**
     * This method is a helper method designed to load in the group members files upon completion
     * Passes the PCBuild object to the corresponding component to update the currentBuild object
     * @param fxmlFileName String representation of the fxml file name, e.g. 'Motherboard.fxml'
     * @param windowTitle String representation of the name for the window of the GUI, e.g. 'add motherboard'
     */
    public void loadComponent(String fxmlFileName, String windowTitle){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent babyRoot = loader.load();

            //open correct controller file based on fxml file name
            switch(fxmlFileName) {
                case "Motherboard.fxml":
                    MotherboardController boardController = loader.getController();
                    boardController.setBuild(currentBuild); //sets MotherboardController object 'boardController'
                                                            // as the Motherbaord object of the current PCBuild
                                                            // this is repeated for remaining components
                    break;
                case "GPU.fxml":
                    GPUController gpuController = loader.getController();
                    gpuController.setBuild(currentBuild);
                    break;
                case "CPU.fxml":
                    CPUController cpuController = loader.getController();
                    cpuController.setBuild(currentBuild);
                    break;
                case "PowerSupply.fxml":
                    PowerSupplyController powerSupplyController = loader.getController();
                    powerSupplyController.setBuild(currentBuild);
                    break;
                case "RAM.fxml":
                    RAMController ramController = loader.getController();
                    ramController.setBuild(currentBuild);
                    break;
                case "Storage.fxml":
                    StorageController storageController = loader.getController();
                    storageController.setBuild(currentBuild);
                    break;
            }//end switch statements

            //after loading the correct file, set the stage to display the file in a new window
            //user must close the window themselves
            Stage stage = new Stage();
            stage.setTitle(windowTitle);
            stage.setScene(new Scene(babyRoot));
            stage.show();
        } catch (IOException a){
            a.printStackTrace();
        }
    }

    /**
     * Main method that is used to run the PCBuilder program. Automatically adds sample components for the build.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);  // This launches the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        // Sample components for build
        currentBuild.setCPU(new CPU("Intel", "i7-12700K", 349.99, "LGA 1700", 3.6));
        currentBuild.setGpu(new GPU("NVIDIA", "RTX 4070", 599.99, 12, 1500, 220));
        currentBuild.setRam(new RAM("Corsair", "Vengeance", 89.99, 16, "A Type"));
        currentBuild.setStorage(new Storage("Samsung", "970 EVO Plus", 129.99, 1000, "SSD", 3500, 3500));
        currentBuild.setPowerSupply(new PowerSupply("EVGA", "SuperNOVA 750", 119.99, 750, true, "great"));
        currentBuild.setMotherboard(new Motherboard("ASUS", "ROG STRIX B550-F", 179.99, "B550", "ATX", "DDR4", "SO-DIMM"));

        // Layout setup for the GUI
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 10;");

        // Creating buttons for actions
        Button viewBuildButton = new Button("View Build");
        Button addComponentButton = new Button("Add Component");
        Button calculatePriceButton = new Button("Calculate Total Price");
        Button displayBuildButton = new Button("Display Build");

        // Label for displaying output
        Label outputLabel = new Label("Select an option");

        // Event handlers for buttons
        viewBuildButton.setOnAction(e -> {
            StringBuilder buildInfo = new StringBuilder("Build: \n");
            if(currentBuild.getCpu() != null)
                buildInfo.append(currentBuild.getCpu().getDetails()).append("\n");
            if(currentBuild.getGpu() != null)
                buildInfo.append(currentBuild.getGpu().getDetails()).append("\n");
            if(currentBuild.getRam() != null)
                buildInfo.append(currentBuild.getRam().getDetails()).append("\n");
            if(currentBuild.getStorage() != null)
                buildInfo.append(currentBuild.getStorage().getDetails()).append("\n");
            if(currentBuild.getPowerSupply() != null)
                buildInfo.append(currentBuild.getPowerSupply().getDetails()).append("\n");
            if(currentBuild.getMotherboard() != null)
                buildInfo.append(currentBuild.getMotherboard().getDetails()).append("\n");
            outputLabel.setText(buildInfo.toString());
        });

        addComponentButton.setOnAction(e -> {
            // Creating a dialog to select a component to add
            ChoiceDialog<String> componentDialog = new ChoiceDialog<>("CPU", "CPU", "GPU", "RAM", "Storage", "Power Supply", "Motherboard");
            componentDialog.setTitle("Add Component");
            componentDialog.setHeaderText("Choose which component to add");
            componentDialog.showAndWait().ifPresent(componentChoice -> {
                switch (componentChoice) {
                    case "CPU":
                        loadComponent("CPU.fxml", "Add CPU");
                        outputLabel.setText("Added CPU");
                        break;
                    case "GPU":
                        loadComponent("GPU.fxml", "Add GPU");
                        outputLabel.setText("Added GPU");
                        break;
                    case "RAM":
                        loadComponent("RAM.fxml", "Add RAM");
                        outputLabel.setText("Added RAM");
                        break;
                    case "Storage":
                        loadComponent("Storage.fxml", "Add Storage");
                        outputLabel.setText("Added Storage");
                        break;
                    case "Power Supply":
                        loadComponent("PowerSupply.fxml", "Add Power Supply");
                        outputLabel.setText("Added Power Supply");
                        break;
                    case "Motherboard":
                        loadComponent("Motherboard.fxml", "Add Motherboard");
                        outputLabel.setText("Added Motherboard");
                        break;
                }
            });
        });

        calculatePriceButton.setOnAction(e -> {
            double totalPrice = calculateTotalPrice();
            outputLabel.setText("Total Price: $" + totalPrice);
        });

        displayBuildButton.setOnAction(e -> {
            displayBuild(outputLabel);
        });

        // Adding buttons and output label to layout
        root.getChildren().addAll(viewBuildButton, addComponentButton, calculatePriceButton, displayBuildButton, outputLabel);

        // Set up scene and stage
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("PC Builder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
    * method calculates the total price of the users build
    *@return double: total is the price of all components added together
    */
    public double calculateTotalPrice() {
        double total = 0.0;
        if (currentBuild.getCpu() != null) total += currentBuild.getCpu().getPrice();
        if (currentBuild.getGpu() != null) total += currentBuild.getGpu().getPrice();
        if (currentBuild.getRam() != null) total += currentBuild.getRam().getPrice();
        if (currentBuild.getStorage() != null) total += currentBuild.getStorage().getPrice();
        if (currentBuild.getPowerSupply() != null) total += currentBuild.getPowerSupply().getPrice();
        if (currentBuild.getMotherboard() != null) total += currentBuild.getMotherboard().getPrice();
        return total;
    }

    /**
    * method displays the user's current PCBuild object
    * param: outputLabel label for the build
    */
    public void displayBuild(Label outputLabel) {
        StringBuilder buildDetails = new StringBuilder("----- PC Build Summary -----\n");
        if (currentBuild.getCpu() != null)
            buildDetails.append(currentBuild.getCpu().getDetails()).append("\n");
        if (currentBuild.getGpu() != null)
            buildDetails.append(currentBuild.getGpu().getDetails()).append("\n");
        if (currentBuild.getRam() != null)
            buildDetails.append(currentBuild.getRam().getDetails()).append("\n");
        if (currentBuild.getStorage() != null)
            buildDetails.append(currentBuild.getStorage().getDetails()).append("\n");
        if (currentBuild.getPowerSupply() != null)
            buildDetails.append(currentBuild.getPowerSupply().getDetails()).append("\n");
        if (currentBuild.getMotherboard() != null)
            buildDetails.append(currentBuild.getMotherboard().getDetails()).append("\n");
        buildDetails.append("Total Price: $").append(calculateTotalPrice());
        outputLabel.setText(buildDetails.toString());
    }
}

