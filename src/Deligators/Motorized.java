package Deligators;

public class Motorized 
{
	private int averageFuel;
	private int averageLifeTime;
	
	public Motorized(int averageFuel,int averageLifeTime)
	{
		this.averageFuel=averageFuel;
		this.averageLifeTime=averageLifeTime;
	}
	
	public void setAverageFuel(int fuel)
	{
		this.averageFuel=fuel;
	}

	public int getAverageFuel()
	{
		return averageFuel;
	}

	public int getAverageLifeTime()
	{
		return averageLifeTime;
	}
	
	public String toString()
	{
		return " ,Engine: "+ averageFuel+" ,Average life time: "+averageLifeTime;
	}
	public boolean equals(Object other) {
		if (other instanceof IMotorized) {
			return averageFuel == ((IMotorized) other).getAverageFuel()
					&& averageLifeTime == ((IMotorized) other).getAverageLifeTime();
		}
		return false;

	}

}
