package Classes;


import javax.swing.ImageIcon;
import Deligators.IMotorized;
import Deligators.Motorized;

public class ElectricBicycle extends Bicycle implements IMotorized
{
	private Motorized motorized;

	public ElectricBicycle(String model, int distance, int passengers, int maxSpeed, boolean roadType,int lifeTime, ImageIcon image) {
		super(model, distance, passengers, maxSpeed, 2, roadType, image);
		motorized=new Motorized(20,lifeTime);
		
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
		return "Electric Bicycle: \n"+super.toString()+motorized.toString();
		
	}
	public boolean equals(Object other) {
		if (other instanceof ElectricBicycle) {
			return super.equals(other)&&motorized.equals(other);
		}
		return false;
	}
	@Override
	public Object cloneVehicle() {
		ElectricBicycle tmp=new ElectricBicycle(super.getModel(), super.getDistance(), super.getPassengers(), super.getMaxSpeed(), super.getRoadType(), motorized.getAverageLifeTime(), super.getImage());
		return tmp;		
	}

}
