package driver;

import java.util.Scanner;

import exception.SlotException;
import model.ParkingLot;
import model.Slot;
import model.Ticket;
import repositories.TicketRepo;
import search.Search;
import services.IParkingLotService;
import services.ParkingLotServiceImpl;

public class Main {
	
	public static void main(String[] args)
	{
		Search search=new Search();
		Ticket t1=new Ticket();
		TicketRepo t2=new TicketRepo();
		Scanner sc=new Scanner(System.in);
		IParkingLotService parkingLotService=new ParkingLotServiceImpl();
		System.out.println("enter number of slots");
		int n=sc.nextInt();
		ParkingLot parkingLot = parkingLotService.createParkingLot(1, n);
		int m=0;
		
		
		//enter car
		System.out.println("enter no. of cars currently in the parking lot");
		while(true)
		{
			m=sc.nextInt();
			if(m>n)
			{
				System.out.print("enter no of cars in  range which is <=");
				System.out.println(n);
			}
			else
			{
				break;
			}
		}
		parkingLotService.addRandomVehicle(m, parkingLot);
		
		
		
		//display car present in parking lot
		System.out.println("Shows the list of cars along with their details in a Table");
		System.out.println("-----------------------------------------------------------------------");
		parkingLotService.displayAllParkedVehicle(parkingLot);
		System.out.println("-----------------------------------------------------------------------");
		
		
		//parking new car in parking lot by user with regno and color
				//
				while(true)
				{
					System.out.println("if u don't want to park new car then press 0");
					System.out.println("enter any number to park new car");
					int zero=sc.nextInt();
					if(zero==0)break;
					System.out.println("enter registeration number of car");
					String registerationNumber=sc.next();
					System.out.println("enter color of car");
					String colorOfCar=sc.next();
					t1=parkingLotService.parkCar(registerationNumber,colorOfCar,parkingLot);
					t2.allTicket.add(t1);
					System.out.println("display ticket with entry time");
					search.displayTicket(t2);
					System.out.println();
					System.out.println("display all vechile");
					parkingLotService.displayAllParkedVehicle(parkingLot);
					System.out.println();
				}
		
		
		
		//removing car from parking lot
		while(true)
		{
			try
			{
				System.out.println("enter slot number to remove");
				System.out.println("enter 0 if you dont want to remove");
				System.out.println("*************************************");
				int removeSlotNumber=sc.nextInt();
				if(removeSlotNumber==0)
				{
					break;
				}
				System.out.println("display ticket with exit time");
				search.displayCarDetailsBySlotNo(parkingLot, removeSlotNumber);
				t1=parkingLotService.removeParkedVehicle(removeSlotNumber,parkingLot);
				t2.allTicketWithExitTime.add(t1);
				search.displayTicketWithExitTime(t2);
				System.out.println();
			}
			catch(SlotException e)
			{
				System.out.println(e.getMessage());
				break;
			}
			System.out.println();
			parkingLotService.displayAllParkedVehicle(parkingLot);
		}
		//
		
		
		
		
		//display car details by color,regno,etc
		System.out.println("enter color of car you want to see registeration no of");
		String color=sc.next();
		search.displayByColor(parkingLot,color);
		System.out.println("enter registration number to display slot number ");
		String regNo=sc.next();
		search.displaySlotNumber(regNo,parkingLot);
		System.out.println("enter color to find out slot no");
		String col=sc.next();
		search.displaySlotNoByColor(col,parkingLot);
	}
}
