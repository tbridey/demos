# Week 1 Study Guide
Topics Covered: SQL (PostgreSQL)

Review the material covered from the week, which is listed out below.

Leverage the "How to do well in QC" Document that is pinned to the Training channel on Slack.

In particular, be able to answer "Tell me about your experience with X?", where X is any of the topics listed below.

Be able to provide overall reasons `Why` certain features are available. Such as what problems they solve.

## Topics
- AWS (Amazon Web Services)
  - RDS = Relational Database Service
  - Cloud Database platform
- Intro to SQL
  - Structured Query Language
  - Concepts of Databases / Relational Databases
  - Referential Integrity
- Constraints
- SQL Dialects
  - We use PostgreSQL
- SQL Sublanguages
  - DDL, DML, DQL, DCL, TCL
- Basic Queries
  - WHERE, IN, LIKE, HAVING, ORDER BY, GROUP BY clause
  - Syntax for SELECT, INSERT, UPDATE, DELETE queries
- Nested Queries
- Aggregate/Scalar Functions
- Multiplicity/Cardinality
  - one to one
    - Unique foreign key on either side
  - one to many / many to one
    - Non-unique foreign key on the side of the many
  - many to many
    - Requires the use of Join Tables
    - Both foreign keys are non-unique
- Transaction Properties
  - ACID
  - Atomicity
  - Consistency
  - Isolation
  - Durability
- Transaction Problems
  - Dirty Read
  - Non-Repeatable Read
  - Phantom Read
- Transaction Isolation Levels
  - Read Uncommitted
  - *Read Committed*
  - Repeatable Read
  - Serializable
- Join Operations
  - INNER JOIN
  - FULL OUTER JOIN
  - LEFT/RIGHT JOIN
  - CROSS JOIN
  - SELF JOIN
- Normalization
  - 1NF
    - Needs Primary Key
    - Atomic Data
  - 2NF
    - No partial dependencies (No composite keys)
  - 3NF
    - No transitive dependencies
- PL/PgSQL
  - Procedural Language, PostgreSQL
  - It is a programming language accompanied by postgres
- Functions/Stored Procedures
  - In Postgres, these are the same, but this is not the case in other dialects
  - Function Phases
    - DECLARE
    - BEGIN
    - END
- Triggers
  - Use Trigger Functions
- Sequences
- Cursors
- Indexes
- JDBC
  - Java DataBase Connectivity
  - It is an API for interacting with a relational database through Java
  - Interfaces
    - Connection
    - Statement
      - PreparedStatement
        - CallableStatement
    - ResultSet
  - Remember that PreparedStatements protect against SQL Injection
  - DAO Design Pattern (Data Access Object)
    - The idea that all data access will be performed in a single class
    - And the rest of the application can ignore that complexity
- Mocking dependencies with Mockito Library
  - The concept of mocking exists outside of just mockito, but that is library we use for Java
  - We mock the dependencies of our services in order to test just that 1 unit
  - Be familiar with some Mockito functionalities
    - @Mock annotation
    - MockitoAnnotations.InitMocks
    - verify
    - when
      - thenReturn
      - thenThrow
  - In order to mock, we must modify our implementation to allow injecting a fake object
    - Initially, our services didn't support mocking its DAO, so we added a constructor to support this
