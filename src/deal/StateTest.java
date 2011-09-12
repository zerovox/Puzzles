package deal;

public class StateTest {

	public static void main(String[] args) {
	State x = new State();
	int RUNS = 100000;
	int[] remove = {7,12,9,5,2,3,4,15,14,13,10,20,0,5,11};
	int[] offers;
	
	for(int i = 0; i < remove.length; i++)
		x.openBox(remove[i]);
	
	System.out.println("Starting simulation, " + (22-x.closed()) + " boxes already opened");
	int closed = x.closed();
	
	if(closed >= 17) {
		offers = new int[251];
		long total = 0;
		for(int k = 0; k < RUNS; k++) {
			State y = x.clone();
			closed = y.closed();
			for(int i = 0; i < closed-17; i++)
				y.openBox();
			total += y.average()/250;
			offers = histo(offers, y.average()/250);
		}
		closed = 17;
		
		System.out.println("At the 17 box offer, offer prediction :" + total/RUNS);
	}
	
	if(closed >= 14) {
		offers = new int[251];
		long total = 0;
		for(int k = 0; k < RUNS; k++) {
			State y = x.clone();
			closed = y.closed();
			for(int i = 0; i < closed-14; i++)
				y.openBox();
			total += y.average()/250;
			offers = histo(offers, y.average()/250);
		}
		closed = 14;
		
		System.out.println("At the 14 box offer, offer prediction :" + total/RUNS);
	}
	
	if(closed >= 11) {
		offers = new int[251];
		long total = 0;
		for(int k = 0; k < RUNS; k++) {
			State y = x.clone();
			closed = y.closed();
			for(int i = 0; i < closed-11; i++)
				y.openBox();
			total += y.average()/250;
			offers = histo(offers, y.average()/250);
		}
		closed = 11;
		
		System.out.println("At the 11 box offer, offer prediction :" + total/RUNS);
	}
	
	if(closed >= 8) {
		offers = new int[251];
		long total = 0;
		for(int k = 0; k < RUNS; k++) {
			State y = x.clone();
			closed = y.closed();
			for(int i = 0; i < closed-8; i++)
				y.openBox();
			total += y.average()/200;
			offers = histo(offers, y.average()/200);
		}
		closed = 8;
		
		System.out.println("At the 8 box offer, offer prediction :" + total/RUNS);
		printHisto(offers);
	}
	
	if(closed >= 5) {
		offers = new int[251];
		long total = 0;
		for(int k = 0; k < RUNS; k++) {
			State y = x.clone();
			closed = y.closed();
			for(int i = 0; i < closed-5; i++)
				y.openBox();
			total += y.average()/125;
			offers = histo(offers, y.average()/125);
		}
		closed = 5;
		
		System.out.println("At the 5 box offer, offer prediction :" + total/RUNS);
		printHisto(offers);
	}
	
	if(closed >= 2) {
		offers = new int[251];
		long total = 0;
		for(int k = 0; k < RUNS; k++) {
			State y = x.clone();
			closed = y.closed();
			for(int i = 0; i < closed-2; i++)
				y.openBox();
			total += y.average()/120;
			offers = histo(offers, y.average()/120);
		}
		closed = 2;
		
		System.out.println("At the 2 box offer, offer prediction :" + total/RUNS);
		printHisto(offers);
	}
		
		
	}
	
	public static int[] histo(int[] offers, int offer) {
		offer = offer/1000;
		offers[offer] += 1;
		return offers;
	}
	
	public static void printHisto(int[] offers){
		int max = 0;
		for(int i = 0; i<offers.length;i++){
			if(max<offers[i]){
				max = offers[i];
			}
		}
		int segment = max/20;
		
		for(int i = 20; i>0;i--){
			for(int j = 0; j<offers.length; j++){
				if(i*segment>offers[j])
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.print("\n");
		}
	}

}