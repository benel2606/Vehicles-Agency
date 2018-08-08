package AbstractFactory;

import javax.swing.ImageIcon;

import Classes.SpyGlider;
import Classes.ToyGlider;
import Deligators.IVehicle;
import GUI.AddVehiclesFrame;

public class AirVehiclesFactory implements IVehiclesFactory {

	@Override
	public IVehicle makeVehicle(String type,AddVehiclesFrame window) {
		IVehicle tmpVehicle=null;
		String[] tmpData=null;
		ImageIcon tmpIcon=null;
		switch (type) {
	        case "Toy Glider":
	        	tmpIcon=window.getIcon(4);
	            tmpVehicle = new ToyGlider(0,tmpIcon);
	            break;
	        case "Spy Glider":
	        	tmpIcon=window.getIcon(3);
	        	tmpData = window.getSpyGliderDetails();
	            tmpVehicle = new SpyGlider(0,tmpData[0], tmpIcon);
	            break;
    }
    return tmpVehicle;
		
	}
	

}
