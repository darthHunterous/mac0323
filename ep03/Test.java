import edu.princeton.cs.algs4.*;

public class Test {
    public static void main (String[] args) {
        int[][] matrix = { {2, 3}, {1, 0} };
        int[][] matrix2 = { {0, 2}, {1, 3} };
        int[][] matrix3 = { {8, 1, 3}, {4, 0, 2}, {7, 6, 5} };

        Board puzzle = new Board(matrix);
        Board puzzle2 = new Board(matrix2);
        Board puzzle3 = new Board(matrix3);

        StdOut.println(puzzle3.manhattan());
        StdOut.println(puzzle.manhattan());
        StdOut.println(puzzle.toString());
        StdOut.println(puzzle2.manhattan());
        StdOut.println(puzzle2.toString());
    }
}
