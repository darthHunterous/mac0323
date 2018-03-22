public class Percolation {
    private int[][] grid;
    private int openSites, size;
    private QuickFindUF uf;

    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        grid = new int[n][n];
        openSites = 0;
        size = n;
        uf = new QuickFindUF(n*n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = -1;
    }

    public void open(int row, int col) {
        if(row >= size || col >= size)
            throw new IllegalArgumentException();
        if (grid[row][col] == -1) {
            if (row != 0)
                grid[row][col] = 0;
            else
                grid[row][col] = 1;
            openSites++;
            if (row != 0 && isOpen(row-1, col)) // tem vizinho acima
                uf.union(row*size+col, (row-1)*size+col);
            if (row != size-1 && isOpen(row+1, col)) // tem vizinho abaixo
                uf.union(row*size+col, (row+1)*size+col);
            if (col != 0 && isOpen(row, col-1)) // tem vizinho a esquerda
                uf.union(row*size+col, row*size+(col-1));
            if (col != size-1 && isOpen(row, col+1)) // tem vizinho a direita
                uf.union(row*size+col, row*size+(col+1));
        }
    }

    public boolean isOpen(int row, int col) {
        return (grid[row][col] == 0) || (grid[row][col] == 1);
    }

    public boolean isFull(int row, int col) {
        return (grid[row][col] == 1);
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        if (uf.connected(0, size*size-1))
            return true;
        return false;
    }

    public static void main(String[] args) {

    }
}
