package Hashing;

public class Node<T> {

    private Node a;
    private Node b;

    private T e;

    public Node(T e){
        this.e = e;
    }

    public Node getA() {
        return a;
    }

    public void setA(Node a) {
        this.a = a;
    }

    public Node getB() {
        return b;
    }

    public void setB(Node b) {
        this.b = b;
    }

    public T getE() {
        return e;
    }

    public void setE(T e) {
        this.e = e;
    }
}
