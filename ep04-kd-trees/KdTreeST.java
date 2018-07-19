import edu.princeton.cs.algs4.*;

public class KdTreeST<Value> {
    RedBlackBST<Point2D, Value> symbolTable;
    private Node kdTree;

    private class Node<Item> {
        private Item item;
        private Value value;
    }

    // construct an empty symbol table of points
    public KdTreeST() {
        symbolTable = new RedBlackBST<Point2D, Value>();
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return symbolTable.isEmpty();
    }

    // number of points
    public int size() {
        return symbolTable.size();
    }

    // associate the value val with point p
    public void put(Point2D p, Value val) {
        if (p == null || val == null)
            throw new IllegalArgumentException();
        symbolTable.put(p, val);
    }

    // value associated with point p
    public Value get(Point2D p) {
        if (p == null)
            throw new IllegalArgumentException();
        return symbolTable.get(p);
    }

    // does the symbol table contain point p?
    public boolean contains(Point2D p) {
        if (p == null)
            throw new IllegalArgumentException();
        return symbolTable.contains(p);
    }

    // all points in the symbol table
    public Iterable<Point2D> points() {
        return symbolTable.keys();
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null)
            throw new IllegalArgumentException();
        Queue<Point2D> insideRect = new Queue<Point2D>();
        for (Point2D d : symbolTable.keys())
            if (rect.contains(d))
                insideRect.enqueue(d);
        return insideRect;
    }

    // a nearest neighbor of point p; null if the symbol table is empty
    public Point2D nearest(Point2D p) {
        if (p == null)
            throw new IllegalArgumentException();
        if (symbolTable == null)
            return null;
        double distance = -1.0;
        Point2D closest = null;
        for (Point2D d: symbolTable.keys())
            if (!d.equals(p))
                if (d.distanceTo(p) < distance || distance == -1.0) {
                    distance = d.distanceTo(p);
                    closest = d;
                }
        return closest;
    }

    public Iterable<Point2D> nearest(Point2D p, int k) {
        return null;
    }

    // unit testing
    public static void main(String[] args) {
        // testando construtor
        KdTreeST<Integer> test = new KdTreeST<Integer>();

        // testando isEmpty()
        StdOut.println("Lista precisa estar vazia(true) => " + test.isEmpty());

        // testando size()
        StdOut.println("Número de itens na tabela deve ser zero => " + test.size());

        // testando put()
        Point2D one = new Point2D(0.5, 0.5);
        Point2D two = new Point2D(1.0, 1.0);
        test.put(one, 1);
        test.put(two, 2);
        StdOut.println("Agora deve ter dois => " + test.size());

        // testando get()
        StdOut.println("Valor de one deve ser um => " + test.get(one));
        StdOut.println("Valor de two deve ser dois => " + test.get(two));

        // testando contains()
        Point2D three = new Point2D(0.0, 0.0);
        StdOut.println("A table não contém three => " + test.contains(three));
        StdOut.println("A table contém two => " + test.contains(two));

        // testando points()
        StdOut.println();
        for (Point2D d: test.points())
            StdOut.println(d.toString());

        // testando range(RectHV)
        RectHV rectangle = new RectHV(0.0, 0.0, 0.75, 0.75);
        StdOut.println();
        for (Point2D d: test.range(rectangle))
            StdOut.println(d.toString());

        // testando nearest(Point2D)
        StdOut.println();
        StdOut.println(test.nearest(three).toString());

        RectHV empty = null;
        test.range(empty);
    }
}
