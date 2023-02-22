package lesson3.homework;

import java.util.Iterator;

public class MyList<E> implements Iterable<E> {
    private Node<E> node = null;
    private int nodeCounter = 0;

    public MyList() {
        node = new Node<>();
    }

    public void add(E element) {
        if (nodeCounter == 0) {
            node.set(element);
        } else node.add(element);
        nodeCounter++;
    }

    public int size() {return nodeCounter;}



    @Override
    public Iterator<E> iterator() {
        return new MyListIterator(node);
    }

    private class Node<E> {
        private E element;
        private Node<E> next = null;

        Node() {
        }

        Node(E element) {
            this.element = element;
        }

        void set(E element) {
            this.element = element;
        }

        void add(E element) {
            if (isNext()) {
                next.add(element);
            } else {
                next = new Node<>(element);
            }
        }

        E getElement() {
            return element;
        }

        boolean isNext() {
            return (next == null);
        }
    }


    private class MyListIterator implements Iterator<E> {

        private Node<E> current;

        private boolean isFirst = true;

        public MyListIterator(Node<E> node) {
            this.current = node;
        }

        @Override
        public boolean hasNext() {
            if (nodeCounter == 1 && isFirst) {
                return true;
            }
            return current.isNext();
        }
        @Override
        public E next() {
            if (isFirst) isFirst = false;
            else current = current.next;
            return current.getElement();
        }

    }
}
