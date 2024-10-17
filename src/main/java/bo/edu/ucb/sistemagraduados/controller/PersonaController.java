package bo.edu.ucb.sistemagraduados.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import bo.edu.ucb.sistemagraduados.entity.Persona;
import bo.edu.ucb.sistemagraduados.service.PersonaService;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/persona")
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/getPersona/{id}")
    public Persona getPersonaById (Integer id) {
        return personaService.findById(id);
        }
    
    @PostMapping("/savePersona")
    @ResponseBody
    public void savePersona(@RequestBody Persona persona) {
        personaService.guardarPersona(persona);
    }

}
