# CakeManagerClient
The code is organised as follows:
1. `client` cake rest api client
2. `controller` contains the ui controller
3. `model` is the business model containing entities
4. `service`  contains the services

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
To test that it works, point your browser to http://localhost:8080 alternatively, you can run
curl http://localhost:8080/actuator/health

## Endpoints
- http://localhost:8080
- http://localhost:8080/actuator/health

## Further readings
* [Gradle user manual](https://docs.gradle.org/)  
* [Spring Boot reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)  
* [Spring Data JPA reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)  
