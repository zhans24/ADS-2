import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();

        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.set(0,1);
        linkedList.add(2,2);
        System.out.println(linkedList);
        linkedList.remove('c');
        System.out.println(linkedList);
    }
}