package Pilhas;

public class Stack<T> implements TADPilha<T> {

    private Node<T> topo;
    private int qtd;

    public void push(T e) {
        Node<T> novo = new Node<T>(e);
        novo.next = topo;
        topo = novo;
        qtd++;
    }

    public T pop() {
        T r = null;
        if (!isEmpty()) {
            r = topo.info;
            topo = topo.next;
            qtd--;
        } else {
            r = null;
        }
        return r;
    }

    public T top() {
        T r = null;
        if (!isEmpty()) {
            r = topo.info;
        } else {
            throw new RuntimeException("Stack vazia!");
        }
        return r;
    }

    public void inverter() {
        Stack pil1 = new Stack();
        Stack pil2 = new Stack();
        int count = 0;
        int tamanho = size();
        while (count < tamanho) {
            T removido = pop();
            pil1.push(removido);
            count++;
        }
        while (!pil1.isEmpty()) {
            pil2.push(pil1.pop());
        }
        while (!pil2.isEmpty()) {
            push((T) pil2.pop());
        }
    }

    public T takeInTop(int index) {
        Stack auxiliar = new Stack();
        Stack work = new Stack();

        int count = 0;
        int tamanho = size();
        while (count < tamanho) {
            T remove = pop();
            auxiliar.push(remove);
            T valToWork = (T) auxiliar.top();
            work.push(valToWork);
            count++;
        }
        auxiliar.inverter();
        T r = null;
        for (int i = 0; i <= index; i++) {
            r = (T) auxiliar.top();
            auxiliar.pop();
        }
        while (!work.isEmpty()) {
            push((T) work.pop());
        }

        return r;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public boolean isFull() {
        return false;
    }

    public int size() {
        return qtd;
    }

    public String toString() {
        String r = "";
        if (!isEmpty()) {
            Node<T> p = topo;
            while (p != null) {
                r += p.info; // + ";"; para a questao de pares e outras
                p = p.next;
            }
        } /*else {
            r += "-> null";
        }*/
        return r;
    }

    public String display() {
        String r = "";
        if (!isEmpty()) {
            Node<T> p = topo;
            while (p != null) {
                r = p.info + " " + r;
                p = p.next;
            }
        } else {
            return "Empty";
        }
        return r;
    }


    public void print() {
        System.out.println(this);
    }

}
