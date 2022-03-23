# Microservices-com-Spring-Cloud-Curso-ALura

 ## Solução a ser implementada no curso:

Criação três microsserviços: Fornecedor, Loja e Transportador
- Uma apresentação da modelagem focado em DDD (Domain Driven Design)
- Quebrar o domínio em contextos menores (bounded context)

## Tópicos importantes aprendidos:
- Integração entre microsserviços com RestTemplate
  - O RestTemplate do Spring permite chamadas HTTP de alto nível
- Introdução ao Service discovery e Service registry
  - Service registry é um servidor central, onde todos os microsserviços ficam cadastrados (nome e IP/porta)
  - Service discovery é um mecanismo de descoberta do IP do microsserviço pelo nome
  - Dessa forma, nenhum microsserviço fica acoplado ao outro pelo IP/porta
- A implementação do service registry através do Eureka Server
- Registro da Loja e do Fornecedor no Eureka Server
- Resolução do IP/porta através do nome do microsserviço nas requisições, ou seja, os microsserviços não precisam conhecer o endereço IP  das outras aplicações, mas apenas o nome que elas se registraram no Eureka.
- Um servidor de configuração é o lugar central para definir as configurações dos serviços
- Todas as configurações dos microsserviços devem ficar externalizadas e centralizadas
- O Spring Config Server é uma implementação do servidor do projeto Spring Cloud
- Sobre a integração dos microsserviços com o servidor de configuração:
  - Para tal, devemos configurar o nome do microsserviço, profile e URL do Config Server
e existem várias formas de definir um repositório de configurações, entre elas o GitHub
- Client Side Load Balancing (CSLB) é o cliente HTTP que decide qual microsserviço recebe a requisição
  - Pode ter várias instâncias do mesmo serviço no ar
  - A configuração do CSLB é feita a partir da anotação @LoadBalanced, na criação do RestTemplate
  - Como implementação do CSLB, usamos um projeto chamado Ribbon, que faz parte do Spring Cloud Netflix
- Para descobrir quais clientes existem, podemos injetar a interface DiscoveryClient
- Como alternativa ao RestTemplate, podemos usar o Spring Feign, que já usa o Ribbon para CSLB
- O Spring Feign exige apenas uma interface, com a definição e mapeamento dos métodos que executarão a requisição
  - Toda a implementação da interface é gerada pelo Spring Feign
- Arquitetura distribuída, temos logs distribuídos
  - Ou seja, cada microsserviço (e instância dele) possui o seu log
  - Isso dificulta o acompanhamento e rastreabilidade das requisições
- Para unificar os logs, precisamos de agregadores de log
  - Como implementação de um agregador, usamos o Papertrail, um agregador como serviço
- Usamos a biblioteca Logback para gerar e enviar os logs ao agregador
  - O Logback possui um appender, que possibilita o envio dos logs
- Para acompanhar uma transação nos logs, usamos uma correlation-id
  - A correltation-id é um identificador da transação, que é passada de requisição pra requisição
  - Dessa forma, podemos entender quais requisições fazem parte da mesma transação
- A biblioteca Spring Sleuth, que é usada para gerar a correlation-id

## Curiosidade:
O arquivo bootstrap.yml é carregado em um contexto com maior precedência, chamado de Bootstrap Application Context. É neste contexto que o Spring Cloud Config Client se conecta ao configuration server, baixa e disponibiliza as variáveis de ambiente para o Spring Application Context, que é o contexto da nossa aplicação. Porém a partir da versão Spring Boot 2.4 mudou sua funcionalidade padrão. Uma nova 
spring.config.import propriedade é obrigatória. Sendo assim, o application.yml do fornecedor, com a solução não legada seria:

spring:
  application:
    name: 'fornecedor'
  profiles:
    active: default
  config:
    import: configserver:http://localhost:8888