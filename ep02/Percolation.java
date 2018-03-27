import edu.princeton.cs.algs4.*;

public class Percolation {
    private int[][] grid;
    private int openSites, size;
    private WeightedQuickUnionUF wquuf;

    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        grid = new int[n][n];
        openSites = 0;
        size = n;
        wquuf = new WeightedQuickUnionUF(n*n + 2);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = -1;
    }

    public void open(int row, int col) {
        if(row >= size || col >= size || row < 0 || col < 0)
            throw new IllegalArgumentException();
        if (grid[row][col] == -1) {
            openSites++;
            grid[row][col] = 0;
            if (row == 0)
                wquuf.union(row*size+col, size*size);
            if (row == size-1)
                wquuf.union(row*size+col, size*size+1);
            if (row != 0 && isOpen(row-1, col)) // tem vizinho acima
                wquuf.union(row*size+col, (row-1)*size+col);
            if (row != size-1 && isOpen(row+1, col)) // tem vizinho abaixo
                wquuf.union(row*size+col, (row+1)*size+col);
            if (col != 0 && isOpen(row, col-1)) // tem vizinho a esquerda
                wquuf.union(row*size+col, row*size+(col-1));
            if (col != size-1 && isOpen(row, col+1)) // tem vizinho a direita
                wquuf.union(row*size+col, row*size+(col+1));
        }
    }

    public boolean isOpen(int row, int col) {
        if(row >= size || col >= size || row < 0 || col < 0)
            throw new IllegalArgumentException();
        return (grid[row][col] == 0) || (grid[row][col] == 1);
    }

    public boolean isFull(int row, int col) {
        if(row >= size || col >= size || row < 0 || col < 0)
            throw new IllegalArgumentException();
        return (wquuf.connected(wquuf.find(row*size+col), size*size));
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        if (wquuf.connected(size*size, size*size+1))
            return true;
        return false;
    }
}
