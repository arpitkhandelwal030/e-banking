package com.app.dao;

import com.app.pojos.Account;

public interface IAccountDao {

	//account add
		String addAccount(Account account,String username);
}
