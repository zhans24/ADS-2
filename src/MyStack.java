public class MyStack<T> extends MyArrayList<T>{
    public MyStack(){
        super();
    }

    public T push(T t){
        add(t);
        return t;
    }

    public T pop(){
        T t= get(length()-1);
        removeLast();
        return t;
    }

    public T peek(){
        return get(length()-1);
    }

    public boolean isEmpty(){
        return length()==0;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
