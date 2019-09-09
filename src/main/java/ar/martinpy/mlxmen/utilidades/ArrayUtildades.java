package ar.martinpy.mlxmen.utilidades;

public class ArrayUtildades {

    public static char[][] convertirVectorStringsACharArray(String[] vector){

        char[][] resultado = new char[vector.length][vector.length];

        for(int i=0; i<vector.length;i++){

            char[] cadena = vector[i].toCharArray();

            for(int j = 0 ; j<cadena.length ; j++){
                resultado[i][j] = cadena[j];
            }
        }
        return resultado;

    }

    public static void imprimirArray(char[][] array){

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println(" ");
        }
    }

}
