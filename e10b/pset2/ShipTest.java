//
public class ShipTest {
    public static void main(String[] args) {

        // define array of Ship objects to test inheritance
        Ship[] shipsArray = new Ship[6];

        shipsArray[0] = new Cruiseship(
                "SS Gosling",
                1995,
                Ship.engineType.STEAM_ENGINE,
                1000);

        shipsArray[1] = new Cruiseship(
                "SS Sheridan",
                1995,
                Ship.engineType.STEAM_TURBINE,
                500);

        shipsArray[2] = new CargoShip(
                "HMS Naughton",
                1995,
                Ship.engineType.GAS_TURBINE,
                100000);

        shipsArray[3] = new CargoShip(
                "The Leitner",
                1970,
                Ship.engineType.DIESEL,
                220000);

        shipsArray[4] = new ReeferVessel(
                "The Habermehl",
                2000,
                Ship.engineType.ELECTRIC,
                100000,
                -20.0);

        shipsArray[5] = new ReeferVessel(
                "PleaseGiveMeFullCreditITriedReallyHard",
                2000,
                Ship.engineType.WIND,
                1,
                -30.0);

        for (Ship ship : shipsArray) {
            System.out.println(ship.toString());
        }
    }
}