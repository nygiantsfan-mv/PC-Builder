/**
 * @author: Group2
 * Date: 4/16/2025
 * Class: CSC-331-001
 * Purpose: Power Supply is a subclass to Component. It represents the power supply in a computer.
 */
package com.example.pcbuilderfx;

public class PowerSupply extends Component {
    private int wattage;
    private boolean modular;
    private String efficiencyRating;

    public PowerSupply(String brand, String model, double price, int wattage, boolean modular, String efficiencyRating) {
        super(brand, model, price);
        this.wattage = wattage;
        this.modular = modular;
        this.efficiencyRating = efficiencyRating;


    }

    /**
     * method retrieves the object's wattage attribute
     * @return int: wattage
     */
    public int getWattage() {
        return wattage;
    }

    /**
     * method returns the object's modular attribute
     * @return boolean: modular
     */
    public boolean isModular() {
        return modular;
    }

    /**
     * method returns the efficiency rating of the object
     * @return String: efficiency rating
     */
    public String getEfficiencyRating(){
        return efficiencyRating;
    }

    /**
     * method sets the objects int attribute
     * @param wattage: int representing the amount of wattage possessed by the power supply object
     */
    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    /**
     * method sets the object's modular attribute
     * @param modular: boolean representing the modular effect of the object in the PowerSupply
     */
    public void setModular(boolean modular){
        this.modular = modular;
    }

    /**
     * method sets the efficiencyRating of the object
     * @param efficiencyRating: String representing how effective the rating is in the power supply
     */
    public void setEfficiencyRating(String efficiencyRating){
        this.efficiencyRating = efficiencyRating;
    }

    @Override
    public String getDetails() {
        return String.format("Power Supply: %s %s, Wattage: %dW, Modular: %b, Efficiency Rating: %s - $%.2f",
                brand, model, wattage, modular, efficiencyRating, price);
    }
}
