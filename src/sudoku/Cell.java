package sudoku;

public class Cell {
	private int num;
	private Bitmap candidates = new Bitmap();
	
	public Cell(int n){
		num = n;
		candidates.add(n);
		if(n>0){
			candidates.allToFalse();
		}
	}
	
	public void remove(int n) {
		candidates.remove(n);
		check();
	}
	
	public int num() {
		return num;
	}
	
	public Bitmap bitmap(){
		return candidates;
	}
	
	public void remove(Bitmap set){
		candidates.remove(set);
	}
	
	/*
	 * Returns true if number is fixed
	 */
	public boolean check() {
		if (num > 0) {
			return true;
		} else {
			int count = 0;
			int last = 0;
			for (int i = 1; i<10; i++){
				if (candidates.isIn(i)) {
					count++;
					last = i;
				}
			}
			if (count == 1){
				num = last;
				candidates.allToFalse();
			}
			if (count == 0){
				System.out.println(num);
				System.out.println(candidates);
				throw new IllegalStateException();
			}
			return (count == 1);
		}
	}
}
