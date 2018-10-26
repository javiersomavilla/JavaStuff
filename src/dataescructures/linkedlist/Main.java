package dataescructures.linkedlist;

public class Main {

    public static void main(String[] args) {
       LinkedList list = new LinkedList<Integer>();
       
       list.add(0);
       list.add(1);
       list.add(3);
       list.add(4);
       list.add(5);
       
       LinkedList list2 = new LinkedList<Integer>();
       list2.add(6);
       list2.add(7);
       
       list.addAll(list2);
       
       list.addAt(2, 2);
       
       System.out.println(list.toString());
       
       System.out.println(list.get(7));
       
       System.out.println(list.contains(13));
       
       list.removeFirst();
       list.removeLast();
       list.removeAt(3);
       
       System.out.println(list.toString());
       
    }

}
