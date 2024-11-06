package bo.edu.ucb.sistemagraduados.service;

import bo.edu.ucb.sistemagraduados.dto.PersonaDto;
import bo.edu.ucb.sistemagraduados.entity.Persona;
import bo.edu.ucb.sistemagraduados.mapper.PersonaMapper;
import bo.edu.ucb.sistemagraduados.repository.PersonaRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    private  final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public PersonaDto findById(Integer id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        return PersonaMapper.toPersonaDto(persona);
    }
    public PersonaDto save(PersonaDto personaDto) {
        Persona persona = PersonaMapper.toPersona(personaDto);
        Persona savedPersona = personaRepository.save(persona);
        return PersonaMapper.toPersonaDto(savedPersona);
    }
    public void deleteById(Integer id) {
        personaRepository.deleteById(id);
    }
    @Transactional
    public PersonaDto update(Integer id, PersonaDto personaDto) {
        Persona personaExistente = personaRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        Persona updatedPersona = PersonaMapper.updatePersonaFromDto(personaDto, personaExistente);
        updatedPersona = personaRepository.save(updatedPersona);
        return PersonaMapper.toPersonaDto(updatedPersona);
    }
}
