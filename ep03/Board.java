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
        return puzzle[row][col];
    }

    // board size n
    public int size() {
        return n;
    }

    // number of tiles out of place
//    public int hamming() {

//    }

    // sum of Manhattan distances between tiles and goal
//    public int manhattan() {

//    }

    // is this board the goal board?
//    public boolean isGoal() {

//    }

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
        int[][] matrix = new int[3][3];
        StdOut.println(matrix.length);
        Board blah = new Board(matrix);
        StdOut.println(blah.toString());
    }
}
