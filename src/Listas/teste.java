package Listas;

public class teste {
    public static void main(String[] args) {
        List<Integer> lista = new List<>();
        lista.add(2);
        lista.add(65);
        lista.add(23);
        lista.add(6);
        lista.add(5);

        System.out.println(lista.procurar(2));
    }
}
