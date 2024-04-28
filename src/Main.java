

public class Main {
    public static void main(String[] args) {


        MyLinkedList<Integer> arr = new MyLinkedList<>();
        arr.add(21);
        arr.add(2231);
        arr.add(332);
        arr.add(23);
        arr.add(4);
        System.out.println(arr);
        arr.sort();
        System.out.println(arr);
        arr.sort(true);
        System.out.println(arr);
    }

}