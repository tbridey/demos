/*
	There is a SQL construct called a stored procedure or a user-defined function.
	Some SQL Dialects have 1 or both, for example OracleSQL has both, and there are
	differences between them. However, PostgreSQL only has functions. Stored Procedures
	are effectively just functions that don't return anything. PostgreSQL accomplishes
	this with the 'void' return type with functions.

	Due to some differences in basic SQL syntax versus Postgres specific syntax, as
	well as backwards compatibility, there are some syntax keywords that refer to
	PROCEDURE, but it still just means function in terms of postgres.
	
	Each Dialect does have slightly different syntax for declaring stored
	procedures/functions, but this is how we'll do so in postgres
*/

-- The OR REPLACE is optional, but will allow you to re-run the script
CREATE OR REPLACE FUNCTION get_current_time() RETURNS TIME WITH TIME ZONE
AS
$$
	SELECT current_time;
	-- current_time is a built in variable that is just the current time
	-- Normally, we might have a RETURN statement
	-- But by default the last statement's value will be returned
$$ LANGUAGE SQL;

-- Effectively the $$ feature is sort of applying string interpolation
-- Since the actual CREATE FUNCTION behavior under the hood
-- requires just a string of text, like raw SQL

SELECT get_current_time();

-- As shown above, we can use the SQL language specifier, or the plpgsql
-- specifier

-- This will have an impact on specific syntax

-- varname TYPE
CREATE OR REPLACE FUNCTION get_initials(user_id INTEGER) RETURNS VARCHAR(2)
AS
$$
	SELECT SUBSTRING("username", 1, 1) || SUBSTRING("password", 1, 1)
		FROM project0.users WHERE id = user_id;
$$ LANGUAGE SQL;

SELECT get_initials(1);
SELECT get_initials(12);

SELECT get_initials(id) FROM project0.users;


CREATE OR REPLACE FUNCTION withdraw(account_id INTEGER, amount NUMERIC(50, 2))
	RETURNS BOOLEAN
AS
$$
BEGIN
--	IF amount < 0 THEN
--		RETURN false;
--	END IF;
	
	IF amount > (SELECT balance FROM project0.accounts WHERE id = account_id) THEN
        RETURN false;
    ELSE
	    UPDATE project0.accounts SET balance = balance - amount
			WHERE id = account_id;
    	RETURN true;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION transfer_funds(
	source_account INTEGER,
	target_account INTEGER,
	amount NUMERIC(50, 2)
	) RETURNS boolean
AS
$$
BEGIN
	BEGIN
		SELECT withdraw(source_account, amount);
		SELECT withdraw(target_account, -1 * amount);
		RETURN true;
	EXCEPTION
		WHEN OTHERS THEN
			RETURN false;
	END;
END;
$$ LANGUAGE plpgsql;

SELECT withdraw(1, 5);

SELECT transfer_funds(1, 2, 30);

--ALTER TABLE project0.users
--	ADD COLUMN hire_date DATE NOT NULL DEFAULT current_date;
	
CREATE OR REPLACE FUNCTION users_before_year(year INTEGER) RETURNS SETOF project0.users
AS
$$
	SELECT * FROM project0.users WHERE EXTRACT(YEAR FROM hire_date) < year;
$$ LANGUAGE SQL;

SELECT * FROM users_before_year(2021);

CREATE OR REPLACE FUNCTION get_info() RETURNS TABLE(
	full_info VARCHAR(250),
	username VARCHAR(250),
	password VARCHAR(250)
) AS
$$
	SELECT username || password, username, password FROM project0.users;

$$ LANGUAGE SQL;

SELECT * FROM get_info();

-- CallableStatement in JDBC
-- "? = { my_function(?, ?, ?) }"

-- In JDBC, the default transaction structure
-- is that every statement sent to the database
-- is a transaction of that 1 statement
-- The DB will commit after every statement
-- received