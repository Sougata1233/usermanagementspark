package com.easybusiness.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easybusiness.usermanagement.entity.UserHierarchy;

public interface UserHierarcyRepository extends JpaRepository<UserHierarchy, Long> {

	UserHierarchy findByHierarcyId(long id);
	
	@Query("select h from UserHierarchy h where h.orgHead.id = :orgHead")
	List<UserHierarchy> findHierarcyByOrgHead(@Param("orgHead") long orgHead);
	
	@Query("select h from UserHierarchy h where h.groupHead.id = :groupHead")
	List<UserHierarchy> findHierarcyByGroupHead(@Param("groupHead") long groupHead);
	
	@Query("select h from UserHierarchy h where h.user.id = :id")
	List<UserHierarchy> findHierarchyByUserId(@Param("id") long id);
	
	@Query("select h from UserHierarchy h where h.hrManager.id = :hrManager")
	List<UserHierarchy> findHierarchyByHrManager(@Param("hrManager") long hrManager);
	
	@Query("select h from UserHierarchy h where h.priSupervisor.id = :priSupervisor")
	List<UserHierarchy> findHierarchyBypriSupervisor(@Param("priSupervisor") long priSupervisor);
	
	@Query("select h from UserHierarchy h where h.prjSupervisor.id = :prjSupervisor")
	List<UserHierarchy> findHierarchyByPrjSupervisor(@Param("prjSupervisor") long prjSupervisor);
	
	@Query("select h from UserHierarchy h where h.parentOrgId.id = :parentOrgId")
	List<UserHierarchy> findByParentOrgId(@Param("parentOrgId") long parentOrgId);
	
	@Query("select h from UserHierarchy h where h.orgId.id = :orgId")
	List<UserHierarchy> findByOrgId(@Param("orgId") long orgId);
	
		
}
