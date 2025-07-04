# CakeManagerService
The code is organised as follows:
1. `config` Spring configuration
2. `domain` is the domain model containing entities
3. `model`  is the business model containing entities
4. `repository` contains a data access object (DAO) which provides an abstract interface to the database
5. `resource` contains the rest controller
6. `service`  contains the services

# Database
H2 database, which can be easily changed in the `application.yml` for any other database.
URL `jdbc:h2:mem:cake-manager-service`

## Build
The application can be built using the following command:
```
gradlew clean build
```

## Running 
The application can then be started with the following command - here with the profile `production`:
```
java -Dspring.profiles.active=production -jar ./build/libs/cake-manager-service-0.0.1-SNAPSHOT.jar
```

## Test
To test that it works, point your browser to http://localhost:8080/swagger-ui.html alternatively, you can run
curl http://localhost:8080/actuator/health

## Endpoints
- http://localhost:8080
- http://localhost:8080/cakes
- http://localhost:8080/actuator/health
- http://localhost:8080/h2-console
- http://localhost:8080/swagger-ui.html

## Docker (Example)
Create network (If not created)
```
docker network create cake-app
```
Build
```
docker build -t cake-service-image .
```
Run
```
docker run --name cake-manager-service --network cake-app -p 8282:8080 cake-service-image
```

## Further readings
* [Gradle user manual](https://docs.gradle.org/)  
* [Spring Boot reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)  
* [Spring Data JPA reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)  
