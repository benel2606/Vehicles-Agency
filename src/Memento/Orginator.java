package Memento;

import java.util.Vector;

import Deligators.ISeaVehicle;
import Deligators.IVehicle;

public class Orginator {
	    private Vector<IVehicle> vehiclesAgency;
	    private Vector<ISeaVehicle> seaVehicles;
	    private int totalMileage;

	    public void setVehicleAgency(Vector<IVehicle> list) {
	        vehiclesAgency = list;
	    }

	    public void setSeaVehicles(Vector<ISeaVehicle> list) {
	        seaVehicles = list;
	    }

	    public void setTotalMileage(int mileage) {
	        totalMileage = mileage;
	    }

	    public int getTotalMileage() {
	        return totalMileage;
	    }

	    public Vector<IVehicle> getVehicleAgency() {
	        return vehiclesAgency;
	    }

	    public Vector<ISeaVehicle> getSeaVehicles() {
	        return seaVehicles;
	    }

	    public Memento createMemento() {
	        return new Memento(vehiclesAgency,seaVehicles, totalMileage);
	    }

	    public boolean setMemento(Memento memento) {
	        if (memento != null) {
	            vehiclesAgency = memento.getVehicleAgency();
	            seaVehicles = memento.getSeaVehicles();
	            totalMileage = memento.getTotalMileage();
	            return true;
	        }
	        return false;
	    }

}
