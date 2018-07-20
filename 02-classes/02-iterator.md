# 02 - Iteradores

* **Redimensionamento de vetores:**
    * Dobrar o tamanho se ele está lotado
    * Reduzir o tamanha à metade, se tem menos de um quarto da capacidade

* **Implementar iteradores em Java:**

    * **Passo 0:** incluir import da interface
        * <code>import java.util.Iterator;</code>

    * **Passo 1:** incluir o compromisso de implementação do iterador.
        ```Java
        public class Bag<Item> implements Iterable <Item>; {
        ...
        }
        ```
        * Especificação:
            ```Java
            public interface Iterable<Item> {
                public Iterator<Item> iterator();
            }
            ```

    * **Passo 2:** implementar <code>iterator()</code>
        ```Java
        public Iterator<Item> iterator() {
            return new BagIterator();
        }
        ```
        * Especificação:
            ```Java
            public interface Iterator<Item> {
                boolean hasNext();
                Item next();
                void remove();
            }
            ```

    * **Passo 3:** implementar a subclasse da interface Iterator
        ```Java
        private class BagIterator implements Iterator<Item> {
            private Node current = first;

            public boolean hasnext() {
                return current != null;
            }

            public Item next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;

                return item;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
        ```
        * Convenção, deixa-se <code>remove()</code> vazio
            * Não é uma boa prática alterar a estrutura enquanto se itera

* **Exemplo 01:**
    * Iterable Bag
        ```Java
        // Passo 0: importar o Java Iterator
        import java.util.Iterator;

        // Passo 1: implements Iterable<Item> na classe
        public class Bag<Item> implements Iterable<Item> {
            private Node first;
            private int n;
            private Node current;

            private class Node {
                private Item item;
                private Node next;
            }

            public Bag() { // construtor
                first = null;
            }

            public void add(Item item) {
                Node oldFirst = first;
                first = new Node();
                first.item = item;
                first.next = oldFirst;
                n++;
            }

            public int size() {
                return n;
            }

            public boolean isEmpty() {
                return n == 0;
            }

            // Passo 2: método Iterator<Item> iterator()
            public Iterator<Item> iterator() {
                return new BagIterator();
            }

            // Passo 3: implementar Iterator
            private class BagIterator implements Iterator<Item> {
                private Node current = first;

                public boolean hasNext() {
                    return current != null;
                }

                public Item next() {
                    Item item = current.item;
                    current = current.next;

                    return item;
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }
        }
        ```
    * Cliente:
        ```Java
        import edu.princeton.cs.algs4.StdOut;
        import java.util.Iterator;

        public class Cliente {
            public static void main(String[] args) {
                Bag<Integer> bag = new Bag<Integer>();

                for (int i = 10; i < 20; i++)
                    bag.add(i);

                StdOut.println(bag.size());
                Iterator<Integer> it = bag.iterator();

                while (it.hasNext()) {
                    Integer valor = it.next();
                    StdOut.println("Item " + valor);
                }

                // Bag de Strings
                Bag<String> bagS = new Bag<String>();
                bagS.add("Como");
                bagS.add("é");
                bagS.add("bom");
                bagS.add("estudar");
                bagS.add("MAC0323!");

                StdOut.println(bagS.size());

                for (String s : bagS)
                    StdOut.print(s + " ");
                StdOut.println();
            }
        }
        ```

* **Exemplo 02:**
    * Range.java
        ```Java
        // https://codereview.stackexchange.com/questions/48109/simple-example-of-an-iterable-and-an-iterator-in-java
        import java.util.NoSuchElementException;
        import java.util.Iterator;
        import edu.princeton.cs.algs4.StdOut;

        public class Range implements Iterable<Integer> {
            private final int start;
            private final int end;

            public Range(int start, int end) {
                this.start = start;
                this.end = end;
            }

            public Iterator<Integer> iterator() {
                return new RangeIterator(start, end);
            }

            // Inner class example
            private static class RangeIterator implements Iterator<Integer> {
                private int current;
                private final int end;

                public RangeIterator(int start, int end) {
                    this.current = start;
                    this.end = end;
                }

                public boolean hasNext() {
                    return current < end;
                }

                public Integer next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int val = current;
                    current++;

                    return val;
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

                private static void help() {
                    String s = "Uso: java Range ini fim\n"
                             + "    ini= inteiro início do intervalo\n"
                             + "    fim= inteiro fim do intervalo";
                    StdOut.println(s);
                }

            public static void main(String[] args) {
                if (args.length != 2) {
                    help();
                    return;
                }
                int ini;
                int fim;

                try {
                    ini = Integer.parseInt(args[0]);
                    fim = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    StdOut.println("NumberFormatException: " + e.getMessage());
                    help();
                    return;
                }
                Range range = new Range(ini, fim);

                // Long way
                StdOut.println("Iterando baixo nível");
                Iterator<Integer> it = range.iterator();
                while (it.hasNext()) {
                    int cur = it.next();
                    System.out.println(cur);
                }

                // Shorter, nice way:
                // Read ":" as "in"
                StdOut.println("Iterando alto nível");
                for (Integer cur : range) {
                    System.out.println(cur);
                }
            }
        }
        ```