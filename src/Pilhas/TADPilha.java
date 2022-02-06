package Pilhas;

public interface TADPilha<T> {

    public void push(T e);

    public T pop();

    public T top();

    public boolean isEmpty();

    public boolean isFull();

    public int size();

    public void print();

}