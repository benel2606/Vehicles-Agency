package Classes;

import javax.swing.ImageIcon;

import Deligators.INotMotorized;
import Deligators.NotMotorized;

public class RegularBicycle extends Bicycle  implements INotMotorized{
	private NotMotorized notMotorized;

	public RegularBicycle(String model, int distance, int passengers, int maxSpeed, boolean roadType, ImageIcon image) 
	{
		super(model, distance, passengers, maxSpeed, 2, roadType, image);
		notMotorized=new NotMotorized("Manual",'A');
	}
	public String getPowerSource() {
		return notMotorized.getPowerSource();
	}
	public char getEnergyScore() {
		return notMotorized.getEnergyScore();
	}
	public String toString() {
		return "Regular Bicycle:  \n"+super.toString()+notMotorized.toString();
		
	}
	public boolean equals(Object other) {
		if (other instanceof RegularBicycle) {
			return super.equals(other)&&notMotorized.equals(other);
		}
		return false;
	}
	@Override
	public Object cloneVehicle() {
		RegularBicycle tmp=new RegularBicycle(super.getModel(), super.getDistance(), super.getPassengers(), super.getMaxSpeed(), super.getRoadType(), super.getImage());
		return tmp;
	}

}
