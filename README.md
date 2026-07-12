# MiniTaskAPI
To-Do List
A full-stack web application for managing tasks with a modern, card-based interface. Built with React.js for the frontend and Spring Boot (Java) for the backend, this app allows users to create, edit, delete, and mark tasks as complete, with data persisted in an H2 database.
Features

Add Tasks: Create new tasks with a title (limited to 100 characters).
Edit Tasks: Modify existing task titles inline.
Delete Tasks: Remove tasks with a single click.
Mark Complete: Toggle task completion with checkboxes, visually indicated by a strikethrough.
Modern UI: Sleek card layout with hover effects, centered design, and a coral-themed background.
Persistent Storage: Tasks saved in an H2 in-memory database during runtime.

Technologies

Frontend:
React.js: Dynamic, component-based UI.
JavaScript Fetch API: HTTP requests to the backend.
CSS: Custom styles for a polished, card-based design.

Backend:
Spring Boot (Java): RESTful API for CRUD operations.
H2 Database: In-memory storage for tasks.


Tools:
Node.js & npm: React app runtime and dependency management.
Maven: Spring Boot build and dependency management.



Prerequisites

Node.js (v16 or higher): Download
Java (JDK 17 or higher): Download
Maven: Download
Git: Download

Setup

Clone the Repository:
git clone https://github.com/your-username/to-do-list.git
cd to-do-list


Backend Setup:

Navigate to the backend directory (e.g., minitaskapi):cd minitaskapi


Install dependencies and run the Spring Boot app:mvn clean install
mvn spring-boot:run


The backend runs on http://localhost:8081.
(Optional) Access the H2 console at http://localhost:8081/h2-console (JDBC URL: jdbc:h2:mem:testdb, username: sa, no password).


Frontend Setup:

Open a new terminal and navigate to the frontend directory (e.g., task-manager):cd task-manager


Install dependencies and start the React app:npm install
npm start


The frontend runs on http://localhost:3000.



Usage

Open http://localhost:3000 in your browser.
Add a Task:
Enter a task title (max 100 characters) in the input field.
Click "Add Task" to save it.


Manage Tasks:
Complete: Check the box to mark a task as done (strikethrough applied).
Edit: Click "Edit" to modify the title, then "Save".
Delete: Click "Delete" to remove a task.


Tasks persist in the H2 database until the backend restarts (in-memory).

Project Structure

Frontend (task-manager/):
src/App.js: Main React component with UI and API logic.
src/App.css: Custom styles for the card-based design.


Backend (minitaskapi/):
src/main/java/.../Task.java: Task entity (id, title, completed).
src/main/java/.../TaskRepository.java: JPA repository for database operations.
src/main/java/.../TaskController.java: REST controller for API endpoints.



API Endpoints

GET /tasks: Retrieve all tasks.
POST /tasks: Create a new task (body: { "title": "Task", "completed": false }).
PUT /tasks/{id}: Update a task’s title or completion status.
DELETE /tasks/{id}: Delete a task.

Why This Project?

Learning: Demonstrates full-stack development, from React state management to Spring Boot API design.
Portfolio: Showcases modern UI design and backend integration for job applications or LinkedIn.
Scalability: Easily extendable (e.g., add persistent storage).

Future Improvements

Add persistent storage (e.g., MySQL) for tasks across sessions.
Implement user authentication for personalized task lists.
Enhance UI with animations or additional styling (e.g., task categories).

Contributing
Feel free to fork this repository, submit issues, or open pull requests. Contributions are welcome!
License
This project is licensed under the MIT License—see the LICENSE file for details.
Contact
Created by Preet—connect with me on [LinkedIn](https://www.linkedin.com/in/preet-dhillon-09b174270/) or email at preet_231@icloud.

