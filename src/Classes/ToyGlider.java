package Classes;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

import Deligators.AirVehicle;
import Deligators.IAirVehicle;
import Deligators.INotMotorized;
import Deligators.IVehicle;
import Deligators.NotMotorized;
import Deligators.Vehicle;

public class ToyGlider implements IVehicle,IAirVehicle,INotMotorized {
	private Vehicle vehicle;
	private AirVehicle airVehicle;
	private NotMotorized notMotorized ;

	public ToyGlider(int distance,ImageIcon image) {
		vehicle=new Vehicle("Toy", distance, 0, 10,image);
		airVehicle=new AirVehicle(false);		
		notMotorized=new NotMotorized("Manual", 'A');

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
	public void set_useType(boolean type) {
		airVehicle.set_useType(true);
	}
	public boolean get_useType() {
		return airVehicle.get_useType();
	}
	public String getPowerSource() {
		return notMotorized.getPowerSource();
	}

	public char getEnergyScore() {
		return notMotorized.getEnergyScore();
	}
	
	public String toString() {
		return ("Toy Glider:      \n" + vehicle.toString() + airVehicle.toString()+notMotorized.toString());
	}

	public boolean equals(Object other) {
		if (other instanceof ToyGlider) {
			return vehicle.equals(other)&& airVehicle.equals(other)&&notMotorized.equals(other);
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
		ToyGlider tmp=new ToyGlider(vehicle.getDistance(), vehicle.getImage());
		return tmp;
	}
	

}
