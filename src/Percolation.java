import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Percolation {
	boolean[][] n_square;
	static int[] rowsandcolumns_array;
	int n;	
	WeightedQuickUnionUF wquf; 
	
	public Percolation(int n) {
		this.n = n;
		n_square = new boolean[n][n];
		wquf = new WeightedQuickUnionUF(n);
		int i = 0, row = 0, col = 0;
		for (int num: rowsandcolumns_array) {
			if (i % 2 == 0) {
				row = num;
			}
			
			else {
				col = num;
				StdOut.println("row: " + row + " col: " + col + " xyTo1D: " + xyTo1D(row, col));
			}
			if (checkValidIndex(row, col) == false) break;
			i++;
		}
		
	}  // create n-by-n grid, with all sites blocked
	
	private boolean checkValidIndex(int row, int col) throws ArrayIndexOutOfBoundsException{
		if (row > n || col > n) {
			try {
				throw new ArrayIndexOutOfBoundsException();
			} catch (ArrayIndexOutOfBoundsException e) {
				StdOut.println("The row: " + row + " or column: " + col + " exceeded n " + n);
			}
			return false;
		}
		return true;

	}
	
	private int xyTo1D(int row, int col) {
		return (((row - 1) * n) + (col - 1));
		
	}
	
	/**   
	public void open(int row, int col) {
	
	}       // open site (row, col) if it is not open already 
	   
	public boolean isOpen(int row, int col){
		
		
	}  // is site (row, col) open?
	   
	public boolean isFull(int row, int col) {
		
	} // is site (row, col) full?
	   
	public boolean percolates() {
		
	}             // does the system percolate?
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdOut.print("What is the value for n: ");
		int n = StdIn.readInt();
		StdOut.print("What are the value of rows and column: ");
		rowsandcolumns_array = StdIn.readAllInts();
		Percolation p = new Percolation(n);
	}

}

