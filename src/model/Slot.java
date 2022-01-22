package model;

public class Slot {
	public Slot() {
		
	}
	private int id;
	private int serialNo;
	private boolean isAvailable;
	private Vehicle vechle;
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Slot(int id,int serialNo, boolean isAvailable) {
		super();
		this.id=id;
		this.serialNo = serialNo;
		this.isAvailable = isAvailable;
	}
	public Vehicle getVechle() {
		return vechle;
	}
	public void setVechle(Vehicle vechle) {
		this.vechle = vechle;
	}
}
