package com.revature.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class FrontOutRepo implements IFrontOutRepo {

	
	public FrontOutRepo() {
		super();
	}

	@Override
	public String getString() {
		return "https://giphy.com/gi";
	}

}
