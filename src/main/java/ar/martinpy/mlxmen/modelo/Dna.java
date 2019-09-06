package ar.martinpy.mlxmen.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "dna")
public class Dna {

    @Id
    private Long id;

    private String[] dna;

    private Boolean isMutant = false;

    public Dna() {

    }

    public Long getId() {
        return id;
    }

    public Boolean getMutant() {
        return isMutant;
    }

    public void setMutant(Boolean mutant) {
        isMutant = mutant;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dna dna1 = (Dna) o;
        return Objects.equals(dna, dna1.dna);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dna);
    }

    @Override
    public String toString() {
        return "Dna{" +
                "dna=" + dna.toString() + " es mutante: " + this.getMutant() +
                '}';
    }
}
