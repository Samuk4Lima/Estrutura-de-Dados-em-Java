package Listas;

public class ListaDinamica<T extends Comparable<T>> {
    private NodeDyn<T> elemento;
    private NodeDyn<T> end;
    private int tam = 0;

    public void add(T novo) {
        if (elemento == null) {
            elemento = new NodeDyn(novo);
            end = elemento;
        } else {
            NodeDyn temp = elemento;
            while (temp.getB() != null) {
                temp = temp.getB();
            }
            temp.setB(new NodeDyn(novo));
            temp.getB().setA(end);
            end = temp.getB();
        }
        tam++;
    }

    public T get(int e) {
        if (e > tam - 1)
            return null;
        NodeDyn<T> aux = elemento;
        for (int i = 0; i < e; i++) {
            aux = aux.getB();
        }
        return aux.getE();
    }

    public boolean contains(T e){
        boolean r = false;
        NodeDyn<T> temp = elemento;
        for (int i = 0; i < tam; i ++){
            if (temp.getE().compareTo(e) == 0){
                r = true;
                break;
            } else {
                temp = temp.getB();
            }
        }
        return r;
    }
    public int size(){
        return tam;
    }


}
