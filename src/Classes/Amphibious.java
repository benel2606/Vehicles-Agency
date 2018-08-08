package Classes;

import javax.swing.ImageIcon;
import javax.swing.border.Border;

import Deligators.*;


public class Amphibious implements IVehicle, ILandVehicle,ISeaVehicle,IMotorized
{
	private Vehicle vehicle;
	private LandVehicle landVehicle;
	private SeaVehicle seaVehicle;
	private Motorized motorized;
	
	public Amphibious (String model, int distance, int passengers, int max_speed, int wheels, boolean windDirection, String flag,int averageFuel,int averageLifeTime,ImageIcon image)
	{
		vehicle=new Vehicle(model,distance,passengers,max_speed,image);
		landVehicle=new LandVehicle(wheels,false);
		seaVehicle=new SeaVehicle(windDirection, flag);
		motorized=new Motorized(averageFuel, averageLifeTime);
	}
	public void addDistance(int addLength) {
		vehicle.addDistance(addLength);
	}
	public String getModel() {
		return vehicle.getModel();
	}
	public int getDistance() {
		return vehicle.getDistance();
	}
	public void setDistance(int distance) {
		vehicle.setDistance(distance);
	}
	public int getPassengers() {
		return vehicle.getPassengers();
	}
	public int getMaxSpeed() {
		return vehicle.getMaxSpeed();
	}
	public void setImage(ImageIcon image) {
		vehicle.setImage(image);	
	}
	public ImageIcon getImage() {
		return vehicle.getImage();
	}
	public int getWheels() {
		return landVehicle.getWheels();
	}
	public boolean getRoadType() {
		return landVehicle.getRoadType();
	}
	public void setWindDirection(boolean wind) {
		seaVehicle.setWindDirection(wind);
	}
	public void setFlag(String newFlag) {
		seaVehicle.setFlag(newFlag);
	}
	public boolean getWindDirection() {
		return seaVehicle.getWindDirection();
	}
	public String getFlag() {
		return seaVehicle.getFlag();
	}
	public void setAverageFuel(int fuel) {
		motorized.setAverageFuel(fuel);
	}

	public int getAverageFuel() {
		return motorized.getAverageFuel();
	}

	public int getAverageLifeTime() {
		return motorized.getAverageLifeTime();
	}

	public String toString() {
		return "Amphibious:       \n"+vehicle.toString()+landVehicle.toString()+seaVehicle.toString()+motorized.toString();
	}
	public boolean equals(Object other) {
		if (other instanceof Amphibious) {
			return vehicle.equals(other)&&landVehicle.equals(other)&&seaVehicle.equals(other);
		}
		return false;
	}
	@Override
	public String getColor() {
		return vehicle.getColor();
	}
	@Override
	public Border getBorder() {
		return vehicle.getBorder();
	}
	@Override
	public String getStatus() {
		return vehicle.getStatus();
	}
	@Override
	public Object cloneVehicle() {
		Amphibious tmp=new Amphibious(vehicle.getModel(), vehicle.getDistance(), vehicle.getPassengers(), vehicle.getMaxSpeed(), landVehicle.getWheels(), seaVehicle.getWindDirection(), seaVehicle.getFlag(), motorized.getAverageFuel(), motorized.getAverageLifeTime(), vehicle.getImage());
		return tmp;
	}
	
	
	
	
	

}
