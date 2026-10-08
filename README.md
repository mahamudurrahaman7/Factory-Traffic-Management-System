# Factory Traffic Management System — Backend

## 1. Overview

Backend for a Factory Traffic Management System built with **Java and Spring Boot**.

Currently implemented:

* Junction management
* Sensor Event management
* REST APIs
* Validation
* PostgreSQL persistence
* DTO mapping with MapStruct
* Soft delete
* Junction–Sensor Event relationship

## 2. Tech Stack

Java • Spring Boot • Spring Data JPA • PostgreSQL • MapStruct • Maven • REST API • Bean Validation • Postman

## 3. Architecture

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

DTOs are used for API requests/responses, with MapStruct handling entity mapping.

## 4. Main Entities

### Junction

Represents a traffic junction and contains:

* ID
* Mode
* Current phase
* Controller status
* Desired/actual signals

### Sensor Event

Represents an event received from a sensor:

* Event ID
* Junction ID
* Sensor ID
* Event type
* Vehicle count
* Event time

One Junction can have many Sensor Events.

## 5. APIs

### Junction

```text
POST   /api/junctions
GET    /api/junctions
GET    /api/junctions/{id}
PUT    /api/junctions/{id}
PATCH  /api/junctions/{id}
DELETE /api/junctions/{id}
```

### Sensor Event

```text
POST   /api/sensor-events
GET    /api/sensor-events
GET    /api/sensor-events/{id}
PUT    /api/sensor-events/{id}
PATCH  /api/sensor-events/{id}
DELETE /api/sensor-events/{id}
```

## 6. Validation & Soft Delete

Request DTOs use Bean Validation such as `@NotNull`, `@NotBlank`, and `@PositiveOrZero`.

Junctions and Sensor Events use **soft delete**. Deleted records are marked with `isDeleted = true` instead of being physically removed.

## 7. Current Scope

The current implementation focuses on the **core CRUD and data-management layer**.

Advanced traffic-control logic such as:

* Dynamic signal timing
* Emergency vehicle priority
* Maximum waiting-time calculation
* Duplicate/out-of-order event handling
* Controller retry/recovery logic

has **not been implemented yet** because the required business rules are not fully defined. The current structure is designed so these rules can be added later.

## 8. Traffic States

Main phases:

```text
NORTH_SOUTH
EAST_WEST
ALL_RED
```

Signal states:

```text
RED
YELLOW
GREEN
```

`ALL_RED` can be used as a safety phase between conflicting green phases.

## 9. Database

PostgreSQL is used with the main tables:

```text
junction
sensor_event
```

`SensorEvent` references `Junction` through a foreign key.
## 10. Test Cases

| # | Test Case                                  | Expected Result            |
| - | ------------------------------------------ | -------------------------- |
| 1 | Create Junction with valid data            | `201 CREATED`              |
| 2 | Create Sensor Event with valid Junction ID | Event created successfully |
| 3 | Get resource by valid ID                   | Correct resource returned  |
| 4 | Request non-existing resource              | `404 NOT FOUND`            |
| 5 | Send invalid/incomplete request            | `400 BAD REQUEST`          |

Postman can be used to manually verify the API flow, and a Postman collection is included with the project.

## 11. Error Handling

Common HTTP responses:

```text
200 OK
201 CREATED
204 NO CONTENT
400 BAD REQUEST
404 NOT FOUND
```

Invalid request data is rejected through validation.

## 12. Demonstration Flow

```text
1. Create a Junction
       ↓
2. Get the Junction
       ↓
3. Create a Sensor Event using Junction ID
       ↓
4. Get the Sensor Event
       ↓
5. Update / Delete resources
```

A Postman collection is included for API testing.

## 13. Running the Project

Requirements:

* Java
* Maven
* PostgreSQL

Create a PostgreSQL database:

```text
factory_traffic_management
```

Configure the database connection in:

```text
application.properties
```
