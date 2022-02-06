package Fila;

public class Queue<T> implements TADFila<T> {

    private Node<T> inicio, fim;
    private int qtd;

    public boolean isEmpty() {
        return this.qtd == 0;
    }

    public void enqueue(T novo) {
        Node<T> novoNode = new Node<T>(novo);
        if (inicio == null) {
            inicio = fim = novoNode;
        } else {
            fim.next = novoNode;
            fim = novoNode;
        }
        qtd++;
    }

    public T remove() {
        T r = null;
        if (inicio != null) {
            r = inicio.info;
            inicio = inicio.next;
            if (inicio == null) {
                fim = null;
            }
            qtd--;
        }
        return r;
    }

    public void receberString(String entrada) {
        String[] transformaArray = entrada.split(";");
        int[] vetorArray = new int[transformaArray.length];
        Queue queue = new Queue();

        for (int i = 0; i < transformaArray.length; i++) {
            vetorArray[i] = Integer.parseInt(transformaArray[i]);
            queue.enqueue(vetorArray[i]);
        }
        int tamanho = queue.size();
        for (int i = 0; i < tamanho; i++){
            T recebe = (T) queue.remove();
            enqueue(recebe);

        }



    }

    public void inverterFila(int n) {
        Queue queue = new Queue();
        int count = 0;
        int tamanho = size();
        while (count < tamanho) {
            T aux = remove();
            queue.enqueue(aux);
            count++;
        }
        for (int i = n-1; i >= 0;i--){
            T recebe = (T) queue.giraFila(i);
            enqueue(recebe);
        }
        for (int i = n-1; i >= 0;i--){
            queue.remove();
        }
        int iterator = 0;
        while (iterator < queue.size()){
            T integra = (T) queue.giraFila(iterator);
            enqueue(integra);
            iterator++;
        }

    }

    public T consultarInicio() {
        T r = null;
        if (inicio != null) {
            r = inicio.info;
        }
        return r;
    }


    public T giraFila(int index) {
        Queue auxiliar = new Queue();
        int count = 0;
        while (count < size()){
            T aux = remove();
            auxiliar.enqueue(aux);
            enqueue(aux);
            count++;
        }

        T r = null;
        for (int i = 0; i <= index; i++){
            r = (T) auxiliar.consultarInicio();
            auxiliar.remove();
        }

        return r;
    }

    public int indexOf(T e) {
        int i = 0;
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

    public int recebeInt(int e) {
        int i = 0;
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

    public int size() {
        return qtd;
    }

    public String toString() {
        String s = "";
        Node<T> aux = inicio;
        while (aux != null) {
            s += aux + " ";
            aux = aux.next;
        }
        return s;
    }

    public String display() {
        String s = "";
        Node<T> aux = inicio;
        while (aux != null) {
            s += aux + " ";
            aux = aux.next;
        }
        if (s == "") {
            return "Empty";
        } else {
            return s;
        }

    }


    public void print() {
        System.out.println(this);
    }

}