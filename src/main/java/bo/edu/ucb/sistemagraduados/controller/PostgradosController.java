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

import bo.edu.ucb.sistemagraduados.dto.PostgradosDto;
import bo.edu.ucb.sistemagraduados.service.PostgradosService;


@RestController
@RequestMapping("/api/v1/postgrados")
@CrossOrigin(origins = "*")
public class PostgradosController {
    
    @Autowired
    private PostgradosService posgradosService;

    @GetMapping ("/getPostgrados/{id}")
    @ResponseBody
    public ResponseEntity<PostgradosDto> getPostgradosById(@PathVariable Integer id) {
        PostgradosDto postgradosDto = posgradosService.findById(id);
        if (postgradosDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postgradosDto);
    }

    @GetMapping("/obtenerPostgrados")
    public ResponseEntity<List<PostgradosDto>> listaPostgrados() {
        return ResponseEntity.ok(posgradosService.findAll());
    }

    
    @PostMapping ("/postPostgrados")
    @ResponseBody
    public ResponseEntity<PostgradosDto> savePostgrados(@RequestBody PostgradosDto postgradosDto) {
        PostgradosDto postgradosDtoSaved = posgradosService.save(postgradosDto);
        return ResponseEntity.ok(postgradosDtoSaved);
    }

    @DeleteMapping("/deletePostgrados/{id}")
    @ResponseBody
    public ResponseEntity<String> deletePostgrados(@PathVariable Integer id) {
        posgradosService.deleteById(id);
        return ResponseEntity.ok("Postgrado eliminado correctamente");
    }

    @PutMapping ("/putPostgrados/{id}")
    @ResponseBody
    public ResponseEntity<PostgradosDto> updatePostgrados(@PathVariable Integer id, @RequestBody PostgradosDto postgradosDto) {
        PostgradosDto postgradosDtoUpdated = posgradosService.update(id, postgradosDto);
        return ResponseEntity.ok(postgradosDtoUpdated);
    }
}
