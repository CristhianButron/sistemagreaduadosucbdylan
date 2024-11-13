package bo.edu.ucb.sistemagraduados.mapper;

import java.util.Objects;

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

    public static Persona updatePersonaFromDto (PersonaDto personaactualizadaDto, Persona personaExistente) {
        if (personaactualizadaDto == null || personaExistente == null) {
            return null;
        }
        if (personaactualizadaDto.getNombre() != null && !Objects.equals(personaExistente.getNombre(), personaactualizadaDto.getNombre())) {
            personaExistente.setNombre(personaactualizadaDto.getNombre());
        }
        if (personaactualizadaDto.getAPaterno() != null && !Objects.equals(personaExistente.getAPaterno(), personaactualizadaDto.getAPaterno())) {
            personaExistente.setAPaterno(personaactualizadaDto.getAPaterno());
        }
        if (personaactualizadaDto.getAMaterno() != null && !Objects.equals(personaExistente.getAMaterno(), personaactualizadaDto.getAMaterno())) {
            personaExistente.setAMaterno(personaactualizadaDto.getAMaterno());
        }
        if (personaactualizadaDto.getCi() != null && !Objects.equals(personaExistente.getCi(), personaactualizadaDto.getCi())) {
            personaExistente.setCi(personaactualizadaDto.getCi());
        }
        if (personaactualizadaDto.getFechaNacimiento() != null && !Objects.equals(personaExistente.getFechaNacimiento(), personaactualizadaDto.getFechaNacimiento())) {
            personaExistente.setFechaNacimiento(personaactualizadaDto.getFechaNacimiento());
        }
        if (personaactualizadaDto.getGeneroNacimiento() != null && !Objects.equals(personaExistente.getGeneroNacimiento(), personaactualizadaDto.getGeneroNacimiento())) {
            personaExistente.setGeneroNacimiento(personaactualizadaDto.getGeneroNacimiento());
        }
        if (personaactualizadaDto.getNacionalidad() != null && !Objects.equals(personaExistente.getNacionalidad(), personaactualizadaDto.getNacionalidad())) {
            personaExistente.setNacionalidad(personaactualizadaDto.getNacionalidad());
        }
        return personaExistente;
    }

}
