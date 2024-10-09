# Geolocation API 🌎

## Description

This project provides a REST API to convert geographic coordinates into city names using an external API.

## Requirements

- SpringBoot
- Maven
- Docker

## Running locally 💻

1. **Clone Repository:**
   ```bash
   git clone https://github.com/arturoburigo/GeoLocation-API.git
   ```

2. **Build and run:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. **API:**
    API will be available at `http://localhost:8080/api`.

## Building and running Docker 🐳

1. **Docker Image building:**
   ```bash
   docker build -t geo-location .
   ```

2. **Run the container:**
   ```bash
   docker-compose up
   ```

3. **API address:**

   API will be available at `http://localhost:8080/api`.


## Routes

- `GET /api/location?lat={lat}&lon={lon}`: Returns the city based on the provided coordinates.
- `POST /api/coordinates`: Receives a JSON object in the body with latitude and longitude, and returns the corresponding city.
- `GET /api/sobre`: Information about the project.

### Request Example

**GET** `/api/location?lat={lat_value}&lon={lon_value}`

**Response:**

```json
//For this example I'm using lat=40.7128&lon=-74.0060
{
	"País": "United States",
	"Cidade": "New York",
	"Estado": "New York"
}
```
**POST** `/api/coordinates`

**Json Body Example:**

```json
{
	"lat": -23.5505, 
	"lon": -46.6333
}
```
**Response:**
```json
{
  "País": "Brazil",
  "Cidade": "São Paulo",
  "Estado": "São Paulo"
}
```



