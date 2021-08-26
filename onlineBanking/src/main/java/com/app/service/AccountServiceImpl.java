package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAccountDao;
import com.app.pojos.Account;
@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountDao accountDao;
	@Override
	public String addAccount(Account account,String username) {
		
		return accountDao.addAccount(account,username);
	}

}
