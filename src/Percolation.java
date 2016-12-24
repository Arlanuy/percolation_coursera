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
	static WeightedQuickUnionUF wquf_row;
	static WeightedQuickUnionUF wquf_col;
	final boolean OPEN = true;
	final boolean CLOSE = false;
	
	public Percolation(int n) {
		this.n = n;
		n_square = new boolean[n][n];
		wquf_row = new WeightedQuickUnionUF(n);
		wquf_col = new WeightedQuickUnionUF(n);
		initNSquare();
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
	
	public void open(int r, int c)
	{
		int row = r - 1;
		int col = c - 1;
		if ((row > n - 1 || col > n - 1)|| (row < 0 || col < 0)) {
			throw new IndexOutOfBoundsException("row index i out of bounds");
		}
		
		else {
			n_square[row][col] = OPEN;
			if ((row >= 1) &&
			(wquf_row.connected(row, row - 1) == true)) {
				wquf_row.union(row, row - 1);
			}
			
			if (row < (n - 1) &&
				(wquf_row.connected(row, row + 1) == true)) {
					wquf_row.union(row, row + 1);
			}
			
			if (((col) >= 1) &&
				(wquf_col.connected(col, col - 1) == true)) {
					wquf_col.union(col, col - 1);
				}
				
			if (col < (n - 1) &&
				(wquf_col.connected(col, col + 1) == true)) {
					wquf_col.union(col, col + 1);
			}
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
	private boolean isAdjacent(int ind1, int ind2) {
		if ((ind1 == (ind2 - 1)) || (ind1 == (ind2 + 1))) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		StdOut.print("What is the value for n: ");
		int N = StdIn.readInt();
		 Percolation perc = new Percolation(N);
		 int i = 1;
		 rows_array = new int[N];
		 columns_array = new int[N];
		 while (!StdIn.isEmpty())
		 {
			 rows_array = Arrays.copyOf(rows_array, i);
			 columns_array = Arrays.copyOf(columns_array, i);
			 int p = StdIn.readInt();
			 int q = StdIn.readInt();
			 StdOut.println("p: " + p + " q: " + q);
			 rows_array[i-1] = p - 1;
			 columns_array[i-1] = q - 1;
			 perc.open(p, q);
			 if ((i != 1) && (!wquf_row.connected(rows_array[i-2], rows_array[i-1])) 
					 && perc.isAdjacent(rows_array[i-2], rows_array[i-1]))
			 {
				 wquf_row.union(rows_array[i-2], rows_array[i-1]);
				 StdOut.println("Baby its hot outside");
				 StdOut.println(rows_array[i-2] + " " + rows_array[i-1]);
			 }
			 
			 if ((i != 1) && (!wquf_col.connected(columns_array[i-2], columns_array[i-1]))
					 && perc.isAdjacent(columns_array[i-2], columns_array[i-1]))
			 {
				 wquf_col.union(columns_array[i-2], columns_array[i-1]);
				 StdOut.println("Baby its cold outside");
				 StdOut.println(columns_array[i-2] + " " + columns_array[i-1]);
			 }
			 i++;
		 }
	}

}

