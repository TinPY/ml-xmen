package ar.martinpy.mlxmen.utilidades;

import java.util.HashMap;
import java.util.Map;

public class GeneradorVectores {

    public static String[] generarArrayEjemploMutanteTamanio4(){
        String[] resultado = new String[4];
        resultado[0] = "ATGA";
        resultado[1] = "CAAT";
        resultado[2] = "TAAC";
        resultado[3] = "AGCA";

        return resultado;
    }

    public static String[] generarArrayEjemploNOMutanteTamanio4(){
        String[] resultado = new String[4];
        resultado[0] = "ATGA";
        resultado[1] = "CACT";
        resultado[2] = "TGAC";
        resultado[3] = "AGCC";

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

    public static String[] generarArrayTamanio5ParaOutOfRangeException(){

        String[] resultado = new String[5];
        resultado[0] = "ATC";
        resultado[1] = "CAGTG";
        resultado[2] = "TATG";
        resultado[3] = "AGAAG";

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

    public static String[] generarArrayEjemploNOMutanteTamanio5(){
        String[] resultado = new String[5];
        resultado[0] = "ATGCG";
        resultado[1] = "CAGTG";
        resultado[2] = "TTCTG";
        resultado[3] = "AGAAG";
        resultado[4] = "CACCT";

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
