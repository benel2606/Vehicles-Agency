package GUI;

import java.util.Vector;
import java.util.concurrent.Semaphore;

import Deligators.ISeaVehicle;
import Deligators.IVehicle;

public class MainGUI {
	private static  Vector<ISeaVehicle>seaVehicles=new Vector<>();
	private static  Vector<IVehicle> vehiclesAgency=new Vector<>();
	static Vector<Semaphore> semalock = new Vector<>();
	
	public Vector<IVehicle> getVehiclesAgency() {return vehiclesAgency;}
	public Vector<ISeaVehicle> getSeaVehiclesAgency() {return seaVehicles;}

	public static void main(String[] args) 
	{
		MainFrame.getInstance(vehiclesAgency, seaVehicles).setVisible(true);;
	}

}
