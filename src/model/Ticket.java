package model;

import java.util.Date;

public class Ticket {
	public Ticket()
	{
		
	}
	private int id;
	private String vechleNo;
	private String entryTime;
	private String color;
	private String exitTime;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Ticket(int id,String vechleNo, String entryTime,String color) {
		super();
		this.id=id;
		this.entryTime=entryTime;
		this.vechleNo = vechleNo;
		this.color=color;
	}
	public Ticket(int id,String exitTime)
	{
		super();
		this.id=id;
		this.exitTime=exitTime;
	}
	public String getExitTime() {
		return exitTime;
	}
	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}
	public String getVechleNo() {
		return vechleNo;
	}
	public void setVechleNo(String vechleNo) {
		this.vechleNo = vechleNo;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
}
