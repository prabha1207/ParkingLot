package model;

import java.util.List;

public class ParkingLot {
	private int id;
	public ParkingLot(int id,List<Slot> allSlots) {
		super();
		this.id=id;
		this.allSlots = allSlots;
	}
	private List<Slot> allSlots;
	public List<Slot> getAllSlots() {
		return allSlots;
	}
	public void setAllSlots(List<Slot> allSlots) {
		this.allSlots = allSlots;
	}
}
