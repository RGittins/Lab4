package csci1902.lab4;

public class Bus {
	BusStop current;
	int next;
	Q1 riders = new Q1();
	
	public Bus(int stop){
		next = stop;
	}
	
	
	public void incNextStop(){
		next = (next+1)%Settings.STOPCOUNT;
		System.out.println(next);
	}
	
	public int getNextStopNumber(){
		return next;
	}
	
	public BusStop getNextStop(){
		return Simulator.stops[next];
	}
}
