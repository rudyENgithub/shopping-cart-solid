# Spring Boot REST API CUSCATLAN TEST



## Getting Started

### Prerequisites

* Java 11
* JDK 11
* Maven


### Installing

* Clone the project
* Install the dependencies with `mvn install`
* Run the project with `mvn spring-boot:run`

### Usage

* The API is available at [http://localhost:8489](http://localhost:8489)
* The Swagger UI is available at [http://localhost:8489/swagger-ui.html](http://localhost:8489/swagger-ui/index.html)

## Database

MYSQL is used as the database.

### Application properties

The application properties are located in `src/main/resources/application.properties`.

```server.port=8489


# MySQL Connection Details
spring.jpa.hibernate.ddl-auto=create-drop
spring.datasource.url=jdbc:mysql://localhost:3306/cuscatlan_carrito
spring.datasource.username=root
spring.datasource.password=root123

spring.jpa.show-sql=true

logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
spring.jpa.properties.hibernate.jdbc.time_zone=America/El_Salvador


```

### Database creation

The database can be created with the following command:

```sql
CREATE DATABASE cuscatlan_carrito;
```

### Products

* `localhost:8489/api/products/populate` - GET - Get products from https://fakestoreapi.com/

### Orders

* `localhost:8489/api/orders` - GET - Get all orders
* `localhost:8489/api/orders/{id}` - GET - Get a order by id
* `localhost:8489/api/orders` - POST - Create a order
* `localhost:8489/api/orders/{id}` - PUT - Update a order
* `localhost:8489/api/orders/{id}` - DELETE - Delete a order

### Payments

* `localhost:8489/api/payments` - GET - Get all payments
* `localhost:8489/api/payments` - POST - Create a payments


## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Swagger](https://swagger.io/) - API Documentation
* [MYSQL](https://www.mysql.com/) - Database


## License

This project is licensed under the MIT License - see the [LICENSE©](LICENSE) file for details
