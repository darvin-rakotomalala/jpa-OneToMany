## Spring Data JPA/Hibernate | One-To-One
Dans ce repo, nous allons voir comment implémenter le mappage bidirectionnel Spring JPA `One-To-Many`/`Many-To-One` avec Hibernate dans un exemple Spring Boot à l'aide d'annotations `@OneToMany` et `@ManyToOne`.

### Technologies
---
- Java 11
- Spring Boot 2.7.3
- Spring Data JPA
- Lombok
- Maven 3+
- PostgreSQL
- MapStruct

### Exemple
---
CRUD - L'entité `posts` a une relation un-à-plusieurs avec l'entité `comments`.

### Exécuter et tester le projet
---
- Exécuter l'application `mvn spring-boot:run`
- Importer dans Postman la collection `jpa-OneToMany.postman_collection.json` pour tester les APIs
- Vous pouver utiliser aussi l'url du Swagger ou importer l'url Swagger dans Postman
  - Les descriptions OpenAPI seront disponibles au chemin `/v3/api-docs` par défaut : http://localhost:8081/v3/api-docs/ et/ou http://localhost:8081/swagger-ui/index.html