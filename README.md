# test-target-systemas

Após iniciar o projeto, iniciado a dockerização do projeto para criar um pipeline de entrega continua com o gitActions e a hub do Docker neste caso.

criado 2 endpoints um para salvar um novo recurso e um para busca de todos os recursos como pede o test apenas uma busca de recusos, para fazer sentido criei um endpoint para salvar os dados.

para acesso do swagger 

link: http://localhost:8000/api/target/swagger-ui/index.html#/

para acesso do bando de dados em memoria h2

link: http://localhost:8000/api/target/h2-console/login

fiz teste em todas as camadas, repository como integração, serviços e controller, como objetivo de mostrar uma aplicação escalavel e testavel.

na raiz do projeto dar um comando: mvn clean install, é necessário ter o maven instalado e passado para as variaveis de ambiente.

como foi passando um retorno de xml e um de json, o mesmo endipoint de busca tem ambos os recursos, com uma anotação do pacote jackson.

