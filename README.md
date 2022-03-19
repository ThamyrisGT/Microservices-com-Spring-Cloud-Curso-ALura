# Microservices-com-Spring-Cloud-Curso-ALura

 ## Solução a ser implementada no curso:

Criação três microsserviços: Fornecedor, Loja e Transportador
- Uma apresentação da modelagem focado em DDD (Domain Driven Design)
- Quebraremos o domínio em contextos menores (bounded context)

Integração entre microsserviços com RestTemplate
- O RestTemplate do Spring permite chamadas HTTP de alto nível
- Introdução ao Service discovery e Service registry
- Service registry é um servidor central, onde todos os microsserviços ficam cadastrados (nome e IP/porta)
- Service discovery é um mecanismo de descoberta do IP do microsserviço pelo nome
  Dessa forma, nenhum microsserviço fica acoplado ao outro pelo IP/porta
- A implementação do service registry através do Eureka Server
- Registro da Loja e do Fornecedor no Eureka Server
- Resolução do IP/porta através do nome do microsserviço nas requisições, ou seja, os microsserviços não precisam conhecer o endereço IP das outras aplicações, mas apenas o nome que elas se registraram no Eureka.