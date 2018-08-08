package Deligators;

public class NotMotorized {
	private String powerSource;
	private char energyScore;
	
	public NotMotorized(String powerSource,char energyScore) {
		this.powerSource=powerSource;
		this.energyScore=energyScore;
	}
	
	public String getPowerSource() {
		return powerSource;
	}

	public char getEnergyScore() {
		return energyScore;
	}
	
	public String toString()
	{
		return (" ,Power source: " + powerSource+ " ,Energy score: "+energyScore);
	}
	public boolean equals(Object other) {
		if (other instanceof INotMotorized) {
			return powerSource == ((INotMotorized) other).getPowerSource()
					&& energyScore == ((INotMotorized) other).getEnergyScore();
		}
		return false;

	}

}
