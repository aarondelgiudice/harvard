public class TankerVessel extends CargoShip {
    // cargo type, e.g. oil
    private String cargoType;
    private String parentCompany;

    // constructor
    public TankerVessel(String name, int yearBuilt, engineType engine, double cargoCapacity, String cargoType,
            String parentCompany) {
        // call super constructor(name, yearBuilt, engine, cargoCapacity) from CargoShip
        super(name, yearBuilt, engine, cargoCapacity);
        // set cargo type & parent company
        this.cargoType = cargoType;
        this.parentCompany = parentCompany;
    }

    // getter
    public String getCargoType() {
        // return cargo type
        return cargoType;
    }

    public String getParentCompany() {
        // return parent company
        return parentCompany;
    }

    // setter
    public void setCargoType(String cargoType) {
        // set cargo type
        this.cargoType = cargoType;
    }

    public void setParentCompany(String parentCompany) {
        // set parent company
        this.parentCompany = parentCompany;
    }

    // toString
    public String toString() {
        // returns cargo ship name and cargo capacity
        return "Tanker Vessel Name: \t" + getName() + ", Cargo Capacity: " + getCargoCapacity() + " (tons)"
                + ", Cargo Type: " + getCargoType() + ", Parent Company: " + getParentCompany();
    }
}