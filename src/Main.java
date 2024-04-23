
public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> ll=new MyLinkedList<>();
        ll.add("z");
        ll.add("h");
        ll.add("a");
        ll.add("a");
        ll.add("a");
        ll.add("s");
        ll.add("i");
        ll.add("k");
        ll.add("g");

        System.out.println(ll);
        ll.pop("kg");
        System.out.println(ll);
    }
}