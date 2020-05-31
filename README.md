# Documentacao

# Tecnologias utilizadas
- Java 8
- Spring boot 2
- Spring Data Rest
- Spring Security com JWT(Java Web Token)
- Docker

# Como executar os testes:
$ mvn clean test

# Onde estao os scripts do banco?
Encontra-se em "scripts/"

# Criar o banco de dados Mysql perfil: Producao 
$ cd api-rest/
$ docker rm -f api-database; docker run --name api-database -p 3306:3306 -v ${PWD}/scripts/schema.sql:/docker-entrypoint-initdb.d/schema.sql -e MYSQL_ROOT_PASSWORD=root123 -e MYSQL_DATABASE=api-rest mysql:5.7

# Subindo a aplicação apontando para o banco Local (H2).
$ mvn clean install
$ cd target/
$ java -jar *.jar

# Se preferir, Subir a aplicação apontando para o banco Producao (Mysql).
$ mvn clean install
$ cd target/
$ java -jar -Dspring.profiles.active=production *.jar


## Caso queira utilizar o POSTMAN para realizar testes manuais:
 O arquivo encontra-se em "postman/rest-api.postam_collection.json"
 
 
#OBS: Os Testes usam o banco h2 mockado.