package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.BankAccount;

@Repository
public interface BankDao extends JpaRepository<BankAccount, Long> {

}
