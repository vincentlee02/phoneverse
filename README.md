# phoneverse
BCA Internship Personal Project

Rangkuman dari semua yang dipelajari untuk menyelesaikan PhoneVerse

Microservices is a development method which breaks down software into modules with detailed interfaces and specialized functions

Containers are an example of microservice architecture since containers host the individual microservices that form a microservice application

Containers are ideal because of its fast start times, security (provide isolation on the containerized microservice), easier management and network configuration since all microservices run in containers managed on the same platform.

Whether to use containers as a method to implement microservice architecture depends on the needed scenarios, for example if the microservices require different OS environment

example of containers are Docker and Kubernetes

Packages are modules of code which are compiled together into an application

Virtual Desktop Infrastructure is a technology that refers to the use of virtual machines to provide and manage virtual desktops. VDI hosts desktop environment on a centralized server and deploys them to end-users on request

Benefits of virtual desktop infrastructure: enable secure and productive remote work on any device, reduce cost of licensing and infrastructure, protect against outages to stay productive, simplify IT management, and keep application and user data secure


proxy is a server that acts as a gateway between a client requesting a resource and the server providing the resource.

REST (Representational State Transfer) is an architectural style that defines a set of constraints to be used for creating web services. REST API is a way of accessing web services in a simple and flexible way without having any processing.

A request is sent from client to server in the form of web url as HTTP GET or POST or PUT or DELETE request.
A response from the server in the form of a resource which can be anything like HTML, XML, Image, SOAP (Simple Object Access Protocol) or JSON.
For now, JSON is the most popular format being used in Web Services.

RESTful web services are very popular because they are light weight, highly scalable, and maintainable and are very commonly used to create APIs for web-based application.

Benefits of using REST: the use of actions (GET, POST, PUT, DELETE), caching, redirection and forwarding, and security (encryption and authentication)

Caching refers in storing the server response in the client itself, so that a client need not make a server request for the same resource again and again

springboot snapshot means that it has not been released yet

good link for studying REST: https://www.codecademy.com/article/what-is-rest

REST is stateless and separate the concerns of client and server

Separating concerns of client and server means code on the client side can be changed at any time without affecting the operation of the server and code on the server side can be changed without affecting the operation of the client.

As long as each side knows what format of messages to send to the other, they can be kept modular and separate, which allows each component the ability to evolve independently.

Stateless means that the server does not need to know anything about what state the client is in and vice versa. This constraint of statelessness is enforced through the use of resources, rather than commands.

In REST architecture, clients send requests to retrieve or modify resources, and servers send responses to those requests.

A request generally consists of: an HTTP verb, a header, a path to the resource, and an optional message body containing data.

HTTP verb defines the kind of operation to perform which are GET (retrieve), POST (create), PUT (update), DELETE (remove).

In the header of the request, the client sends the type of content that it is able to receive from the server.
This is called the Accept field which ensures the server does not send data that cannot be understood or processed by the client.

MIME types that is used to specify the content types in the accept field consists of a type and subtype separated by slash (/).

Examples of MIME types and subtypes:
image -> image/png, image/jpeg, image/gif
audio -> audio/wav, audio/mpeg
video -> video/mp4, video/ogg
application -> application/json, application/pdf, application/xml, application/octet-stream

For example, a client accessing a resource with id 23 in an article resource on a server might send a GET request like this:
GET /articles/23
Accept: text/html, application/xhtml

In RESTful APIs, paths should be designed to help the client know what is going on. It must be hierarchical and descriptive. For example fashionboutique.com/customers/223/orders/12

An example of response from the server for
GET /articles/23 HTTP/1.1
Accept: text/html, application/xhtml
The server responds back with the content along with the response header as such
HTTP/1.1 200 (OK)
Context-Type: text/html

Some of the response code:
200 - OK
201 - CREATED
204 - NO CONTENT (succcessful response after delete)
400 - BAD REQUEST
403 - FORBIDDEN
404 - NOT FOUND
500 - INTERNAL SERVER ERROR

Before the Servlet 3.x specification, DispatcherServlet would be registered in the web.xml file for a Spring MVC application. Since the Servlet 3.x specification, we can register servlets programmatically using ServletContainerInitializer.

JPA or Java Persistence API is one possible approach to Object Relational Mapping. Via JPA, the developer can map, store, update, and retrieve data from relational databases to Java objects and vice versa

Hibernate is one of the best implementations of JPA where it maps Java classes to database tables and from Java data types to SQL data types and relieves the developer from most common data persistence related programming tasks.

Spring Bean: semua class yg diberikan spring annotation menjadi bean
@autowired = making sure that every class using 1 single instance (singleton konsep), jadi harus diberikan annotation @autowired biar tiap kelas bisa memakai 1 single instance yg sama (gausah bikin object baru lagi)

Setting Up DevTools
Go to settings -> advanced settings -> check allow auto-make to start even if developed application is currently running
Go to settings -> search "compiler" -> check build project automatically
Go to main java file (click on public class)-> modify run configuration -> modify options -> on update action -> update classes and resources and on frame deactivation -> update classes and resources

Adding BootStrap to pom.xml dependencies
<dependency>
  <groupId>org.webjars</groupId>
  <artifactId>bootstrap</artifactId>
  <version>4.3.1</version>
</dependency>
  <dependency>
  <groupId>org.webjars</groupId>
  <artifactId>webjars-locator-core</artifactId>
</dependency>

di file view html tambahin ini
<html lang="en" xmlns:th="https://www.thymeleaf.org"> (setelah !DOCTYPE html
didalam tag <head> tambahin <link rel="stylesheet" type="text/css" th:href="@{/webjars/bootstrap/css/bootstrap.min.css}"/> di paling bawah

to check if bootstrap is already applied, inspect on the page in browser and click on the href webjars and see if the content of bootstrap.min.css has contents on it

in application.properties file, to configure for using PostGreSQL as the database server, use this code
server.port=8080
spring.datasource.url=jdbc:postgresql://localhost:5432/usersdb <- name of the db
spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database=postgresql
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
                                                                  
Hibernate Validator
https://docs.jboss.org/hibernate/validator/3.1/reference/en/html_single/

SQL Queries in Repository
https://www.baeldung.com/spring-data-jpa-query
                                                                  
                                                                
