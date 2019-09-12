package ar.martinpy.mlxmen.servicios;

import ar.martinpy.mlxmen.componentes.ComponenteDetectorMutante;
import ar.martinpy.mlxmen.modelo.Dna;
import ar.martinpy.mlxmen.modelo.Stats;
import ar.martinpy.mlxmen.repositorios.RepositorioDna;
import ar.martinpy.mlxmen.repositorios.RepositorioStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class ServicioXmenImplementacion implements ServicioXmen {

    @Autowired
    RepositorioStats repositorioStats;

    @Autowired
    RepositorioDna repositorioDna;

    @Autowired
    ComponenteDetectorMutante componenteDetectorMutante;

    @Override
    @Transactional(readOnly = true)
    public Stats obtenerStatsPorId(Long id) {
        Optional<Stats> stats = this.repositorioStats.findById(id);

        if(stats.isPresent()){
            return stats.get();
        }else{
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Stats obtenerUltimoStats() {
        Stats stats = new Stats(0,0,0.0);

        try{
            List<Stats> estadisticas = this.repositorioStats.findAll();

            if(!estadisticas.isEmpty()){
                stats = estadisticas.get(0);
            }
            return stats;

        }catch(Exception e){
            e.printStackTrace();
            return stats;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Stats> obtenerTodos() {
        try{
            List<Stats> estadisticas = this.repositorioStats.findAll();

            if(estadisticas == null){
                return new ArrayList<>();
            }
            return estadisticas;
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    @Transactional
    public boolean guardarStats(Stats stats) {
        try{
            this.repositorioStats.save(stats);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Dna obtenerDnaPorId(Long id) {

        Optional<Dna> dna = this.repositorioDna.findById(id);

        if(dna.isPresent()){
            return dna.get();
        }else{
            return null;
        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<Dna> obtenerTodosDna() {
        return this.repositorioDna.findAll();
    }

    @Override
    @Transactional
    public boolean guardarDna(Dna dna) {

        try{
            this.repositorioDna.save(dna);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public boolean borrarTodosDna() {
        try{
            this.repositorioDna.deleteAll();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isMutant(String[] dna) {

        return componenteDetectorMutante.isMutant(dna);

    }


}
