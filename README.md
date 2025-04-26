# 📎 Projeto Encurtador de URL

Este projeto é um **serviço de encurtamento de URLs** desenvolvido com **Java**, utilizando **Spring Boot** e **MongoDB** para persistência dos dados.

A ideia é fornecer endpoints para criar, listar e buscar URLs.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot 3.4
- Spring Data MongoDB
- MongoDB
- Gradle

---

## 📦 Como rodar o projeto localmente

### Pré-requisitos

- Java 21 (Eclipse Temurin) ([https://adoptium.net/temurin/releases/](https://github.com/adoptium/temurin21-binaries/releases/tag/jdk-21.0.7%2B6))
- Gradle instalado (ou use o wrapper `./gradlew`)
- MongoDB rodando localmente via docker preferencialmente.

### Como criar um docker de mongoDB
```
docker run -d --name mongodb -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=secret mongo:latest
```

### Passos para rodar

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

# Entre na pasta do projeto
cd seu-repositorio

# Execute o projeto
./gradlew bootRun
```

A aplicação estará disponível em:  
`http://localhost:8080`

---

## 🔗 Endpoints disponíveis

| Método | Rota                   | Descrição                         |
|:------:|:----------------------- |:--------------------------------- |
| POST   | `/urls`                  | Cria uma nova URL encurtada       |
| GET    | `/urls`                  | Retorna todas as URLs cadastradas |
| GET    | `/urls/{id}`             | Retorna uma URL bruta pelo ID           |

---

## 🗃️ Estrutura da coleção no MongoDB

Cada documento armazenado na coleção `urls` possui o seguinte formato:

```json
{
  "_id": "ObjectId",
  "id": 1,
  "url": "https://www.exemplo.com"
}
```

- `_id` → ID gerado automaticamente pelo MongoDB.
- `id` → ID sequencial do projeto.
- `url` → URL original.

---

## 🛠️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/volpe/encurtador/
│   │       ├── domain/
│   │       ├── migrations/
│   │       ├── repository/
│   │       ├── service/
│   │       ├── web.rest/
│   │       └── EncurtadorApplication.java
│   └── resources/
│       ├── application.properties
│       └── static/
└── test/
```
