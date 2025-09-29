
# 📚 Sistema de Biblioteca (CLI + PostgreSQL)

Um sistema de gerenciamento de biblioteca desenvolvido em **Java (CLI)** com persistência de dados no **PostgreSQL**.  
O projeto segue boas práticas de **arquitetura em camadas** (Model, Repository, Service e CLI).

---

## 🎯 Objetivo
Gerenciar livros, usuários e empréstimos de uma biblioteca via **linha de comando**, com armazenamento persistente em banco de dados PostgreSQL.  

---

## 🚀 Funcionalidades

- ✅ Cadastrar livros  
- ✅ Listar livros cadastrados  
- 🔜 Gerenciamento de usuários  
- 🔜 Controle de empréstimos e devoluções  

---

## 📂 Estrutura do Projeto

```bash
sistema-biblioteca-cli/
├── lib/
│   └── postgresql-42.7.4.jar   # driver JDBC
├── src/
│   ├── model/
│   │   └── Livro.java
│   ├── repository/
│   │   └── LivroRepository.java
│   ├── service/
│   │   └── BibliotecaService.java
│   ├── cli/
│   │   └── BibliotecaCLI.java
│   ├── config/
│   │   └── ConnectionFactory.java
│   └── Main.java
└── README.md
```
---

## ⚙️ Configuração do Banco

Crie o banco de dados no PostgreSQL:

```sql
CREATE DATABASE biblioteca;

\c biblioteca;

CREATE TABLE livros (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    isbn VARCHAR(20) UNIQUE NOT NULL,
    quantidade_total INT NOT NULL,
    quantidade_disponivel INT NOT NULL
);
