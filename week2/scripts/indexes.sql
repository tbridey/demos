/*
	Cursors are a datatype in SQL that are kind of similar to iterators in Java.
	They will retrieve query data only a few records at a time.
	This is sometimes needed if the query returns multiple GB in respose.
	However, there is currently a lack of functionality in the postgres
	JDBC driver where it is currently unable to take advantage of cursors.
	They can still be used, however the JDBC driver will just obtain all
	records at once. So using cursors in Postgres JDBC for now defeats the
	entire purpose. According to PostgreSQL, this problem can be fixed, but
	they haven't had the time.
*/

DROP FUNCTION IF EXISTS test_func;
CREATE OR REPLACE FUNCTION test_func() RETURNS VARCHAR
AS
$$
DECLARE
	temp_id INTEGER;
	temp_username VARCHAR;
	temp_password VARCHAR;
	temp_role project0.role;
	temp_hire_date DATE;
	cursor1 refcursor; -- unopened
	cursor2 CURSOR FOR SELECT * FROM project0.users; -- unopened
BEGIN
	OPEN cursor1 FOR SELECT id FROM project0.accounts;
	OPEN cursor2;

	FETCH cursor1 INTO temp_id;

	FETCH cursor2 INTO temp_id, temp_username, temp_password, temp_role, temp_hire_date;

	MOVE FORWARD 1 FROM cursor1;
	MOVE FORWARD 1 FROM cursor2;

	RETURN temp_id || ' ' || temp_username || ' ' || temp_password || ' ' || temp_role || ' ' || temp_hire_date;
END;
$$ LANGUAGE plpgsql;

SELECT test_func();






/*
	Indexes are a structure in a database that provides a means of quickly querying/sorting
	the values in a table based on 1 or more columns
	
	So if you perform certain queries based on a single column very frequently,
	it might be prudent to create an index for that column
	
	The downside, is that it creates overall overhead for the database per index
	
	So if the table is not queried that often or does not contain that much data
	it may not be worthwhile
*/

--CREATE INDEX accounts_owner_key ON project0.accounts (owner);

SELECT * FROM project0.accounts WHERE owner IN (1, 12);

DROP TABLE IF EXISTS test_table CASCADE;
CREATE TABLE test_table(
	value INTEGER,
	value2 INTEGER
);

CREATE INDEX test_table_index1 ON test_table (value);
CREATE INDEX test_table_index2 ON test_table (value2);
CREATE INDEX test_table_index3 ON test_table (value, value2);

INSERT INTO test_table (value, value2) VALUES (1, 2);
INSERT INTO test_table (value, value2) VALUES (1, 2);
INSERT INTO test_table (value, value2) VALUES (1, 2);
INSERT INTO test_table (value, value2) VALUES (1, 2);
INSERT INTO test_table (value, value2) VALUES (1, 2);
INSERT INTO test_table (value, value2) VALUES (1, 2);
INSERT INTO test_table (SELECT * FROM test_table); -- Duplicating all data in the table
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);
INSERT INTO test_table (SELECT * FROM test_table);

SELECT COUNT(value) FROM test_table;
