import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> ll=new MyLinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(5);
        ll.add(5);
        ll.add(6);
        System.out.println(ll);
        System.out.println(ll.length());
        ll.add(1,7);
        System.out.println(ll);;
        System.out.println(ll.length());

    }
}