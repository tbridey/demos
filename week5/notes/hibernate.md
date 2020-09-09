# Hibernate

It's an Object Relational Mapper for Java Applications

Creates a mapping between the Object-Oriented Java architecture with to the relational database architecture.
Classes in Java get mapped to tables in the DB.
Objects in Java get mapped to records in those tables.
HAS-A relationships (such as fields in a class) become foreign keys in the DB.

It allows us to perform SQL operations on a database in an object-oriented fashion.

Hibernate follows JPA (Java Persistence API)

Provides many annotations to configure classes as tables in the DB.
## JPA

- @Entity
  - Defines the class to be tracked by Hibernate
  - Terminology that Hibernate uses to describe classes mapped to a DB
- @Table
  - Allows us to define the table name that the class gets mapped to
- @Id
  - Defines which field will act as the primary key of the table
- @Column
  - Allows us to define the column name that specific fields will use
  - Note, this is not required
  - Fields will automatically become column
  - This just allows us to configure the column names
- Mapping annotations
  - Used to configure the relationships between tables
  - @OneToOne
  - @OneToMany
    - @ManyToOne
  - @ManyToMany
    - @JoinTable
    - @JoinColumn
- etc

Alternatively, Hibernate supports xml configuration, so we do not have to use these annotations if we didn't want to. However, the annotations are really great, so most of the time, we will use them.

We will use an xml configuration file (hibernate.cfg.xml).

## API
- Session
  - Interface that represents a "session" with the database
  - It may last longer than a single JDBC Connection, or it might be shorter
- SessionFactory
  - Interface that is used to build sessions (obtained with Configuration object)
- Configuration
  - Class that represents the information in the hibernate.cfg.xml file
- Transaction
  - Interface that represents a transaction within the DB

## Cache

Hibernate uses several caches to provide optimizations for our SQL operations
- Ex: If we were to perform several update operations in a row, Hibernate can track all of the changes
    and execute all at once as a single update with the resulting values

There are different levels
- L1 cache
  - Built in and provided for us automatically
  - Scoped to a single session
- L2 cache
  - Not built in or provided but we can add to our project
    - Does not come with Hibernate
    - Will need some other library
  - Scoped to a SessionFactory
  - Optimizations can be performed across multiple sessions
    - However, these optimizations becomes very complex

## Object States

Objects are synchronized with the DB through sessions and therefore can have different states depending on when/if they are currently synchronized.

- Transient
  - Not synchronized with the DB
  - Newly created object that has yet to be associated with the DB (or any session)
- Persistent
  - This is an object whose state is currently managed by Hibernate, and is syncrhonized with the DB through sessions
  - This means that we have a currently active session to synchronize the object
- Detached
  - This is an object that was previously persistent, but the session it was associate with has closed
  - It no longer has a session with the DB in order to be synchronized

Hibernate has a feature called "Automatic Dirty Checking"

This means that if we modify a PERSISTENT entity in any way (such as with setters), Hibernate will automatically update that entity.
