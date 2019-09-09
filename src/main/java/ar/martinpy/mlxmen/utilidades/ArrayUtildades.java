package ar.martinpy.mlxmen.utilidades;

import com.google.api.gax.rpc.OutOfRangeException;

public class ArrayUtildades {

    public static char[][] convertirVectorStringsACharArray(String[] vector) throws OutOfRangeException{

        char[][] resultado = new char[vector.length][vector.length];

        try{
            for(int i=0; i<vector.length;i++){
                char[] caracter = vector[i].toCharArray();
                for(int j = 0 ; j<caracter.length ; j++){
                    resultado[i][j] = caracter[j];
                }
            }
            return resultado;
        }catch(OutOfRangeException ore){
            ore.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }



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
