package ar.martinpy.mlxmen.servicios;

import ar.martinpy.mlxmen.modelo.Dna;
import ar.martinpy.mlxmen.modelo.Stats;

public interface ServicioXmen {

    Stats obtenerStatsPorId(Long id);
    boolean guardarStats(Stats stats);

    Dna obtenerDnaPorId(Long id);
    boolean guardarDna(Dna dna);


}
