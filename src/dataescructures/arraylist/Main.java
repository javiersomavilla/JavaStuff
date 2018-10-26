package dataescructures.arraylist;


public class Main {

    public static void main(String[] args) {
        ArrayList list = new ArrayList<Integer>();
        
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("List 1: Size = "+list.getSize()+" Length = "+list.getArray().length);
        System.out.println("------------------------------------------------------------------------");
        System.out.println(list.toString());
        
        ArrayList list2 = new ArrayList<Integer>();
        
        list2.add(-1);
        list2.add(-2);
        list2.add(-3);
        list2.add(-4);
        list2.add(-5);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("List 2: Size = "+list2.getSize()+" Length = "+list2.getArray().length);
        System.out.println("------------------------------------------------------------------------");
        System.out.println(list2.toString());
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("List 1 add 234 at 5:");
        System.out.println("------------------------------------------------------------------------");        
        list.addAt(5, 234);
        System.out.println(list.toString());
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("List 2 added to List 1");
        System.out.println("------------------------------------------------------------------------"); 
        list.add(list2);
        System.out.println(list.toString());
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("set 1000 at 3");
        System.out.println("------------------------------------------------------------------------"); 
        list.set(3,1000);
        System.out.println(list.toString());

        System.out.println("------------------------------------------------------------------------");
        System.out.println("remove first occurrence of 1");
        System.out.println("------------------------------------------------------------------------"); 
        list.removeFirstOccurrence(1);
        System.out.println(list.toString());
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("remove at 4");
        System.out.println("------------------------------------------------------------------------");
        list.removeAt(4);
        System.out.println(list.toString());

        System.out.println("------------------------------------------------------------------------");
        System.out.println("remove from 6-9");
        System.out.println("------------------------------------------------------------------------");
        list.remove(6,9);        
        System.out.println(list.toString());
        
    }

}
