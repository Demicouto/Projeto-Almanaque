
# 📚 Sistema de Biblioteca

Um sistema de gerenciamento de biblioteca desenvolvido em **Java (CLI)** com persistência de dados no **PostgreSQL**.  
O projeto segue boas práticas de **arquitetura em camadas** (Model, Repository, Service e CLI).

---

## 🎯 Objetivo
Gerenciar livros, usuários e empréstimos de uma biblioteca via **linha de comando**, com armazenamento persistente em banco de dados PostgreSQL.  

---

## 📂 Estrutura do Projeto

```bash
Projeto-Almanaque/
├── docs/
|   ├── data/
|   |   └── Informações sobre usuário logado
│   └── Documentos do projeto
├── src/
│   ├── model/
|   |   ├── enums/
|   |   |   └── Tipos de usuário, adm ou leitor
│   │   └── Livro.java
│   │   └── Usuario.java
│   │   └── Emprestimo.java
│   ├── controller/
|   |   └── LivroController.java
|   |   └── UsuarioController.java
│   ├── util/
│   │   └── DataBaseConnection.java
|   |   └── DatabaseSetup.java
│   ├── view/
│   │   └── MenusView.java
│   └── Main.java
└── README.md
```
# 🗂️ Padrão MVC
### Model
O **model** está responsável pelas as entidades, atualmente contendo Livro, Usuario, Emprestimo que são nossa únicas entidades, nesses arquivos contém toda regra de criação dessas entidades.
### View
O **view** fica responsável por tudo que é visual que no nosso caso são menus que irão aparecer no terminal.
### Controller
O **controller** vai ficar responsável pelo controle de cada funcionalidade e de como elas vão funcionar, na pasta controller você encontra todos arquivos nomeados com base em suas responsábilidades. 


## 📂 Passos para instalação:
Você deve seguir os seguintes passos para que o script funcione corretamente, principalmente na parte de banco de dados. 
### Clonar o repositório:
- Dê um **git clone nesse** respositório: https://github.com/Demicouto/Projeto-Almanaque.git
### Banco de dados:
- Configurar o BD, **crie um banco de dados chamado "biblioteca"**
- Configure o pom.xml para **aceitar o PostgreSQL.**
```bash
 <dependencies>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version>
        </dependency>
</dependencies>
```
### Conectar o script ao DB:
- Dentro das pastas, **exatamente no arquivo util/DataBaseConnection.java** você deve por suas credenciais de login no seu DB. 
- private static final String URL = `"jdbc:postgresql://localhost:5432/biblioteca"`, **normalmente é essa sua url final** caso tenha seguido os passos corretos. 
- private static final String USER = `"postgres"`, **originalmente é esse seu user** caso você nã tenha trocado na instalação.
- private static final String PASSWORD = "", **você que escolheu.** 

### Tecnologias utilizadas:
- **Java 23**
- **PostgreSQL**
- **PlantUML**
- **Git e Github**


---
- Licença MIT License - sinta-se à vontade para usar, modificar e compartilhar este projeto.
---
