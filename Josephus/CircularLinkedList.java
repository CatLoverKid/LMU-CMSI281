public class CircularLinkedList extends AbstractLinkedList implements CircularCollectible {

    public CircularLinkedList() {
        super();
    }

    public CircularLinkedList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(String s) {
	Node newNode = new Node(first,s);
	first = newNode;
        n ++;
    }

    public String first() {
        return first.value;
    }

    /** remove(String s):
     *  removes the first element in the list for which
     *      element.equals(s)
     *  is true.
     */
    public void remove(String s) {
        throw new UnsupportedOperationException();
    }

    /** removeAll(String s):
     *  removes all elements in the list for which
     *      element.equals(s)
     *  is true.
     */
    public void removeAll(String s) {
        throw new UnsupportedOperationException();
    }

    public CircularIterator iterator() {
        return new CircularLinkedListIterator();
    }

    class CircularLinkedListIterator implements CircularIterator {
        
        public CircularLinkedListIterator() {
            super();
        }

        public boolean hasNext() {
            return next != null;
        }

        public Node next() {
            next = next.next;
	    return next;
        }

        /** remove():
         *  removes the last/previous element in the list
         *  (i.e. removes the element that was returned by the
         *  most recent call to next())
         */
        public void remove() {
            
        }

        /** removeKth(int k):
         *  iterates through the next k elements and removes
         *  the kth one. The next call to removeKth would
         *  start at the node after the removed node.
         *  (i.e. kthNode.next)
         */
        public void removeKthElement(int k) {
            throw new UnsupportedOperationException();
        }

        public boolean oneElementLeft() {
            return n == 1;
        }
    }
}

