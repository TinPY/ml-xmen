package ar.martinpy.mlxmen.controladores;

import ar.martinpy.mlxmen.modelo.Dna;
import ar.martinpy.mlxmen.modelo.Stats;
import ar.martinpy.mlxmen.servicios.ServicioXmen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorXmen {

    @Autowired
    ServicioXmen servicioXmen;

    @RequestMapping("/")
    public String home() {
        return "Holis!";
    }

    @RequestMapping(value = "/mutant", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> esMutante(@RequestBody Dna dnaParametro) {

        // OBTENER DNA y DETECTAR MUTANTE
        boolean resultado = servicioXmen.isMutant(dnaParametro.getDna());

        // GUARDAR DNA
        dnaParametro.setMutant(resultado);
        this.servicioXmen.guardarDna(dnaParametro);

        // GUARDAR STATS
        //* Recuperar Stats Anterior si existe
        //Stats stats = new Stats(123,456,0.2);
        Stats stats = this.servicioXmen.obtenerUltimoStats();

        //* count_human_dna ++
        stats.setCount_human_dna(stats.getCount_human_dna() + 1);
        //* if 'resultado' count_mutant_dna++
        if(resultado){
            stats.setCount_mutant_dna(stats.getCount_mutant_dna() + 1);
        }
        //* re calcular ratio
        stats.setRatio( stats.getCount_mutant_dna().doubleValue() / stats.getCount_human_dna().doubleValue()) ;
        //* guardar stats
        this.servicioXmen.guardarStats(stats);

        if(resultado){
            return ResponseEntity.status(HttpStatus.OK).body(dnaParametro);
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dnaParametro);
        }

    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> stats() {

        // Obtener Stats
        Stats stats = this.servicioXmen.obtenerUltimoStats();

        return ResponseEntity.status(HttpStatus.OK).body(stats);

    }

    @RequestMapping(value = "/reiniciarstats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> reiniciarStats() {

        // Obtener Stats y Setear a 0

        Stats stats = this.servicioXmen.obtenerUltimoStats();
        stats.setCount_mutant_dna(0);
        stats.setCount_human_dna(0);
        stats.setRatio(0.0);

        // Actualizar Stats
        this.servicioXmen.guardarStats(stats);

        // Borrar todos los Dna
        this.servicioXmen.borrarTodosDna();

        return ResponseEntity.status(HttpStatus.OK).body(stats);

    }
}
