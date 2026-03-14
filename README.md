The Policy Owner Service is a standalone microservice responsible for managing policy owner information in Alturion Policy Systems. It provides REST APIs which manages owner creation, retrieval of owner details, and the mapping between policy owners and agents. The service enforces uniqueness constraints on Aadhaar and PAN numbers to prevent duplicate records. The service is designed following microservice architecture principles with global exception handling, standardized API responses and ensures clear separation of responsibilities between domain services. The service collaborates with:

->Agent Service for agent-owner mapping operations.

->Policy Info Service for validating policy ownership during policy-related operations.

Responsibilities of this service includes managing policy owner information maintaining the Agent–Owner mapping providing owner data to other services Supporting aggregation operations required for dashboards. Service URLs and environment configurations are managed through application.properties

Tech Stack: Java 17, Maven, Spring Boot, Spring Data JPA, SQL, REST API, RestTemplate (inter-service communication), Global Exception Handling

Project Structure:

controller   → REST API endpoints

service      → business logic

repository   → database access layer

entity       → JPA entity classes

dto          → request and response models

client       → communication with other microservices

exception    → custom exceptions and global exception handling

config       → application configurations

API Endpoints:

POST - /create

GET  - /{userID}

POST - /agent/assign/agent

GET  - /agent/{agentId}

These endpoints support owner creation, owner information retrieval, assigning agents to owners, and retrieval of owner details associated with the agent.
