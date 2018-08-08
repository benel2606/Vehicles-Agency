package Memento;

import java.util.Vector;

import Deligators.ISeaVehicle;
import Deligators.IVehicle;

public class Memento {
    private Vector<IVehicle> vehicleAgency;
    private Vector<ISeaVehicle> seaVehicles;
    private int totalMileage;

    Memento(Vector<IVehicle> vehicles,Vector<ISeaVehicle> sea, int mileage) {
        vehicleAgency = vehicles;
        seaVehicles=sea;
        totalMileage = mileage;
    }

    Vector<IVehicle> getVehicleAgency() {
        return vehicleAgency;
    }

    int getTotalMileage() {
        return totalMileage;
    }

    Vector<ISeaVehicle> getSeaVehicles() {
        return seaVehicles;
    }
}
