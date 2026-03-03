The Policy Owner Service is a standalone microservice responsible for managing policy owner information in the insurance domain. It provides REST APIs to create and retrieve policy owner details using a unique system-generated identifier. The service enforces uniqueness constraints on Aadhaar and PAN numbers to prevent duplicate records. It follows a layered architecture with global exception handling and standardized API responses. It is built to support future inter-service communication in a distributed microservices ecosystem.

Tech Stack: 

Java 17

Spring Boot

Spring Data JPA

SQL DB

REST API

Global Exception Handling
