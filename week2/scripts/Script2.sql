DROP TABLE IF EXISTS users CASCADE;
-- Completely remove the users table, regardless of any relationships
-- that exist, and also remove the corresponding relationships
-- Without the CASCADE keyword, this DROP statement would fail if there
-- were any relationships that needed to be upheld

-- CASCADE operations are VERY dangerous and could be very large scale
-- DO NOT do this on ANY database that you are concerned about maintaining data on

-- For us, we are developing small scale, short lived databases, that don't matter
-- in the long run, so CASCADE doesn't bother us here

-- If using any SQL keywords, it is common practice to capitalize them
-- However, SQL is actually case-insensitive unless using quotations
-- Since SQL is case-insensitive, it is common practice to leverage underscores
-- as needed

CREATE TABLE public.users (
	-- We list our columns along with their types
	-- Along with any constraints
	-- column_name DATATYPE CONSTRAINTS
	id SERIAL PRIMARY KEY,
	-- The SERIAL datatype is a type in postgres specifically
	-- that provides auto-incrementing for our primary keys
	-- This means when inserting a new record, we can ignore inserting
	-- a value for the primary key, and it will be generated for us
	-- Aside from that, it is effectively just an integer
	first_name VARCHAR (250) NOT NULL CHECK (LENGTH(first_name) > 0),
	last_name VARCHAR (250) NOT NULL CHECK (LENGTH(last_name) > 0),
	email VARCHAR (250),
	age INTEGER DEFAULT 0 CHECK (age >= 0),
	supervisor INTEGER
);

ALTER TABLE users
	ADD CONSTRAINT users_supervisor_fk
	FOREIGN KEY (supervisor) REFERENCES users (id);

-- ALTER TABLE table_name
--		ADD CONSTRAINT constraint_name
--		CONSTRAINT TYPE (column) [REFERENCES target_table (target_column)]

DROP TABLE IF EXISTS public.phonenumber CASCADE;

CREATE TABLE public.phonenumber (
	id SERIAL PRIMARY KEY,
	-- tables can have a fully qualified name with schema.table_name
	user_id INTEGER NOT NULL REFERENCES public.users (id),
	home VARCHAR (20),
	mobile VARCHAR (20),
	work VARCHAR (20)
);

DROP SCHEMA project0;

CREATE SCHEMA project0;

-- INSERT INTO table (columns) VALUES (values);
INSERT INTO users (first_name, last_name) VALUES ('Matthew', 'Oberlies');

INSERT INTO users (first_name, last_name, age, supervisor) VALUES ('Jane', 'Doe', 27, 1);

-- SELECT columns FROM table_name;
SELECT first_name, last_name FROM users;

-- The || is performing string concatenation
-- Can use the AS keyword as an alias
SELECT first_name || ' ' || last_name AS full_name FROM users;