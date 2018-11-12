package com.easybusiness.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.Bank;
import com.easybusiness.usermanagement.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long>{

    List<Branch> findById(long id);

    List<Branch> findByBank(Bank bank);

}
