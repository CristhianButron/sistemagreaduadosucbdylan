package bo.edu.ucb.sistemagraduados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.sistemagraduados.dto.EstudiosSuperioresDto;
import bo.edu.ucb.sistemagraduados.entity.EstudiosSuperiores;
import bo.edu.ucb.sistemagraduados.mapper.EstudiosSuperioresMapper;
import bo.edu.ucb.sistemagraduados.repository.EstudiosSuperioresRepository;

@Service
public class EstudiosSuperioresService {
    @Autowired
    private final EstudiosSuperioresRepository estudiosSuperioresRepository;

    public EstudiosSuperioresService(EstudiosSuperioresRepository estudiosSuperioresRepository) {
        this.estudiosSuperioresRepository = estudiosSuperioresRepository;
    }

    public EstudiosSuperioresDto findById(Integer id) {
        EstudiosSuperiores estudiosSuperiores = estudiosSuperioresRepository.findById(id).orElse(null);
        return EstudiosSuperioresMapper.toEstudiosSuperioresDto(estudiosSuperiores);  
    } 

    public List<EstudiosSuperioresDto> findAll() {
        List<EstudiosSuperiores> estudiosSuperioresList = estudiosSuperioresRepository.findAll();
        return EstudiosSuperioresMapper.toEstudiosSuperioresDtoList(estudiosSuperioresList);
    }

    public EstudiosSuperioresDto save(EstudiosSuperioresDto estudiosSuperioresDto) {
        EstudiosSuperiores estudiosSuperiores = EstudiosSuperioresMapper.toEstudiosSuperiores(estudiosSuperioresDto);
        estudiosSuperiores = estudiosSuperioresRepository.save(estudiosSuperiores);
        return EstudiosSuperioresMapper.toEstudiosSuperioresDto(estudiosSuperiores);
    }

    public void deleteById(Integer id) {
        estudiosSuperioresRepository.deleteById(id);
    }

    public EstudiosSuperioresDto update (Integer id, EstudiosSuperioresDto estudiosSuperioresDto) {
        EstudiosSuperiores estudiosSuperioresExistente = estudiosSuperioresRepository.findById(id).orElse(null);
        EstudiosSuperiores estudiosSuperiores = EstudiosSuperioresMapper.updateEstudiosSuperioresFromDto(estudiosSuperioresDto, estudiosSuperioresExistente);
        estudiosSuperiores = estudiosSuperioresRepository.save(estudiosSuperiores);
        return EstudiosSuperioresMapper.toEstudiosSuperioresDto(estudiosSuperiores);
    }

}
