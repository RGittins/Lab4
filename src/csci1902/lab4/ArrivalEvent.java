package csci1902.lab4;

public class ArrivalEvent implements Event {
	BusStop stop;
	public ArrivalEvent(BusStop s)
	{
		stop = s;
	}
	
	public void run() {
		Simulator.agenda.add(new ArrivalEvent(stop), randomArrivalTime());
		stop.addRider(new Rider(Simulator.agenda.getCurrentTime(),randomStop()));
		Stats.totalRiders++;
	}
	
	private int randomArrivalTime()
	{
		//return
		return 10;
	}
	
	private int randomStop()
	{
		return 10;
	}

}
