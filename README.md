# ![Waracle Cake Manager Exercise - using Java, Spring and Docker](icon.png) Cake Manager.
[![CircleCI](https://dl.circleci.com/status-badge/img/gh/4loopltd/Waracle/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/4loopltd/Waracle/tree/master)

This codebase was created for the [Waracle Cake Manager Exercise](https://github.com/Waracle/cake-manager).

For the purpose of the exercise the project is faithful to the original requirements.

The project is organised as follows:
1. `cake-manager-client` UI using Spring & Thymeleaf
2. `cake-manager-service` API using Spring, H2 & Swagger
3. `docker-compose` Docker config which will build and run the application

## Getting started
You need installed:
- Docker

## Running 
To build and run the application
```
docker-compose up
```
To verify that it works, point your browser to:
http://localhost:8080/

For the purpose of the exercise, the API is also exposed:
http://localhost:8282/

*Port numbers are configurable via the docker config.*

## Endpoints
- http://localhost:8080/actuator/health
- http://localhost:8080
- http://localhost:8282/actuator/health
- http://localhost:8282
- http://localhost:8282/cakes
- http://localhost:8282/h2-console
- http://localhost:8282/swagger-ui.html

## Change log
- Application split into client & server
- Tests added
- Containerisation added
- Swagger added
- CircleCI added

## TODO: If time...
- OAuth?
