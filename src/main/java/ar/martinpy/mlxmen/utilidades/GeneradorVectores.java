package ar.martinpy.mlxmen.utilidades;

import java.util.HashMap;
import java.util.Map;

public class GeneradorVectores {

    public static String[] generarArrayEjemploMutanteTamanio6B(){
        String[] resultado = new String[6];
        resultado[0] = "ATGAGT";
        resultado[1] = "CAATCC";
        resultado[2] = "TAACTT";
        resultado[3] = "AGCATG";
        resultado[4] = "CACTTA";
        resultado[5] = "ACTCTG";

        return resultado;
    }

    public static String[] generarArrayEjemploMutanteTamanio6C(){
        String[] resultado = new String[6];
        resultado[0] = "ATGAGT";
        resultado[1] = "CAATCC";
        resultado[2] = "TTTTTC";
        resultado[3] = "AGCATG";
        resultado[4] = "CTCTAA";
        resultado[5] = "ACTCTG";

        return resultado;
    }

    public static String[] generarArrayEjemploMutanteTamanio6(){
        String[] resultado = new String[6];
        resultado[0] = "ATGCGA";
        resultado[1] = "CAGTGC";
        resultado[2] = "TTATGT";
        resultado[3] = "AGAAGG";
        resultado[4] = "CCCCTA";
        resultado[5] = "TCACTG";

        return resultado;
    }

    public static String[] generarArrayEjemploNOMutanteTamanio6(){
        String[] resultado = new String[6];
        resultado[0] = "ATGCGA";
        resultado[1] = "CAGTGC";
        resultado[2] = "TTATTT";
        resultado[3] = "AGACGG";
        resultado[4] = "GCGTCA";
        resultado[5] = "TCACTG";

        return resultado;
    }

    public static String[] generarArrayEjemploMutanteTamanio5(){
        String[] resultado = new String[5];
        resultado[0] = "ATGCG";
        resultado[1] = "CAGTG";
        resultado[2] = "TTATG";
        resultado[3] = "AGAAG";
        resultado[4] = "CCCCT";

        return resultado;
    }

    public static String[] generarArrayAleatorio(int tamanio){

        Map<Integer,String> letras = new HashMap<>();
        letras.put(1,"A");
        letras.put(2,"T");
        letras.put(3,"C");
        letras.put(4,"G");

        String[] arrayResultado = new String[tamanio];
        StringBuilder sb;

        int numeroLetra;
        String letra;

        // fila
        for(int i=0; i < tamanio ; i++){

            sb = new StringBuilder();

            // cadena de array
            for(int j=0; j < tamanio ; j++){
                numeroLetra = (int) Math.round((Math.random() * 3) + 1);
                letra = letras.get(numeroLetra);
                sb.append(letra);
            }

            arrayResultado[i] = sb.toString();
            System.out.println("cadena resultado de fila >> " + sb.toString());

        }



        return arrayResultado;

    }
}
