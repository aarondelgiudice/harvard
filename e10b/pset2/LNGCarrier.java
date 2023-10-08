public class LNGCarrier extends CargoShip {
    // set parent company (e.g. "Royal Dutch Shell") in case the ship runs aground
    // and we need to sue someone
    private String parentCompany;
    private double cargoTemperature = -162.0;

    // constructor
    public LNGCarrier(String name, int yearBuilt, engineType engine, double cargoCapacity, String parentCompany, double cargoTemperature) {
        // call super constructor(name, yearBuilt, engine, cargoCapacity) from CargoShip
        super(name, yearBuilt, engine, cargoCapacity);
        // set parent company and temp
        this.parentCompany = parentCompany;
        this.cargoTemperature = cargoTemperature;
    }

    // getter
    public String getParentCompany() {
        // return parent company
        return parentCompany;
    }

    public double getCargoTemperature() {
        // return cargo temperature
        return cargoTemperature;
    }

    // setter
    public void setParentCompany(String parentCompany) {
        // set parent company
        this.parentCompany = parentCompany;
    }

    public void setCargoTemperature(double cargoTemperature) {
        // set cargo temperature
        this.cargoTemperature = cargoTemperature;
    }

    // toString
    public String toString() {
        // returns cargo ship name and cargo capacity
        return "LNG Carrier Name: \t" + getName() + ", Cargo Capacity: " + getCargoCapacity() + " (tons)"
                + ", Parent Company: " + getParentCompany();
    }
}