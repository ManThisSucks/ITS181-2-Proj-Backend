# Pet API

A RESTful API for managing dog data, including information about availability, reservation, and other details. This API provides CRUD operations for managing dogs, allowing integration with front-end applications such as Angular.

## Endpoints

All endpoints are CORS-enabled for `http://localhost:4200`. This is for compatibility with the sister Angular project that you can find in https://github.com/ManThisSucks/ITS181-2-Proj-Frontend 

### Get All Dogs
- **URL**: `/api/dogs/all`
- **Method**: `GET`
- **Description**: Returns a list of all dogs.

### Get Available Dogs
- **URL**: `/api/dogs/available`
- **Method**: `GET`
- **Description**: Returns a list of all available dogs (not reserved).

### Get Dog by ID
- **URL**: `/api/dog/{id}`
- **Method**: `GET`
- **Description**: Retrieves a specific dog by ID.

### Add a Dog
- **URL**: `/api/add-dog`
- **Method**: `POST`
- **Description**: Adds a new dog to the database.
- **Request Body**: `Dog` object (JSON)

### Add Multiple Dogs
- **URL**: `/api/add-dogs`
- **Method**: `POST`
- **Description**: Adds multiple dogs to the database.
- **Request Body**: List of `Dog` objects (JSON)

### Update a Dog
- **URL**: `/api/update-dog/{id}`
- **Method**: `PUT`
- **Description**: Updates an existing dog’s information.
- **Request Body**: `Dog` object (JSON)

### Delete a Dog
- **URL**: `/api/dog/{id}`
- **Method**: `DELETE`
- **Description**: Deletes a dog by ID.

### Reserve a Dog
- **URL**: `/api/reserve-dog/{id}`
- **Method**: `GET`
- **Description**: Marks a dog as reserved by ID.

### Unreserve a Dog
- **URL**: `/api/unreserve-dog/{id}`
- **Method**: `GET`
- **Description**: Marks a reserved dog as available by ID.

## Models

### Dog
- **Fields**:
    - `id`: Long (unique identifier)
    - `name`: String
    - `breed`: String
    - `age`: Integer
    - `description`: String
    - `isAvailable`: Boolean
    - `imageFilePath`: String

## Setup

To use the API, ensure the following:
1. Clone the repository.
2. Set up a MySQL database and configure connection properties.
3. Start the Spring Boot application.

### Easy API Tests with Postman
Listed below are some POSTMAN tests you can try. 

#### Add new dogs
this adds 5 dogs to the database (useful for starting out)
POST Request to http://localhost:18080/api/add-dogs
```json
[
    {
        "name": "Buddy",
        "breed": "Golden Retriever",
        "age": 3,
        "description": "Male, golden color, large size",
        "available": true,
        "imageFilePath": ""
    },
    {
        "name": "Bella",
        "breed": "Beagle",
        "age": 5,
        "description": "Female, tri-color, medium size",
        "available": true,
        "imageFilePath": ""
    },
    {
        "name": "Max",
        "breed": "Labrador",
        "age": 4,
        "description": "Male, black color, large size",
        "available": false,
        "imageFilePath": ""
    },
    {
        "name": "Luna",
        "breed": "Corgi",
        "age": 2,
        "description": "Female, tan and white, small size",
        "available": true,
        "imageFilePath": ""
    },
    {
        "name": "Rocky",
        "breed": "Bulldog",
        "age": 6,
        "description": "Male, brindle coat, medium size",
        "available": false,
        "imageFilePath": ""
    }
]
```

#### View all dogs
this should respond with the data for all dogs
GET Request to http://localhost:18080/api/dogs/all
(no body)

#### Reserve a dog
try reserving one of the dogs with available=true
GET Request to http://localhost:18080/api/reserve-dog/5
(no body)
_(make sure to replace the id in the URL with the id of an available dog)_
