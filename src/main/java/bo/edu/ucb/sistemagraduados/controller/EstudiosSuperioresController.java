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

import bo.edu.ucb.sistemagraduados.dto.EstudiosSuperioresDto;
import bo.edu.ucb.sistemagraduados.service.EstudiosSuperioresService;

@RestController
@RequestMapping("/api/v1/estudios-superiores")
@CrossOrigin (origins = "*")
public class EstudiosSuperioresController {

    @Autowired
    private EstudiosSuperioresService estudiosSuperioresService;
    
    @GetMapping("/getEstudiosSuperiores/{id}")
    @ResponseBody
    public ResponseEntity<EstudiosSuperioresDto> getEstudiosSuperioresById(@PathVariable Integer id) {
        EstudiosSuperioresDto estudiosSuperioresDto = estudiosSuperioresService.findById(id);
        if (estudiosSuperioresDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudiosSuperioresDto);
    }

    @GetMapping("/getEstudiosSuperiores")
    @ResponseBody
    public ResponseEntity<List<EstudiosSuperioresDto>> getEstudiosSuperiores() {
        List<EstudiosSuperioresDto> estudiosSuperioresDto = estudiosSuperioresService.findAll();
        if (estudiosSuperioresDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudiosSuperioresDto);
    }

    @PostMapping ("/saveEstudiosSuperiores")
    @ResponseBody
    public ResponseEntity<EstudiosSuperioresDto> saveEstudiosSuperiores(@RequestBody EstudiosSuperioresDto estudiosSuperioresDto) {
        EstudiosSuperioresDto savedEstudiosSuperioresDto = estudiosSuperioresService.save(estudiosSuperioresDto);
        return ResponseEntity.ok(savedEstudiosSuperioresDto);
    }

    @DeleteMapping("/deleteEstudiosSuperiores/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteEstudiosSuperiores(@PathVariable Integer id) {
        estudiosSuperioresService.deleteById(id);
        return ResponseEntity.ok().body("Estudios superiores eliminados correctamente");
    }

    @PutMapping("/updateEstudiosSuperiores/{id}")
    @ResponseBody
    public ResponseEntity<EstudiosSuperioresDto> updateEstudiosSuperiores(@PathVariable Integer id, @RequestBody EstudiosSuperioresDto estudiosSuperioresDto) {
        EstudiosSuperioresDto updatedEstudiosSuperioresDto = estudiosSuperioresService.update(id, estudiosSuperioresDto);
        return ResponseEntity.ok(updatedEstudiosSuperioresDto);
    }
}
