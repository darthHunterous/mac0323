import edu.princeton.cs.algs4.*;

public class Board {
    int[][] puzzle;
    int n;

    /* create a board from a n-by-n array of tiles, where tiles[row][col] = tile
    at (row, col) */
    public Board(int[][] tiles) {
        puzzle = tiles;
        n = tiles.length;
    }

    // string representation of this board
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(n);
        s.append('\n');

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(puzzle[i][j]);
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
        return this.puzzle.hamming() == 0;
    }

    // does this board equal y?
//    public boolean equals(Object y) {

//    }

    // all neighboring boards
//    public Iterable<Board> neighbors() {

//    }

    // is this board solvable?
//    public boolean isSolvable() {

//    }

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
        Board puzzle2 = new Board(matrix2);
        StdOut.println(puzzle2.isGoal());
    }
}
