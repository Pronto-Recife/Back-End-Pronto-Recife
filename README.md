# Back-End Pronto Recife

![Pronto Recife](https://i.imgur.com/MNS94gD.png)

## 📖 Sobre o Projeto

O **Pronto Recife** é uma iniciativa desenvolvida para facilitar o acesso aos serviços de saúde no município de Recife. Este repositório contém o código do back-end, responsável por gerenciar e disponibilizar informações das unidades de saúde e prontuários médicos por meio de APIs seguras e eficientes.

O back-end foi projetado para garantir a segurança, escalabilidade e robustez necessárias para atender às demandas de saúde da população.

---

## 🚀 Funcionalidades

### 🗄️ Gerenciamento de Dados
- Estrutura de banco de dados eficiente, utilizando modelo relacional.
- Armazena informações sobre pacientes, unidades de saúde e atendimentos médicos.

### 🔐 Autenticação e Autorização
- Suporte a autenticação via tokens JWT.
- Diferenciação de acessos entre usuários, administradores e profissionais da saúde.

### 📡 APIs RESTful
- Endpoints para criação, leitura, atualização e exclusão (CRUD) de registros.
- Rotas documentadas para integração com o front-end.

### 📊 Logs e Monitoramento
- Implementação de logs para rastrear atividades do sistema.
- Suporte a monitoramento de performance para garantir alta disponibilidade.

### 🔄 Integração com APIs Externas
- Integração com serviços de geolocalização e verificação de CEP.
- Comunicação com sistemas de terceiros para dados adicionais.

---

## 🛠️ Tecnologias Utilizadas

- **Back-End:**
  - [Node.js](https://nodejs.org/) - Ambiente de execução JavaScript.
  - [Express.js](https://expressjs.com/) - Framework web para criação de APIs RESTful.
  - [Sequelize](https://sequelize.org/) - ORM para manipulação do banco de dados.

- **Banco de Dados:**
  - [PostgreSQL](https://www.postgresql.org/) - Sistema de banco de dados relacional.

- **Outras Ferramentas:**
  - **Docker** - Para containerização e padronização do ambiente de desenvolvimento.
  - **Swagger** - Para documentação das APIs.
  - **JWT** - Para autenticação segura.

---

## 🧑‍💻 Como Rodar o Projeto Localmente

### Pré-requisitos:
- **Node.js** (v16 ou superior)
- **Docker** e **Docker Compose**
- **Git**

### Passos:
1. Clone o repositório:
   ```bash
   git clone https://github.com/Pronto-Recife/Back-End-Pronto-Recife.git
