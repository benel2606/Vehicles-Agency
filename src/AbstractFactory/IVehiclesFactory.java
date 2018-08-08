package AbstractFactory;

import Deligators.IVehicle;
import GUI.AddVehiclesFrame;

public interface IVehiclesFactory {
	public IVehicle makeVehicle(String type,AddVehiclesFrame window);

}
