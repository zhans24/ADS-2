public class MyLinkedList<T> implements MyList<T>{
    private Node<T> head;
    private Node<T> tail;

    private int size=0;

    private static class Node<T>{
        T value;
        Node<T> next;
        Node<T> prev;
        public Node(T value) {
            this.value = value;
            this.next=null;
            this.prev=null;
        }

        @Override
        public String toString() {
            return (next!=null) ? (value+","+next) : value+"";
        }
    }


    @Override
    public void add(T t) {
        Node<T> node = new Node<>(t);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }


    @Override
    public void add(int index, T t) {
        if (index==size) {
            add(t);
            return;
        }
        checkIndex(index);
        if (index==0){
            addFirst(t);
        } else{
            Node<T> curr=head;
            Node<T> prev;
            for (int i = 0; i !=index-1 && curr.next!=null; i++) {
                curr=curr.next;
            }
            prev=curr.next;
            curr.next=new Node<>(t);
            curr.next.next=prev;
            size++;
        }
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index");
    }

    @Override
    public void addFirst(T t) {
        Node<T> first=new Node<>(t);
        if (head==null){
            head=first;
            tail=first;
        }
        else {
            first.next=head;
            head.prev=first;
            head=first;
        }
        size++;
    }
    @Override
    public void addLast(T t){
        add(t);
    }

    @Override
    public void set(int index, T t) {
        checkIndex(index);
        Node<T> curr = head;
        for (int i = 0; i < index && curr.next != null; i++) {
            curr = curr.next;
        }
        curr.value = new Node<>(t).value;

    }

    @Override
    public T get(int index) {
        checkIndex(index);

        Node<T> curr = head;

        for (int i = 0; i < index && curr.next != null; i++) {
            curr = curr.next;
        }
        return curr.value;

    }

    @Override
    public T getFirst() {
        return (head!=null)?head.value:null;
    }

    @Override
    public T getLast() {
        return (tail!=null)?tail.value:null;
    }

    @Override
    public void remove(){
        removeLast();
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index==0){
            removeFirst();
        }
        else if (index==size-1) {
            removeLast();
        }
        else{
            Node<T> curr=head;
            Node<T> prev=tail;
            for (int i = size-1 ; i !=index+1 && prev.prev!=null; i--) {
                prev=prev.prev;
            }
            for (int i = 0; i !=index-1 && curr.next!=null; i++) {
                curr=curr.next;
            }
            curr.next=prev;
            size--;
        }

    }

    @Override
    public void remove(Object o) {
        int check=size;
        Node<T> curr=head;
        while (curr != null) {
            if (curr.value.equals(o)) {
                if (curr == head) {
                    head = head.next;
                    head.prev = null;
                } else if (curr == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                size--;
            }
            curr = curr.next;
        }
        if (size==check)
            throw new RuntimeException("Element not in list");
    }

    @Override
    public void removeFirst() {
        if (head==null){
            throw new RuntimeException("List is empty");
        }
        else if (head.next==null){
            head=null;
            tail=null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (tail==null) {
            throw new RuntimeException("List is empty");
        }
        else if (tail.prev==null){
            head=null;
            tail= null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    @Override
    public void sort() {
        if (size>0)
            bubblesort(this.head,this.size);
        else
            throw new RuntimeException("List is empty");
    }



    @Override
    public void sort(boolean reverse) {
        if (reverse && size > 0){
            bubblesort(head, this.size);
            this.head = reverseList(head);
        }
        else
            sort();
    }

    private Node<T> reverseList(Node<T> head) {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private void bubblesort(Node<T> first,int size){
        for (int i = 0; i < size - 1 ; i++) {
            Node<T> curr =first;
            for (int j = 0; j < size - i - 1   ; j++) {
                if (((Comparable<T>) curr.value).compareTo(curr.next.value) > 0) {
                    T t = curr.value;
                    curr.value = curr.next.value;
                    curr.next.value = t;
                }
                curr = curr.next;
            }
        }
    }
    @Override
    public int indexOf(Object o) {
        int counter=0;
        Node<T> curr=head;

        while (curr.next!=null){
            if (curr.value.equals(o)){
                return counter;
            }
            else ++counter;
            curr=curr.next;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index=-1;
        int counter=0;
        Node<T> curr=head;

        while (curr.next!=null){
            if (curr.value.equals(o))
                index=counter;
            counter++;
            curr=curr.next;
        }
        return index;
    }

    @Override
    public boolean exists(Object o) {
        Node<T> curr=head;

        while (curr!=null){
            if (curr.value==o)
                return true;
            curr=curr.next;
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr=new Object[size];
        Node<T> node=head;

        for (int i = 0; i < size && node!=null; i++) {
            arr[i]=node.value;
            node=node.next;
        }

        return arr;
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
        size=0;
    }


    @Override
    public MyLinkedList<T> range(int begin,int end) {
        return new MyLinkedList<>();
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public String toString() {
        return "["+( (head!=null)?head:"" ) +"]";
    }

}

