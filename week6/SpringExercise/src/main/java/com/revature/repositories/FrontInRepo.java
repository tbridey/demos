package com.revature.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class FrontInRepo implements IFrontInRepo {

	public FrontInRepo() {
		super();
	}

	@Override
	public String getString() {
		return "fs/new-girl-new-girl-go";
	}

}
