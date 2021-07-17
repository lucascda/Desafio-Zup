<h1>Desafio Zup Orange Talents</h1>
<p> Requisitos do desafio: https://gist.github.com/lucascda/ce8f40271ec88261a756a1153c88c264</p>
Antes de testar o projeto crie um arquivo chamado application-test.properties em src/main/resources com as seguintes configurações recomendadas:

```
#Configuração H2
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

#config jpa hibernate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true  


#marvel api
marvel.key= 
marvel.hash= 
marvel.uri= gateway.marvel.com/v1/public
```
<p>No lugar de marvel.key e marvel.hash adicione a sua chave pública e a hash(chave publica + timestamp + chave privada em md5) de acordo com as regras da Marvel Api.</p>
<p>Usei uma timestamp igual a 1 em todas as requisições, então use o modelo: 1+chave pública+chave privada</p>
<p>Link de como criar a hash e autorização no geral: https://developer.marvel.com/documentation/authorization</p>
<p>Link da documentação da Marvel API: https://developer.marvel.com/documentation/getting_started</p>

Endpoints da API:
```
POST http://localhost:8080/v1/users/    : Cria um usuário passando os atributos dele em um payload JSON
GET http://localhost:8080/v1/users/{id} : Busca um usuário de {id} do tipo Long
POST http://localhost:8080/v1/comics/{ComicId}/{id} : Cadastra uma comic de {ComicId} do tipo inteiro(vide Marvel API) passando um {id} de um usuário.
```
