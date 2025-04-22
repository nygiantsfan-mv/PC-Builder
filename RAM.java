/**
 * @author: Group2
 * Date: 4/22/2025
 * Class: CSC331
 * Purpose: RAM is a subclass to Component. It represents the RAM in a computer.
 */
package com.example.pcbuilderfx;

public class RAM extends Component {
    private int capacity;
    private String type;

    public RAM(String brand, String model, double price, int capacity, String type){
        super(brand, model, price);
        this.capacity = capacity;
        this.type = type;
    }
    // ends constructor

    // Getters

    /**
     * method returns the object's capacity attribute
     * @return int: Capacity
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * method returns the object's type attribute
     * @return String: type
     */

    public String getType(){
        return type;
    }

    // Setters
    /**
     * method sets the objects capacity attribute
     * @param capacity: int representing the capacity compatible with the RAM
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * method sets the object's type attribute
     * @param type: String representing the type of RAM compatible with the RAM
     */
    public void setType(String type){
        this.type = type;
    }

    @Override
    public String getDetails() {
        return String.format("RAM: %s %s, Capacity: %dGB, Type: %s - $%.2f",
                brand, model, capacity, type, price);
    }
}
