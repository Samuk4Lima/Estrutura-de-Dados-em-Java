package Arvores;

public class Arvore<T extends Comparable> implements TADArvore<T> {


    protected Node<Comparable> raiz;

    public void inserir(T novo) {
        if (!existe(novo)) {
            Node<Comparable> novoNode = new Node(novo);
            if (raiz == null) {
                raiz = novoNode;
            } else {
                Node<Comparable> aux = raiz;
                while (aux != null) {
                    int flag = aux.info.compareTo(novo);
                    if (flag < 0) {
                        if (aux.direita != null) {
                            aux = aux.direita;
                        } else {
                            aux.direita = novoNode;
                            break;
                        }
                    } else {
                        if (aux.esquerda != null) {
                            aux = aux.esquerda;
                        } else {
                            aux.esquerda = novoNode;
                            break;
                        }
                    }
                }
            }
        }
    }

    public boolean remover(T e) {
        boolean r = false;
        if (raiz != null) {
            if (raiz.info.equals(e)) {
                if (raiz.esquerda == null) {
                    raiz = raiz.direita;
                } else if (raiz.direita == null) {
                    raiz = raiz.esquerda;
                } else {
                    substituiRaizSubarvore(raiz);
                }
                r = true;
            } else {
                // o no que preciso remover, nao eh a raiz
                // localizar o no na arvore
                Node<Comparable> p = raiz;
                Node<Comparable> paiP = p;
                while (p != null) {
                    int flag = p.info.compareTo(e);
                    if (flag == 0) {
                        // encontrei o no que deve ser removido!
                        break;
                    } else if (flag < 0) {
                        paiP = p;
                        p = p.direita;
                    } else {
                        paiP = p;
                        p = p.esquerda;
                    }
                }
                if (p != null) {
                    // trata a remocao do no p da arvore
                    r = true;
                    if (p.esquerda == null) {
                        if (paiP.esquerda == p) {
                            paiP.esquerda = p.direita;
                        } else {
                            paiP.direita = p.direita;
                        }
                    } else if (p.direita == null) {
                        if (paiP.esquerda == p) {
                            paiP.esquerda = p.esquerda;
                        } else {
                            paiP.direita = p.esquerda;
                        }
                    } else {
                        substituiRaizSubarvore(p);
                    }
                }
            }
        }
        return r;
    }

    private void substituiRaizSubarvore(Node<Comparable> raizSubArvore) {
        // localizando o menor descendente a direita da raiz
        Node<Comparable> aux = raizSubArvore.direita;
        Node<Comparable> paiAux = aux;
        while (aux.esquerda != null) {
            paiAux = aux;
            aux = aux.esquerda;
        }
        // substitui a informação da raiz
        raizSubArvore.info = aux.info;
        if (aux != paiAux) {
            // remove o no que substituiu a raiz
            paiAux.esquerda = aux.direita;
        } else {
            raizSubArvore.direita = aux.direita;
        }
    }

    public T consultar(T e) {
        T r = null;
        Node<Comparable> aux = raiz;
        while (aux != null) {
            int flag = aux.info.compareTo(e);
            if (flag == 0) {
                r = (T) aux.info;
                break;
            } else if (flag < 0) {
                aux = aux.direita;
            } else {
                aux = aux.esquerda;
            }
        }
        return r;
    }

    private float vsDforE(Node<Comparable> p){
        float total = 0;
        if (p != null){
            total = (float) p.info;
            total = (total * vsDforE(p.direita) / vsDforE(p.esquerda));
        } if (total != 0)
            return total;
        else
            return 1;


    }

    private float vsEforD(Node<Comparable> p){
        float total = 0;
        if (p != null){
            total = (float) p.info;
            total = (total * vsEforD(p.esquerda) / vsEforD(p.direita));
        } if (total != 0)
            return total;
        else
            return 1;
    }

    public String vsEforD(){
        String str = String.valueOf(String.format("%.03f",vsEforD(raiz)));
        str = str.replaceAll("\\,", ".");
        return str;
    }

    public String vsDforE(){
        String str = String.valueOf(String.format("%.03f",vsDforE(raiz)));
        str = str.replaceAll("\\,", ".");
        return str;
    }


    public boolean existe(T e) {
        return consultar(e) != null;
    }



    private int contadorDeFolhas(Node<Comparable> node) {
        if (node == null)
            return 0;
        if (node.esquerda == null && node.direita == null)
            return 1;
        else
            return contadorDeFolhas(node.esquerda) + contadorDeFolhas(node.direita);

    }

