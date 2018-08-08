package AbstractFactory;

import javax.swing.ImageIcon;

import Classes.Amphibious;
import Classes.CruiseShip;
import Classes.Frigate;
import Classes.HybridAircraft;
import Deligators.IVehicle;
import GUI.AddVehiclesFrame;

public class SeaVehiclesFactory implements IVehiclesFactory {

	@Override
	public IVehicle makeVehicle(String type, AddVehiclesFrame window) {
		IVehicle tmpVehicle = null;
        String[] tmpData=null;
        ImageIcon tmpIcon=null;
        switch (type) {
            case "Frigate":
            	tmpIcon=window.getIcon(2);
                tmpData = window.getFrigateDetails();
                tmpVehicle = new Frigate(tmpData[0],0,Integer.parseInt(tmpData[1]), Integer.parseInt(tmpData[2]), Boolean.parseBoolean(tmpData[3]), tmpIcon);
                break;
            case "Cruise":
            	tmpIcon=window.getIcon(7);
                tmpData = window.getCruiseShipDetails();
                tmpVehicle = new CruiseShip(tmpData[0], 0,Integer.parseInt(tmpData[1]),Integer.parseInt(tmpData[2]),tmpData[3], Integer.parseInt(tmpData[4]), Integer.parseInt(tmpData[5]), tmpIcon);
                break;
            case "Amphibious":
            	tmpIcon=window.getIcon(5);
                tmpData = window.getAmphibiousDetails();
                tmpVehicle = new Amphibious(tmpData[0],0, Integer.parseInt(tmpData[1]), Integer.parseInt(tmpData[2]), Integer.parseInt(tmpData[3]), Boolean.parseBoolean(tmpData[4]), tmpData[5], Integer.parseInt(tmpData[6]), Integer.parseInt(tmpData[7]), tmpIcon);
                break;
            case "Hybrid Aircraft":
            	tmpIcon=window.getIcon(8);
                tmpData = window.getHybridAircraftDetails();
                tmpVehicle = new HybridAircraft(tmpData[0],0,Integer.parseInt(tmpData[1]), Integer.parseInt(tmpData[2]), Integer.parseInt(tmpData[3]), Boolean.parseBoolean(tmpData[4]), tmpData[5], Integer.parseInt(tmpData[6]), Integer.parseInt(tmpData[7]), tmpIcon);
                break;
        }
        return tmpVehicle;
    }

}
