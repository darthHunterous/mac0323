import edu.princeton.cs.algs4.*;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> perm = new RandomizedQueue<String>();
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty())
            perm.enqueue(StdIn.readString());
        for (int i = 0; i < k; i++)
            StdOut.println(perm.dequeue());
    }
}
