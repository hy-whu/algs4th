package percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class PercolationStats {
	private double[] trials_result;
	
	   public PercolationStats(int n, int trials) {
		   
		   trials_result = new double[trials];
		   for(int i = 0;i<trials;i++) {
			   Percolation percolations = new Percolation(n);
			   while(true) {
				   int row = StdRandom.uniform(n) +1;
				   int col = StdRandom.uniform(n) +1;
				   if(!percolations.isOpen(row, col)) {
					   percolations.open(row, col);
					//   System.out.println("row= "+row+"  col= "+col +"  open");
				   }
				   if(percolations.percolates()) {
					   trials_result[i] =(double) percolations.numberOfOpenSites()/(n*n);
					   break;
				   }
				   
			   }
			   
			   
			   
		   }
		   
	   }
	   // perform trials independent experiments on an n-by-n grid
	   public double mean() {
		   
		return StdStats.mean(trials_result);                          // sample mean of percolation threshold
		   
	   }
	   public double stddev() {
		return StdStats.stddev(trials_result);                        // sample standard deviation of percolation threshold
		   
	   }
	   public double confidenceLo() {
		return mean() - 1.96*stddev()/(Math.sqrt(trials_result.length)) ;                  // low  endpoint of 95% confidence interval
		   
	   }
	   public double confidenceHi() {
		return mean() + 1.96*stddev()/(Math.sqrt(trials_result.length));                 // high endpoint of 95% confidence interval
		   
	   }

	   public static void main(String[] args) { // test client (described below)
		   int n = 0;
		   int trials = 0;
		   while(!StdIn.isEmpty()){
			      n = StdIn.readInt();
			      trials = StdIn.readInt();
			     
			      PercolationStats percolationStats = new PercolationStats(n,trials);
				   StdOut.println("mean                  ="+percolationStats.mean() );
				   StdOut.println("stddev                  ="+percolationStats.stddev() );
				   StdOut.println("95% confidence interval      =["+percolationStats.confidenceLo() +","+percolationStats.confidenceHi()+"]");
				   
			  }
		   
		   
	   }
	}
