package services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exception.SlotException;
import model.ParkingLot;
import model.Slot;
import model.Ticket;
import model.Vehicle;

public class ParkingLotServiceImpl implements IParkingLotService {
	
	@Override
	public ParkingLot createParkingLot(int parkingLotId,int numberOfSlots) {
		List<Slot> allSlots=new ArrayList<>();
		for(int i=1;i<=numberOfSlots;i++)
		{
			Slot s=new Slot(i,i,true);
			allSlots.add(s);
		}
		
		ParkingLot parkingLot=new ParkingLot(parkingLotId,allSlots);
		return parkingLot;
	}
	private Slot getFirstAvailableSlots(ParkingLot parkingLot) throws SlotException
	{
		for (Slot slot : parkingLot.getAllSlots())
		{
			if (slot.isAvailable())
			{
				return slot;
			}
		}
		throw new SlotException("slots not available");
	}
	private String getRandomPlateNumber()
	{
		String finalString="";
		final String firstString="KA";
		String secondString=getRandNumber(1,99);
		String thirdString=getRandTwoCharName(65,90);
		String forthString=getRandNumber2(1000,9999);
		finalString+=firstString;
		finalString+='-';
		finalString+=secondString;
		finalString+='-';
		finalString+=thirdString;
		finalString+='-';
		finalString+=forthString;
		
		return finalString;
	}
	
	private String getRandNumber2(int i, int j) {
		int num=i+(int)(Math.random() * (j-i));
		String str="";
		str+=num;
		return str;
	}
	private String getRandTwoCharName(int i, int j) {
		String str="";
		int num1=i+(int)(Math.random()*(j-i));
		int num2=i+(int)(Math.random()*(j-i));
		char ch1=(char)num1;
		char ch2=(char)num2;
		str+=ch1;
		str+=ch2;
		return str;
	}
	private String getRandNumber(int i, int j) {
		String str="";
		int num=i+(int)(Math.random()*(j-i));
		if(num>=1 && num<=9)
		{
			str+='0';
		}
		str+=num;
		return str;
	}
	@Override
	public void addRandomVehicle(int numberOfVechle, ParkingLot parkingLot) {
		for(int i=1;i<=numberOfVechle;i++)
		{
			try
			{
				Slot availableSlot = getFirstAvailableSlots(parkingLot);
				Vehicle vehicle = new Vehicle(i,getRandomPlateNumber(),getRandomColor());
				parkVehicleInSlot(availableSlot,vehicle);
			}
			catch(SlotException e)
			{
				System.out.println(e.getMessage());
				break;
			}
		}
		
	}
	private String getRandomColor() {
		String[] color= {"Black","White","Blue","Red"};
		int num=(int)(Math.random()*(4-0));
		String str=color[num];
		return str;
	}
	private void parkVehicleInSlot(Slot availableSlot,Vehicle vehicle)
	{
		availableSlot.setVechle(vehicle);
		availableSlot.setAvailable(false);
	}
	
	private void unparkVehicleInSlot(Slot availableSlot,Vehicle vehicle)
	{
		availableSlot.setVechle(null);
		availableSlot.setAvailable(true);
	}
	public void displayAllParkedVehicle(ParkingLot parkingLot)
	{
		for(Slot slot : parkingLot.getAllSlots())
		{
			if(!slot.isAvailable())
			{
				System.out.println(slot.getVechle().getPlateNo() + " | " + slot.getVechle().getColor()+" | "+slot.getSerialNo());
			}
		}
	}
	static int id=1;
	@Override
	public Ticket removeParkedVehicle(int removeSlotNumber, ParkingLot parkingLot) throws SlotException{
		boolean foundSlot=false;
		for(Slot slot : parkingLot.getAllSlots()) 
		{
			
			if(!slot.isAvailable() && slot.getSerialNo()==removeSlotNumber)
			{
				foundSlot=true;
				slot.setAvailable(true);
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				Ticket ticket = new Ticket(id, dateFormat.format(date));
				return ticket;
			}
		}
		if(!foundSlot)
		{
			throw new SlotException("no vehicle is parked");
		}
		return null;
	}

	@Override
	public Ticket parkCar(String registerationNumber, String colorOfCar, ParkingLot parkingLot) {
		
		try {
			Slot availableSlot = getFirstAvailableSlots(parkingLot);
			int i=(int)Math.random();
			Vehicle vehicle = new Vehicle(i,registerationNumber,colorOfCar);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			//System.out.println(dateFormat.format(date));
			Ticket ticket = new Ticket(id, registerationNumber, dateFormat.format(date) , colorOfCar);
			//System.out.println(ticket.getEntryTime());
			id++;
			parkVehicleInSlot(availableSlot,vehicle);
			return ticket;
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
		
		
	}
	


}
