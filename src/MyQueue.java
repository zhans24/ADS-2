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



    public boolean isEmpty(){
        return getFirst()==null;
    }

    public T peek(){
        return getFirst();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
