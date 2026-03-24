Policy Owner Service:

1) Description:

The Policy Owner Service is a standalone microservice within the Alturion Policy Systems, responsible for managing policy owner data and enforcing data integrity constraints. This service ensures uniqueness of critical identifiers such as Aadhaar and PAN to prevent duplicate records. It is designed by following microservice architecture principles, with a strong focus on separation of concerns, scalability, and maintainability. The service also integrates secure authentication and authorization mechanisms using Spring Security and JWT.

2) Responsibilities:

• Create and manage policy owner records

• Maintain Agent–Owner mappings

• Provide owner details to other microservices

• Support aggregation use cases for dashboards

• Validate policy ownership during inter-service communication

3) Tech Stack: Java 17, Maven, Spring Boot, Spring Data JPA, SQL, REST API, RestTemplate (inter-service communication), Spring Security (JWT-based Authentication & Authorization), Global Exception Handling

4) Project Structure:

controller   → Exposes REST endpoints and handles HTTP requests/responses

service      → Contains core business logic and orchestration

repository   → Handles database interactions using Spring Data JPA

domain       → Represents JPA entities mapped to database tables

dto          → Defines request and response payloads for APIs

client       → Handles inter-service communication using RestTemplate

exception    → Contains custom exceptions and global exception handling

config       → Includes application-level configurations

security     → Contains JWT-related components

5) Application Security:

• Implemented JWT-based authentication using Spring Security with a custom filter to validate tokens and set the SecurityContext for each request.

• Enforced access control using @PreAuthorize with role checks and user-specific validation to ensure users can only access their own data.

• Secured inter-service communication by forwarding JWT tokens via a custom interceptor, enabling authorization checks across microservices.

6) Public Endpoints:

POST /api/policyowners/create

POST /api/policyowners/login

7) Secured Endpoints (Requires JWT):

GET  /api/policyowners/{userID}

POST /api/policyowners/agent/assign-agent

GET  /api/policyowners/agent/{agentId}

8) Configuration:

Environment-specific properties are managed via application.properties which includes:

Database configuration, JWT secret key, Service URLs for inter-service communication
