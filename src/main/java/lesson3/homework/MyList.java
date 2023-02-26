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
    public String toString() {
        StringBuilder myListOut = new StringBuilder();
        myListOut.append("MyList{");
        while (iterator().hasNext()) {
//            System.out.println(iterator().hasNext());
//            System.out.println(iterator().next());
            E item = iterator().next();
            myListOut.append(item + ", ");
        }
        return "MyList{" +
                "node=" + node +
                ", nodeCounter=" + nodeCounter +
                '}';
    }

    //    @Override
//    public String toString() {
//        StringBuilder myListOut = new StringBuilder();
//        myListOut.append("MyList{");
//        for (E item : this) {
//            myListOut.append(item + ", ");
//        }
//
//        return myListOut.toString();
//    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator(node);
    }

    private class Node<E> {
        private E element;
        private Node<E> next = null;
        private Node<E> prev = null;

        Node() {
        }

        Node(E element) {
            set(element);
        }

        public Node(E element, Node<E> prev) {
            this.element = element;
            this.prev = prev;
        }

        void set(E element) {
            this.element = element;
        }


        void add(E element) {
            if (isNext()) {
                next.add(element);
            } else {
                next = new Node<>(element, this);

//                System.out.println(next.prev);
            }
        }

        E getElement() {
            return element;
        }

        String getPrev() {
            if (!isPrev()) {
                return "None";
            }
            return (String) prev.getElement();
        }

        boolean isNext() {
            return (next != null);
        }

        boolean isPrev() {
            return (prev != null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next.getElement() +
                    ", prev=" + (isPrev()? prev.getElement() : "None") +
                    '}';
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
                System.out.println(current);
                return true;
            }
            System.out.println(current);
            return current.isNext();
        }
        @Override
        public E next() {
            if (isFirst) isFirst = false;
            else current = current.next;
            System.out.println("current=" + current);

            return current.getElement();
        }

    }
}
