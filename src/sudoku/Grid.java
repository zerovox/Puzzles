package sudoku;

public class Grid {
	private Cell[][] rows = new Cell[9][9];
	private Cell[][] cols = new Cell[9][9];
	private Cell[][] boxes = new Cell[9][9];
	private boolean solved;
	
	public Grid(int[] vals){
		for(int i = 0; i < 81; i++){
			Cell x = new Cell(vals[i]);
			int m = i/27;
			int n = (i/3)%3 + 3*m;
			int z = (i%9)%3;
			int y = (i/9)%3;
			rows[i/9][i%9] = x;
			cols[i%9][i/9] = x;
			boxes[n][z+(3*y)] = x;
		}
		solved = false;
	}
	
	public Grid(Cell[][] rows, Cell[][] cols, Cell[][] boxes, boolean solved){
		this.rows = rows;
		this.cols = cols;
		this.boxes = boxes;
		this.solved = solved;
	}
	
	public String toString(){
		String ret = "";
		for(int i = 0; i < 9; i++){
			for(int x = 0; x < 9; x++){
				ret = ret + rows[i][x].num();
			}
		}
		return ret;
	}
	
	public int entries(){
		int ret = 0;
		for(int i = 0; i < 9; i++){
			for(int x = 0; x < 9; x++){
				if(!(rows[i][x].num() == 0))
					ret++;
			}
		}
		return ret;
	}
	
	public void updateCandidates(){
		checkAll();
		for(int i = 0; i<9; i++){
			for(int x = 0; x<9; x++){
				for(int y = 0; y<9; y++){
					rows[i][x].remove(rows[i][y].num());
					rows[i][x].check();
					cols[i][x].remove(cols[i][y].num());
					cols[i][x].check();
					boxes[i][x].remove(boxes[i][y].num());
					boxes[i][x].check();
				}		
			}
		}
	}
	
	public void checkAll(){
		for(int i = 0; i<9; i++){
			for(int x = 0; x<9; x++){
				rows[i][x].check();
			}
		}
	}
	public void isolateSingleCandidates(){
		updateCandidates();
		for(int i = 0; i<9; i++){
			for(int x = 0; x<9; x++){
				Bitmap rowCs = new Bitmap();
				rowCs.allToFalse();
				Bitmap colCs = new Bitmap();
				colCs.allToFalse();
				Bitmap boxCs = new Bitmap();
				boxCs.allToFalse();
				for(int y = 0; y<9; y++){
					if (x != y) {
						rowCs.union(rows[i][y].bitmap());
						colCs.union(cols[i][y].bitmap());
						boxCs.union(boxes[i][y].bitmap());
					}
				}
				if(rows[i][x].bitmap().suitable(rowCs))
					rows[i][x].remove(rowCs);
				updateCandidates();
				if(boxes[i][x].bitmap().suitable(boxCs))
					boxes[i][x].remove(boxCs);
				updateCandidates();
				if(cols[i][x].bitmap().suitable(colCs))
					cols[i][x].remove(colCs);				
				updateCandidates();
			}
		}
	}
	
	public void printState(){
		System.out.print(fixed() + "," + (81-fixed()));
	}
	
	private int fixed(){
		int fix = 0;
		for(int i = 0; i < 9; i++){
			for(int x = 0; x < 9; x++){
				if(rows[i][x].num() > 0)
					fix++;
			}
		}
		
		return fix;
	}
	
	public boolean solve(){
		int fixed = fixed();
		int previous = 0;
		while(fixed>previous){
			previous = fixed;
			isolateSingleCandidates();
			fixed = fixed();
		}
		
		if (fixed() == 81)
			solved = true;
		else
			solved = false;
		return solved;
		
	}
	
	public boolean solved(){
		return solved;
	}
	
	//All below here is used for generating sudokus
	
	public void seed() {
		boolean seeded = false;
		while(!seeded){
			int x = (int) Math.round(8*Math.random());
			int y = (int) Math.round(8*Math.random());
			if(rows[x][y].num() ==  0){
				rows[x][y].bitmap().random();
				rows[x][y].check();
				seeded = true;
			}
		}
	}
	
	public String stringWithoutN(int n){
		String ret = "";
		for(int i = 0; i < 9; i++){
			for(int x = 0; x < 9; x++){
				if ((9*i+x) == n)
					ret = ret + "0";
				else
					ret = ret + rows[i][x].num();
			}
		}
		return ret;
	}
	
	public void newSolution() {
		while(!this.solved()){
			this.seed();
			this.solve();
		}
	}
	
	public Grid clone(){
		int[] array = Generate.stringToIntArray(this.toString());
		return new Grid(array);
	}
	
	public boolean equals(Grid x){
		return (x.toString().equals(this.toString()));
	}
}
