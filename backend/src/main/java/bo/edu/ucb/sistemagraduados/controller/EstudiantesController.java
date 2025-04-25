package bo.edu.ucb.sistemagraduados.controller;

import bo.edu.ucb.sistemagraduados.dto.EstudiantesDto;
import bo.edu.ucb.sistemagraduados.service.EstudiantesService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/v1/estudiantes")
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "Bearer Authentication")
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

    @PutMapping("/putEstudiantes/{id}")
    @ResponseBody
    public ResponseEntity<EstudiantesDto> updateEstudiante(@PathVariable Integer id, @RequestBody EstudiantesDto estudiantesDto) {
        EstudiantesDto updatedEstudianteDto = estudiantesService.update(id, estudiantesDto);
        return ResponseEntity.ok(updatedEstudianteDto);
    }
    
    @DeleteMapping("/deleteEstudiantes/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteEstudiante(@PathVariable Integer id) {
        estudiantesService.delete(id);
        return ResponseEntity.ok("Estudiante eliminado correctamente");
    }

    @GetMapping ("/getEstudiantesByFechasIngreso/{FechaInicio}/{FechaFin}")
    @ResponseBody
    public List<EstudiantesDto> getEstudiantesByFechas(@PathVariable LocalDate FechaInicio, @PathVariable LocalDate FechaFin) {
        return estudiantesService.findByFechasIngresoBetween(FechaInicio, FechaFin);
    }

    @GetMapping ("/getEstudiantesByFechasFin/{FechaInicio}/{FechaFin}")
    @ResponseBody
    public List<EstudiantesDto> getEstudiantesByFechasFin(@PathVariable LocalDate FechaInicio, @PathVariable LocalDate FechaFin) {
        return estudiantesService.findByFechasFinBetween(FechaInicio, FechaFin);
    }

}

