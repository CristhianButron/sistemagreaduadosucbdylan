package bo.edu.ucb.sistemagraduados.controller;

import bo.edu.ucb.sistemagraduados.dto.CarrerasDto;
import bo.edu.ucb.sistemagraduados.service.CarrerasService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/carreras")
@CrossOrigin(origins = "*")
public class CarrerasController {

    @Autowired
    private CarrerasService carrerasService;

    @GetMapping("/obtenerCarreraById/{id}")
    public ResponseEntity<CarrerasDto> getCarrerasById(@PathVariable Integer id) {
        CarrerasDto carrerasDto = carrerasService.findById(id);
        if (carrerasDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carrerasDto);
    }

    @GetMapping("/obtenerCarreras")
    public ResponseEntity<List<CarrerasDto>> listaCarreras() {
        return ResponseEntity.ok(carrerasService.findAll());
    }

    @GetMapping("/obtenerCarreraByNombre/{nombre}")
    public ResponseEntity<CarrerasDto> getCarreraByNombre(@PathVariable String nombre) {
        CarrerasDto carrerasDto = carrerasService.findByNombre(nombre);
        if (carrerasDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carrerasDto);
    }

    @GetMapping("/obtenerCarreraBySigla/{sigla}")
    public ResponseEntity<CarrerasDto> getCarreraBySigla(@PathVariable String sigla) {
        CarrerasDto carrerasDto = carrerasService.findBySigla(sigla);
        if (carrerasDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carrerasDto);
    }
    
    
    @PostMapping("/guardarCarrera")
    public ResponseEntity<CarrerasDto> savePersona(@RequestBody CarrerasDto carrerasDto) {
        CarrerasDto savedCarrerasDto = carrerasService.save(carrerasDto);
        return ResponseEntity.ok(savedCarrerasDto);
    }
    
    @PutMapping("/updateCarrera/{id}")
    public ResponseEntity<CarrerasDto> updateCarrera(@PathVariable Integer id, @RequestBody CarrerasDto carrerasDto) {
        CarrerasDto updatedCarrerasDto = carrerasService.update(id, carrerasDto);
        return ResponseEntity.ok(updatedCarrerasDto);
    }

    @DeleteMapping("/deleteCarrera/{id}")
    public ResponseEntity<String> deleteCarrera(@PathVariable Integer id) {
        carrerasService.deleteById(id);
        return ResponseEntity.ok("Carrera eliminada correctamente");
    }
}
