import edu.princeton.cs.algs4.*;

import java.util.*;

public class Board {
    int[][] puzzle;
    private int n;

    /* create a board from a n-by-n array of tiles, where tiles[row][col] = tile
    at (row, col) */
    public Board(int[][] tiles) {
        n = tiles.length;
        puzzle = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                puzzle[i][j] = tiles[i][j];
    }

    // string representation of this board
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(n);
        s.append('\n');
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(this.puzzle[i][j]);
                s.append(' ');
            }
            s.append('\n');
        }
        return s.toString();
    }

    // tile at (row, col) or zero if blank
    public int tileAt(int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= n)
            throw new IllegalArgumentException();
        return puzzle[row][col];
    }

    // board size n
    public int size() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        int hammingDistance = 0;
        int currentTileNumber = 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (this.puzzle[i][j] != currentTileNumber)
                    hammingDistance++;
                currentTileNumber++;
            }
        return hammingDistance - 1;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int currentTileNumber = 1;
        int manhattanDistance = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (puzzle[i][j] != currentTileNumber && puzzle[i][j] != 0) {
                    manhattanDistance += Math.abs(((puzzle[i][j] - 1) / 3) - i);
                    manhattanDistance += Math.abs(((puzzle[i][j] - 1) % n) - j);
                }
                currentTileNumber++;
            }
        return manhattanDistance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        int currentTileNumber = 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (puzzle[i][j] != currentTileNumber)
                    return false;
                currentTileNumber++;
                if (currentTileNumber == n * n)
                    currentTileNumber = 0;
            }
        return true;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this)
            return true;
        if (this == null || y == null)
            return false;
        if (this.getClass() != y.getClass())
            return false;

        Board other = (Board) y;
        if (this.size() != other.size())
            return false;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (this.puzzle[i][j] != other.puzzle[i][j])
                    return false;
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        int iBlank = -1, jBlank = -1;
        boolean stop = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (this.puzzle[i][j] == 0) {
                    iBlank = i;
                    jBlank = j;
                    stop = true;
                    break;
                }
            if (stop)
                break;
        }

        LinkedList<Board> neighbors = new LinkedList<Board>();
        Board aux = new Board(puzzle);
        if (iBlank != 0) {
            //StdOut.println(up.toString());
            aux.swap(iBlank, jBlank, iBlank-1, jBlank);
            //StdOut.println(up.toString());
            neighbors.add(aux);
            aux.swap(iBlank, jBlank, iBlank-1, jBlank);
        }
        if (iBlank != n-1) {
            aux.swap(iBlank, jBlank, iBlank+1, jBlank);
            neighbors.add(aux);
            aux.swap(iBlank, jBlank, iBlank+1, jBlank);
        }
        if (jBlank != 0) {
            //StdOut.println(left.toString());
            aux.swap(iBlank, jBlank, iBlank, jBlank-1);
            //StdOut.println(left.toString());
            neighbors.add(aux);
            aux.swap(iBlank, jBlank, iBlank, jBlank-1);
        }
        if (jBlank != n-1) {
            aux.swap(iBlank, jBlank, iBlank, jBlank+1);
            neighbors.add(aux);
            aux.swap(iBlank, jBlank, iBlank, jBlank+1);
        }
        return neighbors;
    }

    // is this board solvable?
//    public boolean isSolvable() {

//    }

    private void swap(int i1, int j1, int i2, int j2) {
        int aux;
        aux = this.puzzle[i1][j1];
        this.puzzle[i1][j1] = this.puzzle[i2][j2];
        this.puzzle[i2][j2] = aux;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = StdIn.readInt();

        Board puzzle = new Board(matrix);
        StdOut.println(puzzle.toString());
        StdOut.println(puzzle.tileAt(0, 0));
        StdOut.println(puzzle.size());
        StdOut.println(puzzle.hamming());
        StdOut.println(puzzle.manhattan());

        int[][] matrix2 = new int[n][n];
        int aux = 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                matrix2[i][j] = aux;
                aux++;
            }
        matrix2[n-1][n-1] = 0;

        Board puzzle2 = new Board(matrix2);
        StdOut.println(puzzle2.isGoal());
        StdOut.println(puzzle2.equals(puzzle2));

        puzzle2.neighbors();
        //for (Board x : puzzle2.neighbors())
        //    StdOut.println(x.toString());
    }
}
