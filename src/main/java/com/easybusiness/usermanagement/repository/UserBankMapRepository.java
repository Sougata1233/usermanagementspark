package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.Bank;
import com.easybusiness.usermanagement.entity.Branch;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserBankMap;

public interface UserBankMapRepository extends JpaRepository<UserBankMap, Long> {

    Optional<UserBankMap> findById(Long i);

    List<UserBankMap> findByBank(Bank bank);
    
    List<UserBankMap> findByBranch(Branch branch);
    
    List<UserBankMap> findByUser(User user);

}
