package Arvores;

public class Node<T extends Comparable> {

    T info;
    Node<T> esquerda, direita;

    public Node(T novo) {
        info = novo;
    }

    public String toString() {
        return "" + info;
    }
}
