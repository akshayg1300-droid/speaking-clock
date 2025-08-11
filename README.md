# Speaking Clock Microservice

## Overview
This is a Spring Boot microservice that converts 24-hour clock times into words.

### Features
- **Current Time in Words**  
  `GET /api/time/now` → Returns the current system time in words.  
  Example: `"08:34"` → `"It's eight thirty four"`

- **Parse User Input**  
  `GET /api/time/parse?time=HH:mm` → Converts a given 24-hour format time string into words.

- **Special Cases**  
  - `00:00` → `"It's Midnight"`
  - `12:00` → `"It's Midday"`

- Built with **Java 17**, **Spring Boot**, and **Swagger UI**.

---

## Prerequisites
- **Java**: JDK 17 
- **Maven**: 3.5+
- **Git**: Optional, for cloning the repo

---

## Build Instructions
```bash
# Clean and build the project
mvn clean install


# Run using Maven
mvn spring-boot:run

# OR run the JAR file
java -jar target/speaking-clock-0.0.1-SNAPSHOT.jar

#Get Current Time in Words
GET /api/time/now
{
  "message": "It's eight thirty four"
}

#Parse a Specific Time
{
  "message": "It's eleven twenty five"
}



http://localhost:8081/swagger-ui/index.html
