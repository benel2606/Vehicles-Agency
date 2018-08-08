package Classes;

import javax.swing.ImageIcon;

import Deligators.*;

public class HybridAircraft extends Amphibious implements IAirVehicle{
	private AirVehicle airVehicle;
	
	public HybridAircraft(String model, int distance, int passengers, int max_speed, int wheels, boolean windDirection,
			String flag, int averageFuel, int averageLifeTime, ImageIcon image) {
		super(model, distance, passengers, max_speed, wheels, windDirection, flag, averageFuel, averageLifeTime, image);
		airVehicle=new AirVehicle(true);
		
	}
	public void set_useType(boolean type) {
		airVehicle.set_useType(type);
		
	}
	public boolean get_useType() {
		return airVehicle.get_useType();
	}
	public String toString() {
		return ("Hybrid Aircraft:  \n"+super.toString()+airVehicle.toString()).replaceAll("Amphibious:       \n", "");
	}
	public boolean equals(Object other) {
		if (other instanceof HybridAircraft) {
			return super.equals(other)&&airVehicle.equals(other);
		}
		return false;
	}
	
	
	
}