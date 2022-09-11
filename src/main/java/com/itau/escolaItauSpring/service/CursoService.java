package com.itau.escolaItauSpring.service;

import com.itau.escolaItauSpring.dto.request.CursoRequest;
import com.itau.escolaItauSpring.dto.response.CursoResponse;
import com.itau.escolaItauSpring.exception.ItemNaoExistenteException;
import com.itau.escolaItauSpring.mapper.CursoMapper;
import com.itau.escolaItauSpring.model.Curso;
import com.itau.escolaItauSpring.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository repository;
    private final CursoMapper mapper;

    public CursoResponse criar(CursoRequest cursoRequest){
        Curso curso = mapper.toModel(cursoRequest);
        return mapper.toResponse(repository.save(curso));
    }

    public List<CursoResponse> listar() {
        List<Curso> cursos = repository.findAll();
        return mapper.toResponseList(cursos);
    }

    public CursoResponse buscarPorId(UUID id){
        Curso  curso = findById(id);
        return mapper.toResponse(curso);
    }

    public void remover(UUID id) {
        Curso curso = findById(id);
        repository.delete(curso);
    }

    private Curso findById(UUID id){
        return repository.findById(id).orElseThrow(ItemNaoExistenteException ::new);

    }

    public List<CursoResponse> buscarPorNome(String nome, Pageable pageable) {
        Page<Curso> cursos = repository.findByNome(nome, pageable);
        return mapper.toResponseList(cursos.getContent());

    }
}


