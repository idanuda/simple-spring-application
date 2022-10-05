# simple-spring-application

Spring boot application with basic rest controller.

## Description

Dockerized RestFul spring boot application.

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
$ docker run -dp 8080:8080 --rm -it my-app:latest
```
Live docker trace:
```
$ docker logs --follow <DOCKER-ID>
```

## Authors

Contributors names and contact info

ex. Idan Yehuda

## Version History

* 0.0.1
    * Initial Release

## License

This project is licensed under the MIT License - see the LICENSE.md file for details

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [PurpleBooth](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
* [dbader](https://github.com/dbader/readme-template)
* [zenorocha](https://gist.github.com/zenorocha/4526327)
* [fvcproductions](https://gist.github.com/fvcproductions/1bfc2d4aecb01a834b46)