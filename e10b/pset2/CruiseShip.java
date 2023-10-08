public class CruiseShip extends Ship {

    private int maxPassengers;
    private boolean hasNorovirus;

    // constructor
    public CruiseShip(String name, int yearBuilt, engineType engine, int maxPassengers) {
        // call super constructor(name, yearBuilt, engine) from Ship class
        super(name, yearBuilt, engine);
        // set max number of passengers and norovirus status
        this.maxPassengers = maxPassengers;
        this.hasNorovirus = false;
    }

    // getter
    public int getMaxPassengers() {
        return maxPassengers;
    }

    public boolean hasNorovirus() {
        return hasNorovirus;
    }

    // setter
    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public void setHasNorovirus(boolean hasNorovirus) {
        this.hasNorovirus = hasNorovirus;
    }

    // toString method
    // returns cruiseship name and max number of passengers
    public String toString() {
        return "CruiseShip Name: \t" + getName() + ", Maximum Passengers: " + getMaxPassengers();
    }
}
