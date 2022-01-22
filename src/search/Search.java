package search;


import model.ParkingLot;
import model.Slot;
import model.Ticket;
import repositories.TicketRepo;


public class Search{
	public Search()
	{
		
	}
	public void displayByColor(ParkingLot parkingLot,String color)
	{
		for(Slot slot : parkingLot.getAllSlots())
		{
			if(!slot.isAvailable())
			{
				//System.out.println(slot.getVechle().getPlateNo() + " | " + slot.getVechle().getColor()+" | "+slot.getSerialNo());
				if(color.equalsIgnoreCase(slot.getVechle().getColor().trim()))
				{
					System.out.println(slot.getVechle().getPlateNo());
				}
			}
		}
	}
	public void displaySlotNumber(String regNo,ParkingLot parkingLot)
	{
		int flag=0;
		for(Slot slot : parkingLot.getAllSlots())
		{
			if(!slot.isAvailable())
			{
				//System.out.println(slot.getVechle().getPlateNo() + " | " + slot.getVechle().getColor()+" | "+slot.getSerialNo());
				if(slot.getVechle().getPlateNo().equalsIgnoreCase(regNo))
				{
					flag=1;
					System.out.println(slot.getSerialNo());
					break;
				}
			}
		}
		if(flag==0)
		{
			System.out.println("Not available car of that registeration number");
		}
	}
	public void displaySlotNoByColor(String col,ParkingLot parkingLot)
	{
		int flag=0;
		for(Slot slot : parkingLot.getAllSlots())
		{
			if(!slot.isAvailable())
			{
				//System.out.println(slot.getVechle().getPlateNo() + " | " + slot.getVechle().getColor()+" | "+slot.getSerialNo());
				
				if(slot.getVechle().getColor().trim().equalsIgnoreCase(col))
				{
					flag=1;
					System.out.println(slot.getSerialNo());
				}
			}
		}
		if(flag==0)
		{
			System.out.println("Not available any car of that color ");
		}
	}
	public void displayTicket(TicketRepo t2,String registerationNumber) {
		for(Ticket t: t2.getAllTicket())
		{
			if(registerationNumber==t.getVechleNo())
			{
			System.out.println(t.getColor()+" "+t.getVechleNo()+" "+t.getEntryTime());
			break;
			}
		}
	}
	public void displayTicketWithExitTime(TicketRepo t2)
	{
		for(Ticket t: t2.getAllTicketWithExitTime())
		{
			 
			System.out.println(t.getExitTime());
			
		}
	}
	
	public void displayCarDetailsBySlotNo(ParkingLot parkingLot,int slotNo)
	{
		for(Slot slot : parkingLot.getAllSlots())
		{
			if(!slot.isAvailable() && slot.getSerialNo()==slotNo)
			{
				//System.out.println(slot.getVechle().getPlateNo() + " | " + slot.getVechle().getColor()+" | "+slot.getSerialNo());
				
				System.out.print(slot.getVechle().getPlateNo()+" "+slot.getVechle().getColor()+" ");
				break;
			}
		}
		
	}
}


