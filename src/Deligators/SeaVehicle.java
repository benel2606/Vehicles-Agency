package Deligators;

public class SeaVehicle {
	private boolean windDirection;
	private String flag;

	public SeaVehicle(boolean windDirection, String flag) {
		this.windDirection = windDirection;
		this.flag = flag;
	}

	public void setWindDirection(boolean wind) {
		windDirection = wind;
	}

	public void setFlag(String newFlag) {
		flag = newFlag;
	}

	public boolean getWindDirection() {
		return windDirection;
	}

	public String getFlag() {
		return flag;
	}
	public String toString() {
		String w;
		if (windDirection)
			w = "With the wind";
		else
			w = "Against the wind";
		return (" ,"+w + " ,Under " + flag + " flag");
	}

	public boolean equals(Object other) {
		if (other instanceof ISeaVehicle) {
			return windDirection == ((ISeaVehicle) other).getWindDirection()
					&& flag.equals(((ISeaVehicle) other).getFlag());
		}
		return false;
	}

}
