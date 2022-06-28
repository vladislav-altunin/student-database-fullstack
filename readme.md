# Student Database Dynamic Web Application

Check the following sections below for more information:

:dart:  Goals \
:memo:  Description \
:file_folder:  Repo structure and source files \
:arrow_forward:  How to run the application \
:camera:  Screenshots 

## Goals

The primary goals are to demonstrate awareness of _design patterns_ (The Java DAO pattern in this case), the ability to connect (to) a _database_, and other skills required to build a dynamic web application (e.g. _Java Servlets_ , _The Fetch API_ ).

NB The UI components of the application built with plain JavaScript, CSS and HTML are aiming to slightly improve the user experience. That is, best practices were not followed nor frontend libraries / frameworks were used.

## Description

This is a small web application that allows the user to list all students, add, delete, and update student data saved in a database on a server.

Server-side implementation: Student class (model), StudentDAO (data access object), Servlets, SQL database.  

Client-side: The Fetch API. 

Other: UI components were built using JavaScript, CSS and HTML.

## Repo structure and source files

All code is located in the `src/main` folder

Java files `src/main/java`

Java files are divided into three folders:
* `data_access` - includes db connection parameters, db utils, the DAO
* `model` - includes the Student class
* `servlets`

JavaScript files and HTML & CSS `src/main/webapp`

## How to run the application

Cloud version is coming soon

To run the web application on a local host you would need to have installed the following:

- IDE: Eclipse IDE for Enterprise Java and Web Developers
- Database: PostgreSQL
- Web Server: Apache Tomcat 8.5.73

Run `src/main/webapp/index.html`

If you are not able to test the application, check some screenshots below.

## Screenshots

While a cloud version of the application is being developed, here are some screenshots :)

1. Home page, empty database, CTA "Add Student"

![home page](https://github.com/vladislav-altunin/student-database-fullstack/blob/main/src/main/webapp/images/student_db_pics/empty.png)

2. Add student form (can be autofilled)

![add student](https://github.com/vladislav-altunin/student-database-fullstack/blob/main/src/main/webapp/images/student_db_pics/add.png)

3. Home page, populated database

![database](https://github.com/vladislav-altunin/student-database-fullstack/blob/main/src/main/webapp/images/student_db_pics/database.png)

4. Update student information. Notice, that student number cannot be updated.

![update student](https://github.com/vladislav-altunin/student-database-fullstack/blob/main/src/main/webapp/images/student_db_pics/update.png)

5. Delete student. Confirm deletion.

![delete student](https://github.com/vladislav-altunin/student-database-fullstack/blob/main/src/main/webapp/images/student_db_pics/delete.png)
