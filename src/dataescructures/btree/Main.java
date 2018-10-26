package dataescructures.btree;

public class Main {

    public static void main(String[] args) {
        BTree bt = getTree();
        
        bt.add(5);
        bt.add(3);
        bt.add(8);
        bt.add(2);
        bt.add(4);
        bt.add(6);
        bt.add(10);
        bt.add(1);
        bt.add(7);
        bt.add(9);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Arbol base:");
        System.out.println("------------------------------------------------------------------------");
        BTreePrinter.printNode(bt);
        System.out.println("Eliminamos el nodo 3");
        bt.remove(3);
        BTreePrinter.printNode(bt);
        
        bt = getTree();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Arbol base:");
        System.out.println("------------------------------------------------------------------------");
        BTreePrinter.printNode(bt);
        System.out.println("Eliminamos el nodo 2");
        bt.remove(2);
        BTreePrinter.printNode(bt);
        
        bt = getTree();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Arbol base:");
        System.out.println("------------------------------------------------------------------------");
        BTreePrinter.printNode(bt);
        System.out.println("Eliminamos el nodo 1");
        bt.remove(1);
        BTreePrinter.printNode(bt);
        
        bt = getTree();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Arbol base:");
        System.out.println("------------------------------------------------------------------------");
        BTreePrinter.printNode(bt);
        System.out.println("Eliminamos el nodo 8");
        bt.remove(8);
        BTreePrinter.printNode(bt);
    }
    
    private static BTree<Integer> getTree(){
        BTree bt = new BTree<Integer>();
        
        bt.add(5);
        bt.add(3);
        bt.add(8);
        bt.add(2);
        bt.add(4);
        bt.add(6);
        bt.add(10);
        bt.add(1);
        bt.add(7);
        bt.add(9);
        
        return bt;
    }

}
