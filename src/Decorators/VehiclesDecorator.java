package Decorators;

import javax.swing.ImageIcon;
import javax.swing.border.Border;

import Deligators.IVehicle;

public abstract class VehiclesDecorator implements IVehicle {

	private IVehicle vehicle;
	public VehiclesDecorator(IVehicle v) {
		vehicle=v;
	}

	@Override
	public void addDistance(int addLength) {
		vehicle.addDistance(addLength);
	}
	@Override
	public String getModel() {
		return vehicle.getModel();
	}

	@Override
	public int getDistance() {
		return vehicle.getDistance();
	}

	@Override
	public void setDistance(int distance) {
		vehicle.setDistance(distance);		
	}

	@Override
	public int getPassengers() {
		return vehicle.getPassengers();
	}

	@Override
	public int getMaxSpeed() {
		return vehicle.getMaxSpeed();
	}

	@Override
	public void setImage(ImageIcon image) {
		vehicle.setImage(image);
	}

	@Override
	public ImageIcon getImage() {
		return vehicle.getImage();
	}
	@Override
	public String toString()
	{
		return vehicle.toString();
	}
	@Override
	public boolean equals(Object other) {
        if (other instanceof IVehicle)
            return vehicle.equals(other);
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
