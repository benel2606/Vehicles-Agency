package Classes;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

import Deligators.IMotorized;
import Deligators.ISeaVehicle;
import Deligators.IVehicle;
import Deligators.Motorized;
import Deligators.SeaVehicle;
import Deligators.Vehicle;

public class Frigate implements  IVehicle, IMotorized,ISeaVehicle {
	private Vehicle vehicle;
	private SeaVehicle seaVehicle;
	private Motorized motorized;

	public Frigate(String model, int distance, int passengers, int maxSpeed, boolean windDirection,ImageIcon image) {
		vehicle=new Vehicle(model, distance, passengers, maxSpeed,image);
		seaVehicle=new SeaVehicle(windDirection, "Israel");
		motorized=new Motorized(500, 4);
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
	public void setAverageFuel(int fuel) {
		motorized.setAverageFuel(fuel);
	}

	public int getAverageFuel() {
		return motorized.getAverageFuel();
	}

	public int getAverageLifeTime() {
		return motorized.getAverageLifeTime();
	}
	public void setWindDirection(boolean wind)
	{
		seaVehicle.setWindDirection(wind);
	}
	public void setFlag(String newFlag)
	{
		seaVehicle.setFlag(newFlag);
	}
	public boolean getWindDirection()
	{
		return seaVehicle.getWindDirection();
	}
	public String getFlag()
	{
		return seaVehicle.getFlag();
	}
	public String toString() {
		return "Frigate:          \n" + vehicle.toString() +seaVehicle.toString()+ motorized.toString(); //"  Engine: " + AverageFuel + "  Life time of "	+ AverageLifeTime + " years");
	}

	public boolean equals(Object other) {
		if (other instanceof Frigate) {
			return vehicle.equals(other) && seaVehicle.equals(other)&&motorized.equals(other);//&&AverageLifeTime == ((Frigate) other).getAverageLifeTime()&& AverageFuel == ((Frigate) other).getAverageFuel());
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
		Frigate tmp=new Frigate(vehicle.getModel(), vehicle.getDistance(), vehicle.getPassengers(), vehicle.getMaxSpeed(), seaVehicle.getWindDirection(), vehicle.getImage());
		return tmp;
	}
}
