package Deligators;

import javax.swing.ImageIcon;
import javax.swing.border.Border;

public interface IVehicle {
	public void addDistance(int addLength);
	public String getModel();
	public int getDistance();
	public void setDistance(int distance);
	public int getPassengers();
	public int getMaxSpeed();
	public void setImage(ImageIcon image);
	public ImageIcon getImage();
	public String toString();
	public boolean equals(Object other);
	public String getColor();
	public Border getBorder();
	public String getStatus();
	public Object cloneVehicle();
}
