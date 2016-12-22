import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Percolation {
	boolean[][] n_square;
	static int[] rows_array;
	static int[] columns_array;
	int n;	
	WeightedQuickUnionUF wquf;
	final boolean OPEN = true;
	final boolean CLOSE = false;
	
	public Percolation(int n) {
		this.n = n;
		n_square = new boolean[n][n];
		wquf = new WeightedQuickUnionUF(n);
		initNSquare();
		int i = 0, row = 0, col = 0;
		for (int num: rowsandcolumns_array) {
			if (i % 2 == 0) {
				row = num;
			}
			
			else {
				col = num;
				StdOut.println("row: " + row + " col: " + col + " xyTo1D: " + xyTo1D(row, col));
				open(row, col);
			}
			i++;
		}
		
	}  // create n-by-n grid, with all sites blocked
	
	private void initNSquare() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				n_square[i][j] = CLOSE;
			}
		}
	}
	
	private boolean checkValidIndex(int row, int col) {
		if ((row > n || col > n)|| (row < 1 || col < 1)) {					
			return false;
		}
		return true;

	}
	
	private int xyTo1D(int row, int col) {
		return (((row - 1) * n) + (col - 1));
		
	}
	
	public void open(int row, int col) {
		if ((row > n || col > n)|| (row < 1 || col < 1)) {
			throw new IndexOutOfBoundsException("row index i out of bounds");
		}
		
		else {
			n_square[row - 1][col- 1] = OPEN;
		}
	
	}       // open site (row, col) if it is not open already 
	/**    
	public boolean isOpen(int row, int col){
		
	}  // is site (row, col) open?
 
	public boolean isFull(int row, int col) {
		
	} // is site (row, col) full?
	   
	public boolean percolates() {
		
	}             // does the system percolate?
	*/
	public static void main(String[] args) {
		StdOut.print("What is the value for n: ");
		int N = StdIn.readInt();
		 UF uf = new UF(N);
		 int i = 1;
		 while (!StdIn.isEmpty())
		 {
			 rows_array = Arrays.copyOf(rows_array, i);
			 columns_array = Arrays.copyOf(rows_array, i);
			 int p = StdIn.readInt();
			 int q = StdIn.readInt();
			 rows_array[i-1] = p;
			 columns_array[i-1] = q;
			 if (!uf.connected(p, q))
			 {
				 uf.union(p, q);
				 StdOut.println(p + " " + q);
			 }
		 }
		Percolation p = new Percolation(n);
	}

}

