package Listas;

public class Node<T> {

    public T info;
    public Node<T> next;

    public Node(T novo) {
        this.info = novo;
    }

    public String toString() {
        return "" + info;
    }
}