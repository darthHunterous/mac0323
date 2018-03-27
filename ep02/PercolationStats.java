import edu.princeton.cs.algs4.*;

public class PercolationStats {
    private double[] threshold;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();
        this.threshold = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation currentTrial = new Percolation(n);
            while (!currentTrial.percolates()) {
                int row = StdRandom.uniform(n);
                int col = StdRandom.uniform(n);
                currentTrial.open(row, col);
            }
            threshold[i] = (double) currentTrial.numberOfOpenSites() / (n*n);
        }
    }

    public double mean() {
        return StdStats.mean(threshold);
    }

    public double stddev() {
        return StdStats.stddev(threshold);
    }

    public double confidenceLow() {
        return this.mean() - (1.96*this.stddev()/Math.sqrt(threshold.length));
    }

    public double confidenceHigh() {
        return this.mean() + (1.96*this.stddev()/Math.sqrt(threshold.length));
    }

    public static void main(String[] args) {
        PercolationStats test = new PercolationStats(20, 100);
        StdOut.println(test.mean());
        StdOut.println(test.stddev());
        StdOut.println(test.confidenceLow());
        StdOut.println(test.confidenceHigh());
    }
}
