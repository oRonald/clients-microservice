# Client Microservice

Esse microserviço é o responsável pela manipulação dos dados dos clientes, possuindo métodos como registrar e uma busca por CPF.
Como se trata apenas de uma aplicação para estudos de arquitetura de microserviço, utilizei o Banco de Dados H2 para salvar registros e realizar pesquisas.

Por se tratar de um dos microserviços da aplicação, foi implementado o Eureka Discovery Client, que diferentemente do Discovery Server, que é o servidor que 
será registrado os outros serviços, o Discovery Client se trata da aplicação que será registrada no Discovery Server

<img width="755" height="198" alt="image" src="https://github.com/user-attachments/assets/d7aa442d-1375-4945-9ad9-7f0e28af96b7" />

<p>Como foi utilizado o gateway como ponte entre os microserviços e o usuario, a porta foi definida como aleatória.</p>
Nós precisamos definir qual o localhost ou URL do Discovery Server para que o serviço se registre automaticamente.

<hr/>

## Tecnologias
- Java 17
- Spring Boot 3
- Spring Cloud
- Eureka Discovery Client
- Spring Data JPA
- Spring Web
- H2 Database
- Lombok
- Spring Boot Actuator
- OpenAPI Springdoc (Swagger)
