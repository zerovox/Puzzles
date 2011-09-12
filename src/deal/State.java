package deal;

public class State {
	private boolean[] boxes; //true is closed
	private int closed; 
	
	State(){
		boxes = new boolean[22];
		allTrue();
	}
	
	State(boolean[] boxes, int closed){
		this.boxes = new boolean[22];
		System.arraycopy(boxes, 0, this.boxes, 0, 22);
		this.closed = closed;
	}
	
	private void allTrue(){
		for(int i = 0; i < 22; i++){
			boxes[i] = true;
		}
		closed = 22;
	}
	
	public State clone() {
		return new State(boxes, closed);
	}
	
	public void openBox() {
		int x = (int) (Math.round(Math.random()*(closed-1))) + 1 ;
		int c = 0;
		int i = 0;
		while(c<x){
			if(boxes[i])
				c++;
			i++;
		}
		
		openBox(--i);		
	}
	
	public void openBox(int i){
		if(boxes[i])
			closed--;
		boxes[i] = false;
	}
	
	public void openBoxes(int i){
		assert i<=closed;
		for(int j = 0; i<j; i++)
			openBox();
	}
	
	public int closed(){
		return closed;
	}
	
	public int[] closedBoxes(){
		int[] out = new int[closed];
		int c = 0;
		for(int i = 0; i < 22; i++){
			if(boxes[i]){
				out[c] = i;
				c++;
			}
		}
		
		return out;
	}
	
	public int average(){
		int total = 0;
		for(int i = 0; i < 22; i++){
			if(boxes[i]){
				total += CashValues.toPence(i);
			}
		}
		
		return (int) Math.round(total/(closed));
	}
	
	public boolean isOpen(int i) {
		return boxes[i];
	}

}
