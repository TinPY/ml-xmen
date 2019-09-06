package ar.martinpy.mlxmen.servicios;

import ar.martinpy.mlxmen.modelo.Dna;
import ar.martinpy.mlxmen.modelo.Stats;

import java.util.List;

public interface ServicioXmen {

    Stats obtenerStatsPorId(Long id);
    List<Stats> obtenerTodos();
    boolean guardarStats(Stats stats);

    Dna obtenerDnaPorId(Long id);
    boolean guardarDna(Dna dna);

    boolean isMutant(String[] dna);


}
