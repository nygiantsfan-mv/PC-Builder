/**
 * @author: Group2
 * Date: 4/22/2025
 * Class: CSC331
 * Purpose: Represents a CPU and inherits from the component class
 */
package com.example.pcbuilderfx;

public class CPU extends Component {
    private String socketType;
    private double speed;

    /**
     * Constructs a CPU component with attributes
     *
     * @param brand of CPU
     * @param model of CPU
     * @param price of CPU
     * @param socketType of CPU
     * @param speed of CPU
     */
    public CPU(String brand, String model, double price, String socketType, double speed) {
        super (brand, model, price);
        this.socketType = socketType;
        this.speed = speed;
    }

    /**
     * Gets the SocketType of the CPU
     *
     * @return socketType
     */
    public String getSocketType() {
        return socketType;
    }

    /**
     * Gets the speed of the CPU
     *
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the socketType of the CPU
     *
     * @param socketType
     */
    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }

    /**
     * Sets the speed of the CPU
     *
     * @param speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

     /**
     * Returns price of the component
     *
     * @param price as a double
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Returns a formatted string with the details of the CPU,
     * brand, model, and price.
     *
     * @param string of CPU details
     */
    public String getDetails() {
        return "CPU: " + brand + " " + model + " - " + price + " USD";
    }
}
