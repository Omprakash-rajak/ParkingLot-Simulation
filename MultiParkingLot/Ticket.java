package MultiParkingLot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
private double ticketnumber;

private String outime;
private Vehicle vehicle;
DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-mm-dd  HH:mm:ss");
LocalDateTime intime=LocalDateTime.now();

public Ticket() {
	
	this.ticketnumber = Math.random();
	this.intime = LocalDateTime.now();
	
}
	
public double getTicketnumber() {
	return ticketnumber;
}
public void setTicketnumber(int ticketnumber) {
	this.ticketnumber = ticketnumber;
}

public LocalDateTime getIntime() {
	return intime;
}

public void setIntime(LocalDateTime intime) {
	this.intime = intime;
}

public String getOuttime() {
	return outime;
}
public void setOuttime(String outtime) {
	this.outime = outtime;
}
public Vehicle getVehicle() {
	return vehicle;
}
public void setVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
}
public void TicketDetails() {
	System.out.println("ticket number : "+ ticketnumber);
	System.out.println("Vehicle  in time : "+ intime);
	System.out.println("Vehical Out time : "+ outime);
	
}


}
