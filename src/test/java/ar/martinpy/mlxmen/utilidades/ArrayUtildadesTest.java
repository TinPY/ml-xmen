package ar.martinpy.mlxmen.utilidades;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

public class ArrayUtildadesTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertirVectorStringsACharArray_vectorTamanioIncorrecto_ThrowsOutOfRangeExceptionAndFalse(){

        String[] vector = GeneradorVectores.generarArrayTamanio5ParaOutOfRangeException();

        char[][] array = ArrayUtildades.convertirVectorStringCuadradoACharArrayCuadrado(vector);

        Assert.assertNull(array);

    }

    @Test
    public void convertirVectorStringsACharArray_vectorCorrecto_retornaCharArray(){
        String[] vector = GeneradorVectores.generarArrayEjemploNOMutanteTamanio6();

        char[][] array  = ArrayUtildades.convertirVectorStringCuadradoACharArrayCuadrado(vector);

        Assert.assertNotNull(array);

        Assert.assertEquals(6,array.length);
    }

}