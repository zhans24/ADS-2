public class MyArrayList<T> implements MyList<T> {
    private T[] arr;
    private int size=0;
    public MyArrayList(int length){
        arr=(T[]) new Object[length];
        size=length;
    }

    public MyArrayList(){
        arr=(T[]) new Object[1];
    }
    @Override
    public void add(T t) {


    }

    @Override
    public void add(int index, T t) {

    }

    @Override
    public void addFirst(T t) {

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
    public void remove() {

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
    public int length() {
        return this.size;
    }

    @Override
    public MyList<T> range(int begin, int end) {
        return null;
    }
}
