# Instant-Spring
pre-cooked spring web application with Thymeleaf template

## Development

### Prerequisites
* JDK 17
* Docker-Desktop

### Start the required services e.g. postgres
```bash
docker-compose -f docker/docker-compose.yaml up -d
```

### Stop the required services
```bash
docker-compose -f docker/docker-compose.yaml down
```

### Compiles, tests and assembles the code into JAR file
```bash
./gradlew build
```

### Run application
```bash
./gradlew bootRun
```