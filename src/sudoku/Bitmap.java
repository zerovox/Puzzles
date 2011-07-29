package sudoku;

//a set of numbers 1..9, has a 0 but this is largely igored and only present so that indicies correlate with the number they represent
public class Bitmap {
	private boolean[] state;
	Bitmap(){
		state = new boolean[10];
		for (int i = 1; i<10; i++)
			state[i] = true;
	}
	
	public void add (int n){
		state[n] = true;
	}
	
	public void remove (int n) {
		state[n] = false;
	}
	
	public void union(Bitmap set){
		for (int i = 1; i<10; i++){
			if(set.isIn(i))
				add(i);
		}
	}
	
	public void intersect(Bitmap set){
		for (int i = 1; i<10; i++){
			if(!set.isIn(i))
				remove(i);
		}
	}
	
	public void remove(Bitmap set){
		for (int i = 1; i<10; i++){
			if(set.isIn(i))
				remove(i);
		}
	}
	
	public boolean equals(Bitmap set){
		for (int i = 1; i<10; i++){
			if((set.isIn(i) && !this.isIn(i)) || (!set.isIn(i) && this.isIn(i)))
				return false;
		}
		return true;
	}
	
	public boolean suitable(Bitmap set){
		for (int i = 1; i<10; i++){
			if((!set.isIn(i) && this.isIn(i)))
				return true;
		}
		return false;
	}
	
	public boolean isIn(int n){
		return state[n];
	}
	
	public String toString(){
		String ret = "";
		for (int i = 1; i<10; i++){
			if(state[i])
				ret = ret + i; 
		}
		return ret;
	}
	
	public void allToFalse(){
		for (int i = 1; i<10; i++)
			state[i] = false;
	}

	public void random() {
		boolean found = false;
		while(!found){
			int y = (int) (1 + Math.round(8*Math.random()));
			if(state[y]){
				allToFalse();
				state[y] = true;
				found = true;
			}
		}
		
	}

}
