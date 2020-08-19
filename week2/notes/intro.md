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

## Cardinality / Multiplicity

Describes the numerical relationship between 2 tables. There are 3 categories:

- 1 to 1
  - Individual records in one table are associated with only 1 record in the other
  - Can be created by using unique foriegn key constraints
  - Note the foreign key may be on either side of the relationship
- 1 to many (or many to 1)
  - Individual records in one table are associated with many records in the other
  - Ex: Bees to beehives
  - Accomplished with a non-unique foreign key
  - Note, that the foreign key must be on the many side of the relationship
- many to many
  - Records in both tables are associated with many records in the other
  - Ex: Students and Courses or Students and Professors
  - We construct this relationship using a join table

Join tables are a separate, independent table. It consists of 2 columns, both of which are foreign keys back to the original source tables. Both of these columns will be non-unique foreign keys, to effectively structure this as two 1 to many relationships back to back. Neither source table will contain any foreign keys to the other table in regards to this relationship

Table1 PKs
1
2
3
4

Table2 PKs
1
2

Join Table
1 1
1 2
2 1
4 2
3 1

Example join table name: users_accounts_jt
The primary key of the join table is commonly structured (but not always) as a composite key over both columns

## Normalization

Database Normalization = Design Pattern for databases that aims to reduce both duplicate data and redundancy

Must always ensure *Referential Integrity*
Atomic Data = Data that has been broken down into the smallest possible meaningful unit
Ex: Multiple phone numbers should be separated into different records/cells

Levels of Normalization
- 0NF = Zero Normal Form
  - No normalization whatsoever
  - Absolute Chaos
- 1NF = 1st Normal Form
  - All data must be atomic
  - Table should have a primary key
- 2NF = 2nd Normal Form
  - 1NF + No Partial Dependencies
    - All records must be identified by a single column (no composite keys)
- 3NF = 3rd Normal Form
  - 2NF + No Transitive Dependencies
    - No column is dependent upon a column that is not the Primary Key
    - Ex of Transitive Dependencies:
      - supervisorId & supervisorName
      - supervisorName is NOT dependent upon the PK of the employees table
      - It is dependent upon the supervisorId column
- There are always more Normalization levels
- There are complicated nuanced levels that go on even beyond 6NF for example
- However, they out of scope for this training at least
