package bo.edu.ucb.sistemagraduados.mapper;

import bo.edu.ucb.sistemagraduados.dto.PersonaDto;
import bo.edu.ucb.sistemagraduados.entity.Persona;

public class PersonaMapper {
    public static PersonaDto toPersonaDto (Persona persona) {
        PersonaDto personaDto = new PersonaDto();
        personaDto.setIdPersona(persona.getIdPersona());
        personaDto.setNombre(persona.getNombre());
        personaDto.setAPaterno(persona.getAPaterno());
        personaDto.setAMaterno(persona.getAMaterno());
        personaDto.setCi(persona.getCi());
        personaDto.setFechaNacimiento(persona.getFechaNacimiento());
        personaDto.setGeneroNacimiento(persona.getGeneroNacimiento());
        personaDto.setNacionalidad(persona.getNacionalidad());
        return personaDto;
    }
    public static Persona toPersona (PersonaDto personaDto) {
        Persona persona = new Persona();
        persona.setNombre(personaDto.getNombre());
        persona.setAPaterno(personaDto.getAPaterno());
        persona.setAMaterno(personaDto.getAMaterno());
        persona.setCi(personaDto.getCi());
        persona.setFechaNacimiento(personaDto.getFechaNacimiento());
        persona.setGeneroNacimiento(personaDto.getGeneroNacimiento());
        persona.setNacionalidad(personaDto.getNacionalidad());
        return persona;
    }
}
