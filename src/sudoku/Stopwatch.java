package sudoku;

/**
 * 
 * @author Tim
 *
 * A very basic timing class.
 * 
 */

public class Stopwatch {
	private long endTime;
	private long startTime;
	private boolean done = false;
	private boolean started = false;
	
	public void start(){
		if(started)
			throw new IllegalStateException();
		else
			startTime = System.currentTimeMillis();
		started = true;
		done = false;
	}
	
	public void stop(){
		if (done)
			throw new IllegalStateException();
		else
			done = true;
		endTime = System.currentTimeMillis();
	}
	
	public int inMillis(){
		if(done)
			return (int) (endTime - startTime);
		else
			return (int) (System.nanoTime() - startTime);
	}

}
