package Classes;

import javax.swing.ImageIcon;
import javax.swing.border.Border;

import Deligators.*;

public abstract class Bicycle implements IVehicle,ILandVehicle {
	
	private Vehicle vehicle;
	private LandVehicle landVehicle;
	
	public Bicycle(String model, int distance, int passengers, int maxSpeed,int wheels,boolean roadType,ImageIcon image) {
		vehicle=new Vehicle(model, distance, passengers, maxSpeed,image);
		landVehicle=new LandVehicle(wheels, roadType);
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
	public String toString() {
		return vehicle.toString()+landVehicle.toString();
		
	}
	public boolean equals(Object other) {
		if (other instanceof Bicycle) {
			return vehicle.equals(other)&&landVehicle.equals(other);
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
	

	
}
