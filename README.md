# JPO GeoJSON Consumer Test

This repository demonstrates a proof-of-concept for consuming and deserializing Kafka messages from the [JPO GeoJSON converter](https://github.com/usdot-jpo-ode/geojsonconverter) using schema-generated classes.

## Overview

This project showcases an approach to handle GeoJSON-formatted messages from Kafka topics by:

1. Using JSON schemas to generate strongly-typed Java classes
2. Leveraging these generated classes for automated serialization/deserialization
3. Processing messages from the GeoJSON converter in a type-safe manner

## Key Components

- **Schema-Generated Classes**: Located in `jpo-consumer/target/generated-sources/jsonschema2pojo/`
  - `ProcessedBsmSchema.java`: Basic Safety Message (BSM) schema
  - `ProcessedMapSchema.java`: MAP message schema
  - `ProcessedPsmSchema.java`: Personal Safety Message (PSM) schema
  - Supporting classes for shared properties and movement states

- **Consumer Implementation**:
  - `GeojsonConsumer.java`: Main consumer class that processes GeoJSON messages
  - `JacksonConfig.java`: Jackson configuration for JSON processing
  - `JpoConsumerApplication.java`: Spring Boot application entry point

## Getting Started

1. Ensure you have the following prerequisites:
   - Java 21
   - Maven
   - Access to a Kafka broker with GeoJSON converter topics

2. Build the project:

   ```bash
   mvn clean install
   ```

3. Run the application:

   ```bash
   java -jar jpo-consumer/target/jpo-consumer.jar
   ```

## Configuration

Configure Kafka connection details and other properties in `application.properties` or through environment variables.
