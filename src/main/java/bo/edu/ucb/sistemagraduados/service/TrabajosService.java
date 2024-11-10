package bo.edu.ucb.sistemagraduados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.sistemagraduados.dto.TrabajosDto;
import bo.edu.ucb.sistemagraduados.entity.Trabajos;
import bo.edu.ucb.sistemagraduados.mapper.TrabajosMapper;
import bo.edu.ucb.sistemagraduados.repository.TrabajosRepository;
import jakarta.transaction.Transactional;

@Service
public class TrabajosService {
    @Autowired
    private final TrabajosRepository trabajosRepository;

    public TrabajosService(TrabajosRepository trabajosRepository) {
        this.trabajosRepository = trabajosRepository;
    }

    public TrabajosDto findById(Integer id) {
        Trabajos trabajos = trabajosRepository.findById(id).orElse(null);
        return TrabajosMapper.toTrabajosDto(trabajos);
    }

    public List<TrabajosDto> findAll() {
        List<Trabajos> trabajos = trabajosRepository.findAll();
        return TrabajosMapper.toTrabajosDtoList(trabajos);
    }

    public TrabajosDto save(TrabajosDto trabajosDto) {
        Trabajos trabajos = TrabajosMapper.toTrabajos(trabajosDto);
        Trabajos savedTrabajos = trabajosRepository.save(trabajos);
        return TrabajosMapper.toTrabajosDto(savedTrabajos);
    }

    public void deleteById(Integer id) {
        trabajosRepository.deleteById(id);
    }

    @Transactional
    public TrabajosDto update(Integer id, TrabajosDto trabajosDto) {
        Trabajos trabajosExistente = trabajosRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Trabajos no encontrada"));
        Trabajos trabajosActualizado = TrabajosMapper.updateTrabajosFromDto(trabajosDto, trabajosExistente);
        trabajosActualizado = trabajosRepository.save(trabajosActualizado);
        return TrabajosMapper.toTrabajosDto(trabajosActualizado);
    }

}
