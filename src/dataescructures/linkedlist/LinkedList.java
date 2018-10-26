package dataescructures.linkedlist;

public class LinkedList <E extends Comparable<E>>{
    
    // ATTRIBUTES
    private Node<E> first;
    private Node<E> last;
    private int size;
    
    // CONSTRUCTOR
    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    // METHODS
    public E get(int index){
        Node<E> node = null;
        
         if(index >= 0 && index < size){
            if(index == 0){
                node = this.first;
            }else if(index == size - 1){
                node = this.last;
            }else if(index <= size /2){
                node = this.first;
                for(int i=0; i<index; i++){
                    node = node.getNext();
                }
            }else{
                node = this.last;
                for(int i=size-1; i>index; i--){
                    node = node.getBefore();
                }
            }           
        }
        
        return node != null ? node.getValue() : null;
    }
    
    public Node<E> add(E value){
        return addLast(value);
    }
    
    public Node<E> addFirst(E value){
        Node<E> newNode = new Node<E>(value);
        if(size == 0){
            this.first = newNode;
            this.last = newNode;
        }else{
            newNode.setNext(this.first);
            this.first.setBefore(newNode);
            this.first = newNode;
        }
        size++;
        return newNode;
    }
    
    public Node<E> addLast(E value){
        Node<E> newNode = new Node<E>(value);
        if(size == 0){
            this.first = newNode;
            this.last = newNode;
        }else{
            newNode.setBefore(this.last);
            this.last.setNext(newNode);
            this.last = newNode;
        }
        size++;
        return newNode;
    }
    
    public Node<E> addAt(int index, E newValue){
        Node<E> newNode = null;
        
        if(index >= 0 && index < size){
            Node<E> node = this.first;
            newNode = new Node(newValue);
            for(int i=0; i<index; i++){
                node = node.getNext();
            }
            
            newNode.setBefore(node.getBefore());
            newNode.setNext(node);
            node.getBefore().setNext(newNode);
            
            this.size++;
        }
        
        return newNode;
    }
    
    public void addAll(LinkedList<E> list){
        list.first.setBefore(this.last);
        this.last.setNext(list.getFirst());
        this.last = list.getLast();
        this.size += list.size;
    }
    
    public Node<E> removeFirst(){
        Node<E> first = this.first;
        
        this.first = this.first.getNext();
        this.first.setBefore(null);
        this.size--;
        
        return first;
    }
    
    public Node<E> removeLast(){
        Node<E> last = this.last;
        
        this.last = this.last.getBefore();
        this.last.setNext(null);
        this.size--;
        
        return last;
    }
    
    public Node<E> removeAt(int index){
        Node<E> node = null;
        
        if(index >= 0 && index < size){
            node = this.first;
            
            for(int i=0; i<index; i++){
                node = node.getNext();
            }
            
            node.getBefore().setNext(node.getNext());
            node.getNext().setBefore(node.getBefore());
            this.size--;
        }
        
        return node;
    }
    
    public boolean contains(E value){
        boolean founded = false;
        
        Node<E> node = this.first;
        for(int i=0; i<size && !founded; i++){
            if(node.getValue().compareTo(value) == 0){
                founded = true;
            }
            node = node.getNext();
        }
        
        return founded;
    }
    
    public void clear(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    // GETTERS && SETTERS
    public Node<E> getFirst() {
        return first;
    }
    public void setFirst(Node<E> first) {
        this.first = first;
    }
    public Node<E> getLast() {
        return last;
    }
    public void setLast(Node<E> last) {
        this.last = last;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }  
    
    // TOSTRING
    public String toString(){
        String strList = "";
        
        Node<E> node = this.first;
        
        for(int i=0; i<this.size; i++){
            strList += node.getValue();
            node = node.getNext();
        }
        
        return strList;
    }
}
