# Projeto SeuPCUpgrade

Projeto realizado para o bootcamp da DIO Inter Java Developer

No projeto é implementada uma API para cadastro de produtos
relacionados a componentes de computadores.

Tecnologias utilizadas:
- Spring WebFlux
- Library reativa Reactor
- banco DynamoDb
- Junit
- Postman 
- Swagger.

**Comando para ativar o DynamoDB Localmente**

- Os comandos dever ser realizados no PowerShell com o CLI da AWS instalado

java -D"java.library.path=./DynamoDBLocal_lib" -jar DynamoDBLocal.jar -sharedDb

Obs: Não esquecer de "-sharedDb", isso garante que a aplicação vai usar o mesmo banco de dados todas as vezes, sem criar novo a cada utilização

**Comando para exibir as tabelas existentes no banco de dados**
aws dynamodb list-tables --endpoint-url http://localhost:8000

**O dynamoDB deverá ser acessado localmente com as chaves da Amazom usando CLI da AWS com o comando**
aws configure


