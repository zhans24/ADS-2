
public class MyMinHeap<T> extends MyArrayList<T>{

    public MyMinHeap() {
        super();
    }

    public void insert(T t) {
        add(t);
        int currentIndex = length() - 1;
        int parentIndex = (currentIndex - 1) / 2;

        while (parentIndex >= 0 && ((Comparable<T>)get(currentIndex)).compareTo(get(parentIndex))>0 ) {
            T sw = get(currentIndex);
            set(currentIndex, get(parentIndex));
            set(parentIndex, sw);

            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }

    public T min() {
        if (length()==0) {
            throw new IllegalStateException("Heap is empty");
        }

        T sw = get(0);
        set(0, get(length() - 1));
        remove(length() - 1);

        heapify(0);

        return sw;
    }

    private void heapify(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < length() && ((Comparable<T>)get(leftChild)).compareTo(get(smallest))<0) {
            smallest = leftChild;
        }

        if (rightChild < length() && ((Comparable<T>)get(rightChild)).compareTo(get(smallest))<0)   {
            smallest = rightChild;
        }

        if (smallest != index) {
            T t = get(index);
            set(index, get(smallest));
            set(smallest, t);

            heapify(smallest);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}