package com.example.easynotes.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.BankAccount;

@Service
@Transactional(rollbackFor = Exception.class)
public class BankDaoImpl {

	@Autowired
	EntityManagerFactory em;
	
	public BankAccount findById(Long id) {
		try {
		EntityManager entitymanager =  em.createEntityManager();
		
		Query query = entitymanager.createQuery("select b from BankAccount b where b.id= :id");
		query.setParameter("id", id);
		
		return (BankAccount)query.getResultList().get(0);
		}catch(Exception e) {
			throw  new ResourceNotFoundException("Note", "id", id);
		}
		
	}
	
	
	
	
}
