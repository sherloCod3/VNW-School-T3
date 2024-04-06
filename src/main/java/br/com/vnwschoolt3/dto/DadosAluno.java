package br.com.vnwschoolt3.dto;

import br.com.vnwschoolt3.enums.Curso;
import br.com.vnwschoolt3.model.Endereco;

public record DadosAluno(String nome, String email, String cpf, Curso curso, String telefone, Endereco endereco) {

    // Os registros (records) em Java tratam todos os campos como finais e fornecem
    // automaticamente getters para esses campos. Não é necessário definir getters
    // explicitamente em registros.

    // Não é necessário definir setters em registros, pois os campos são finais e não podem ser alterados após a criação do objeto.
}
