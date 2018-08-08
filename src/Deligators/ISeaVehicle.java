package Deligators;

public interface ISeaVehicle 
{
	public void setWindDirection(boolean wind);
	public void setFlag(String newFlag);
	public boolean getWindDirection();
	public String getFlag();
	public String toString();
	public boolean equals(Object other);
	
}
