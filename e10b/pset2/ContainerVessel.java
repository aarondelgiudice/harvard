public class ContainerVessel extends CargoShip {
    private boolean areYouSmugglingAnyConterfeitGoods;

    // constructor
    public ContainerVessel(String name, int yearBuilt, engineType engine, double cargoCapacity,
            boolean areYouSmugglingAnyConterfeitGoods) {
        // call super constructor(name, yearBuilt, engine, cargoCapacity) from CargoShip
        super(name, yearBuilt, engine, cargoCapacity);
        // set cargo status, counterfeit/not counterfeit
        this.areYouSmugglingAnyConterfeitGoods = areYouSmugglingAnyConterfeitGoods;
    }

    // getter
    public boolean getAreYouSmugglingAnyConterfeitGoods() {
        // return cargo status, counterfeit/not counterfeit
        return areYouSmugglingAnyConterfeitGoods;
    }

    // setter
    public void setAreYouSmugglingAnyConterfeitGoods(boolean areYouSmugglingAnyConterfeitGoods) {
        // set cargo status, counterfeit/not counterfeit
        this.areYouSmugglingAnyConterfeitGoods = areYouSmugglingAnyConterfeitGoods;
    }

    // toString
    public String toString() {
        // returns cargo ship name and cargo capacity
        return "Container Vessel Name: \t" + getName() + ", Cargo Capacity: " + getCargoCapacity() + " (tons)"
                + ", Counterfeit Goods: " + getAreYouSmugglingAnyConterfeitGoods();
    }
}