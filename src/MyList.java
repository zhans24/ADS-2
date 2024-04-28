public interface MyList<T> {

    void add(T t);
    void add(int index,T t);
    void addFirst(T t);
    void addLast(T t);
    void set(int index,T t);
    T get(int index);
    T getFirst();
    T getLast();
    void remove(int index);
    void remove();
    void remove(Object o);
    void removeFirst();
    void removeLast();
    void sort();
    void sort(boolean reverse);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    boolean exists(Object o);
    public Object[] toArray();
    MyList<T> range(int begin,int end);
    void clear();
    int length();
}
