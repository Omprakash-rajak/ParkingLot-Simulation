package MultiParkingLot;

import java.util.List;

public class MultipleParkingLot {
	@Override
	public String toString() {
		return "MultipleParkingLot [parkinglot=" + parkinglot + "]";
	}

	private List<ParkingLot>parkinglot;
	

	
	public List<ParkingLot> getParkinglot() {
		return parkinglot;
	}

	public void setParkinglot(List<ParkingLot> parkinglot) {
		this.parkinglot = parkinglot;
	}

}
