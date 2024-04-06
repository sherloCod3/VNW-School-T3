# 🎓 VNW School T3

![VNW School T3 Logo](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZuYCDmBYqM6HhW5-6REt-jgQxTxMCZeywcjSSs6WDvg&s)

Bem-vindo ao VNW School T3, um sistema de gerenciamento de alunos desenvolvido em Java com Spring Boot.

## 📝 Sobre o Projeto

O VNW School T3 é uma aplicação que permite às instituições educacionais gerenciar informações sobre os alunos, incluindo cadastro, atualização, exclusão e visualização de dados.

## 🚀 Funcionalidades

- Cadastro de novos alunos com informações detalhadas.
- Atualização dos dados de alunos existentes.
- Exclusão de alunos do sistema.
- Visualização detalhada dos dados de cada aluno.
- Listagem de todos os alunos cadastrados.

## 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## 📂 Estrutura do Projeto

- `src/main/java/br/com/vnwschoolt3/model`: Contém as classes de modelo, como AlunoModel e Endereco.
- `src/main/java/br/com/vnwschoolt3/controller`: Contém os controladores REST, como AlunoController.
- `src/main/java/br/com/vnwschoolt3/service`: Contém as classes de serviço, como AlunoService.
- `src/main/java/br/com/vnwschoolt3/dto`: Contém as classes DTO (Data Transfer Object), como DadosAluno.
- `src/main/resources`: Contém arquivos de configuração e recursos estáticos.

## 🔧 Configuração e Execução

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/vnw-school-t3.git
```
2. Navegue até o diretório do projeto:
```
cd vnw-school-t3
```
3. Execute a aplicação com o Maven:
```
mvn spring-boot:run
```
4. Acesse a aplicação em seu navegador web:
```
http://localhost:8080
```

## 🤝 Contribuição
Contribuições são sempre bem-vindas! Sinta-se à vontade para abrir uma issue para relatar bugs ou sugerir novas funcionalidades. Pull requests também são encorajados.

## 📝 Licença
Este projeto está licenciado sob a MIT License.
