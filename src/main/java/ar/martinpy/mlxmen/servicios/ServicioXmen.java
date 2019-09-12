package ar.martinpy.mlxmen.servicios;

import ar.martinpy.mlxmen.modelo.Dna;
import ar.martinpy.mlxmen.modelo.Stats;

import java.util.List;

public interface ServicioXmen {

    Stats obtenerStatsPorId(Long id);
    Stats obtenerUltimoStats();
    List<Stats> obtenerTodos();
    boolean guardarStats(Stats stats);

    Dna obtenerDnaPorId(Long id);
    List<Dna> obtenerTodosDna();
    boolean guardarDna(Dna dna);
    boolean borrarTodosDna();

    boolean isMutant(String[] dna);


}
