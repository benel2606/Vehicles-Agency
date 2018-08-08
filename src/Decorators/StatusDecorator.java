package Decorators;

import javax.swing.border.Border;

import Deligators.IVehicle;

public class StatusDecorator extends VehiclesDecorator {
	private IVehicle vehicle;
	private String status;
	
	public StatusDecorator(IVehicle vehicle,String status) {
		super(vehicle);
		this.vehicle=vehicle;
		this.status=status;
	}
	 @Override
    public boolean equals(Object other) {
        if (other instanceof StatusDecorator)
            return status.equals(((StatusDecorator) other).getStatus()) && vehicle.equals(((StatusDecorator) other).withoutStatusDecorator());
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " ,Status: " + status;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public IVehicle withoutStatusDecorator() {
        return vehicle;
    }

    @Override
    public Border getBorder() {
        return vehicle.getBorder();
    }

    public void setStatus(String newStatus) {
        status = newStatus;
    }
	@Override
	public Object cloneVehicle() {
		return new StatusDecorator((IVehicle)vehicle.cloneVehicle(), status);
	}
		

}
