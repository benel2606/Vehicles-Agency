package AbstractFactory;

import javax.swing.ImageIcon;
import Classes.ElectricBicycle;
import Classes.Jeep;
import Classes.RegularBicycle;
import Deligators.IVehicle;
import GUI.AddVehiclesFrame;

public class LandVehiclesFactory implements IVehiclesFactory {

	@Override
	public IVehicle makeVehicle(String type, AddVehiclesFrame window) {
		IVehicle tmpVehicle=null;
		ImageIcon tmpIcon=null;
		String[] tmpData=null;
		switch (type) {
	        case "Jeep":
	        	tmpIcon=window.getIcon(1);
	            tmpData = window.getJeepDetails();
	            tmpVehicle = new Jeep(tmpData[0],0, Integer.parseInt(tmpData[1]), Integer.parseInt(tmpData[2]), Integer.parseInt(tmpData[3]), tmpIcon);
	            break;
	        case "Bicycle":
	        	tmpIcon=window.getIcon(6);
	            tmpData = window.getRegularBicycleDetails();
	            tmpVehicle = new RegularBicycle(tmpData[0],0,Integer.parseInt(tmpData[1]), Integer.parseInt(tmpData[2]),Boolean.parseBoolean(tmpData[3]), tmpIcon);
	            break;
	        case "Electric Bicycle":
	        	tmpIcon=window.getIcon(9);
	            tmpData = window.getElectricBicycleDetails();
	            tmpVehicle = new ElectricBicycle(tmpData[0],0, Integer.parseInt(tmpData[1]), Integer.parseInt(tmpData[2]), Boolean.parseBoolean(tmpData[3]), Integer.parseInt(tmpData[4]), tmpIcon);
	            break;
    }
    return tmpVehicle;
		
	}

}
