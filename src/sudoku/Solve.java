package sudoku;

public class Solve {

	public static void main(String[] args) {
		//Deal with input
		String argss = "047701003860050210097020000000900300052000480006003000000090030028030946600800000";
		int[] a = new int[81];
		for(int i = 0; i<81; i++){
			a[i] = argss.charAt(i) - 48;
		}
		Grid x = new Grid(a);
		
		//Display the input neatly
		System.out.println("Input sudoku:\n");
		printSquare(x.toString());
		
		//Start timing
		Stopwatch timer = new Stopwatch();
		timer.start();
		
		//Solve!
		x.solve();
		
		//Finish timing
		timer.stop();
		int time = timer.inMillis()/1000;
		int r = timer.inMillis()%1000; 
		
		//Output solution/stuck grid
		System.out.print("\n\n");
		if(x.solved()){
			System.out.println("Found a solution in " + time +"."+ r + " seconds. Solution:\n");
		} else {
			System.out.println("No distict solution found after " + time +"."+ r + " seconds. Stuck at:\n");
		}		
		printSquare(x.toString());
	}
	
	public static void printSquare(String out){
		for(int i = 0; i < 81; i++){
			if(i%27 == 0 && i != 0)
				System.out.print("\n------------");
			if(i%3 == 0 && i%9 != 0 && i!=0)
				System.out.print("|");
			if(i%9 == 0 && i!=0)
				System.out.print("\n");
			if(out.charAt(i) == 48)
				System.out.print(" ");
			else
				System.out.print(out.charAt(i));
		}
	}

}
