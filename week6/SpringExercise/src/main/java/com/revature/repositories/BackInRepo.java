package com.revature.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class BackInRepo implements IBackInRepo {

	public BackInRepo() {
		super();
	}

	@Override
	public String getString() {
		return "osebumps-walkaway-3ornkf4";
	}

}
