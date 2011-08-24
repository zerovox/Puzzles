package deal;

public class StateTest {

	public static void main(String[] args) {
	State x = new State();
	int RUNS = 100000;
	int[] remove = {21,20,19,18,17};
	
	for(int i = 0; i < remove.length; i++)
		x.openBox(remove[i]);
	
	int closed = x.closed();
	
	if(closed > 17) {
		long total = 0;
		for(int k = 0; k < RUNS; k++) {
			State y = x.clone();
			closed = y.closed();
			for(int i = 0; i < closed-17; i++)
				y.openBox();
			total += y.halfTheAverage()/100;
		}
		closed = 17;
		
		System.out.println("At the 17 box offer, average HTA is :" + total/RUNS);
	}
	
	if(closed > 14) {
		long total = 0;
		for(int k = 0; k < RUNS; k++) {
			State y = x.clone();
			closed = y.closed();
			for(int i = 0; i < closed-14; i++)
				y.openBox();
			total += y.halfTheAverage()/100;
		}
		closed = 14;
		
		System.out.println("At the 14 box offer, average HTA is :" + total/RUNS);
	}
	
	if(closed > 11) {
		long total = 0;
		for(int k = 0; k < RUNS; k++) {
			State y = x.clone();
			closed = y.closed();
			for(int i = 0; i < closed-11; i++)
				y.openBox();
			total += y.halfTheAverage()/100;
		}
		closed = 11;
		
		System.out.println("At the 11 box offer, average HTA is :" + total/RUNS);
	}
	
	if(closed > 8) {
		long total = 0;
		for(int k = 0; k < RUNS; k++) {
			State y = x.clone();
			closed = y.closed();
			for(int i = 0; i < closed-8; i++)
				y.openBox();
			total += y.halfTheAverage()/100;
		}
		closed = 8;
		
		System.out.println("At the 8 box offer, average HTA is :" + total/RUNS);
	}
	
	if(closed > 5) {
		long total = 0;
		for(int k = 0; k < RUNS; k++) {
			State y = x.clone();
			closed = y.closed();
			for(int i = 0; i < closed-5; i++)
				y.openBox();
			total += y.halfTheAverage()/100;
		}
		closed = 5;
		
		System.out.println("At the 5 box offer, average HTA is :" + total/RUNS);
	}
	
	if(closed > 2) {
		long total = 0;
		for(int k = 0; k < RUNS; k++) {
			State y = x.clone();
			closed = y.closed();
			for(int i = 0; i < closed-2; i++)
				y.openBox();
			total += y.halfTheAverage()/100;
		}
		closed = 2;
		
		System.out.println("At the 2 box offer, average HTA is :" + total/RUNS);
	}
		
		
	}

}