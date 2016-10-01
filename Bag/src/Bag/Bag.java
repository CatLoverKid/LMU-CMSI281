import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Bag implements Collectible {
    private Node first;
    private int n; // number of nodes
    private int total; // total number of words in this bag

    public Bag(){
        first = null;
        n = 0;
        total = 0;
    }

    public int uniqueSize() {
      return n;
    }
    
    public int size(){
        return total;
    }
    
    public void add(String name){
        total += 1;
        boolean checkUnique = true;
        for (Obliterator i = iterator(); i.hasNext(); ) {
            Node current = i.next();
            if(name.equals(current.item)){
                current.count++;
                checkUnique = false;
            }
        }
        if(checkUnique){
            Node node = new Node(first, name, 1);
            first = node;
            n += 1;
        }
    } 

    public Obliterator iterator() {
        return new BagIterator(first);  
    }

    public boolean isEmpty() {
        return total == 0;
    }

    class BagIterator implements Obliterator {
        private Node current;
        public Node first;

        public BagIterator(Node firstNode) {
            current = firstNode;
            first = firstNode;
        }

        public boolean hasNext() { 
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Node next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = current;
            current = current.next; 
            return node;
        }
    }

    public static void main(String[] args) throws IOException {
        Bag bag = new Bag();
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            while (s.hasNext()) {
                String item = s.next();
                bag.add(item);
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        System.out.format("Total number of words: %d\n", bag.size());
        System.out.format("Unique number of words: %d\n", bag.uniqueSize());

        for (Obliterator i = bag.iterator(); i.hasNext(); ) {
            Node node = i.next();
            System.out.format("%s %d\n", node.item, node.count);
        }
    }
}
