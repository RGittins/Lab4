package csci1902.lab4;

public class ArrivalEvent implements Event {
	BusStop stop;
	public ArrivalEvent(BusStop s)
	{
		stop = s;
	}
	
	public void run() {
		Simulator.agenda.add(new ArrivalEvent(stop), randomArrivalTime());
		
		stop.addRider(new Rider(Simulator.agenda.getCurrentTime(),(stop.getStopNumber()+randomStop())%Settings.STOPCOUNT));
		
		if(stop.riders.length() > Stats.longestQ)
			Stats.longestQ = stop.riders.length();
		Stats.totalRiders++;
	}
	
	private double randomArrivalTime()
	{
		int random = (int) (Math.random() * 9);
		return Settings.ARRIVALRATE+(arrivalDistribution[random]*Settings.ARRIVALRATE);
	}
	
	
	private int randomStop()
	{
		int random = (int)Math.random() * 49;
		return stopDistribution[random];
	}
	private static int[] stopDistribution = new int[]{
		2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,
		4,5,6,7,8,9,10,11,12,13,14,15,16,
		6,7,8,9,10,11,12,13,14,15,
		7,8,9,10,11,12,13,
		9,10,11,12
	};
	private static double[] arrivalDistribution = new double[]{
		.75,.5,.5,.2,.2,-.2,-.2,-.5,-.5,-.75
	};
}
