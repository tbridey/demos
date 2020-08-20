/*
	A Sequence in SQL is similar to the idea of sequences in Mathematics
	
	They are just a series of numbers with some rules to determine the values
	
	Sequences in SQL are much more restricted than in math.
	Pretty much Sequences may only have INTEGERs, and generally only
	increment
	
	Most often, sequences are used to define newly generated Primary Keys
*/

CREATE TABLE my_table (
	id INTEGER PRIMARY KEY,
	favorite_sport VARCHAR(250) NOT NULL
);

--INSERT INTO my_table (favorite_sport) VALUES ('Soccer');
-- The above statement fails without the SERIAL datatype

DROP SEQUENCE my_table_pk_sequence
CREATE SEQUENCE IF NOT EXISTS my_table_pk_sequence
	MINVALUE 100000
	NO MAXVALUE
	START WITH 100000
	NO CYCLE
	OWNED BY my_table.id;
-- Sequence that starts at 100,000 and increments further from there

CREATE OR REPLACE FUNCTION set_my_table_id() RETURNS TRIGGER
AS
$$
BEGIN
	NEW.id = NEXTVAL('my_table_pk_sequence');
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS trg_my_table_pk ON my_table;
CREATE TRIGGER trg_my_table_pk
BEFORE INSERT
ON my_table
FOR EACH ROW
	EXECUTE PROCEDURE set_my_table_id();

INSERT INTO my_table (favorite_sport) VALUES ('Soccer');

