import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdIn;


public class Percolation {
	boolean[][] n_square;
	WeightedQuickUnionUF wquf; 
	
	public Percolation(int n) {
		n_square = new boolean[n][n];
		wquf = new WeightedQuickUnionUF(n);
		
	}  // create n-by-n grid, with all sites blocked
	   
	public void open(int row, int col) {
	
	}       // open site (row, col) if it is not open already 
	   
	public boolean isOpen(int row, int col){
		
		
	}  // is site (row, col) open?
	   
	public boolean isFull(int row, int col) {
		
	} // is site (row, col) full?
	   
	public boolean percolates() {
		
	}             // does the system percolate?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = StdIn.readInt() 
	}

}

