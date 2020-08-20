/*
	Triggers are SQL DB structure that perform a task (a function)
	in reponse to UPDATEs, INSERTs, and DELETEs on the DB or a table.
	
	We can set these triggers to perform their task BEFORE, AFTER, or INSTEAD OF
	the cause of the trigger
	Note that INSTEAD OF is limited to work on Views
*/

--SELECT username, balance FROM project0.users, project0.accounts;


DROP FUNCTION IF EXISTS skip_delete_on_non_empty_account;
-- This is a Trigger Function
CREATE OR REPLACE FUNCTION skip_delete_on_non_empty_account() RETURNS TRIGGER
AS
$$
BEGIN
	RAISE 'Empty the account balance before you delete it';
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS prevent_empty_account_deletion ON project0.accounts;
CREATE TRIGGER prevent_empty_account_deletion
BEFORE DELETE
ON project0.accounts
FOR EACH ROW -- Or FOR EACH STATEMENT
	-- In Triggers, we have access to special tables
	-- called OLD and NEW
	-- If your trigger applies on DELETE
	-- You will only OLD
	-- If on INSERT
	-- There is only NEW
	-- If on UPDATE
	-- There is both OLD and NEW
	
	WHEN (OLD.balance > 0)
		EXECUTE PROCEDURE skip_delete_on_non_empty_account();
		
DELETE FROM project0.accounts WHERE id = 1;

SELECT withdraw(1, 8);

DELETE FROM project0.accounts WHERE id = 1;