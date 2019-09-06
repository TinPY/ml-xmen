package ar.martinpy.mlxmen.modelo;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.util.Objects;


@Entity(name = "stats")
public class Stats {

    @Id
    Long id;
    Integer count_mutant_dna = 0;
    Integer count_human_dna = 0;
    Double ratio = 0.0;

    public Stats(Integer count_mutant_dna, Integer count_human_dna, Double ratio) {
        this.count_mutant_dna = count_mutant_dna;
        this.count_human_dna = count_human_dna;
        this.ratio = ratio;
    }

    public Long getId() {
        return id;
    }

    public Integer getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public void setCount_mutant_dna(Integer count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public Integer getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(Integer count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return Objects.equals(id, stats.id) &&
                Objects.equals(count_mutant_dna, stats.count_mutant_dna) &&
                Objects.equals(count_human_dna, stats.count_human_dna) &&
                Objects.equals(ratio, stats.ratio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count_mutant_dna, count_human_dna, ratio);
    }

    @Override
    public String toString() {
        return "Stats{" +
                "id=" + id +
                ", count_mutant_dna=" + count_mutant_dna +
                ", count_human_dna=" + count_human_dna +
                ", ratio=" + ratio +
                '}';
    }
}
