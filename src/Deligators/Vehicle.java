package Deligators;

import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class Vehicle {
	private final String model;
	private int distance;
	private final int passengers;
	private final int maxSpeed;
	private ImageIcon image;

	public Vehicle(String model, int distance, int passengers, int maxSpeed,ImageIcon image) {
		this.model = model;
		this.distance = distance;
		this.passengers = passengers;
		this.maxSpeed = maxSpeed;
		this.image=image;
	}

	public void addDistance(int addLength) {
		distance += addLength;
	}

	public String getModel() {
		return model;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getPassengers() {
		return passengers;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}
	public ImageIcon getImage()
	{
		return image;
	}
	public void setImage(ImageIcon image)
	{
		this.image=image;
	}
	public String getColor()
	{
		return "";
	}
	public Border getBorder()
	{
		return null;
	}
	public String getStatus()
	{
		return "";
	}
	public String toString() {
		return ("Model: " + model + " ,Traveled: " + distance + "km" + " ,Max speed: " + maxSpeed + "Mph"
				+ " ,can carry max of " + passengers + " people");
	}
	public boolean equals(Object other) {
		if (other instanceof IVehicle) {
			return model.equals(((IVehicle) other).getModel()) && distance == ((IVehicle) other).getDistance()
					&& passengers == ((IVehicle) other).getPassengers() && maxSpeed == ((IVehicle) other).getMaxSpeed();
		}
		return false;

	}
}
