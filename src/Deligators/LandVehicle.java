package Deligators;

public class LandVehicle{
	private final int wheels;
	private final boolean roadType;

	public LandVehicle(int wheels, boolean roadType) {
		this.wheels = wheels;
		this.roadType = roadType;
	}

	public int getWheels() {
		return wheels;
	}

	public boolean getRoadType() {
		return roadType;
	}

	public String toString() {
		String r = "";
		if (roadType)
			r = "Dirt road";
		else
			r = "Paved road";

		return (" ,Wheels: " + wheels + " ,Can drive in " + r);
	}

	public boolean equals(Object other) {
		if (other instanceof ILandVehicle) {
			return wheels == ((ILandVehicle) other).getWheels()
					&& roadType == ((ILandVehicle) other).getRoadType();
		}
		return false;

	}

}
