
public class MyLinkedList<T> implements MyList<T>{
    Node<T> head;
    private static class Node<T>{
        T value;
        Node<T> next;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        public Node(T value) {
            this.value = value;
            this.next=null;
        }
    }
    @Override
    public void add(T t) {
        if (head == null)
            head=new Node<>(t);
        else {
            Node<T> curr;
            for (curr=head; curr.next != null ;curr=curr.next);
            curr.next=new Node<>(t);
        }
    }

    @Override
    public void add(int index, T t) {

    }

    @Override
    public void addFirst(T t) {
        Node<T> first=new Node<>(t);
        first.next=head;
        head=first;
    }

    @Override
    public void set(int index, T t) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void pop(Object o) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public void sort(boolean reverse) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public boolean exists(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        return "linkedlist{" +
                "head=" + head +
                '}';
    }

    @Override
    public void length() {

    }


}

