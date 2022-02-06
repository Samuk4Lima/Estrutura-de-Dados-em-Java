package Fila;

public interface TADFila<T> {

    public void enqueue(T novo);

    public T remove();

    public T consultarInicio();

    public int size();

    public void print();
}
