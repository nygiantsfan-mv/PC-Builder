/**
 * @author: Group2
 * Date: 4/22/2025
 * Class: CSC-331
 * Purpose: Abstract base class representing a generic PC component
 * Contains common fields brand, model, and price which all components share
 */
package com.example.pcbuilderfx;

public abstract class Component {
    protected String brand;
    protected String model;
    protected double price;


    /**
     * Constructs a component with a brand, model and price
     *
     * @param brand of the component
     * @param model of the component
     * @param price of the component
     */
    //Constructor
    public Component(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    /**
     * Gets the brand (String)
     *
     * @return Brand as a String
     */
    //Getters
    public String getBrand() {
        return brand;
    }

    /**
     * Gets the model (String)
     *
     * @return Model as a String
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the Price (double)
     *
     * @return Price as a double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets a detailed description of a component
     *
     * @return String describing component details
     */
    public abstract String getDetails();

    /**
     * Returns a string representation of the component
     *
     * @return formatted string of the component
     */
    @Override
    public String toString() {
        return brand + " " + model + " ($" + price + ") - " + getDetails();
    }
}
