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

Table1 PK       |
:---------------|
1               |
2               |
3               |
4               |

Table2 PK       |
:---------------|
1               |
2               |

Join Table FK1  |Join Table FK2  |
:---------------|----------------|
1               |1               |
1               |2               |
2               |1               |
4               |2               |
3               |1               |

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

## Transactions

A transaction is a unit of work performed against a database. It is the propagation of one or more changes to the database. Generally used with UPDATE, DELETE, and INSERT operations.

A transaction would be used if you want to group multiple operations together and execute them all at once.

### ACID (Properties of Transactions)

A. Atomicity
  - The operation occurs successfully or not at all
  - If it fails, the transaction will be aborted and changes will be rolled back
C. Consistency
  - Ensure that the database properly changes state upon a successfully commit transaction
  - No transaction should have any adverse effect on the data residing in the database
    - Referential Integrity must be maintained
I. Isolation
  - Enables transactions to operate independently of each other
  - Provides the ability to support parallel processing for performance benefits
  - Some issues could potentially arise due to this however
D. Durability
  - Ensures that the result or effect of a committed transaction persists in case of system failure
  - There is no delay between a transaction completing and the state being permanently persisted

### Transaction Problems

There are some issues that can arise while following the Isolation property of transactions. We try to handle them concurrently, because it is faster. But what might happen if one transaction reads data from another transaction, but then the second transaction gets rolled back? We have retrieved data that should not have existed.

- Dirty Read
  - When a transactions reads data that has been added by a different transaction that has yet to be committed
- Non-Repeatable Read
  - When a transaction re-reads data that it has previously read and finds another committed transaction has modified
- Phantom Read
  - When a transaction re-runs a query to find that the number of records has changed

### Transaction Isolation Levels

- The degree to which two transactions will interact with each other over the same data
- As our application becomes more complex, we must account for transactions that may occur at the same time
- The higher the Isolation Level, the more careful the system is about avoiding conflicts, but the locking overhead can increase as concurrency decreases

Isolation Level |    Dirty Read    | Non-Repeatable Read |   Phantom Read   |
:---------------|------------------|---------------------|------------------|
Read Uncommitted|:heavy_check_mark:|:heavy_check_mark:   |:heavy_check_mark:|
Read Committed  |                  |:heavy_check_mark:   |:heavy_check_mark:|
Repeatable Read |                  |                     |:heavy_check_mark:|
Serializable    |                  |                     |                  |

By default, PostgreSQL is set ot Read Committed

## Database Joins

- Operations that allow us bring together data from multiple tables
- Particularly useful in describing many to many relationships
- There are several types
  - Inner Join
    - Only show records with the compared value existing in both tables
  - Full Outer Join
    - Fully join all tables together, substituting null values where data is absent
  - Left/Right Join
    - All data from the Left/Right table paired with the other and subituting nulls where appropriate
  - Cross Join
    - Cartesian Cross Product on records from both tables, so you get a list of permutations from the tables
    - This can generate a LOT of data in response
  - Self Join
    - Any join that operates on only 1 table
    - Not truly its own category

We will obtain a single result with columns selected from both tables, and records will be joined overlapping on one value from a single column.

Most particularly, this overlapping column will be our foreign key to the other table's primary key.
Some SQL Dialects enforce that Joins can only be performed through foreign keys, but not all dialects do.

```SQL
SELECT <columns> FROM <left> <JOIN TYPE> JOIN <right>
  ON <left.column> = <right.column>;
```
