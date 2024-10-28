package bo.edu.ucb.sistemagraduados.controller;

import bo.edu.ucb.sistemagraduados.dto.CarrerasDto;
import bo.edu.ucb.sistemagraduados.service.CarrerasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carreras")
@CrossOrigin(origins = "*")
public class CarrerasController {

    @Autowired
    private CarrerasService carrerasService;

    @GetMapping("/getCarrera/{id}")
    public ResponseEntity<CarrerasDto> getCarrerasById(@PathVariable Integer id) {
        CarrerasDto carrerasDto = carrerasService.findById(id);
        if (carrerasDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carrerasDto);
    }

    @PostMapping("/saveCarrera")
    public ResponseEntity<CarrerasDto> savePersona(@RequestBody CarrerasDto carrerasDto) {
        CarrerasDto savedCarrerasDto = carrerasService.save(carrerasDto);
        return ResponseEntity.ok(savedCarrerasDto);
    }
}
