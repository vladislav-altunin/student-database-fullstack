# Student Database Dynamic Web Application

This is a readme file for the student-database-fullstack GitHub repository. Check the following sections below for more information:

* Goals
* Description
* Repo structure and source files
* How to run the application
* Screenshots

## Goals

The primary goals are to demonstrate awareness of design patterns (The Java DAO pattern in this case), the ability to connect (to) a database, and other skills required to build a dynamic web application (e.g. Java Servlets, The Fetch API).

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