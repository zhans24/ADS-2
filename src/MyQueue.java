public class MyQueue<T> extends MyLinkedList<T>{

    public MyQueue(){
        super();
    }

    public void enqueue(T t){
        add(t);
    }

    public void dequeue(){
        removeFirst();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public boolean isEmpty(){
        return getFirst()==null;
    }

    public T peek(){
        return getFirst();
    }
}
