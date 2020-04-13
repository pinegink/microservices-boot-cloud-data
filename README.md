# Project decription

**Technologies used:**

 - Spring Boot, Cloud
 - Spring Data JPA, PostgreSQL
 - Thymeleaf
 - Maven
 
**Workflow**

The project consist of three services 

![](https://github.com/pinegink/microservices-boot-cloud-data/blob/master/diagram.jpg)

All three services are connected to Postgres DB and Spring Data JPA is used for handling

When controller of "Songs catalog service" recieves the request:
 
1) "Songs catalog service" retrieves the keys from DB and passes the list to two other services

2) Two other services use theses values as keys for DB queries and send the results back as JSONs

3) The result is passed to the client as an html generated with use of Thymeleaf 
 
When one of services is not available Hystrix logs the message and returns a valid object
 

