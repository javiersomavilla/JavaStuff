package dataescructures.linkedlist;

public class Node<E extends Comparable<E>> implements Comparable<E> {

    // ATTRIBUTES
    private E value;
    private Node<E> next;
    private Node<E> before;

    // CONSTRUCTOR
    public Node(E value) {
        this.value = value;
        this.next = null;
        this.before = null;
    }
    
    // METHODS
    @Override
    public int compareTo(E obj) {
        return obj.compareTo(value);
    }
    
    // GETTERS && SETTERS
    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getBefore() {
        return before;
    }

    public void setBefore(Node<E> before) {
        this.before = before;
    }
}
