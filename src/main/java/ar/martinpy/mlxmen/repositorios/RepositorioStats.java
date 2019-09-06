package ar.martinpy.mlxmen.repositorios;

import ar.martinpy.mlxmen.modelo.Dna;
import ar.martinpy.mlxmen.modelo.Stats;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import java.util.List;
import java.util.Optional;


public interface RepositorioStats extends DatastoreRepository<Stats, Long> {

    Optional<Stats> findById(Long id);
    List<Stats> findAll();

}