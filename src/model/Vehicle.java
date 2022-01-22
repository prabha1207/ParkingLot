package model;

public class Vehicle {
	private int id;
	private String plateNo;
	private String color;
	private Ticket ticket;
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Vehicle(int id,String plateNo, String color) {
		super();
		this.id=id;
		this.plateNo = plateNo;
		this.color = color;
	}
	public String getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
