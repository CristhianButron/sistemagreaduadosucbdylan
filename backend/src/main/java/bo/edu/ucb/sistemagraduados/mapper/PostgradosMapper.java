package bo.edu.ucb.sistemagraduados.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bo.edu.ucb.sistemagraduados.dto.PostgradosDto;
import bo.edu.ucb.sistemagraduados.entity.Postgrados;

public class PostgradosMapper {
    public static PostgradosDto toPostgradosDto(Postgrados postgrado) {
        PostgradosDto postgradoDto = new PostgradosDto();
        postgradoDto.setIdPostgrado(postgrado.getIdPostgrado());
        postgradoDto.setTipo(postgrado.getTipo());
        postgradoDto.setDuracion(postgrado.getDuracion());
        return postgradoDto;
    }

    public static Postgrados toPostgrados(PostgradosDto postgradoDto) {
        Postgrados postgrado = new Postgrados();
        postgrado.setTipo(postgradoDto.getTipo());
        postgrado.setDuracion(postgradoDto.getDuracion());
        return postgrado;
    }

    public static List <PostgradosDto> toPostgradosDtoList (List<Postgrados> postgrados) {
        List <PostgradosDto> postgradosDtos = new ArrayList<>();
        for (Postgrados postgrado : postgrados) {
            postgradosDtos.add(toPostgradosDto(postgrado));
        }
        return postgradosDtos;
    }

    public static Postgrados updatePostgradosFromDto(PostgradosDto postgradoDto, Postgrados postgradoExistente) {
        if (postgradoDto.getTipo() != null && !Objects.equals(postgradoDto.getTipo(), postgradoExistente.getTipo())) {
            postgradoExistente.setTipo(postgradoDto.getTipo());
        }
        if (postgradoDto.getDuracion() != null && !Objects.equals(postgradoDto.getDuracion(), postgradoExistente.getDuracion())) {
            postgradoExistente.setDuracion(postgradoDto.getDuracion());
        }
        return postgradoExistente;
    }
}
