package bo.edu.ucb.sistemagraduados.mapper;

import bo.edu.ucb.sistemagraduados.entity.Carreras;

import java.util.ArrayList;
import java.util.List;

import bo.edu.ucb.sistemagraduados.dto.CarrerasDto;

public class CarrerasMapper {
    public static CarrerasDto toCarrerasDto (Carreras carreras) {
        CarrerasDto carrerasDto = new CarrerasDto();
        carrerasDto.setIdCarrera(carreras.getIdCarrera());
        carrerasDto.setNombre(carreras.getNombre());
        carrerasDto.setSigla(carreras.getSigla());
        return carrerasDto;
    }
    public static Carreras toCarreras (CarrerasDto carrerasDto) {
        Carreras carreras = new Carreras();
        carreras.setNombre(carrerasDto.getNombre());
        carreras.setSigla(carrerasDto.getSigla());
        return carreras;
    }

    public static List<CarrerasDto> toCarrerasDtoList(List<Carreras> carreras) {
        List<CarrerasDto> carrerasDtos = new ArrayList<>();
        for(Carreras carrera : carreras) {
            carrerasDtos.add(toCarrerasDto(carrera));
        }
        return carrerasDtos;
    }
}
