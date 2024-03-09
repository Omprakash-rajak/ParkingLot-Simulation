package MultiParkingLot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {

	private int num2WheelSlots;
	private int num4WheelSlots;
	private int numHeavyVehicleSlots;
	private int available2WheelSlots;
	private int available4WheelSlots;
	private int availableHeavyVehicleSlots;
	private Map<Double, Vehicle> occupiedSlots;

	public ParkingLot(int num2WheelSlots, int num4WheelSlots, int numHeavyVehicleSlots) {
		this.num2WheelSlots = num2WheelSlots;
		this.num4WheelSlots = num4WheelSlots;
		this.numHeavyVehicleSlots = numHeavyVehicleSlots;
		this.available2WheelSlots = num2WheelSlots;
		this.available4WheelSlots = num4WheelSlots;
		this.availableHeavyVehicleSlots = numHeavyVehicleSlots;
		this.occupiedSlots = new HashMap<>();
	}

	public double parkVehicle(Vehicle vehicle) {
		double ticketnumber = -1;
		
		if (vehicle.getSize().equals("2W")) {
			if (available2WheelSlots > 0) {
				ticketnumber = getNextAvailableSlot("2W");
				
				available2WheelSlots--;
				occupiedSlots.put(ticketnumber, vehicle);
			}
		} else if (vehicle.getSize().equals("4W")) {
			if (available4WheelSlots > 0) {
				ticketnumber = getNextAvailableSlot("4W");
				available4WheelSlots--;
				occupiedSlots.put(ticketnumber, vehicle);
			}
		} else if (vehicle.getSize().equals("HV")) {
			if (availableHeavyVehicleSlots > 0) {
				ticketnumber = getNextAvailableSlot("HV");
				availableHeavyVehicleSlots--;
				occupiedSlots.put(ticketnumber, vehicle);
			}
		}
		return ticketnumber;
	}

	private double getNextAvailableSlot(String size) {
		double ticketnumber = Math.random();
		while (occupiedSlots.containsKey(ticketnumber)) {
			ticketnumber++;
		}
		return ticketnumber;
	}

	public Vehicle unparkVehicle1(double ticketnumber) {
		Vehicle vehicle = null;
		if (occupiedSlots.containsKey(ticketnumber)) {
			vehicle = occupiedSlots.remove(ticketnumber);
			String size = vehicle.getSize();
			if (size.equals("2W")) {
				available2WheelSlots++;
			} else if (size.equals("4W")) {
				available4WheelSlots++;
			} else if (size.equals("HV")) {
				availableHeavyVehicleSlots++;
			}
		}
		return vehicle;
	}

//	public String currentOccupancyDetails() {
//		return " In 2 Wheeler : " + "available Slotes = "+available2WheelSlots + "  total Slotes  =  "+ num2WheelSlots + ", In 4 Wheeler : "
//				+"available Slotes = "+ available4WheelSlots + "  total Slotes  = " + num4WheelSlots + " And In  Heavy Vehicle : " +"available Slotes = " +availableHeavyVehicleSlots
	//			+ "  total Slotes  =  " + numHeavyVehicleSlots;
	
	public Vehicle unparkVehicle(double ticketnumber) {
		Vehicle vehicle = null;
		if (occupiedSlots.containsKey(ticketnumber)) {
			vehicle = occupiedSlots.remove(ticketnumber);
			String size = vehicle.getSize();
			if (size.equals("2W")) {
				available2WheelSlots++;
			} else if (size.equals("4W")) {
				available4WheelSlots++;
			} else if (size.equals("HV")) {
				availableHeavyVehicleSlots++;
			}
		}
		return vehicle;
	}
	public String currentOccupancyDetails( int lot) {
		return "  Two  Wheeler : " +" slot=  "+lot+1+ "Free = "+ available2WheelSlots +" / "+  "Occupied  =  "+ (num2WheelSlots-available2WheelSlots) + "   "+
				"  Four  Wheeler : "  +" slot=  "+lot+1+ "Free = "+ available4WheelSlots +" / "+  "Occupied  =  "+ (num4WheelSlots-available4WheelSlots)+  " "+
				"  Heavy  vehicle : "  +" slot=  "+lot+1+ "Free = "+ availableHeavyVehicleSlots +" / "+  "Occupied  =  "+ (numHeavyVehicleSlots-availableHeavyVehicleSlots);
	}
	public void ticketDetails(int lot) {
		
	Set<Map.Entry<Double, Vehicle>>s=occupiedSlots.entrySet();
	for(Map.Entry<Double, Vehicle>m:s)
	{
		double d=m.getKey();
		Vehicle v=m.getValue();
		System.out.println("ticket number : " +d + " Details "+v);
	}
	}
}
