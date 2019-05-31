package com.qa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.qa.model.Account;

public class AccountRepoDB implements AccountRepo{
	@PersistenceContext
	private EntityManager em;
	
	public Account createAccount(Account account) {
		em.persist(account);
		return account;
	}
}
