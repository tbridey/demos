package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.IReimbursementDAO;
import com.revature.repositories.ReimbursementDAO;

public class ReimbursementService {
	
	private IReimbursementDAO reimbursementDao;

	public ReimbursementService() {
		super();
		this.reimbursementDao = new ReimbursementDAO();
	}

	// For mocking if desired
	public ReimbursementService(IReimbursementDAO reimbursementDao) {
		super();
		this.reimbursementDao = reimbursementDao;
	}
	
	public List<Reimbursement> findAll() {
		return this.reimbursementDao.findAll();
	}
	
	// TODO: Implement the rest of methods as needed
}
