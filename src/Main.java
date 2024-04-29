import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


       MyArrayList<Integer> arr=new MyArrayList<>();
       arr.add(243);
       arr.add(232);
       arr.add(23221);
       arr.add(100000);
       arr.add(31313331);
        System.out.println(arr);
        arr.sort();
        System.out.println(arr);
        arr.sort(true);
        System.out.println(arr);
    }

}