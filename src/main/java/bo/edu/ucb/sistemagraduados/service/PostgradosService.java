package bo.edu.ucb.sistemagraduados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.sistemagraduados.dto.PostgradosDto;
import bo.edu.ucb.sistemagraduados.entity.Postgrados;
import bo.edu.ucb.sistemagraduados.mapper.PostgradosMapper;
import bo.edu.ucb.sistemagraduados.repository.PostgradosRepository;

@Service
public class PostgradosService {
    @Autowired
    private final PostgradosRepository postgradosRepository;

    public PostgradosService(PostgradosRepository postgradosRepository) {
        this.postgradosRepository = postgradosRepository;
    }

    public PostgradosDto findById(Integer id) {
        Postgrados postgrados = postgradosRepository.findById(id).orElse(null);
        return PostgradosMapper.toPostgradosDto(postgrados);
    }

    public PostgradosDto save(PostgradosDto postgradosDto) {
        Postgrados postgrados = PostgradosMapper.toPostgrados(postgradosDto);
        Postgrados savedPostgrados = postgradosRepository.save(postgrados);
        return PostgradosMapper.toPostgradosDto(savedPostgrados);
    }

    public void deleteById(Integer id) {
        postgradosRepository.deleteById(id);
    }

    public PostgradosDto update(Integer id, PostgradosDto postgradosDto) {
        Postgrados postgradosExistente = postgradosRepository.findById(id).orElse(null);
        Postgrados postgrados = PostgradosMapper.updatePostgradosFromDto(postgradosDto, postgradosExistente);
        Postgrados updatedPostgrados = postgradosRepository.save(postgrados);
        return PostgradosMapper.toPostgradosDto(updatedPostgrados);
    }

    public List <PostgradosDto> findAll() {
        List<Postgrados> postgrados = postgradosRepository.findAll();
        return PostgradosMapper.toPostgradosDtoList(postgrados);
    }
}
