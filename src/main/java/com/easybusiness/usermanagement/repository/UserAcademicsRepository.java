package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.UserAcademics;

public interface UserAcademicsRepository extends JpaRepository<UserAcademics, Long> {

    Optional<UserAcademics> findById(Long i);

    //List<UserAcademics> findByUser(User user);
    
    List<UserAcademics> findByUser(Long long1);

}
