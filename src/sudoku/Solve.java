package sudoku;

public class Solve {

	public static void main(String[] args) {
		String argss;
		if(args.length > 0 && args[0].length() == 81) {
			argss = args[0];
		} else {
			//Purely so I don't have to enter the sudoku as a string everytime I test this. Should replace with an error message.
			//TODO: Add error message on no input.
			argss = "047701003860050210097020000000900300052000480006003000000090030028030946600800000";
		}
		
		int[] a = new int[81];
		for(int i = 0; i<81; i++){
			a[i] = argss.charAt(i) - 48;
		}
		
		solve(a);
		
	}
	
	public static void solve(int[] numbers) {
		Grid x = new Grid(numbers);
		
		System.out.println("Input sudoku:\n");
		System.out.print(x.toGridString());
		
		Stopwatch timer = new Stopwatch();
		timer.start();
		
		x.solve();
		
		timer.stop();
		int time = timer.inMillis()/1000;
		int r = timer.inMillis()%1000; 
		
		System.out.print("\n\n");
		if(x.solved()){
			System.out.println("Found a solution in " + time +"."+ r + " seconds. Solution:\n");
		} else {
			System.out.println("No distict solution found after " + time +"."+ r + " seconds. Stuck at:\n");
		}		
		System.out.print(x.toGridString());
	}
	
	

}
