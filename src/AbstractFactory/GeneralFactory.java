package AbstractFactory;

public abstract class GeneralFactory {
	public static IVehiclesFactory getFactory(String type) {
        switch (type) {
            case "Sea":
                return new SeaVehiclesFactory();
            case "Air":
                return new AirVehiclesFactory();
            default:
                return new LandVehiclesFactory();
        }
    }

}
