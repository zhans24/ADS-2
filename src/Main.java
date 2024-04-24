public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> ll=new MyLinkedList<>();
        ll.add(10);
        ll.add(2);
        ll.add(14);
        ll.add(14);
        ll.add(14);
        ll.add(3);
        ll.add(6);

        System.out.println(ll);
        System.out.println(ll.indexOf(14));
    }
}