package Hashing;

public class List<T extends Comparable<T>>  {

    private Node<T> elemento;
    private Node<T> fim;
    private int tamanho = 0;


    public void add(T valor){
        if(elemento == null){
            elemento = new Node(valor);
            fim = elemento;
        }else{
            Node temp = elemento;
            while (temp.getB() != null)
                temp = temp.getB();
            temp.setB(new Node(valor));
            temp.getB().setA(fim);
            fim = temp.getB();
        }
        tamanho++;
    }

    public T get(int i){
        if(i > tamanho-1)
            return null;
        Node<T> aux = elemento;
        for(int j = 0; j < i; j++){
            aux = aux.getB();
        }
        return aux.getE();
    }

    public boolean contains(T e){
        boolean r = false;
        Node<T> temp = elemento;
        for(int i = 0; i < tamanho; i++){
            if(temp.getE().compareTo(e) == 0){
                r = true;
                break;
            }else{
                temp = temp.getB();
            }
        }
        return r;
    }

    public int size(){
        return tamanho;
    }

}