package Decorators;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import Deligators.IVehicle;

public class ColorDecorator extends VehiclesDecorator {
	 private String color;
	 private IVehicle vehicle;
	 
	 public ColorDecorator(String color,IVehicle vehicle) {
		 super (vehicle);
		 this.color=color;
		 this.vehicle=vehicle;
		
	}
	 public IVehicle withoutColorDecorator() {
	        return vehicle;
	    }

	    @Override
	    public boolean equals(Object other) {
	        if (other instanceof ColorDecorator)
	            return color.equals(((ColorDecorator) other).getColor()) && vehicle.equals(((ColorDecorator) other).withoutColorDecorator());
	        return false;
	    }

	    @Override
	    public String toString() {
	        return super.toString() + " ,Color: " + color;
	    }

	    @Override
	    public String getColor() {
	        return color;
	    }

	    @Override
	    public Border getBorder() {
	        switch (color) {
	            case "Black":
	                return BorderFactory.createLineBorder(Color.BLACK, 5);
	            case "Red":
	                return BorderFactory.createLineBorder(Color.RED, 5);
	            case "Yellow":
	                return BorderFactory.createLineBorder(Color.YELLOW, 5);
	            case "Blue":
	                return BorderFactory.createLineBorder(Color.BLUE, 5);
	            case "Purple":
	                return BorderFactory.createLineBorder(Color.MAGENTA, 5);
	            case "Gray":
	                return BorderFactory.createLineBorder(Color.GRAY, 5);
	            default: // green
	                return BorderFactory.createLineBorder(Color.GREEN, 5);
	        }
	    }
		@Override
		public Object cloneVehicle() {
			return new ColorDecorator(color, (IVehicle)vehicle.cloneVehicle());
		}

	
}
