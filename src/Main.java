import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue=new MyQueue<>();
        System.out.println(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.length());

        System.out.println(queue);
        System.out.println(queue.isEmpty());

        queue.dequeue();

        System.out.println(queue);
        System.out.println(queue.peek());

        System.out.println("----------------------");
        MyStack<Integer> myStack=new MyStack<>();
        System.out.println(myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack);
        System.out.println("TOP:"+myStack.peek());
        System.out.println("length:"+myStack.length());
        myStack.pop();
        myStack.pop();
        System.out.println(myStack);
        System.out.println(myStack.isEmpty());
        System.out.println("TOP:"+myStack.peek());
        System.out.println("length:"+myStack.length());

        System.out.println("-------------------------------------");
        MyMinHeap myMinHeap=new MyMinHeap();
        myMinHeap.add(1);
        myMinHeap.add(54);
        myMinHeap.add(343);
        myMinHeap.add(4);
        myMinHeap.add(421);
        myMinHeap.add(5);
        System.out.println(myMinHeap);
        myMinHeap.removeMin();
        System.out.println(myMinHeap);

    }

}