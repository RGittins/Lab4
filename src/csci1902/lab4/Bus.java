package csci1902.lab4;

public class Bus {
	BusStop current;
	int next;
	Q1 riders = new Q1();
	
	public Bus(int stop)
	{
		next = stop;
	}
}
