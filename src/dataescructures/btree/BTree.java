package dataescructures.btree;

public class BTree<E extends Comparable<E>> {
    
    // ATTRIBUTES
    private Node<E> root;
    private int size;
    
    // CONSTRUCTOR
    public BTree() {
        this.root = null;
        this.size = 0;
    }

    // METHODS
    public boolean add(E newValue){
        boolean added = false;
        if(this.size == 0){
            this.root = new Node<E>(newValue);
            this.size++;
            added = true;
        }else{
            added = add(this.root, newValue) != null ? true : false; 
        }
       return added;
    }
    
    private Node<E> add(Node<E> currentNode, E newValue){
        Node<E> added = null;
        
        if (currentNode == null) {
            added = new Node<E>(newValue);
            this.size++;
            return added;
        }else{
            if (newValue.compareTo(currentNode.getValue()) < 0) {
                currentNode.setLeftNode(add(currentNode.getLeftNode(), newValue));
                currentNode.getLeftNode().setParentNode(currentNode);
            } else if (newValue.compareTo(currentNode.getValue()) > 0) {
                currentNode.setRightNode(add(currentNode.getRightNode(), newValue));
                currentNode.getRightNode().setParentNode(currentNode);
            }
        }
        
        return currentNode;
    }
    
    public Node<E> remove(E value){
        return remove(this.root, value);
    }
    
    private Node<E> remove(Node<E> currentNode, E value){
        Node<E> removed = null;
        
        if(currentNode != null){
            if(currentNode.getValue().compareTo(value) == 0){
                switch (childrenNumber(currentNode)) {
                    case 0: // leaf node
                        removed = currentNode;
                        if(currentNode.getParentNode().getRightNode() != null && currentNode.getParentNode().getRightNode().getValue().compareTo(value) == 0){  // is the right leaf
                            currentNode.getParentNode().setRightNode(null);
                        }
                        if(currentNode.getParentNode().getLeftNode() != null && currentNode.getParentNode().getLeftNode().getValue().compareTo(value) == 0){    // is the left leaf
                            currentNode.getParentNode().setLeftNode(null);
                        }
                        break;
                    case 1: // currentNode has only one child
                        if(currentNode.getLeftNode() == null){
                            removed = currentNode;
                            currentNode.getRightNode().setParentNode(currentNode.getParentNode());
                            currentNode.getParentNode().setRightNode(currentNode.getRightNode());
                        }else{
                            removed = currentNode;
                            currentNode.getLeftNode().setParentNode(currentNode.getParentNode());
                            currentNode.getParentNode().setLeftNode(currentNode.getLeftNode());
                        }
                        break;
                    case 2: // currentNode has two children                       
                        Node<E> smallestNode = smallestLeafNode(currentNode);   // cojo el elemento hoja mas pequeño a partir de mi nodo actual
                        removed = remove(currentNode, smallestNode.getValue()); // lo almaceno y lo borro del arbol                                               
                        currentNode.setValue(smallestNode.getValue());          // en lugar de borrar el nodo actual, sustituimos su valor por el del nodo borrado
                        removed.setValue(value);                                // al que he borrado realmente (al mas pequeño), le asigno el valor del que acabamos de sustituir
                        break;
                }
            }else{
                if(currentNode.getValue().compareTo(value) > 0){
                    removed = remove(currentNode.getLeftNode(), value);
                }else{
                    removed = remove(currentNode.getRightNode(), value);
                }
            }
        }
        
        if(removed != null){
            removed.cleanRefs();
            this.size--;
        }
        
        return removed;
    }
    
    private int childrenNumber(Node<E> node){
        int num = 0;
        
        if(node.getLeftNode() != null && node.getRightNode() != null){
            num = 2;
        }else if((node.getLeftNode() != null && node.getRightNode() == null) || (node.getRightNode() != null && node.getLeftNode() == null)){
            num = 1;
        }
        
        return num;
    }
    
    private Node<E> smallestLeafNode(Node<E> node) {
        Node<E> smallestLeaf;

        if(node.getLeftNode() == null && node.getRightNode() == null){
            smallestLeaf = node;
        }else{
            if(node.getLeftNode() != null){
                smallestLeaf = smallestLeafNode(node.getLeftNode());
            }else{
                smallestLeaf = smallestLeafNode(node.getRightNode());
            }
        }
        
        return smallestLeaf;
    }
    
    public boolean find(E value){
        return find(this.root, value);
    }
    
    private boolean find(Node<E> currentNode, E value){
        boolean founded = false;
        
        if(currentNode != null){
            if(currentNode.getValue().compareTo(value) == 0){
                return true;
            }
            
            if(currentNode.getValue().compareTo(value) > 0){
                founded = find(currentNode.getLeftNode(), value);
            }
            
            if(currentNode.getValue().compareTo(value) < 0){
                founded = find(currentNode.getRightNode(), value);
            }
        }
        
        return founded;
    }
    
    // GETTERES && SETTERS
    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
