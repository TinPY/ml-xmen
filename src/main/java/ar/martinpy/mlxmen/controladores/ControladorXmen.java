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

        // Recibir DNA
        //dnaParametro.setMutant(true);
        


        // Detectar si es mutante

        // Guardar Dna

        // Guardar Stats

//        Dna dna = new Dna();
//        List<String> cadenas = new ArrayList<>();
//        cadenas.add("AACTGA");
//        cadenas.add("CCCTAA");
//        cadenas.add("ACTGGG");
//        cadenas.add("ACGTGA");
//        cadenas.add("GTTCCA");
//        cadenas.add("CCCCTG");
//        dna.setDna(cadenas);
//
//        dna.setMutant(true);
//
//
//        if(dna.getDna().size() == 6){
//            return ResponseEntity.status(HttpStatus.OK).body(dna);
//        } else {
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }

        return ResponseEntity.status(HttpStatus.OK).body(dnaParametro);

    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> esMutante() {

        // Guardar Stats
//        Stats stats = new Stats(2,10,0.2);
//
//        if (this.servicioXmen.guardarStats(stats)) {
//            return ResponseEntity.status(HttpStatus.OK).body(stats);
//        } else {
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
