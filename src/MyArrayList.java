
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

    private void increaseSize(){
        T[] newArr=(T[])new Object[size+1];
        int s=0;
        for (T t:arr) {
            newArr[s]=t;
            s++;
        }
        arr=newArr;
    }
    @Override
    public void add(T t) {
        increaseSize();
        arr[size++]=t;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index");
    }

    @Override
    public void add(int index, T t) {
        increaseSize();
        checkIndex(index);
        for (int i = index+1; i < size; i++)
            arr[i+1]=arr[i];
        arr[index]=t;
        size++;
    }

    @Override
    public void addFirst(T t) {
        add(0,t);
    }
    @Override
    public void addLast(T t){
        add(t);
    }

    @Override
    public void set(int index, T t) {
        checkIndex(index);
        arr[index]=t;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return get(index);
    }

    @Override
    public T getFirst() {
        checkIndex(0);
        return get(0);
    }

    @Override
    public T getLast() {
        checkIndex(size-1);
        return get(size-1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index+1; i <size ; i++) {
            arr[i-1]=arr[i];
        }
        size--;
    }

    @Override
    public void remove(){
        remove(size-1);
    }
    @Override
    public void removeLast() {
        remove(size-1);
    }

    @Override
    public void remove(Object o) {
        if (!exists(o))
            throw new RuntimeException("Element not in the list");
        for (int i = 0; i < size; i++) {
            if (arr[i]==o) {
                remove(i);
                i=-1;
            }
        }

    }

    @Override
    public void removeFirst() {
        remove(0);
    }
    @Override
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-i-1; j++) {
                if (( (Comparable<T>) arr[j]).compareTo(arr[j+1])>0  ){
                    T swap=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=swap;
                }
            }
        }
    }

    @Override
    public void sort(boolean reverse) {
        if (reverse)
            sort();
        else{
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size-i-1; j++) {
                    if (( (Comparable<T>) arr[j+1]).compareTo(arr[j])>0  ){
                        T swap=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=swap;
                    }
                }
            }
        }
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i <size ; i++) {
            if (arr[i]==o)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index=-1;
        for (int i = 0; i < size; i++) {
            if (arr[i]==o)
                index=i;
        }

        return index;
    }

    @Override
    public boolean exists(Object o) {
        for (T t:arr) {
            if (t==o)
                return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {
        T[] t=(T[]) new Object[1];
        arr=t;
        size=0;
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public MyArrayList<T> range(int begin, int end) {
        MyArrayList<T> newArr=new MyArrayList<>();
        for (int i = begin; i < end; i++) {
            newArr.add(arr[i]);
        }
        return newArr;
    }

    @Override
    public String toString() {
        StringBuilder newArr= new StringBuilder();
        for (int i = 0; i < size-1; i++) {
            newArr.append(arr[i]).append(",");
        }
        return (size>0)?"["+newArr.append(arr[size-1])+"]":"[ ]";
    }
}
