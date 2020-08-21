package com.revature.repositories;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDAO {

	public List<Account> findAll();
	
	public Account findById(int id);
	
	public int insert(Account a);
	
	public boolean update(Account a);
	
	public boolean delete(int id);

	public boolean transfer(int source_account, int target_account, double amount);

	boolean transfer2(Account source_account, Account target_account, double amount);

	String toUppercase(String lowercase);
}
