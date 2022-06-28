# Student Database Dynamic Web Application

Check the following sections below for more information:

:dart: Goals \
:memo: Description \
:file_folder: Repo structure and source files \
:arrow_forward: How to run the application \
:tv: Demonstation video 

## Goals

The primary goals are to demonstrate awareness of ==design patterns== (The Java DAO pattern in this case), the ability to connect (to) a ==database==, and other skills required to build a dynamic web application (e.g. ==Java Servlets==, ==The Fetch API==).

NB The UI components of the application built with plain JavaScript, CSS and HTML are aiming to slightly improve the user experience. That is, best practices were not followed nor frontend libraries / frameworks were used.

## Description

This is a small web application that allows the user to list all students, add, delete, and update student data saved in a database on a server.

Server-side implementation: Student class (model), StudentDAO (data access object), Servlets, SQL database.  

Client-side: The Fetch API. 

Other: UI components were built using JavaScript, CSS and HTML.

## Repo structure and source files

All code is located in the src/main folder

Java files src/main/java

Java files are divided into three folders:
* data_access - includes db connection parameters, db utils, the DAO
* model - includes the Student class
* servlets

JavaScript files and HTML & CSS src/main/webapp

## How to run the application

Cloud version is coming soon

To run the web application on a local host you would need to have installed the following:

- IDE: Eclipse IDE for Enterprise Java and Web Developers
- Database: PostgreSQL
- Web Server: Apache Tomcat 8.5.73

Run `src/main/webapp/index.html`

If you are not able to test the application, check a demonstration video below.

## Demonstration video

While a cloud version of the application is being developed, check the demonstration video below :)

