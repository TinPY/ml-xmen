package ar.martinpy.mlxmen.componentes;

import ar.martinpy.mlxmen.utilidades.GeneradorVectores;
import com.google.api.gax.rpc.OutOfRangeException;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComponenteDetectorMutanteTest {

    @Autowired
    ComponenteDetectorMutante componenteDetectorMutante;

    @Test
    @Ignore
    public void isMutant_fallaDeOne(){

        String[] vectorPrueba = new String[6];

        Assert.assertFalse(componenteDetectorMutante.isMutant(vectorPrueba));
    }

    @Test
    public void isMutant_recibeArrayMutanteTamanio4_retornaVerdadero(){
        String[] vectorPrueba = GeneradorVectores.generarArrayEjemploMutanteTamanio4();
        boolean resultado = componenteDetectorMutante.isMutant(vectorPrueba);

        Assert.assertEquals(4,vectorPrueba.length);
        Assert.assertTrue(resultado);
    }

    @Test
    public void isMutant_recibeArrayNOMutanteTamanio4_retornaFalse(){
        String[] vectorPrueba = GeneradorVectores.generarArrayEjemploNOMutanteTamanio4();
        boolean resultado = componenteDetectorMutante.isMutant(vectorPrueba);

        Assert.assertEquals(4,vectorPrueba.length);
        Assert.assertFalse(resultado);
    }

    @Test
    public void isMutant_recibeArrayMutanteTamanio5_retornaVerdadero(){
        String[] vectorPrueba = GeneradorVectores.generarArrayEjemploMutanteTamanio5();
        boolean resultado = componenteDetectorMutante.isMutant(vectorPrueba);

        Assert.assertEquals(5,vectorPrueba.length);
        Assert.assertTrue(resultado);
    }

    @Test
    public void isMutant_recibeArrayNOMutanteTamanio5_retornaFalso(){
        String[] vectorPrueba = GeneradorVectores.generarArrayEjemploNOMutanteTamanio5();
        boolean resultado = componenteDetectorMutante.isMutant(vectorPrueba);

        Assert.assertEquals(5,vectorPrueba.length);
        Assert.assertFalse(resultado);
    }

    @Test
    public void isMutant_recibeArrayMutanteTamanio6_retornaVerdadero(){

        String[] vectorPrueba = GeneradorVectores.generarArrayEjemploMutanteTamanio6();
        boolean resultado = componenteDetectorMutante.isMutant(vectorPrueba);

        Assert.assertEquals(6,vectorPrueba.length);
        Assert.assertTrue(resultado);

    }

    @Test
    public void isMutant_recibeArrayNoMutanteTamanio6_retornaFalso(){
        String[] vectorPrueba = GeneradorVectores.generarArrayEjemploNOMutanteTamanio6();
        boolean resultado = componenteDetectorMutante.isMutant(vectorPrueba);

        Assert.assertFalse(resultado);
    }

//    @Test(expected = OutOfRangeException.class)
//    @Test
//    public void isMutante_arrayNoCuadrado_retornaFalso(){
//        String[] vectorPrueba = GeneradorVectores.generarArrayTamanio5ParaOutOfRangeException();
//
//        //Assertions.assertThrows(OutOfRangeException.class, () -> this.componenteDetectorMutante.isMutant(vectorPrueba));
//
//        boolean resultado = this.componenteDetectorMutante.isMutant(vectorPrueba);
//
//        Assert.assertTrue(resultado);
//    }


}