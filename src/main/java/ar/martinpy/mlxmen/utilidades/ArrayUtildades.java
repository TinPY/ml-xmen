package ar.martinpy.mlxmen.utilidades;

public class ArrayUtildades {

    public static char[][] convertirVectorStringCuadradoACharArrayCuadrado(String[] vector) throws ArrayIndexOutOfBoundsException{

        int tamanio = vector.length;

        char[][] resultado = new char[tamanio][tamanio];

        for(int i=0; i<tamanio;i++){
            char[] cadena = vector[i].toCharArray();
            for(int j = 0 ; j < tamanio ; j++){
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
