package ar.martinpy.mlxmen.componentes;


import ar.martinpy.mlxmen.utilidades.ArrayUtildades;
import org.springframework.stereotype.Component;

@Component
public class ComponenteDetectorMutante {

    public ComponenteDetectorMutante() {
    }

    public boolean isMutant(String[] dna) {

        char[][] arrayDna;

        // Preparacion
        try{
            arrayDna = ArrayUtildades.convertirVectorStringCuadradoACharArrayCuadrado(dna);
        }catch(ArrayIndexOutOfBoundsException aiob){
            //aiob.printStackTrace();
            return false;
        }

        int n = arrayDna.length;
        int tamañoPatron = 4;                   // tamaño de la palabra (en este caso 4 letras)
        int posicionPatron = tamañoPatron - 1;  // para las diagonales arriba-izq hacia abajo-der
        int k = n - tamañoPatron;               // para 5 == 1 | para 6 == 2  | etc...
        int jd = k;

        int secuenciasMutantes = 0;

        char letraAnteriorHorizontal;
        char letraAnteriorVertical;
        char letraAnteriorDiagonalPrincipal;
        char letraAnteriorIzquierda;
        char letraAnteriorDerecha;
        char letraAnteriorArriba;
        char letraAnteriorAbajo;

        int contadorLetrasHorizontal;
        int contadorLetrasVertical;
        int contadorLetrasDiagonalPrincipal;
        int contadorLetrasIzquierda;
        int contadorLetrasDerecha;
        int contadorLetrasArriba;
        int contadorLetrasAbajo;

        // Inicio de Busqueda

        for(int i = 0; i < n ; i++){

            letraAnteriorHorizontal             = ' ';
            letraAnteriorVertical               = ' ';
            letraAnteriorDiagonalPrincipal      = ' ';
            letraAnteriorIzquierda              = ' ';
            letraAnteriorDerecha                = ' ';
            letraAnteriorArriba                 = ' ';
            letraAnteriorAbajo                  = ' ';
            contadorLetrasHorizontal            = 1;
            contadorLetrasVertical              = 1;
            contadorLetrasDiagonalPrincipal     = 1;
            contadorLetrasIzquierda             = 1;
            contadorLetrasDerecha               = 1;
            contadorLetrasArriba                = 1;
            contadorLetrasAbajo                 = 1;

            for(int j = 0; j < n ; j++){

                int filaAbajo = n-1;

                // HORIZONTAL
                if(arrayDna[i][j] == letraAnteriorHorizontal){
                    if(++contadorLetrasHorizontal == 4){
                        //System.out.println("ENCONTRADO EN HORIZONTAL");
                        if(++secuenciasMutantes > 1){
                            return true;
                        }
                    }
                }else{
                    contadorLetrasHorizontal = 1;
                }
                letraAnteriorHorizontal = arrayDna[i][j];

                // VERTICAL
                if(arrayDna[j][i] == letraAnteriorVertical){
                    if(++contadorLetrasVertical == 4){
                        //System.out.println("ENCONTRADO EN VERTICAL");
                        if(++secuenciasMutantes > 1){
                            return true;
                        }
                    }
                }else{
                    contadorLetrasVertical = 1;
                }

                letraAnteriorVertical = arrayDna[j][i];

                // DIAGONAL PRINCIPAL \
                if(i==0){
                    if(arrayDna[j][j] == letraAnteriorDiagonalPrincipal){
                        if(++contadorLetrasDiagonalPrincipal == 4){
                            //System.out.println("ENCONTRADO EN DIAGONAL PRINCIPAL");
                            if(++secuenciasMutantes > 1){
                                return true;
                            }
                        }
                    }else{
                        contadorLetrasDiagonalPrincipal = 1;
                    }

                    letraAnteriorDiagonalPrincipal = arrayDna[j][j];
                }

                // DIAGONALES \ IZQUIERDA y DERECHA
                if(i>=1 && i<=k && (i+j)<=n-1 ){
                    if(arrayDna[i+j][j] == letraAnteriorIzquierda){
                        if(++contadorLetrasIzquierda == 4){
                            //System.out.println("ENCONTRADO EN DIAGONAL \\ IZQUIERDA");
                            if(++secuenciasMutantes > 1){
                                return true;
                            }
                        }
                    }else{
                        contadorLetrasIzquierda = 1;
                    }

                    letraAnteriorIzquierda = arrayDna[i+j][j];

                    if(arrayDna[j][i+j] == letraAnteriorDerecha){
                        if(++contadorLetrasDerecha == 4){
                            //System.out.println("ENCONTRADO EN DIAGONAL \\ DERECHA");
                            if(++secuenciasMutantes > 1){
                                return true;
                            }
                        }
                    }else{
                        contadorLetrasDerecha = 1;
                    }

                    letraAnteriorDerecha = arrayDna[j][i+j];

                }

                //DIAGONAL / ARRIBA Y PRINCIPAL
                if(i>= posicionPatron && i-j >= 0){
                    int filaArriba = i-j;
                    if(arrayDna[filaArriba][j] == letraAnteriorArriba){
                        if(++contadorLetrasArriba == 4){
                            //System.out.println("ENCONTRADO EN DIAGONAL / ARRIBA O PRINCIPAL");
                            if(++secuenciasMutantes > 1){
                                return true;
                            }
                        }
                    }else{
                        contadorLetrasArriba = 1;
                    }

                    letraAnteriorArriba = arrayDna[filaArriba][j];

                }

                //DIAGONAL / ABAJO
                if(i>= posicionPatron && jd+j < n){
                    int columnaAbajo = jd+j;
                    filaAbajo = filaAbajo-j;

                    // NO repetir la diagonal principal /
                    if(columnaAbajo + filaAbajo >= n){
                        if(arrayDna[filaAbajo][columnaAbajo] == letraAnteriorAbajo){
                            if(++contadorLetrasAbajo == 4){
                                //System.out.println("ENCONTRADO EN DIAGONAL / ABAJO");
                                if(++secuenciasMutantes > 1){
                                    return true;
                                }
                            }
                        }else{
                            contadorLetrasAbajo = 1;
                        }

                        letraAnteriorAbajo = arrayDna[filaAbajo][columnaAbajo];
                    }
                }
            }

            if(i>=posicionPatron){
                jd--;
            }
        }

        return false;
    }
}
