SELECT * FROM project0.users INNER JOIN project0.accounts
	ON project0.users.id = project0.accounts.owner;
	
SELECT project0.users.id, project0.users.username, project0.accounts.balance
	FROM project0.users FULL OUTER JOIN project0.accounts
	ON project0.users.id = project0.accounts.owner;
	
SELECT * FROM project0.users CROSS JOIN project0.accounts;

SELECT * FROM project0.accounts a FULL OUTER JOIN project0.accounts b ON
	a.id = b.owner;
	
SELECT LENGTH(username) FROM project0.users; -- Scalar function

SELECT AVG(LENGTH(username)) FROM project0.users; -- Aggregate function

SELECT SUM(LENGTH(username)) FROM project0.users;

SELECT COS(LENGTH(username)) FROM project0.users;

SELECT role, AVG(LENGTH(username)) FROM project0.users GROUP BY role;
-- Aggregate functions perform calculations across values within groups
-- specified by the GROUP BY clause

SELECT * FROM project0.users WHERE username LIKE 'm%'; -- Starting with m
-- The ILIKE clause is the same as LIKE, except it is case-insensitive

--SELECT id, AVG(LENGTH(username)) FROM project0.users GROUP BY role;
--  In the above query, id does not make sense when grouping by role
-- So it throws an error
