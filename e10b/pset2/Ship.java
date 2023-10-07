public abstract class Ship {

    private String name;
    private int yearBuilt;

    // Enumerated for engine type
    public enum engineType {
        // engine types
        STEAM_ENGINE,
        STEAM_TURBINE,
        GAS_TURBINE,
        DIESEL,
        ELECTRIC,
        WIND,
        HUMAN_FORCE
    }

    private engineType engine;

    // constructor
    public Ship(String name, int yearBuilt, engineType engine) {
        // set str name, int yearBuilt, and engine type
        this.name = name;
        this.yearBuilt = yearBuilt;
        this.engine = engine;
    }

    // getter
    public String getName() {
        // return name
        return name;
    }

    public int getYearBuilt() {
        // return year built
        return yearBuilt;
    }

    public engineType getEngine() {
        // return engine type
        return engine;
    }

    // setter
    public void setName(String name) {
        // set str name
        this.name = name;
    }

    public void setYearBuilt(int yearBuilt) {
        // set int yearBuilt
        this.yearBuilt = yearBuilt;
    }

    public void setMainEngine(engineType engine) {
        // set engine type from defined options
        switch (engine) {
            case STEAM_TURBINE:
                this.engine = engineType.STEAM_TURBINE;
                break;
            case GAS_TURBINE:
                this.engine = engineType.GAS_TURBINE;
                break;
            case DIESEL:
                this.engine = engineType.DIESEL;
                break;
            case ELECTRIC:
                this.engine = engineType.ELECTRIC;
                break;
            case WIND:
                this.engine = engineType.WIND;
                break;
            case HUMAN_FORCE:
                this.engine = engineType.HUMAN_FORCE;
                break;
            default:
                this.engine = engineType.STEAM_ENGINE;
                break;
        }
    }

    // toString method
    public String toString() {
        // returns ship name, engine type, and year built as a string
        return "Ship Name: \t" + name + ", Engine Type: " + engine + ", Year Built: " + yearBuilt;
    }
}
