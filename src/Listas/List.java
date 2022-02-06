package Listas;

public class List<T> implements TADLista<T> {

    protected Node<T> inicio;

    protected int qtd;


    public void add(T novo) {
        Node<T> novoNode = new Node<T>(novo);
        if (inicio == null) {
            inicio = novoNode;
        } else {
            Node<T> aux = inicio;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = novoNode;
        }
        qtd++;
    }

    public boolean remover(T e) {
        boolean r = false;
        if (inicio != null) {
            if (inicio.info.equals(e)) {
                inicio = inicio.next;
                r = true;
                qtd--;
            } else {
                Node<T> aux = inicio;
                while (aux.next != null) {
                    if (aux.next.info.equals(e)) {
                        // encontrei o elemento que deve ser removido!
                        aux.next = aux.next.next; // removido o elemento
                        r = true;
                        qtd--;
                        break;
                    }
                    aux = aux.next;
                }
            }
        }
        return r;
    }

    public boolean procurar(Object o){
        return (indexOf((T) o) != -1);
    }

    public T consultar(int index) {
        if (index < qtd) {
            int i=0;
            Node<T> aux = inicio;
            while (i != index) {
                aux = aux.next;
                i++;
            }
            return aux.info;
        } else {
            return null;
        }
    }

    public int size() {
        return qtd;
    }

    public String toString() {
        String s = "";
        Node<T> aux = inicio;
        while (aux != null) {
            s += aux + "," + " "; //aux + ",";
            aux = aux.next;
        }
        return s;
    }

    public void receberString(String entrada){
        if (entrada. length() == 64){
            for (int i = 0; i< 8; i++){
                List matrizLinha = new List();
                for (int j = 0; j < 8; j++){
                    matrizLinha.add(entrada.charAt(8*i+j));
                }
                add((T) matrizLinha.toString());
            }
        }

    }

    public void print() {
        System.out.println(this);
    }

    public int indexOf(T e) {
        int i=0;
        int r = -1;
        Node<T> aux = inicio;
        while (aux != null) {
            if (aux.info.equals(e)) {
                r = i;
                break;
            }
            aux = aux.next;
            i++;
        }
        return r;
    }

}


