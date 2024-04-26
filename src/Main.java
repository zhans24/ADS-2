import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue=new MyQueue<>();
        System.out.println(queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue);
        System.out.println(queue.isEmpty());
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.peek());
    }

}