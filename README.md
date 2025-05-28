# Habitat Service - EcoHabitats Platform

Este microservicio forma parte del sistema distribuido **EcoHabitats**, una aplicación de gestión ecológica de viviendas. `habitat-service` es responsable del registro, modificación y consulta de las propiedades habitacionales (piso, chalet, etc.) asociadas a cada usuario.

---

## Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 3.4.6**
- **Spring Cloud 2024.0.1**
- **Spring Data JPA**
- **MySQL**
- **Eureka Discovery Client**
- **Feign Client**
- **Swagger / OpenAPI (springdoc-openapi 2.3.0)**

---
### Modelo de datos Habitat  


El modelo `Habitat` representa un espacio para someterse a una mejora de su eficiencia
energética (vivienda, piso, chalet...)

| Atributo  | Tipo de dato | Descripción                            |
|-----------|--------------|----------------------------------------|
| `id`      | `long`       | Identificador único del hábitat        |
| `location` | `string`     | Ubicación geográfica del hábitat       |
| `type`    | `string`     | Tipo de vivienda (p. ej., piso, chalet) |

> Se utiliza para registrar y consultar propiedades habitacionales asociadas a usuarios registrados en la plataforma.


## Estructura

```
com.ecohabitat.habitat_service
├── controllers         # Controladores REST
├── dto                 # Clases DTO para PATCH
├── exceptions          # Excepciones personalizadas y manejador.
├── models              # Entidades JPA
├── repositories        # Interfaces JPA para acceso a datos
├── service             # Lógica de negocio
└── HabitatServiceApplication.java
```

---

## 🔗 Endpoints Principales

| Método | Endpoint                        | Descripción                              |
|--------|---------------------------------|------------------------------------------|
| GET    | `/api/habitat`                  | Obtener todos los hábitats               |
| GET    | `/api/habitat/{id}`             | Obtener un hábitat por ID                |
| POST   | `/api/habitat`                  | Crear un nuevo habitat
| PATCH  | `/api/habitat/update/{id}`      | Actualizar el `ownerId` del hábitat      |
| DELETE | `/api/habitat/delete/{id}`      | Eliminar un hábitat                      |

---

##  Gestión de Errores

Este servicio utiliza un `@ControllerAdvice` centralizado para gestion de errores.  
#### Para que swagger sea accesible se ha de comentar este anotador.  
Ejemplos:
- `HabitatNotFoundException` → 404 Not Found
- `HabitatsNotFoundException` → 404 Not Found


---

## Documentación Swagger

La API está documentada automáticamente con **Swagger/OpenAPI**.

- Accede a:  
  [`http://localhost:8083/swagger-ui.html`](http://localhost:8083/swagger-ui.html)  
  o  
  [`http://localhost:8083/swagger-ui/index.html`](http://localhost:8083/swagger-ui/index.html)

---

## Configuración `application.properties`

```properties
spring.application.name=habitat-service
server.port=8083

spring.datasource.url=jdbc:mysql://localhost:3306/habitat_service
spring.datasource.username=*****
spring.datasource.password=*****

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

eureka.client.service-url.defaultZone=http://localhost:8081/eureka/
```

---

## Cómo Ejecutar

1.  **MySQL** y **Eureka Server**  activos.
2.  Ejecutar.
3. Verifica que esté registrada en Eureka:  
   [http://localhost:8081/eureka](http://localhost:8081/eureka)

---

## Estado del Servicio

- [x] CRUD de hábitats
- [x] Gestión de excepciones
- [x] Documentación Swagger
- [x] Integración con Eureka
- [x] Integración con Feign
- [x] Integración con Gateway
- [x] Pruebas unitarias (en curso)
- [x] Pruebas mock (en curso)

---

Proyecto académico (IronHack BackEnd 2025)
