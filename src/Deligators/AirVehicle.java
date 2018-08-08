package Deligators;

public class AirVehicle {
	private boolean useType;

	public AirVehicle(boolean useType) {
		this.useType = useType;

	}

	public void set_useType(boolean type) {
		useType = type;
	}

	public boolean get_useType() {
		return useType;
	}

	public String toString() {
		String u = "";
		if (useType)
			u = "Military";
		else
			u = "Civilian";

		return (" ," + u);
	}

	public boolean equals(Object other) {
		if (other instanceof IAirVehicle) {
			return useType == ((IAirVehicle) other).get_useType();
		}
		return false;
	}

}
