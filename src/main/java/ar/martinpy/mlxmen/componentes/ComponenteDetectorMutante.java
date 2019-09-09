package ar.martinpy.mlxmen.componentes;


import org.springframework.stereotype.Component;

@Component
public class ComponenteDetectorMutante {

    public ComponenteDetectorMutante() {
    }

    public boolean isMutant(String[] dna){

        //return Math.random() < 0.5;

        return false;

    }

}
