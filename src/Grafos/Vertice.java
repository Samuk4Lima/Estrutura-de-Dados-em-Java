package Grafos;

public class Vertice<T> {
    private T info;
    private boolean foiVisitado;

    public Vertice(T info) {
        super();
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public boolean isFoiVisitado() {
        return foiVisitado;
    }

    public void setFoiVisitado(boolean foiVisitado) {
        this.foiVisitado = foiVisitado;
    }

    public int hashCode(){
        return info.hashCode();
    }

    public boolean equals(Object o){
        boolean r = false;
        if (o != null){
            if (o instanceof Vertice)
                r = this.info.equals(((Vertice)o).info);
            else if (o instanceof ParVerticePeso)
                r = this.info.equals(((ParVerticePeso)o).v.info);
        }
        return r;
    }

    public String toString() {
       return info.toString();
    }
}
