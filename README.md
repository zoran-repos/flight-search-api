# Flight-Search API

This is a Flight-Search API that allows users to search for flights based on various criteria.

## Prerequisites

- Java 8 or higher
- Maven
- Postman

## Getting Started

## Clone the repository:

- git clone https://github.com/zoran-repos/flight-search-api/tree/master

## Navigate to the project directory:

- cd flight-search-api

## Build the project using Maven:

- mvn clean install

## Start the application:

- mvn spring-boot:run

## Test with Postman

Testing with Postman
Open Postman.

Set the request method to GET.

Enter the API endpoint URL, e.g., http://localhost:8080/flights.

Add the required parameters, e.g., origin, destination.

(Optional) Add additional parameters, such as sort.

Click the Send button to execute the request.

Review the response to see the list of flights matching the search criteria.

good example: http://localhost:8080/api/flights?origin=BOM&destination=DEL&sort=price
