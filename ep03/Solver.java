import edu.princeton.cs.algs4.*;

import java.util.*;

public class Solver {
    private BoardPlus solution;
    private MinPQ<BoardPlus> solver;
    private int finalMoves;

    private final Comparator<BoardPlus> priority = new Priority();

    private class BoardPlus {
        Board board;
        int moves;
        BoardPlus previous;
        BoardPlus next;

        public BoardPlus(int auxMoves) {
            board = null;
            moves = auxMoves;
            previous = null;
            next = null;
        }

        public int numberOfMoves() {
            return this.moves;
        }
    }

    private class Priority implements Comparator<BoardPlus> {
        public int compare(BoardPlus one, BoardPlus two) {
            //return (one.moves + one.board.manhattan()) - (two.moves + two.board.manhattan());
            return one.board.manhattan() - two.board.manhattan();
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null || !initial.isSolvable())
            throw new IllegalArgumentException();
        if (initial.size() > 2)
            return;
        BoardPlus aux;
        solution = new BoardPlus(0);
        solution.board = initial;
        solution.previous = null;
        solution.next = null;

        solver = new MinPQ<BoardPlus>(priority);
        for (Board x : solution.board.neighbors()) {
            aux = new BoardPlus(1);
            aux.board = x;
            aux.previous = null;
            aux.next = null;
            solver.insert(aux);
        }
        BoardPlus searchNode = solution;
        BoardPlus solutionEnd = solution;

        for (int i = 1; !searchNode.board.isGoal(); i++) {
            aux = new BoardPlus(i);
            aux = solver.delMin();
            solutionEnd.next = aux;
            aux.previous = solutionEnd;
            searchNode = aux;
            solutionEnd = aux;

            for (Board x : searchNode.board.neighbors()) {
                if (!x.equals(searchNode.previous.board)) {
                    aux = new BoardPlus(i+1);
                    aux.board = x;
                    solver.insert(aux);
                }
            }
        }
        this.finalMoves = solutionEnd.numberOfMoves();

        //for (BoardPlus x : solver) {
        //    StdOut.println(x.board.manhattan() + x.moves);
        //    StdOut.println(x.board.toString());
        //}
        //for (BoardPlus current = solution; current != null; current = current.next)
        //    StdOut.println(current.board.toString());

        //StdOut.println(finalMoves);
    }

    // min number of moves to solve initial board
    public int moves() {
        return this.finalMoves;
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution() {
        LinkedList<Board> list = new LinkedList<Board>();
        for (BoardPlus current = solution; current != null; current = current.next)
            list.add(current.board);
        return list;
    }

    // unit testing
    public static void main(String[] args) {
        Board puzzle = null;
        Solver blah = new Solver(puzzle);

        /*int n = StdIn.readInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = StdIn.readInt();

        Board puzzle = new Board(matrix);
        Solver haha = new Solver(puzzle)*/;
    }
}
