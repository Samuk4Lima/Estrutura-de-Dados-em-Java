package Grafos;

import java.util.Iterator;

public interface TADGrafo<T> {
    int numVertices();
    int numArestas();
    int grau(Vertice<T> v);
    Iterator<Vertice<T>> verticesAdjascentes(Vertice<T> v);
    Iterator<Vertice<T>> arestasIncidentes(Vertice<T> v);
    boolean saoAdjascentes(Vertice<T> v, Vertice<T> w);
    void insereVertice(Vertice<T> v);
    void insereAresta(Vertice<T> v, Vertice<T> w);
    void insereAresta(Vertice<T> v, Vertice<T> w, float peso);
    void removeVertice(Vertice<T> v);
    void removeAresta(Aresta<T> e);

}
