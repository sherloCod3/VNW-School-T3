package br.com.vnwschoolt3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vnwschoolt3.service.AlunoService;
import br.com.vnwschoolt3.dto.DadosAluno;
import br.com.vnwschoolt3.model.AlunoModel;
import br.com.vnwschoolt3.enums.Curso;
import jakarta.validation.Valid;

// Esta classe é um controlador REST que gerencia as requisições relacionadas aos alunos.
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    // Método para encontrar todos os alunos cadastrados.
    @GetMapping
    public List<AlunoModel> encontrarAluno() {

        // Chama o serviço para encontrar todos os alunos.
        List<AlunoModel> alunos = service.encontrarAlunos();

        List<AlunoModel> alunosFiltrados = new ArrayList<>();

        // Iterar sobre cada aluno e adicionar apenas os campos desejados na nova lista
        for (AlunoModel aluno : alunos) {
            // Criar um novo objeto AlunoModel e inicializá-lo com os dados do aluno atual
            AlunoModel alunoFiltrado = new AlunoModel(
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getCpf(),
                aluno.getCurso(),
                aluno.getTelefone(),
                aluno.getEndereco()
            );
            // Adicionar o aluno filtrado à lista de alunos filtrados
            alunosFiltrados.add(alunoFiltrado);
        }

        return alunosFiltrados;
    }

    // Método para encontrar um aluno por seu ID.
    @GetMapping("/{id}")
    public DadosAluno encontrarUmAlunoPorId(@PathVariable Long id) {

        // Chama o serviço para encontrar um aluno por seu ID.
        Optional<AlunoModel> alunoOptional = service.encontrarUmAlunoPorId(id);

        if (alunoOptional.isPresent()) {
            AlunoModel aluno = alunoOptional.get();
            // Retorna um objeto DadosAluno com os dados do aluno encontrado
            return new DadosAluno(aluno.getNome(), aluno.getEmail(), aluno.getCpf(), aluno.getCurso(), aluno.getTelefone(), aluno.getEndereco());
        }

        return null;
    }

    // Método para cadastrar um novo aluno.
    @PostMapping
    public ResponseEntity<String> cadastrarAluno(@RequestBody DadosAluno dados) {
        // Chama o serviço para cadastrar um novo aluno com os dados fornecidos.
        String result = service.cadastrarAluno(dados);

        if (result != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Método para atualizar os dados de um aluno.
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAluno(@PathVariable Long id, @RequestBody @Valid DadosAluno dadosAtualizados) {
        // Chama o serviço para encontrar o aluno a ser atualizado.
        Optional<AlunoModel> alunoOptional = service.encontrarUmAlunoPorId(id);

        if (alunoOptional.isPresent()) {
            AlunoModel aluno = alunoOptional.get();
            // Atualiza os dados do aluno com os dados fornecidos
            aluno.setNome(dadosAtualizados.getNome());
            aluno.setEmail(dadosAtualizados.getEmail());
            aluno.setCpf(dadosAtualizados.getCpf());
            aluno.setCurso(dadosAtualizados.getCurso());
            aluno.setTelefone(dadosAtualizados.getTelefone());
            aluno.setEndereco(dadosAtualizados.getEndereco());

            // Salva o aluno atualizado no banco de dados.
            service.atualizarAluno(aluno);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        // Retorna uma resposta com status 404 Not Found se o aluno não for encontrado
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Método para deletar um aluno por seu ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAlunoPorId(@PathVariable Long id) {
        // Chama o serviço para deletar o aluno por seu ID.
        boolean deleted = service.deletarAlunoPorId(id);

        if (deleted) {
            // Retorna uma resposta com status 204 No Content se o aluno for deletado com sucesso
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            // Retorna uma resposta com status 404 Not Found se o aluno não for encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
