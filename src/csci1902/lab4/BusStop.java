package csci1902.lab4;

public class BusStop {
	public static int id = 1;
	private int stopNumber;
	Q1 riders = new Q1();
	
	public BusStop(){
		stopNumber = id++;
	}
	
	public void addRider(Rider r){
		riders.add(r);
	}
	
	public int getStopNumber()
	{
		return stopNumber;
	}
}
