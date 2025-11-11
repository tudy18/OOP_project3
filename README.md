# OOP Project 3 – MovieStar

JavaFX application for browsing movies, viewing schedules, selecting seats, and checking out tickets.

## Requirements
- Java 17 (LTS)
- Maven 3.8+
- MySQL 8.x with a database named `movie`

## Setup
1. Ensure MySQL is running and create the `movie` database.
2. Update the database credentials if needed in `src/main/java/org/example/oop_project3/utils/DatabaseConnection.java`.
3. Install dependencies and run the app:

```
mvn clean javafx:run
```

## Project Structure
- `org.example.oop_project3.MainApp` – JavaFX entry point.
- `controllers/` – UI controllers for screens.
- `models/` – Domain models like `MovieDetails`, `SelectTickets`.
- `dao/` – Data access classes for persistence.
- `utils/` – Utilities such as `DatabaseConnection`.

## Notes
- The app expects existing tables (`movies`, `schedules`, `users`, etc.). Ensure your schema matches queries in DAOs and controllers.
- Default DB credentials are for local development. Change them for your environment.

## Running
Run via Maven:

```
mvn clean javafx:run
```

If you use an IDE, configure the module `org.example.oop_project3` and run `MainApp`.