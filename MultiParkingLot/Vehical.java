package MultiParkingLot;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

class Vehicle {
	private String number;
	private String  size;
	//DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-mm-dd  HH:mm:ss");
	//LocalDateTime now;
	Ticket ticket;

	public Vehicle(String number, String size) {
		this.number = number;
		this.size = size;
		//this.now = LocalDateTime.now();
		this.ticket=new Ticket();

	//}

	//public LocalDateTime getNow() {
		//return now;
	//}

	//public void setNow(LocalDateTime now) {
		//this.now = now;
	}

	@Override
	public String toString() {
		return "Vehicle number=" + number +
				", size=" + size + ", in Time="+ ticket.getIntime()+
				", Out TIme="+ ticket.getOuttime()+"]";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	
}
