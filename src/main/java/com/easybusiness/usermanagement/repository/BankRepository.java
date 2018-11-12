package com.easybusiness.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{

    List<Bank> findById(long id);

    List<Bank> findByBankName(String bankName);

    

}
