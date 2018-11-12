package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easybusiness.usermanagement.DTO.UserDTO;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserGroup;
import com.easybusiness.usermanagement.entity.UserGroupMap;

public interface UserGroupMapRepository extends JpaRepository<UserGroupMap, Long> {

    Optional<UserGroupMap> findById(Long i);

    List<UserGroupMap> findByUser(User user);
    
    List<UserGroupMap> findByUserGroup(UserGroup userGroup);
    
    List<UserGroupMap> findByUserAndUserGroup(User user,UserGroup userGroup);
    
    @Query("select u.user from UserGroupMap u where u.userGroup.id = :id")
    List<UserDTO> userIds(@Param("id") long groupid);

}
