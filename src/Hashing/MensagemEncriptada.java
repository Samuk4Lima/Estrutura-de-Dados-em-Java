package Hashing;

public class MensagemEncriptada {

    public static String encrypt(String dictionary, String phrase) {

        TabelaHash tabelaHash = new TabelaHash(30);
        String str = "";
        tabelaHash.add(" -0");
        String[] valores = dictionary.split(" ");
        for(String i : valores){
            tabelaHash.add(i);
        }

        for(int i = 0; i < phrase.length(); i++){
            str = str + tabelaHash.encryptInput(Character.toString(phrase.charAt(i))) + " ";
        }

        return str;
    }

    public static void main(String[] args) {
        String dictionary = "a-83 d-75 e-72 i-52 m-38 o-11 p-14 r-71 t-51 u-8";
        String phrase = "o rAto rOeu A roupA dO rEi de rOma";

        String result = MensagemEncriptada.encrypt(dictionary, phrase);

        System.out.println(result);
    }

}