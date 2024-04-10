# Quarkus Booking Application

This is a sample application built with the Quarkus framework. It's a simple booking system where users can create, read, update, and delete bookings. The purpose of this application is to demonstrate the capabilities of Quarkus and serve as a learning resource for developers interested in this technology.

The application is a simple booking system. It exposes a REST API that allows clients to create, read, update, and delete bookings. Each booking has a client name and a car type.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

## Running the Application

To run the application, you need to have Docker installed on your machine. Follow the steps below:

1. Build the application using Gradle:

```bash
./gradlew build
```

2. Build the Docker image:

```bash
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/quarkus-jvm .
```

3. Run the Docker container:

```bash
docker run -i --rm -p 8080:8080 quarkus/quarkus-jvm
```

After executing these commands, the application will be accessible at `http://localhost:8080`.

## Running the Tests

To execute the unit and end-to-end tests, use the following command:

```bash
./gradlew test
```

This will run all the tests in the `src/test` directory.
