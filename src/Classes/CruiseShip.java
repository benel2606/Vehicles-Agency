package Classes;

import javax.swing.ImageIcon;
import javax.swing.border.Border;

import Deligators.*;

public class CruiseShip implements IVehicle,ISeaVehicle,IMotorized,ICommercial{
	private Vehicle vehicle;
	private SeaVehicle seaVehicle;
	private Motorized motorized;
	private String LicenseType;
	
	public CruiseShip(String model, int distance, int passengers, int maxSpeed,String flag,int averageFuel,int averageLifeTime,ImageIcon image) {
		vehicle=new Vehicle(model, distance, passengers, maxSpeed,image);
		seaVehicle=new SeaVehicle(true, flag);
		motorized=new Motorized(averageFuel, averageLifeTime);
		LicenseType="Unlimite";
		
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
	public String getLicenseType()
	{
		return LicenseType;
	}

	public String toString() {
		return "Cruise Ship:      \n" +vehicle.toString()+seaVehicle.toString()+motorized.toString()+" ,License Type: "+LicenseType;
	}
	public boolean equals(Object other)
	{
		if(other instanceof CruiseShip) {
			return vehicle.equals(other)&&seaVehicle.equals(other)&&motorized.equals(other);
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
		CruiseShip tmp=new CruiseShip(vehicle.getModel(), vehicle.getDistance(), vehicle.getPassengers(), vehicle.getMaxSpeed(), seaVehicle.getFlag(), motorized.getAverageFuel(), motorized.getAverageLifeTime(), vehicle.getImage());
		return tmp;
	}

}
