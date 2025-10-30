 🏠 Microservices Kafka ViaCEP

[![Java](https://img.shields.io/badge/Java-17-red?logo=java)](https://www.oracle.com/java/) [![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot) [![Kafka](https://img.shields.io/badge/Apache%20Kafka-Enabled-black?logo=apachekafka)](https://kafka.apache.org/) [![Docker](https://img.shields.io/badge/Docker-Ready-blue?logo=docker)](https://www.docker.com/)


---

## 📘 Sobre o Projeto

Este projeto faz parte de uma arquitetura baseada em **microserviços** desenvolvida com **Spring Boot**.  
O objetivo principal é consumir a **API pública dos Correios (ViaCEP)** para obter o **endereço completo** a partir de um CEP informado, e publicar o resultado em um **tópico Kafka** para posterior consumo por outros serviços.

> 🧩 Atualmente, está implementado o **microserviço produtor** (em desenvolvimento).  
> 🔜 Em breve será criado o **microserviço consumidor**, que processará as mensagens enviadas ao Kafka.

---

## ⚙️ Descrição Técnica

### 🔁 Fluxo de funcionamento

1. O cliente envia uma requisição `GET /api/cep/{cep}`.  
2. O serviço consome a **API ViaCEP** (ex: `https://viacep.com.br/ws/{cep}/json/`).  
3. O resultado é retornado ao cliente e também publicado no tópico **cursos-topico** do Kafka.  
4. Um **futuro microserviço consumidor** receberá essas mensagens e poderá armazená-las em um **banco de dados (AWS RDS)**.

---

## 🧠 Exemplo de Requisição

**Requisição**

```

GET /api/cep/01001000

```

**Resposta**
```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "bairro": "Sé",
  "cidade": "São Paulo",
  "uf": "SP"
}

```

> 📨 Ao mesmo tempo, a resposta acima é publicada no tópico Kafka **cursos-topico**.

----------

## 🧩 Tecnologias Utilizadas

-   ☕ **Java 17**
    
-   🍃 **Spring Boot 3.x**
    
    -   Spring Web
        
    -   Spring Kafka
        
    -   Spring Validation _(em andamento)_
        
    -   Spring Security _(a ser implementado)_
        
-   🐳 **Docker / Docker Compose**
    
-   ⚙️ **Maven**
    
-   🧠 **Lombok**
    
-   🧪 **JUnit 5 / Mockito** _(a ser implementado)_
    
-   📘 **Swagger / OpenAPI** _(a ser adicionado)_
    
-   🗄️ **PostgreSQL (AWS RDS)** _(planejado para o futuro)_
    

----------

## 📂 Estrutura do Projeto

```bash
microservices-kafka-viacep/
├── src/
│   ├── main/
│   │   ├── java/com/escola/matriculas/
│   │   │   ├── config           # Configurações da app
│   │   │	├── controller/      # Endpoints REST
│   │   │   ├── service/         # Lógica de negócio (integração com ViaCEP)
│   │   │	├── mapper/          # Conversão entre Entidades e DTOs
│   │   │	├── repository/      # Persistência de dados
│   │   │   ├── producer/        # Envio de mensagens para Kafka
│   │   │   └── domain/dto/      # Entidades e DTOs
│   │   └── resources/
│   │       └── application-dev.properties  # Configurações da aplicação
└── pom.xml

```

----------

## 🚀 Como Executar Localmente

### 🧰 Pré-requisitos

-   **Java 17**
    
-   **Maven 3.9+**
    
-   **Docker e Docker Compose**
    

### ▶️ Passos

```bash
# 1️⃣ Clonar o repositório
git clone https://github.com/aronricardo93/microservices-kafka-viacep.git
cd microservices-kafka-viacep

# 2️⃣ Subir o Kafka e Zookeeper
docker-compose up --build


```

----------

## 🧱 Melhorias Futuras

### ⚡ Funcionais

-   Implementar **microserviço consumidor** para processar mensagens Kafka
    
-   Persistir dados em **AWS RDS (PostgreSQL)**
    

### 🧩 Técnicas

-   **Tratamento de exceções global** com `@ControllerAdvice`
    
-   **Validações de CEP** com Bean Validation (`@NotNull`, `@Pattern`)
    
-   **Documentação Swagger / OpenAPI** em `/swagger-ui.html`
    
-   **Testes unitários e mocks** com JUnit 5 e Mockito
    
-   **Autenticação JWT** via Spring Security
    
-   Configuração de **profiles dev/prod** e variáveis de ambiente
    

----------

## ☁️ Deploy e Integração

-   Projeto preparado para ambiente **Dockerizado**
    
-   Kafka e Zookeeper sob **Docker Compose**
    
-   Planejado para deploy em **AWS ECS ou EC2**
    
-   Banco **PostgreSQL** hospedado em **AWS RDS**
    

----------

## 👨‍💻 Autor

**Aron Ricardo**  
💻 Desenvolvedor Java | Spring Boot   
🔗 [GitHub](https://github.com/aronricardo93)  
💼 [LinkedIn](https://www.linkedin.com/in/aronricardo)

----------

