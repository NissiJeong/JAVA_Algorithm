package datatype.stack;

import java.util.ArrayList;

public class StackEx<E> {
    private ArrayList<E> list;
    private int top;

    public StackEx() {
        this.list = new ArrayList<>();
        this.top = -1;
    }

    public boolean isFull(){
        return top == list.size()-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public E pop(){
        E value = list.get(top);
        list.remove(top--);
        return value;
    }

    public E peek(){
        return list.get(top);
    }

    public int search(E value){
        int result = list.lastIndexOf(value);

        if(result != -1){
            return top - result + 1;
        } else {
            return result;
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
