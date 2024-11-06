package bo.edu.ucb.sistemagraduados.service;

import bo.edu.ucb.sistemagraduados.entity.Carreras;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import bo.edu.ucb.sistemagraduados.dto.CarrerasDto;
import bo.edu.ucb.sistemagraduados.mapper.CarrerasMapper;
import bo.edu.ucb.sistemagraduados.repository.CarrerasRepository;
import jakarta.transaction.Transactional;

@Service
public class CarrerasService {
    
    @Autowired
    private final CarrerasRepository carrerasRepository;

    public CarrerasService(CarrerasRepository carrerasRepository) {
        this.carrerasRepository = carrerasRepository;
    }

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

    public void deleteById(Integer id) {
        carrerasRepository.deleteById(id);
    }

    @Transactional
    public CarrerasDto update(Integer id, CarrerasDto carrerasDto) {
        Carreras carreraExistente = carrerasRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("carrera no encontrada"));
        Carreras carreraActualizada = CarrerasMapper.updateCarrerasFromDto(carrerasDto, carreraExistente);
        carreraActualizada = carrerasRepository.save(carreraActualizada);
        return CarrerasMapper.toCarrerasDto(carreraActualizada);
    }
}
