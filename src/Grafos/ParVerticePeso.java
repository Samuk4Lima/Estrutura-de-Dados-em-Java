package Grafos;

public class ParVerticePeso<T> {
    Vertice<T> v;
    float peso;
    char tipoAresta;

    public static final char ARESTA_NAO_EXPLORADA = '0';
    public static final char ARESTA_NAO_DESCOBERTA = '1';
    public static final char ARESTA_RETORNO = '2';

    public ParVerticePeso(Vertice<T> w, float peso){
        this.v = w;
        this.peso = peso;
    }
}
