package Arvores;

public interface TADArvore<T extends Comparable> {

    public void inserir(T novo);
    public boolean remover(T e);
    public T consultar(T e);
    public boolean existe(T e);
    public void print();

}