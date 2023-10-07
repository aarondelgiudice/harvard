public class BulkVessel extends CargoShip {
    // cargo type, e.g. wheat, coal
    private String cargoType;

    // constructor
    public BulkVessel(String name, int yearBuilt, engineType engine, double cargoCapacity, String cargoType) {
        // call super constructor(name, yearBuilt, engine, cargoCapacity) from CargoShip
        super(name, yearBuilt, engine, cargoCapacity);
        // set cargo type
        this.cargoType = cargoType;
    }

    // getter
    public String getCargoType() {
        // return cargo type
        return cargoType;
    }

    // setter
    public void setCargoType(String cargoType) {
        // set cargo type
        this.cargoType = cargoType;
    }

    // toString
    public String toString() {
        // returns cargo ship name and cargo capacity
        return "Bulk Vessel Name: \t" + getName() + ", Cargo Capacity: " + getCargoCapacity() + " (tons)"
                + ", Cargo Type: " + getCargoType();
    }
}