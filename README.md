# Meal Planner API

## Overview

This is a Spring Boot-based RESTful API for planning meals for a day or week based on given parameters like calorie count, diet type, and food exclusions. The API uses the Spoonacular API for generating meal plans.

## Features

- Get meals planned for a day
- Get meals planned for a week
- Customize meal plans by:
  - Calorie count
  - Diet type (e.g., vegetarian, keto, etc.)
  - Food exclusions (e.g., nuts, dairy, etc.)

## Technologies Used

- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- Spoonacular API

## Setup and Installation

### Prerequisites

- JDK 11 or higher
- Maven 3.x
- Spring Boot 2.x
- Spoonacular API key

### Steps

1. Clone the repository:


git clone https://github.com/OSUMed/MealPlanner.git

2. Navigate into the project directory:

cd MealPlanner

3. Add your Spoonacular API key in the `application.properties` file:

properties
API.key=your_spoonacular_api_key_here


4. Build the project:


mvn clean install


5. Run the application:


mvn spring-boot:run


## API Endpoints

- `GET /mealplanner/day`: Get meals for a day.
    - Parameters:
        - `numCalories` (optional): Number of calories
        - `diet` (optional): Diet type
        - `exclusions` (optional): Food exclusions
- `GET /mealplanner/week`: Get meals for a week.
    - Parameters are the same as for `/mealplanner/day`.

## Usage Examples


GET /mealplanner/day?numCalories=1500&diet=vegetarian
GET /mealplanner/week?exclusions=nuts,dairy


## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
