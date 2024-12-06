# Encurtador de URLs

Um sistema para encurtar URLs com funcionalidades de cache utilizando Redis e foco em segurança.

---

## 📦 Requisitos

Certifique-se de ter as seguintes ferramentas instaladas no seu ambiente:

- [Java 21](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

---

## 🔧 Configuração do Ambiente

### 1. Clone o repositório

```bash
git clone <URL_DO_REPOSITORIO>
cd <PASTA_DO_PROJETO>
``` 
### 2. Escolha o perfil do projeto

Por padrão, o projeto roda com o perfil `test`, utilizando o banco de dados em memória H2.

- **Para usar o MySQL**:
  - Altere o perfil do projeto para `dev`.
  - Configure o arquivo `application-dev.yml` na pasta `src/main/resources` com as informações do banco de dados.

Exemplo de configuração para MySQL no `application-dev.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/encurtador
    username: root
    password: root
  jpa:
    hibernate:
      ddl-auto: update
```
### 3. Configuração da IpInfoService

O serviço **IpInfoService** utiliza uma variável de ambiente para o link da API do IPInfo. Para que funcione corretamente, basta subistituir por esse link https://ipinfo.io/.

### 4. Acesso aos Recursos da API

Para acessar os recursos protegidos da API, siga os passos abaixo:

#### 1. Crie um perfil de usuário

Envie uma requisição `POST` para a rota:

POST localhost:8080/user

```json
{
  "email": "seila@gmail.com",
  "password": "124124"
}
```
Para ter acesso ao token agora, uma requisição `POST` para a rota:

POST localhost:8080/login
```json
{
  "email": "seila@gmail.com",
  "password": "124124"
}
```
---

## 🛠 Tecnologias Utilizadas

- Docker
- Java
- SQL
- Spring Boot
- OpenFeign
- JPA



