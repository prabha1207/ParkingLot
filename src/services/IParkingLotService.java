package services;

import exception.SlotException;
import model.ParkingLot;
import model.Slot;
import model.Ticket;

public interface IParkingLotService {
	public ParkingLot createParkingLot(int parkingLotId,int numberOfSlots);
	public void addRandomVehicle(int vechicleId,int ticketId,int numberOfVechle,ParkingLot parkingLot);
	public void displayAllParkedVehicle(ParkingLot parkingLot);
	public Ticket removeParkedVehicle(int removeSlotNumber,ParkingLot parkingLot) throws SlotException;
	public Ticket parkCar(int vechicleId,int ticketId,String registerationNumber, String colorOfCar, ParkingLot parkingLot);
}
