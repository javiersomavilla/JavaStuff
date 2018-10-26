package dataescructures.btree;

public class Node<E extends Comparable<E>> implements Comparable<E>{
    
    // ATTRIBUTES
    private Node<E> leftNode;
    private Node<E> rightNode;
    private Node<E> parentNode;
    private E value;
    
    // CONSTRUCTOR
    public Node(E value) {
        this.value = value;        
    }
    
    // METHODS
    @Override
    public int compareTo(E obj) {
        return obj.compareTo(value);
    }
    
    public void cleanRefs(){
        this.parentNode = null;
        this.leftNode = null;
        this.rightNode = null;
    }

    // GETTERS && SETTERS
    public Node<E> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<E> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<E> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<E> rightNode) {
        this.rightNode = rightNode;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<E> parentNode) {
        this.parentNode = parentNode;
    }
}
