package bo.edu.ucb.sistemagraduados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.sistemagraduados.dto.TrabajosDto;
import bo.edu.ucb.sistemagraduados.service.TrabajosService;



import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/v1/trabajos")
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "Bearer Authentication")
public class TrabajosController {

    @Autowired
    private TrabajosService trabajosService;
    
    @GetMapping ("/getTrabajos/{id}")
    @ResponseBody
    public ResponseEntity<TrabajosDto> getTrabajosById(@PathVariable Integer id) {
        TrabajosDto trabajosDto = trabajosService.findById(id);
        if (trabajosDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trabajosDto);
    }

    @GetMapping("/obtenerTrabajos")
    public ResponseEntity<List<TrabajosDto>> listaPostgrados() {
        return ResponseEntity.ok(trabajosService.findAll());
    }
    
    @PostMapping ("/postTrabajos")
    @ResponseBody
    public ResponseEntity<TrabajosDto> saveTrabajos(@RequestBody TrabajosDto trabajosDto) {
        TrabajosDto trabajosDtoSaved = trabajosService.save(trabajosDto);
        return ResponseEntity.ok(trabajosDtoSaved);
    }

    @DeleteMapping("/deleteTrabajos/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteTrabajos(@PathVariable Integer id) {
        trabajosService.deleteById(id);
        return ResponseEntity.ok("Trabajo eliminado correctamente");
    }

    @PutMapping ("/putTrabajos/{id}")
    @ResponseBody
    public ResponseEntity<TrabajosDto> updateTrabajos(@PathVariable Integer id, @RequestBody TrabajosDto trabajosDto) {
        TrabajosDto trabajosDtoSaved = trabajosService.update(id, trabajosDto);
        return ResponseEntity.ok(trabajosDtoSaved);
    }
    
}