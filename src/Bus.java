
public class Bus {

    private int firstStop;
    private int currentStop;
    private int nextStop;
    private int riders;

    public Bus(int start, int riders) {
        firstStop = start;                   //Integer in range [1, 20] determines which stop the bus starts at
        currentStop = start;                 //Keeps track of which stop the bus at, -1 if not stopped  
        nextStop = (currentStop%20) + 1;     //Finds next stop without a conditional
	//GAY
    }

    public int getRiders() {
        return riders;
    }
  
    public int getNextStop() {
        return nextStop;
    }

    public int getCurrentStop() {
    	return currentStop;
    }
}