package bo.edu.ucb.sistemagraduados.service;

import bo.edu.ucb.sistemagraduados.entity.Carreras;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import bo.edu.ucb.sistemagraduados.dto.CarrerasDto;
import bo.edu.ucb.sistemagraduados.mapper.CarrerasMapper;
import bo.edu.ucb.sistemagraduados.repository.CarrerasRepository;

@Service
public class CarrerasService {
    
    @Autowired
    CarrerasRepository carrerasRepository;

    public CarrerasDto findById(Integer id) {
        Carreras carreras = carrerasRepository.findById(id).orElse(null);
        return CarrerasMapper.toCarrerasDto(carreras);
    }

    public CarrerasDto save(CarrerasDto carrerasDto) {
        Carreras carreras = CarrerasMapper.toCarreras(carrerasDto);
        Carreras savedCarreras = carrerasRepository.save(carreras);
        return CarrerasMapper.toCarrerasDto(savedCarreras);
    }

    public List<CarrerasDto> findAll() {

        List<Carreras> carreras = carrerasRepository.findAll();
        return CarrerasMapper.toCarrerasDtoList(carreras);
        
    }
}
