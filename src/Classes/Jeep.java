package Classes;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

import Deligators.ICommercial;
import Deligators.ILandVehicle;
import Deligators.LandVehicle;
import Deligators.Motorized;
import Deligators.Vehicle;
import Deligators.IMotorized;
import Deligators.IVehicle;

public class Jeep implements IVehicle ,ILandVehicle,IMotorized, ICommercial {
	private Vehicle vehicle;
	private LandVehicle landVehicle;
	private Motorized mototized;

	public Jeep(String model, int distance, int max_speed, int AverageLifeTime, int AverageFuel,ImageIcon image) {
		vehicle=new Vehicle(model,distance,5,max_speed,image);
		landVehicle=new LandVehicle(4, true);
		mototized=new Motorized(AverageFuel, AverageLifeTime);
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
		mototized.setAverageFuel(fuel);
	}

	public int getAverageFuel() {
		return mototized.getAverageFuel();
	}

	public int getAverageLifeTime() {
		return mototized.getAverageLifeTime();
	}

	public String getLicenseType() {
		return "MINI";
	}
	public int getWheels() {
		return landVehicle.getWheels();
	}
	public boolean getRoadType()
	{
		return landVehicle.getRoadType();
	}


	public String toString() {
		return ("Jeep:            \n"+vehicle.toString()+" ,"+landVehicle.toString()+ mototized.toString());  //" ,Engine: " + AverageFuel + " ,Life time of "+ AverageLifeTime + " years");
	}

	public boolean equals(Object other) {
		if (other instanceof Jeep) {
			return vehicle.equals(other) && landVehicle.equals(other)&&mototized.equals(other); //AverageLifeTime == ((Jeep) other).getAverageLifeTime()&& AverageFuel == ((Jeep) other).getAverageFuel();
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
		Jeep tmp=new Jeep(vehicle.getModel(), vehicle.getDistance(), vehicle.getMaxSpeed(), mototized.getAverageLifeTime(), mototized.getAverageFuel(), vehicle.getImage());
		return tmp;
	}
}