    public int totalDeFolhas() {
        return contadorDeFolhas(raiz);
    }


    public void inverterArvore() {
        raiz = inverte(raiz);
    }

    private Node inverte(Node<Comparable> node) {
        if (node == null)
            return node;

        //aplicando a recursividade
        Node esquerda = inverte(node.esquerda);
        Node direita = inverte(node.direita);

        //troca de posições
        node.esquerda = direita;
        node.direita = esquerda;

        return node;
    }

    public void printTree() {
        outputArvore(raiz);
    }


    private void outputArvore(Node<Comparable> node) {


        if (node == null)
            return;
        outputArvore(node.esquerda);
        System.out.print(node.info + ";");

        outputArvore(node.direita);
    }

    private String buildStringPosOrdem(Node<Comparable> p) {
        String pEsquerdos;
        String pDireitos;
        if (p.esquerda != null)
            pEsquerdos = buildStringPosOrdem(p.esquerda);
        else
            pEsquerdos = "";
        if (p.direita != null)
            pDireitos = buildStringPosOrdem(p.direita);
        else
            pDireitos = "";
        return pEsquerdos + pDireitos + p.info + ";";
    }

    public String toStringPosOrdem() {
        String ret = buildStringPosOrdem(raiz);
        return ret;
    }


    private String buildStringEmOrdem(Node<Comparable> p) {
        String pEsquerdos;
        String pDireitos;
        if (p.esquerda != null)
            pEsquerdos = buildStringEmOrdem(p.esquerda);
        else
            pEsquerdos = "";
        if (p.direita != null)
            pDireitos = buildStringEmOrdem(p.direita);
        else
            pDireitos = "";
        return pEsquerdos + p.info + pDireitos;
    }

    public String toStringEmOrdem() {
        String ret = buildStringEmOrdem(raiz);
        ret = ret.replaceAll("", ";");
        String retorne = ret.substring(1);
        return "\n" + retorne;
    }


    private void percursoPreOrdem(Node<Comparable> p) {
        if (p != null) {
            System.out.print(p.info + ", ");
            percursoPreOrdem(p.esquerda);
            percursoPreOrdem(p.direita);
        }
    }

    private void percursoPosOrdem(Node<Comparable> p) {
        if (p != null) {
            percursoPosOrdem(p.esquerda);
            percursoPosOrdem(p.direita);
            System.out.print(p.info + ", ");
        }
    }


    private void percursoEmOrdem(Node<Comparable> p) {

        if (p != null) {
            percursoEmOrdem(p.esquerda);
            System.out.print(p.info + ";");
            percursoEmOrdem(p.direita);
        }

    }

    public void getPercursoEmOrdem(){
        percursoEmOrdem(raiz);
    }


    public void print() {
        System.out.print("Percurso pre-ordem: ");
        percursoPreOrdem(raiz);
        System.out.println("");
        System.out.print("Percurso pos-ordem: ");
        percursoPosOrdem(raiz);
        System.out.println("");
        System.out.print("Percurso em-ordem: ");
        percursoEmOrdem(raiz);
        System.out.println("");
    }


    private int percursoPos(Node<Comparable> p) {
        int altura = -1;
        if (p != null) {
            int altNoEsquerdo = percursoPos(p.esquerda);
            int altNoDireito = percursoPos(p.direita);
            altura = (altNoEsquerdo > altNoDireito) ? altNoEsquerdo : altNoDireito;
            altura++;
        }
        return altura;
    }

    public int alturaArvore() {
        int altura = percursoPos(raiz);
        return altura+1; // 1 somado por conta da raiz inical
    }

    private int altura(Node<Comparable> p){
        if (p == null)
            return 0;
        return 1 + Math.max(altura(p.esquerda), altura(p.direita));
    }

    private boolean estaBalanceada(Node<Comparable> p){
        int alturaEsquerda;
        int alturaDireita;

        if (p == null)
            return true;
        alturaEsquerda = altura(p.esquerda);
        alturaDireita = altura(p.direita);
        if (Math.abs(alturaEsquerda - alturaDireita) <= 1 && estaBalanceada(p.esquerda) && estaBalanceada(p.direita))
            return true;
        return false;
    }

    public boolean isBalanceada(){
        return estaBalanceada(raiz);
    }

}



