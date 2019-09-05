package ar.martinpy.mlxmen.servicios;

import ar.martinpy.mlxmen.modelo.Dna;
import ar.martinpy.mlxmen.modelo.Stats;
import ar.martinpy.mlxmen.repositorios.RepositorioDna;
import ar.martinpy.mlxmen.repositorios.RepositorioStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioXmenImplementacion implements ServicioXmen {

    @Autowired
    RepositorioStats repositorioStats;

    @Autowired
    RepositorioDna repositorioDna;

    @Override
    public Stats obtenerStatsPorId(Long id) {
        Optional<Stats> stats = this.repositorioStats.findById(id);

        if(stats.isPresent()){
            return stats.get();
        }else{
            return null;
        }
    }

    @Override
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
    public Dna obtenerDnaPorId(Long id) {

        Optional<Dna> dna = this.repositorioDna.findById(id);

        if(dna.isPresent()){
            return dna.get();
        }else{
            return null;
        }

    }

    @Override
    public boolean guardarDna(Dna dna) {
        try{
            this.repositorioDna.save(dna);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
