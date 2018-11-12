package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.easybusiness.usermanagement.entity.ApproverMaster;

public interface ApproverMasterRepository extends CrudRepository<ApproverMaster, Long>, 
										JpaSpecificationExecutor<ApproverMaster> {

    Optional<ApproverMaster> findById(Long id);

    List<ApproverMaster> findByTaskDesc(String taskDesc);

    List<ApproverMaster> findAll();
    
//    @Query("select a from ApproverMaster a where a.user1.id = :id or a.user2.id = :id or a.user3.id = :id "
//    		+ "or a.user4.id = :id or a.user5.id = :id")
//    List<ApproverMaster> findByUser(@Param("id") long id);
    
    List<ApproverMaster> findByUser1Id(long id);

    List<ApproverMaster> findByUser2Id(long id);
    
    List<ApproverMaster> findByUser3Id(long id);
    
    List<ApproverMaster> findByUser4Id(long id);
    
    List<ApproverMaster> findByUser5Id(long id);
    
    
    ApproverMaster findByUser1IdAndId(long id, long taskid);

    ApproverMaster findByUser2IdAndId(long id, long taskid);
    
    ApproverMaster findByUser3IdAndId(long id, long taskid);
    
    ApproverMaster findByUser4IdAndId(long id, long taskid);
    
    ApproverMaster findByUser5IdAndId(long id, long taskid);
    
}
