package csci1902.lab4;

public class BusStopEvent implements Event {
	Bus bus;
	public BusStopEvent(Bus b){
		bus = b;
	}
	
	@Override
	public void run() {
		bus.current = bus.getNextStop();
		bus.incNextStop(); //Plan next stop
		
		int stopTime = 0; //Keeps track of the time spent loading and unloading
		
		//Unload current passengers set for this stop
		Q1 tempQ = new Q1();
		while(bus.riders.length() > 0)
		{
			Rider currentRider = (Rider)bus.riders.remove();
			if(currentRider.exitStop == bus.current.getStopNumber())
			{			
				Stats.totalRideTime += Simulator.agenda.getCurrentTime()+stopTime - currentRider.boardTime;
				stopTime += Settings.DEBOARDTIME;
			}	
			else
				tempQ.add(currentRider); //Add the rider back into the new bus queue
		}
		
		bus.riders = tempQ; // replace the bus queue
		
		//Load the waiting riders from the stop
		while(bus.riders.length() < Settings.MAXBUSLOAD && bus.current.riders.length() > 0)
		{
			Rider r = (Rider)bus.current.riders.remove();
			r.boardTime = Simulator.agenda.getCurrentTime()+stopTime;
			Stats.totalWaitTime += r.boardTime - r.arrivalTime;
			//System.out.println(r.boardTime + " " + r.arrivalTime);
			bus.riders.add(r);
			stopTime += Settings.BOARDTIME;
		}
		Simulator.agenda.add(new BusStopEvent(bus), Settings.TRAVELTIME+stopTime); 
		
		//There is no need to implement the ability to skip a stop. System naturally handles it
	}

}
