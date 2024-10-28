package bo.edu.ucb.sistemagraduados.service;

import bo.edu.ucb.sistemagraduados.dto.PersonaDto;
import bo.edu.ucb.sistemagraduados.entity.Persona;
import bo.edu.ucb.sistemagraduados.mapper.PersonaMapper;
import bo.edu.ucb.sistemagraduados.repository.PersonaRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaDto findById(Integer id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        return PersonaMapper.toPersonaDto(persona);
    }
    public PersonaDto save(PersonaDto personaDto) {
        Persona persona = PersonaMapper.toPersona(personaDto);
        Persona savedPersona = personaRepository.save(persona);
        return PersonaMapper.toPersonaDto(savedPersona);
    }
}
