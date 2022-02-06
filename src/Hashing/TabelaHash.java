package Hashing;



public class TabelaHash {
    private List<String> tabela[];
    private int tam;

    public TabelaHash(int tam){
        this.tam = 0;
        tabela = new List[tam];
        for(int i = 0; i < tabela.length; i++){
            tabela[i] = new List<>();
        }
    }


    public void add(String e){
        String[] valores = e.split("-");
        int hash = funcaoHash(e);
        if(!procurar(e)){
            tabela[hash].add(e.toLowerCase());
            tam++;
        }

    }

    private int funcaoHash(String elem){
        String[] valores = elem.split("-");
        return valores[0].hashCode() % this.tabela.length;
    }

    public boolean procurar(String e){

        int hash = funcaoHash(e);

        return tabela[hash].contains(e);


    }

    public int encryptInput(String valor){
        String letra = valor.toLowerCase();
        Integer r = null;

        int hash = funcaoHash(letra);
        for(int i = 0; i < tabela[hash].size(); i++){
            String[] valores = tabela[hash].get(i).split("-");
            if(valores[0].equalsIgnoreCase(letra)){
                r = Integer.parseInt(valores[1]);
                break;
            }
        }

        return r;
    }

    public int size(){
        return tam;
    }

}