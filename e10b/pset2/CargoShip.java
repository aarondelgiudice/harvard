public class CargoShip extends Ship {

    private double cargoCapacity;

    // constructor
    public CargoShip(String name, int yearBuilt, engineType engine, double cargoCapacity) {
        // call super constructor(name, yearBuilt, engine) from Ship class
        super(name, yearBuilt, engine);
        // set cargo capacity
        this.cargoCapacity = cargoCapacity;
    }

    // getter
    public double getCargoCapacity() {
        // return cargo capacity
        return cargoCapacity;
    }

    // setter
    public void setCargoCapacity(double cargoCapacity) {
        // set cargo capacity
        this.cargoCapacity = cargoCapacity;
    }

    // toString
    public String toString() {
        // returns cargo ship name and cargo capacity
        return "Cargo Ship Name: \t" + getName() + ", Cargo Capacity: " + getCargoCapacity() + " (tons)";
    }
}
