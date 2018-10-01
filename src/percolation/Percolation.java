package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private WeightedQuickUnionUF weightedQuickUnionUF;
	private final int side;
	private int openCount;
	private Boolean [] open;

	
	   public Percolation(int n) {     
		   // create n-by-n grid, with all sites blocked
		   if(n <= 0)
	        {
	            throw new IllegalArgumentException();
	        }
		  side = n;
		  weightedQuickUnionUF = new WeightedQuickUnionUF(n*n+2);
		  openCount = 0;
		  open = new Boolean[n*n+2];
		  open[0] = true;
		  open[n*n+1] = true;
		  for (int i = 1; i < n*n+1; i++) {
			  open[i] = false;
		  }
	}
		   
		   
		   
	   
	   public void open(int row, int col) {
		   int location = (row-1)*side + col;
		   if((row >=1 && row <= side) && (col >=1 && col <= side)) {
			   
		   }else
	        {
	            throw new IndexOutOfBoundsException();
	        }
			
		   
		   if(!open[location]) {
		   // open site (row, col) if it is not open already
		   open[location]  = true;
		   }
		   
		   
		   if( ( row>1 ) && isOpen(row-1,col) ) {
			  
				   weightedQuickUnionUF.union(location, location-side);   
		
		   }
		   if( ( row < side ) && isOpen(row+1,col) ) {
			   weightedQuickUnionUF.union(location,location+side);
		   }
		   
		   if( ( col>1 ) && isOpen(row,col-1) ){
			   
				weightedQuickUnionUF.union(location, location-1);
			   
		   }
		   if( ( col<side ) && isOpen(row,col+1) ) {
			   
			   weightedQuickUnionUF.union(location, location+1);
		   }
		   
		   if(row==1) {
			   weightedQuickUnionUF.union(location, 0);
		   }
		   if(row==side) {
			   weightedQuickUnionUF.union(location, side*side+1);
		   }
		   openCount++;
	   }
	   
	   
	   public boolean isOpen(int row, int col) {

		   // is site (row, col) open?
		   if((row >=1 && row <= side) && (col >=1 && col <= side)) {
			   int location = (row-1)*side + col;
				return open[location] == true;
			  
		   }else
	        {
	            throw new IndexOutOfBoundsException();
	        }
		  
		
	   }
	   
	   public boolean isFull(int row, int col) {
		   if((row >=1 && row <= side) && (col >=1 && col <= side)) {
			   int location = (row-1)*side + col;
			   return weightedQuickUnionUF.connected(location,0);
		   }else
	        {
	            throw new IndexOutOfBoundsException();
	        }

			
		   // is site (row, col) full?
	   }
	   public int numberOfOpenSites() {

		   return openCount;
		   // number of open sites
	   }
	   
	   public boolean percolates() {
		   return weightedQuickUnionUF.connected(0,side*side+1);
		   // does the system percolate?
	   }

//	   public static void main(String[] args) {
//		   // test client (optional)
//	   }
	}