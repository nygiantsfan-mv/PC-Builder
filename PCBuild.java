package com.example.pcbuilderfx;
/**
* @author group 2
* date: 4/22/2025
* Class: CSC-331
* Purpose: Class is built as a helper. It maintains an object of each class of the components.
* When the user updates a component, the program overwrites the attribute. This allows it to be updated
* without the need to delete the previous object. 
*/

public class PCBuild {
    // attributes will be used to manage user's current pc build
    // each attribute will manage a specific component of the build
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Storage storage;
    private PowerSupply powerSupply;
    private Motherboard motherboard;

    //getters
    /**
    * method retrieves the object's CPU component
    * @return cpu: the cpu component of the user's pc build
    */
    public CPU getCpu(){
        return cpu;
    }
    /**
    * method retrieves the object's GPU component
    * @return gpu: the gpu component of the user's pc build
    */
    public GPU getGpu(){
        return gpu;
    }
    /**
    * method retrieves the object's RAM component
    * @return ram: the ram component of the user's pc build
    */
    public RAM getRam(){
        return ram;
    }
    /**
    * method retrieves the object's Storage component
    * @return: storage: the storage component of the user's pc build
    */
    public Storage getStorage(){
        return storage;
    }
    /**
    * method retrieves the object's PowerSupply component
    * @return: powerSupply: the powersupply component of the user's pc build
    */
    public PowerSupply getPowerSupply(){
        return powerSupply;
    }
    /**
    * method retrieves the object's Motherboard component
    * @return: motherboard: the motherboard component of the user's pc build
    */
    public Motherboard getMotherboard(){
        return motherboard;
    }

    // setters
    /**
    * method sets the objects CPU component
    * @param cpu: string representation of the cpu component
    */
    public void setCPU(CPU cpu){
        this.cpu = cpu;
    }
    /**
    *method sets the objects GPU component
    * @param gpu: String representation of the gpu component
    */
    public void setGpu(GPU gpu){
        this.gpu = gpu;
    }
    /**
    *method sets the objects RAM component
    * @param ram: String representation of the ram component
    */
    public void setRam(RAM ram){
        this.ram = ram;
    }
    /**
    * method sets the objects storage component
    * @param storage: string representation of the storage component
    */
    public void setStorage(Storage storage){
        this.storage = storage;
    }
    /**
    *method sets the objects PowerSupply component
    * @param powerSupply: string representing a powersupply component
    */
    public void setPowerSupply(PowerSupply powerSupply){
        this.powerSupply = powerSupply;
    }
    /**
    * method sets the objects Motherboard component
    * @ param motherboard: string representing a motherboard component
    */
    public void setMotherboard(Motherboard motherboard){
        this.motherboard = motherboard;
    }

    /**
    * method calculates the total price of all the PCBuild object's components
    * @return double: total price of the pc components
    */
    public double calculateTotalPrice() {
        double total = 0.0;
        if (cpu != null) total += cpu.getPrice();
        if (gpu != null) total += gpu.getPrice();
        if (ram != null) total += ram.getPrice();
        if (storage != null) total += storage.getPrice();
        if (powerSupply != null) total += powerSupply.getPrice();
        if (motherboard != null) total += motherboard.getPrice();
        return total;
    }//end calculateTotalPrice method
}
