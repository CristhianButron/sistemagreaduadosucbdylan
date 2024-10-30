package bo.edu.ucb.sistemagraduados.controller;

import bo.edu.ucb.sistemagraduados.dto.EstudiantesDto;
import bo.edu.ucb.sistemagraduados.service.EstudiantesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/estudiantes")
@CrossOrigin(origins = "*")
public class EstudiantesController {

    @Autowired
    EstudiantesService estudiantesService;

    @GetMapping("/getEstudiantes")
    @ResponseBody
    public List<EstudiantesDto> listaEstudiantes() {
        return estudiantesService.findAll();
    }

    @GetMapping("/getEstudiantes/{id}")
    @ResponseBody
    public EstudiantesDto getEstudianteById(@PathVariable Integer id) {
        return estudiantesService.findById(id);
    }
    
    @PostMapping("/postEstudiantes")
    @ResponseBody
    public ResponseEntity<EstudiantesDto> saveEstudiante(@RequestBody EstudiantesDto estudiantesDto) {
        EstudiantesDto savedEstudianteDto = estudiantesService.save(estudiantesDto);
        return ResponseEntity.ok(savedEstudianteDto);
    }
    
    @DeleteMapping("/deleteEstudiantes/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteEstudiante(@PathVariable Integer id) {
        estudiantesService.delete(id);
        return ResponseEntity.ok("Estudiante eliminado correctamente");
    }
}

