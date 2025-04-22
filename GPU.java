/**
 * @author: Group2
 * Date: 4/13/2025
 * Class: CSC-331-001
 * Purpose: GPU is a subclass to Component. It represents the GPU in a computer.
 */
package com.example.pcbuilderfx;

public class GPU extends Component{
    private int vRAMSize;
    private double clockSpeed;
    private int powerConsumption;

    /**
    *Constructor for a new GPU object
    */
    public GPU(String brand, String model, double price, int vRAMSize, double clockSpeed, int powerConsumption){

        super(brand, model, price);
        this.vRAMSize = vRAMSize;
        this.clockSpeed = clockSpeed;
        this.powerConsumption = powerConsumption;

    }//end constructor

    //Getters

    /**
     * method retrieves the object's vRAMSize attribute
     * @return int: vRAMSize
     */
    public int getVRAMSize(){return vRAMSize;}

    /**
     * method retrieves the object's clockSpeed attribute
     * @return String: clockSpeed
     */
    public double getClockSpeed(){return clockSpeed;}

    /**
     * method retrieves the object's powerConsumption attribute
     * @return int: powerConsumption
     */
    public int getPowerConsumption(){return powerConsumption;}

    //Setters

    /**
     * method sets the objects vRAMSize attribute
     * @param vRAMSize: int representing the amount of vRAM possessed by the GPU object
     */
    public void setVRAMSize(int vRAMSize){this.vRAMSize = vRAMSize;}

    /**
     * method sets the objects clockSpeed attribute
     * @param clockSpeed: String representing the clockSpeed of the GPU object
     */
    public void setClockSpeed(double clockSpeed){this.clockSpeed = clockSpeed;}

    /**
     * method sets the objects powerConsumption attribute
     * @param powerConsumption: int representing the amount of power necessary for the GPU object
     */
    public void setPowerConsumption(int powerConsumption){this.powerConsumption = powerConsumption;}

    @Override
    public String getDetails() {
        return String.format("GPU: %s %s, VRAM: %dGB, Clock: %.2f, Power: %dW - $%.2f",
                brand, model, vRAMSize, clockSpeed, powerConsumption, price);
    }

}
