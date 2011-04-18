
public class Rider {
	
	private double arrivalTime;   //Time rider arrived at the bus stop
	private double boardingTime;  //Time rider boarded bus
	private int stopBoard;        //Which stop bus was boarded at
	private int stopExit;         //Which stop bus was exited at
	
	public Rider(double arrivalTime, double boardingTime, int stopBoard, int stopExit){
		this.arrivalTime = arrivalTime;
		this.boardingTime = boardingTime;
		this.stopBoard = stopBoard;
		this.stopExit = stopExit;
	}
	
	public double getArrivalTime(){
		return arrivalTime;
	}
	
	public double getBoardingTime(){
		return boardingTime;
	}
	
	public int getStopBoard(){
		return stopBoard;
	}
	
	public int getStopExit(){
		return stopExit;
	}
}
