# 📚 Sistema de Biblioteca

Um sistema de gerenciamento de biblioteca desenvolvido em **Java (CLI)** com persistência de dados no **PostgreSQL**.  
O projeto segue boas práticas de **arquitetura em camadas** e utiliza o padrão **MVC (Model, View e Controller)**.

---

## 🎯 Objetivo

Gerenciar livros, usuários e empréstimos de uma biblioteca por meio da **linha de comando**, com armazenamento persistente em banco de dados PostgreSQL.

---

## 📂 Estrutura do Projeto

```bash
Projeto-Almanaque/
├── docs/
│   ├── data/
│   │   └── Informações sobre o usuário logado
│   └── Documentos do projeto
├── src/
│   ├── model/
│   │   ├── enums/
│   │   │   └── Tipos de usuário (Administrador e Leitor)
│   │   ├── Livro.java
│   │   ├── Usuario.java
│   │   └── Emprestimo.java
|   |   └── Categoria.java
│   ├── controller/
│   │   ├── LivroController.java
│   │   └── UsuarioController.java
│   ├── util/
│   │   ├── DataBaseConnection.java
│   │   └── DatabaseSetup.java
│   ├── view/
│   │   └── MenusView.java
│   └── Main.java
└── README.md
```

# 🗂️ Padrão MVC

### **Model**
A camada **Model** é responsável pelas entidades do sistema.  
Atualmente, o projeto conta com quatro entidades principais:

- `Livro`
- `Usuario`
- `Emprestimo`
- `Categoria`

Cada classe contém sua estrutura de dados e regras necessárias para criação e manipulação dessas entidades.

---

### **View**
A camada **View** cuida de tudo que envolve a parte visual do sistema.  
Como o projeto funciona via **linha de comando**, essa camada é responsável pelos menus exibidos no terminal.

---

### **Controller**
A camada **Controller** é responsável por controlar cada funcionalidade do sistema, recebendo entradas da view, chamando os serviços e manipulando entidades quando necessário.  
Dentro da pasta `controller/` você encontrará arquivos nomeados conforme suas responsabilidades.

---

## 📂 Passos para Instalação

Para garantir que o sistema funcione corretamente — principalmente a conexão com o banco de dados — siga os passos abaixo.

---

### 🔹 Clonar o repositório

Execute:

```bash
git clone https://github.com/Demicouto/Projeto-Almanaque.git
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

### Contribuição

#### Contribuições são bem-vindas!

    1. Crie uma branch com o seu recurso (git checkout -b feature/nome-da-feature).

    2. Faça commit das suas alterações (git commit -m 'feat: descrição da feature').

    3. Faça push para a branch (git push origin feature/nome-da-feature).

    4. Abra um Pull Request.

- Licença MIT License - sinta-se à vontade para usar, modificar e compartilhar este projeto.
---
