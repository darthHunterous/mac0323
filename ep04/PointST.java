public class PointST<Value> {
    RedBlackBST<Point2D, Value> symbolTable;

    // construct an empty symbol table of points
    public PointST() {
        symbolTable = new RedBlackBST();
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
        symbolTable.put(p, val);
    }

    // value associated with point p
    public Value get(Point2D p) {
        return symbolTable.get(p);
    }

    // does the symbol table contain point p?
    public boolean contains(Point2D p) {
        return symbolTable.contains(p);
    }

    // all points in the symbol table
    public Iterable<Point2D> points() {
        
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {

    }

    // a nearest neighbor of point p; null if the symbol table is empty
    public Point2D nearest(Point2D p) {

    }

    // unit testing
    public static void main(String[] args) {

    }
}
