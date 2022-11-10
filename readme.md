# Simple Spring Boot Application

Spring boot application that implements proxy server for external api (swapi).

## Description

1. Two endpoint:
  
`GET /api/people/?page=[NUMBER]`
   * query-params: (Integer) `page` - define the number of the page.
     
`GET /api/people/{id}`
* route-param: (Integer) `id` - The specific people id.
     
2. For efficiency, all endpoints are cached.

## Getting Started

### Dependencies

* maven
* docker (for dockerized app)

### Installing and Run

Maven: 
```
$ mvn install
$ mvn spring-boot:run
```

Dockerized: 
```
$ docker build -t my-app .
$ docker run -dp 8080:8080 --rm -it my-app:latest spring.profiles.active=dev
```
Live docker trace:
```
$ docker logs --follow <DOCKER-ID>
```

## Authors

Contributors names and contact info

Idan Yehuda - idanuda@gmail.com

## Version History

* 0.0.1
    * Initial Release

## License

This project is licensed under the MIT License - see the LICENSE.md file for details

