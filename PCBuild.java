package com.example.pcbuilderfx;

public class PCBuild {
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Storage storage;
    private PowerSupply powerSupply;
    private Motherboard motherboard;

    //getters
    public CPU getCpu(){
        return cpu;
    }
    public GPU getGpu(){
        return gpu;
    }
    public RAM getRam(){
        return ram;
    }
    public Storage getStorage(){
        return storage;
    }
    public PowerSupply getPowerSupply(){
        return powerSupply;
    }
    public Motherboard getMotherboard(){
        return motherboard;
    }

    // setters
    public void setCPU(CPU cpu){
        this.cpu = cpu;
    }
    public void setGpu(GPU gpu){
        this.gpu = gpu;
    }
    public void setRam(RAM ram){
        this.ram = ram;
    }
    public void setStorage(Storage storage){
        this.storage = storage;
    }
    public void setPowerSupply(PowerSupply powerSupply){
        this.powerSupply = powerSupply;
    }
    public void setMotherboard(Motherboard motherboard){
        this.motherboard = motherboard;
    }

    //imported from PCBUILDERFX
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
