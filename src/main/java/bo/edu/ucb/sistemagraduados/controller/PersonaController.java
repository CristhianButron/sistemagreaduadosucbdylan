package bo.edu.ucb.sistemagraduados.controller;

import bo.edu.ucb.sistemagraduados.dto.PersonaDto;
import bo.edu.ucb.sistemagraduados.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/persona")
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/getPersona/{id}")
    public ResponseEntity<PersonaDto> getPersonaById(@PathVariable Integer id) {
        PersonaDto personaDto = personaService.findById(id);
        if (personaDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personaDto);
    }

    @PostMapping("/savePersona")
    public ResponseEntity<PersonaDto> savePersona(@RequestBody PersonaDto personaDto) {
        PersonaDto savedPersonaDto = personaService.save(personaDto);
        return ResponseEntity.ok(savedPersonaDto);
    }
}
