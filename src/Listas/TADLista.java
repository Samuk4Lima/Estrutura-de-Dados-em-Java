package Listas;

public interface TADLista<T> {

    public void add(T novo);
    public boolean remover(T e);
    public T consultar(int index);
    public void print();
    public int indexOf(T e);

}
