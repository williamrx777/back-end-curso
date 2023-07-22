package com.will.curso.Controller;

import com.will.curso.Entity.Alunos;
import com.will.curso.Repositoriy.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    AlunosRepository alunosRepository;

    @GetMapping
    public List<Alunos> listarTodosOsAlunos(){
        return alunosRepository.findAll();
    }

    @PostMapping
    public Alunos postarAluno(@RequestBody Alunos aluno){
        return this.alunosRepository.save(aluno);
    }

    @PutMapping("/{id}")
    public Optional<Alunos> atualizarAluno(@PathVariable Long id, @RequestBody Alunos aluno){
        Optional<Alunos> alunoExiste = alunosRepository.findById(id);
        if(alunoExiste.isPresent()){
            aluno.setId(id);
            return Optional.of(alunosRepository.save(aluno));
        }else{
            return Optional.empty();
        }
    }
}
