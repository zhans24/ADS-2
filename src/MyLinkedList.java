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

    @Override
    public void addFirst(T t) {
        Node<T> first=new Node<>(t);
        first.next=head;
        head=first;
        size++;
    }

    @Override
    public void set(int index, T t) {
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
        Node<T> curr = head;
        if (index >= 0 && size>index) {
            for (int i = 0; i < index && curr.next != null; i++) {
                curr = curr.next;
            }
            return curr.value;
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
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
        size--;
    }

    @Override
    public void remove(int index) {
        if (index==0){
            head=head.next;
            return;
        }
        if (index > 0 && size>index) {
            Node<T> curr = head;
            Node<T> prev = null;
            for (int i = 0; i < index && curr.next != null; i++) {
                prev=curr;
                curr = curr.next;
            }
            prev.next=curr.next;
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        size--;
    }

    @Override
    public void pop(Object o) {
        int check=size;
        Node<T> curr=head;
        Node<T> prev=null;
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
        size--;

    }

    @Override
    public void removeLast() {
        remove(size-1);
        size--;

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
        int counter=0;
        Node<T> curr=head;
        while (curr.next!=null){
            if (curr.value==o){
                curr=curr.next;
                while (curr!=null){
                    if (curr.value==o)
                        return counter;
                    else
                        ++counter;
                    curr=curr.next;
                }
                return counter;
            }
            else ++counter;
            curr=curr.next;
        }
        return -1;
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
        MyLinkedList<T> l=new MyLinkedList<T>();
        size=0;
    }


    @Override
    public int length() {
        return this.size;
    }


    @Override
    public String toString() {
        return "[ "+head+" ]";
    }

}

