# People Flow

<div align="center"> 
	<img src="https://img.shields.io/badge/Java-17-red?style=for-the-badge&logo=java&logoColor=white" alt="Java Badge" /> 
	<img src="https://img.shields.io/badge/Spring_Boot-3.0-brightgreen?style=for-the-badge&logo=springboot" alt="Spring Boot Badge" /> 
	<img src="https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL Badge" />
	<img src="https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL Badge" />
	<img src="https://img.shields.io/badge/Maven-Build-lightgrey?style=for-the-badge&logo=apachemaven&logoColor=red" alt="Maven Badge" />
	<img src="https://img.shields.io/badge/Render-Deploy-4D2AFF?style=for-the-badge&logo=render&logoColor=white" alt="Render Badge" />
	<img src="https://img.shields.io/badge/Swagger-API-green?style=for-the-badge&logo=swagger&logoColor=white" alt="Swagger Badge" />
	<img src="https://img.shields.io/badge/Insomnia-API_Testing-purple?style=for-the-badge&logo=insomnia&logoColor=white" alt="Insomnia Badge" />
</div>

**O FUTURO DA GESTÃO DE PESSOAS**

People Flow é um sistema completo de Recursos Humanos que une tecnologia, usabilidade e dados para transformar a forma como empresas gerenciam seus talentos. 
Mais que um sistema de RH: uma plataforma estratégica para o desenvolvimento humano.

---

## 🛠 Tecnologias Utilizadas

- **Java 17**: Backend da aplicação
- **Spring Boot**: Framework para desenvolvimento de APIs REST
- **MySQL & PostgreSQL**: Bancos de dados utilizados conforme o ambiente
- **Maven**: Gerenciamento de dependências e build
- **Swagger**: Documentação e testes das APIs
- **Insomnia**: Testes e simulações de requisições HTTP
- **Render**: Deploy e hospedagem da aplicação

---

## 🚀 Executando Localmente

### Pré-requisitos

- Java 17 (https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Maven (https://maven.apache.org/)
- MySQL (https://www.mysql.com/downloads/)
- IDE de sua preferência (SpringToolSuite, IntelliJ, Eclipse, VSCode)

### Passos

1. Clone o repositório:
```bash
 git clone https://github.com/Time-Gene-Mulheres/rh-people_flow.git
```
2. Configure o banco de dados no application.properties com seu usuário e senha:
 ```bash
 spring.datasource.username=seu_usuario
 spring.datasource.password=sua_senha
```
3. Execute a aplicação via bash ou direto pela IDE:

 ```bash
./mvnw spring-boot:run
```

4. Realizar os teste no Insomnia com a URL:

 ```bash
http://localhost:8080
```

➕ Cadastrar Usuário
POST ```/usuarios/cadastrar```

Request body:
```bash
{
  "nome": "Maria Oliveira",
  "usuario": "maria.oliveira",
  "email": "maria@email.com",
  "senha": "123456"
}
```
Respostas:

201 CREATED: Usuário criado  
400 BAD REQUEST: Dados inválidos ou usuário existente

🔐 Autenticar Usuário
POST /usuarios/logar

Autentica um usuário pelo nome de usuário e senha.

Request body:
```bash
{
  "usuario": "joao.silva",
  "senha": "123456"
}
```
Respostas:

200 OK: Usuário autenticado
401 UNAUTHORIZED: Credenciais inválidas

♻️ Atualizar Usuário
PUT /usuarios/atualizar

Request body:
```bash
{
  "id": 1,
  "nome": "Maria Oliveira",
  "usuario": "maria.oliveira",
  "email": "maria@email.com",
  "senha": "novaSenha"
}
```
Respostas:

200 OK: Usuário atualizado
404 NOT FOUND: Usuário não encontrado

📄 Listar Todos os Usuários
GET /usuarios/all

Resposta:

Request body:
```bash
  {
    "id": 1,
    "nome": "João",
    "usuario": "joao",
    "email": "joao@email.com"
  }
```

🔍 Buscar Usuário por ID
GET /usuarios/{id}

Respostas:

200 OK
404 NOT FOUND

🔍 Buscar por nome de usuário
GET /usuarios/usuario/{usuario}

Respostas:

200 OK
404 NOT FOUND

5. Seguir o mesmo conceito para testar SETOR e COLABORADOR
   
7. Acessar a aplicação através da URL para conseguir a documentação via Swagger:
   ```bash
   http://localhost:8080/swagger-ui.html
   ```
---
## 🌐 Deploy

A aplicação está hospedada em produção na plataforma [Render](https://render.com), com banco de dados conectado e ambiente pronto para escalabilidade.
---

## 📚 Funcionalidades

- Cadastro e gestão de colaboradores 
- Cadastro e gestão de Setores
- Cadastro e gestão de Usuários
- Controle Salárial
---

## ✨ Futuras Melhorias 

- Controle de jornada e frequência
- Avaliação de desempenho
- Gestão de benefícios
- Onboarding e processos seletivos
- Geração de relatórios e dashboards
---

## 👩‍💻 Desenvolvedoras

<a href="https://github.com/alexaniatoma">
  <img src="https://github.com/alexaniatoma.png" width="120" alt="Alexânia Toma">
</a>

<a href="https://github.com/DanieleRangel">
  <img src="https://github.com/DanieleRangel.png" width="120" alt="Daniele Rangel">
  </a>

<a href="https://github.com/sandramastrogiacomo">
  <img src="https://github.com/sandramastrogiacomo.png" width="120" alt="Sandra Mastrogiacomo">
</a>

<a href="https://github.com/jessicarodrialves">
  <img src="https://github.com/jessicarodrialves.png" width="120" alt="Jéssica Rodrigues">
</a>

<a href="https://github.com/carol23172">
  <img src="https://github.com/carol23172.png" width="120"  alt="Carolina Almeida"
    />
</a>

<a href="https://github.com/gabrielly-dev">
  <img src="https://github.com/gabrielly-dev.png" width="120" alt="Gabrielly Barbosa">
</a>
<a href="https://github.com/keifsant">
  <img src="https://github.com/keifsant.png" width="120" alt="Keilla Santos">
</a>
<br><br>

