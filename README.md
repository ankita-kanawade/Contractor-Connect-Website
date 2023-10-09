# Contractor-Connect-Website

Contractor-Connect-Website is a web application built using Java Spring Boot, MySQL, HTML, CSS, Bootstrap, and Thymeleaf. It serves as a platform for connecting contractors, allowing users to add, edit, and update contractor details. The website is designed to be mobile-responsive and includes user admin functionality and other features.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Usage](#usage)
  
## Features

1. **User Registration and Authentication**: Users can register for an account and log in as administrators.

2. **Contractor Management**: Admin users can perform CRUD (Create, Read, Update, Delete) operations on contractor details.

3. **Mobile Responsiveness**: The website is designed to be accessible and usable on various devices, including mobile phones and tablets.

4. **Search Functionality**: Users can search for contractors based on various criteria.

5. **Other Features**: Users can connect with Contractor and manage construstion work.

## Technologies Used

- Java Spring Boot
- MySQL
- HTML
- CSS
- Bootstrap
- Thymeleaf

## Getting Started

These instructions will help you set up a development environment for Contractor-Connect-Website.

## Prerequisites

- Java Development Kit (JDK)
- MySQL Server
- Integrated Development Environment (IDE) like VS Code and Spring Suite Tool
- Git

## Installation

1. Clone the repository:

   ```shell
   git clone https://github.com/ankita-kanawade/Contractor-Connect-Website.git
   ```

2. Open the project in your preferred IDE.

3. Configure the MySQL database connection in `application.properties` with your database credentials:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   ```

4. Run the application.

## Usage

1. Open a web browser and navigate to `http://localhost:8080` (or the port you configured).

2. Register for an account or log in as an administrator.

3. Start managing contractors by adding, editing, or updating their details.
