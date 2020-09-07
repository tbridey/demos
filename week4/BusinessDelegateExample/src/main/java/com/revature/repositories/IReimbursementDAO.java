package com.revature.repositories;

import java.util.List;

import com.revature.models.RStatus;
import com.revature.models.RType;
import com.revature.models.Reimbursement;

public interface IReimbursementDAO {
	
	public List<Reimbursement> findAll();
	public Reimbursement findById(int id);
	
	public List<Reimbursement> findByAuthor(int id);
	public List<Reimbursement> findByResolver(int id);
	
	public List<Reimbursement> findByType(RType type);
	public List<Reimbursement> findByStatus(RStatus status);
	
	public Reimbursement insert(Reimbursement e);
	public boolean update(Reimbursement e);
	public boolean delete(int id);
}
