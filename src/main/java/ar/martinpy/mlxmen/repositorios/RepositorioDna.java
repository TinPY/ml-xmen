package ar.martinpy.mlxmen.repositorios;

import java.util.List;
import java.util.Optional;

import ar.martinpy.mlxmen.modelo.Dna;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;


public interface RepositorioDna extends DatastoreRepository<Dna, Long> {

    Optional<Dna> findById(Long id);
    List<Dna> findAll();

}