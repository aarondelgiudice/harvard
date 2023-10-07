public class ReeferVessel extends CargoShip {

    private double cargoTemperature;

    // constructor
    public ReeferVessel(String name, int yearBuilt, engineType engine, double cargoCapacity, double cargoTemperature) {
        // call super constructor(name, yearBuilt, engine, cargoCapacity) from CargoShip
        // class
        super(name, yearBuilt, engine, cargoCapacity);
        // set cargo temperature
        this.cargoTemperature = cargoTemperature;
    }

    // getter
    public double getCargoTemperature() {
        // return cargo temperature
        return cargoTemperature;
    }

    // setter
    public void setCargoTemperature(double cargoTemperature) {
        // set cargo temperature
        this.cargoTemperature = cargoTemperature;
    }

    // toString
    public String toString() {
        // returns cargo ship name and cargo capacity
        return "Reefer Vessel Name: \t" + getName() + ", Cargo Capacity: " + getCargoCapacity() + " (tons)"
                + ", Temperature: " + getCargoTemperature() + " (celsius)";
    }
}