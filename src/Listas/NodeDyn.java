package Listas;

public class NodeDyn<T> {
    private NodeDyn a;
    private NodeDyn b;
    private T e;

    public NodeDyn(T e) {
        this.e = e;
    }

    public NodeDyn getA() {
        return a;
    }

    public NodeDyn getB() {
        return b;
    }

    public void setA(NodeDyn a) {
        this.a = a;
    }

    public void setB(NodeDyn b) {
        this.b = b;
    }

    public T getE() {
        return e;
    }

    public void setE(T e) {
        this.e = e;
    }
}
