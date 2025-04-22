/**
 * @author: Group2
 * Date: 4/22/2025
 * Class: CSC331
 * Purpose: Represents storage component. Inherits from the component class
 */
package com.example.pcbuilderfx;

public class Storage extends Component {
    private int capacity;
    private String type;
    private int readSpeed;
    private int writeSpeed;

    /**
     * Constructs a Storage component with specific attributes
     *
     * @param brand of the storage
     * @param model of the storage
     * @param price of the storage
     * @param capacity of the storage
     * @param type of storage
     * @param readSpeed
     * @param writeSpeed
     */
    public Storage(String brand, String model, double price, int capacity,
                   String type, int readSpeed, int writeSpeed) {
        super(brand, model, price);
        this.capacity = capacity;
        this.type = type;
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
    }

    /**
     * Gets capacity of the storage
     *
     * @return Capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the type of storage
     *
     * @return type of storage
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the readSpeed
     *
     * @return readSpeed
     */
    public int getReadSpeed() {
        return readSpeed;
    }

    /**
     * Gets the writeSpeed
     *
     * @return writeSpeed
     */
    public int getWriteSpeed() {
        return writeSpeed;
    }

    /**
     * Sets the initial capacity
     *
     * @param capacity
     */

    public void setCapacity(int capacity) { this.capacity = capacity; }

    /**
     * Sets the initial type
     *
     * @param type
     */
    public void setType(String type) { this.type = type; }

    /**
     * Sets the initial readSpeed
     *
     * @param readSpeed
     */
    public void setReadSpeed(int readSpeed) { this.readSpeed = readSpeed; }

    /**
     * Sets the initial writeSpeed
     *
     * @param writeSpeed
     */
    public void setWriteSpeed(int writeSpeed) { this.writeSpeed = writeSpeed; }

    @Override
    public String getDetails() {
        return String.format("Storage: %s %s, %dGB %s, Read: %dMB/s, Write: %dMB/s - $%.2f",
                brand, model, capacity, type, readSpeed, writeSpeed, price);
    }
}
