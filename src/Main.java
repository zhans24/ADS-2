
public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> ll=new MyLinkedList<>();
        MyArrayList<Integer> arr=new MyArrayList<>();
        arr.add(5);
        arr.add(32);
        arr.add(5);
        arr.add(5);
        arr.add(65);
        arr.add(5);
        System.out.println(arr);
        arr.set(4,5);
        System.out.println(arr);

    }
}