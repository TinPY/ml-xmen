package ar.martinpy.mlxmen.componentes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ComponenteDetectorMutanteTest {

    ComponenteDetectorMutante componenteDetectorMutante = new ComponenteDetectorMutante();

    @Test
    public void isMutant_falla_deOne(){

        String[] vectorStrings = new String[6];

        Assert.assertFalse(componenteDetectorMutante.isMutant(vectorStrings));
    }

}