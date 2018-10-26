package dataescructures.arraylist;

public class ArrayList<E> {
    
    // ATTRIBUTES
    private int LENGHT = 5;
    private E [] array;
    private int size;
    
    // CONSTRUCTOR
    public ArrayList() {
        this.array = (E[]) new Object[LENGHT];
        this.size = 0;
    }
    
    // METHODS
    public E get(int index){
        E element = null;
        
        if(index >= 0 && index < this.size){
            element = array[index];
        }
        
        return element;
    }
    
    public void add(E value){
        if(isFull()){
           duplicateAndIncrease();
        }
        
        array[size] = value;
        this.size++;
    }

    public boolean addAt(int index, E value){
        boolean added = false;
        
        if(index >= 0 && index < this.size){
            E elementAtIndex = get(index);
            this.array[index] = value;
            add(elementAtIndex);
            added = true;
        }
        
        return added;
    }
    
    public void add(ArrayList<E> array){
        for(int i=0; i<array.getSize(); i++){
            add(array.getArray()[i]);
        }
    }
    
    public E set(int index, E value){
        E setted = null;
        
        if(index >= 0 && index < this.size){
            setted = get(index);
            this.array[index] = value;
        }
        
        return setted;
    }
    
    public E removeFirstOccurrence(E value){        
        E removed = null;
        
        boolean founded = false;
        for(int i=0; i<this.size && !founded; i++){
            if(this.array[i] == value){
                founded = true;
                removed = removeAt(i);
            }
        }
        
        return removed;
    }
    
    public E removeAt(int index){
        E removed = null;
        
        if(index >= 0 && index < this.size){
            removed = this.array[index];
            this.size--;
            this.array[index] = this.array[this.size];
            this.array[this.size] = null;
        }
        
        return removed;
    }
    
    public boolean remove(int from, int to){
        boolean removed = false;
        
        if(from <= to && from >= 0 && to < this.size){
            for(int i=from; i<=to; i++){
                removeAt(i);
            }
        }
        
        return removed;
    }
    
    public boolean isFull(){
        return this.size == this.array.length;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    private void duplicateAndIncrease(){
        LENGHT *= 2;
        E [] newArray = (E[]) new Object[LENGHT];
        
        for(int i=0; i<this.array.length; i++){
            newArray[i] = this.array[i];
        }
        
        this.array = newArray;
    }
    
    public void clear(){
        LENGHT = 5;
        this.array = (E[]) new Object[LENGHT];
        this.size = 0;
    }    
    
    // GETTERS && SETTERS
    public E[] getArray() {
        return array;
    }

    public void setArray(E[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }   
    
    // TOSTRING
    public String toString(){
        String strArray = "";
        
        for(int i=0; i<this.size; i++){
            strArray+=" "+this.array[i];
        }
        
        return strArray.trim();
    }
}
