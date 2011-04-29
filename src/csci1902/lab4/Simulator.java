package csci1902.lab4;

public class Simulator {

	static PQ agenda = new PQ();
	public static Bus[] buses = new Bus[Settings.BUSCOUNT];
	public static BusStop[] stops = new BusStop[Settings.STOPCOUNT];
	
	
	public static void main(String[] args) {
		for(int i = 0;i<Settings.STOPCOUNT;i++)
		{
			stops[i] = new BusStop();
			agenda.add(new ArrivalEvent(stops[i]), 10);
		}
		
		double busSpace = Settings.STOPCOUNT/Settings.BUSCOUNT; //Separate the buses evenly per amount of stops
		
		for(int i = 0;i<Settings.BUSCOUNT;i++)
		{
			buses[i] = new Bus((int)Math.floor(i*busSpace));
			agenda.add(new BusStopEvent(buses[i]), 10);
		}
		
		while(!agenda.isEmpty() && agenda.getCurrentTime() < Settings.RUNTIME)
			agenda.remove().run();
		
		System.out.println("Total Riders: "+Stats.totalRiders);
		System.out.println("Biggest Q: "+Stats.longestQ);
		System.out.println("Average Q: "+(float)Stats.totalQueue/Stats.totalStops);
		System.out.println("Average Bus Q: "+(float)Stats.totalBusQueue/Stats.totalStops);
		System.out.println("Average Wait Time: "+Stats.totalWaitTime/Stats.totalBoardedRiders);
		System.out.println("Average RIDE Time: "+Stats.totalRideTime/Stats.totalRidersRoad);
	}
}
