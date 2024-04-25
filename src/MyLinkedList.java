public class MyLinkedList<T> implements MyList<T>{
    Node<T> head;
    private int size=0;
    private static class Node<T>{
        T value;
        Node<T> next;
        public Node(T value) {
            this.value = value;
            this.next=null;
        }

        @Override
        public String toString() {
            return (next!=null) ? (value+","+next) : value+"";
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
        size++;
    }


    @Override
    public void add(int index, T t) {
        checkIndex(index);
        if (index==0){
            addFirst(t);
        }
        else{
            Node<T> curr=head;
            Node<T> prev;
            for (int i = 0; i != index-1 && curr.next!=null; i++) {
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
        first.next=head;
        head=first;
        size++;
    }

    @Override
    public void set(int index, T t) {
        checkIndex(index);
        Node<T> curr = head;
        if (index >= 0 && size>index) {
            for (int i = 0; i < index && curr.next != null; i++) {
                curr = curr.next;
            }
            curr.value = new Node<>(t).value;
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
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
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size-1);
    }

    @Override
    public void remove(){
        removeLast();
    }

    @Override
    public void remove(int index) {
        checkIndex(index);

        if (index==0){
            head=head.next;
            return;
        }
        Node<T> curr = head;
        Node<T> prev = head;
        for (int i = 0; i < index && curr.next != null; i++) {
            prev=curr;
            curr = curr.next;
        }
        prev.next=curr.next;

        size--;
    }

    @Override
    public void pop(Object o) {
        int check=size;
        Node<T> curr=head;
        Node<T> prev=head;

        while (curr!=null){
            if (curr.value==o) {
                if (curr == head)
                    head = head.next;
                else
                    prev.next = curr.next;
                size--;
            }
            else
                prev=curr;
            curr=curr.next;
        }
        if (size==check)
            throw new RuntimeException("Element not in list");
    }

    @Override
    public void removeFirst() {
        remove(0);

    }

    @Override
    public void removeLast() {
        remove(size-1);

    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1 ; i++) {
            Node<T> curr =head;
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
    public void sort(boolean reverse) {
        if (!reverse) {
            for (int i = 0; i < size - 1; i++) {
                Node<T> curr = head;
                for (int j = 0; j < size - i - 1; j++) {
                    if (((Comparable<T>) curr.value).compareTo(curr.next.value) < 0) {
                        T t = curr.value;
                        curr.value = curr.next.value;
                        curr.next.value = t;
                    }
                    curr = curr.next;
                }
            }
        }else sort();
    }

    @Override
    public int indexOf(Object o) {
        int counter=0;
        Node<T> curr=head;

        while (curr.next!=null){
            if (curr.value==o){
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
            if (curr.value==o)
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
    }


    @Override
    public MyLinkedList<T> range(int begin,int end) {
        MyLinkedList<T> ll=new MyLinkedList<>();

        Node<T> curr=head;
        Node<T> newHead =null;
        Node<T> prev=null;

        for (int i=0;i<end;i++){
            if (i>=begin){
                Node<T> node=new Node<>(curr.value);

                if (newHead==null)
                    newHead=node;
                else
                    prev.next=node;
                prev=node;
            }
            curr=curr.next;
        }

        ll.head=newHead;
        ll.size=end-begin;

        return ll;
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public String toString() {
        return "[ "+( (head!=null)?head:"" ) +" ]";
    }

}

