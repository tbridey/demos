# SQL

SQL = Structured Query Language

It is NOT a programming language, it is a "Query" language. It's a language we use to perform operations against a relational database.

Database is an organized collection of data, stored in an organized format

- Allows us to input, manage, organize, and retrieve data quickly
- Traditionally, it is organized into "tables" with "records" as rows and "fields" as columns
- Data is the intersection between rows and columns

RDBMS = Relational DataBase Management System
- A database management system that upholds specified relationships between tables
- Include functions that maintain the security, accuracy, integrity, and consistency of the data

## SQL Sublanguages
- DDL = Data Definition Language
  - For creation/alteration of table structure
  - CREATE, ALTER, TRUNCATE (Removes ALL data within a table), DROP (delete table)
- DML = Data Manipulation Language
  - Changing/manipulation/modification of the data within a table
  - In regards to CRUD Operations (Create, Read, Update, Delete)
  - INSERT, SELECT, UPDATE, DELETE (delete records)
- DQL = Data Query Language
  - Pertains to the Reading of the data
  - Some consider this not to be a real sublanguage
  - SELECT
- DCL = Data Control Language
  - Regulating access to the data by imposing restrictions like user permissions
  - Pertains to security
  - GRANT, REVOKE
- TCL = Transaction Control Language
  - Pertain to work on the database, and finalizing or reverting changes
  - COMMIT, ROLLBACK, SAVEPOINT, SET TRANSACTION (used to set isolation level)

## Constraints

Constraint = Rules (or conditions) to follow for enforcing database table relationships

1. Primary Key
  - Data in this column is unique, not null
  - Acts as the unique identifier for records in this table
  - A composite key is just a Primary Key that consists of multiple columns together
2. Foreign Key
  - Data in this column references the primary key of another table
  - Establishes relationships between 2 columns in the same table or different tables
3. Unique
  - Data in this column may not have duplicates
  - May still have multiple null values
4. Not Null
  - Make sure that data in this column is not empty (null)
5. Default
  - Provide a default value in case a value was not already provided
6. Check
  - Adds an extra condition (logical conditions) on data
  - Such as age >= 18
