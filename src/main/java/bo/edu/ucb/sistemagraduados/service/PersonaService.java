package bo.edu.ucb.sistemagraduados.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.sistemagraduados.entity.Persona;
import bo.edu.ucb.sistemagraduados.repository.PersonaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonaService {

    @Autowired
    private final PersonaRepository personaRepository;

    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona findById(Integer id) {
        return personaRepository.findById(id).orElse(null);
    }
}
