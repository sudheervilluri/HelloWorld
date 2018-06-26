package com.example.easynotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.BankAccount;
import com.example.easynotes.repository.BankDaoImpl;

@RestController
@RequestMapping("/Banking")
public class BankController {

@Autowired
private BankDaoImpl bankDao;

@RequestMapping(value="/findById/{id}", method = RequestMethod.GET)
	public BankAccount getBankListByID(@PathVariable(value = "id") Long id){
	try {
		return bankDao.findById(id);
	}catch(ResourceNotFoundException e) {
		 new ResourceNotFoundException("Bank", "id", id);
	}
	return null;
}
}
