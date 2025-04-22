/**
 * @author: Matthew Voisey
 * Date: 4/13/2025
 * Class: CSC-331-001
 * Purpose: Motherboard is a subclass to Component. It represents the motherboard in a computer.
 */
package com.example.pcbuilderfx;

public class Motherboard extends Component {
    private String socketType;
    private String chipset;
    private String supportedRAMType;
    private String formFactor;

    public Motherboard(String brand, String model, double price, String socketType, String chipset, String
                       supportedRAMType, String formFactor){

        super(brand, model, price);
        this.socketType = socketType;
        this.chipset = chipset;
        this.supportedRAMType = supportedRAMType;
        this.formFactor = formFactor;

    }//end constructor

    //Getters

    /**
     * method retrieves the object's socketType attribute
     * @return String: socketType
     */
    public String getSocketType(){return socketType;}

    /**
     * method retrieves the object's chipset attribute
     * @return String: chipset
     */
    public String getChipset(){return chipset;}

    /**
     * method retrieves the object's supportedRAMType attribute
     * @return String: supportedRAMType
     */
    public String getSupportedRAMType(){return supportedRAMType;}

    /**
     * method retrieves the object's formFactor attribute
     * @return String: formFactor
     */
    public String getFormFactor(){return formFactor;}

    /**
     * method sets the object's socketType attribute
     * @param socketType String representing a socketType possessed by the motherboard
     */

    // Setters

    public void setSocketType(String socketType){this.socketType = socketType;}

    /**
     * method sets the objects chipset attribute
     * @param chipset: String representing the chipset compatible with the motherboard
     */
    public void setChipset(String chipset){this.chipset = chipset;}

    /**
     * method sets the objects supportedRAMType attribute
     * @param supportedRAMType: String representing the RAM compatible with the motherboard
     */
    public void setSupportedRAMType(String supportedRAMType){this.supportedRAMType = supportedRAMType;}

    /**
     * method sets the objects formFactor attribute
     * @param formFactor: String representing the formFactor of the motherboard
     */
    public void setFormFactor(String formFactor){this.formFactor = formFactor;}

    @Override
    public String getDetails() {
        return String.format("Motherboard: %s %s, Socket: %s, Chipset: %s, RAM type: %s, Form Factor: %s - $%.2f",
                brand, model, socketType, chipset, supportedRAMType, formFactor, price);
    }

}
