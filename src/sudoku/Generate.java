package sudoku;

public class Generate {
	static final boolean print = false;
	static final int RUNS = 150;
	static final int ATTEMPTS = 1;

	public static void main(String[] args) {
		for(int i = 0; i < RUNS; i++){
			Stopwatch timer = new Stopwatch();
			timer.start();
			Grid y = generateStartGrids();
			timer.stop();
			Solve.printSquare(y.toString());
			System.out.print("\n\nCreated in " + timer.inMillis()/1000 +" seconds.\n\n");
		}
	}
	
	public static Grid generateStartGrids() {
		String argss = "000000000000000000000000000000000000000000000000000000000000000000000000000000000"; //bit hacky, but I like strings
		Grid x = new Grid(stringToIntArray(argss));
		x.newSolution();					//get a new complete grid.		
		
		//Find good starter, does ATTEMPTS runs to find the one with fewest entries, although fewest entries != harder sudoku
		Grid minimal = null;
		int count = 81;
		for(int i = 0; i < ATTEMPTS; i++){
			Grid y = singleStartGrid(x);	//sets y to a starter grid for x
			if (y.entries() < count) {
				minimal = y.clone();
				count = y.entries();
			}
		}
		return minimal;
	}
	static Grid singleStartGrid(Grid x) {					//based on completable grid x, produces a starter grid
		Grid z = removeRandomEntry(x);
		Grid y = x.clone();
		while(!(z.equals(y))){
			y = z;
			z = removeRandomEntry(y);
		}
		return y;
	}

	public static int[] stringToIntArray(String argss) {
		int[] a = new int[81];
		for(int i = 0; i<81; i++){
			a[i] = argss.charAt(i) - 48;
		}
		return a;
	}
	
	private static Grid removeRandomEntry(Grid x) {
		int y = (int) (Math.round(80*Math.random()));
		for(int i = 0; i < 81; i++){
			Grid hot = new Grid(stringToIntArray(x.stringWithoutN((i+y)%81)));
			Grid not = hot.clone();
			if(!(hot.equals(x)) && hot.solve())
				return not;
		}
		return x;
	}
}
