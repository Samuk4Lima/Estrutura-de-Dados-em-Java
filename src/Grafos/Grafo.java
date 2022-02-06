package Grafos;


import java.util.*;

public class Grafo<T> implements TADGrafo<T> {
    private Hashtable<Vertice<T>, List<ParVerticePeso<T>>> grafo;
    private boolean isDirecionado;

    public Grafo(boolean isDirecionado) {
        grafo = new Hashtable<Vertice<T>, List<ParVerticePeso<T>>>();
        this.isDirecionado = isDirecionado;
    }

    public int numVertices(){
        return grafo.size();
    }

    public int numArestas(){
        int r = 0;
        for (Enumeration<Vertice<T>> vertices = grafo.keys();
        vertices.hasMoreElements();){
            Vertice<T> v = (Vertice<T>) vertices.nextElement();
            List<ParVerticePeso<T>> adjascentes = grafo.get(v);
            r += adjascentes.size();
        }
        if (!isDirecionado)
            r /= 2;
        return r;

    }

    public int grau(Vertice<T> v){
        int r = 0;
        if (!isDirecionado){
            List<ParVerticePeso<T>> adjascentes = grafo.get(v);
            if (adjascentes != null)
                r = adjascentes.size();
        } else {
            r = grauPositivo(v) + grauNegativo(v);
        }
        return r;
    }

    private int grauNegativo(Vertice<T> v){
        int r = 0;
        List<ParVerticePeso<T>> adjscentes = grafo.get(v);
        if (adjscentes != null){
            r = adjscentes.size();
        }
        return r;
    }

    private int grauPositivo(Vertice<T> destino){
        int r = 0;
        for (Enumeration<Vertice<T>> vertices = grafo.keys();
        vertices.hasMoreElements();){
            Vertice<T> v = (Vertice<T>) vertices.nextElement();
            List<ParVerticePeso<T>> adjscentes = grafo.get(v);
            if (adjscentes.contains(destino))
                r++;

        }
        return r;
    }

     public boolean saoAdjascentes(Vertice<T> v, Vertice<T> w){
        boolean r = false;
        List<ParVerticePeso<T>> adjascentes = grafo.get(v);
        if (adjascentes != null && adjascentes.contains(w)){
            r = true;
        }
        return r;
     }

     public void insereVertice(Vertice<T> v){
        if (grafo.containsKey(v) == false){
            grafo.put(v, new ArrayList<ParVerticePeso<T>>());
        }
     }

     public void insereAresta(Vertice<T> v, Vertice<T> w, float peso){
        insereVertice(v);
        insereVertice(w);
        List<ParVerticePeso<T>> adjascentes = grafo.get(v);
        ParVerticePeso<T> par = new ParVerticePeso<T>(w, peso);
        adjascentes.add(par);
        if (!isDirecionado){
            adjascentes = grafo.get(w);
            par = new ParVerticePeso<T>(v, peso);
            adjascentes.add(par);
        }
     }

     public void insereAresta(Vertice<T> v, Vertice<T> w){
        insereAresta(v, w, 0);
     }

     public void removerVertice(Vertice<T> v){
        if (!isDirecionado){
            if (grafo.containsKey(v)){
                List<ParVerticePeso<T>> adjascentes = grafo.get(v);
                for (Iterator iterator = adjascentes.iterator(); iterator.hasNext();){
                    ParVerticePeso<T> par = (ParVerticePeso<T>) iterator.next();
                    List<ParVerticePeso<T>> temp = grafo.get(par.v);
                    temp.remove(v);
                }
                grafo.remove(v);
            } else {
                for (Enumeration<Vertice<T>> vertices = grafo.keys();
                vertices.hasMoreElements();){
                    Vertice<T> w = (Vertice<T>) vertices.nextElement();
                    List<ParVerticePeso<T>> adjascentes = grafo.get(w);
                    if (adjascentes.contains(v)) {

                        adjascentes.remove(v);
                    }

                }
                grafo.remove(v);
            }
        }
     }

     public void removerAresta(Aresta<T> e){
        if (grafo.containsKey(e.getOrigem()) && grafo.containsKey(e.getDestino())){
            List<ParVerticePeso<T>> adjascentes = grafo.get(e.getOrigem());
            if (adjascentes != null && adjascentes.contains(e.getDestino())){
                adjascentes.remove(e.getDestino());
            }

            if (!isDirecionado){
                adjascentes = grafo.get(e.getDestino());
                if (adjascentes != null && adjascentes.contains(e.getOrigem())){
                    adjascentes.remove(e.getOrigem());
                }
            }
        }
     }
}
