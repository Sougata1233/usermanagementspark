package com.easybusiness.usermanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.easybusiness.usermanagement.entity.ApproverMaster;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.repository.ApproverMasterRepository;


/*
 * DAO class for APPROVER_MASTER table
 */
@Component
public class ApproverMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApproverMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ApproverMasterRepository approverMasterRepository;
    
    @Autowired
    UserDao userDao;

	

    /*
     * find all method for finding all the datas from APPROVER_MASTER table
     */
    @Transactional(readOnly = true)
    public List<ApproverMaster> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<ApproverMaster> approverMasterList = new ArrayList<ApproverMaster>();
	for (ApproverMaster approverMaster : approverMasterRepository.findAll()) {
	    LOGGER.info("ApproverMaster : " + approverMaster);
	    approverMasterList.add(approverMaster);

	}
	return approverMasterList;

    }

    /*
     * find by id method for finding data by taskid from APPROVER_MASTER table
     */
    @Transactional(readOnly = true)
    public Optional<ApproverMaster> findByTaskId(Long taskId) {

	return approverMasterRepository.findById(taskId);
    }

    
    /*
     * findByTaskDesc method for fetching data by taskdesc from APPROVER_MASTER table
     */
    @Transactional(readOnly = true)
    public ApproverMaster findApproverMasterByTaskDesc(String taskDesc) {

	return approverMasterRepository.findByTaskDesc(taskDesc).get(0);
    }
    
    
    /*
     * this method first finds user by calling findUserById method of userDao class and then use the result to
     * find approver authorities by calling ApproverMasterSpecifications class inside approverMasterRepository
     * findAll method
     */
    @Transactional(readOnly = true)
    public List<ApproverMaster> findApproverAuthoritiesOfUser(long userId) {

	User user=userDao.findUserById(userId);
	System.out.println(user);
//	System.out.println(ApproverMasterSpecifications.findIfUserIsAnyApprover(user));
	List<ApproverMaster> aprrovers = new ArrayList<>();
	List<ApproverMaster> approver1 = approverMasterRepository.findByUser1Id(userId);
	List<ApproverMaster> approver2 = approverMasterRepository.findByUser2Id(userId);
	List<ApproverMaster> approver3 = approverMasterRepository.findByUser3Id(userId);
	List<ApproverMaster> approver4 = approverMasterRepository.findByUser4Id(userId);
	List<ApproverMaster> approver5 = approverMasterRepository.findByUser5Id(userId);
	
	if(!approver1.isEmpty()) {
		approver1.forEach(app->{
			aprrovers.add(app);
		});
	}
	if(!approver2.isEmpty()) {
		approver2.forEach(app->{
			aprrovers.add(app);
		});
	}
	if(!approver3.isEmpty()) {
		approver3.forEach(app->{
			aprrovers.add(app);
		});
	}
	if(!approver4.isEmpty()) {
		approver4.forEach(app->{
			aprrovers.add(app);
		});
	}
	if(!approver5.isEmpty()) {
		approver5.forEach(app->{
			aprrovers.add(app);
		});
	}
	
	/*if(!approver1.isEmpty() || !approver2.isEmpty() || !approver3.isEmpty() || !approver4.isEmpty() || !approver5.isEmpty()) {
		
	}*/
	
	
//	return approverMasterRepository.findAll(ApproverMasterSpecifications.findIfUserIsAnyApprover(user));
	return aprrovers;
    }
    
   /* @Transactional(readOnly = true)
    public List<ApproverMaster> findApproverAuthoritiesOfUser(String userId) {

	User users=userDao.findUserById(Long.parseLong(userId));
	return approverMasterRepository.findByUser(users.getId());
    }*/
    
    
    /*
     * checking whether the user is approver for the task or not
     */
    @Transactional(readOnly = true)
    public Boolean findIfUserIsApproverForTaskId(long userId,long taskId) {

    	boolean flag = false;
    	
    	List<ApproverMaster> aprrovers = new ArrayList<>();
    	ApproverMaster approver1 = approverMasterRepository.findByUser1IdAndId(userId, taskId);
    	ApproverMaster approver2 = approverMasterRepository.findByUser2IdAndId(userId, taskId);
    	ApproverMaster approver3 = approverMasterRepository.findByUser3IdAndId(userId, taskId);
    	ApproverMaster approver4 = approverMasterRepository.findByUser4IdAndId(userId, taskId);
    	ApproverMaster approver5 = approverMasterRepository.findByUser5IdAndId(userId, taskId);
    	
    	if(approver1 != null || approver2 != null || approver3 != null || approver4 != null || approver5 != null) {
    		flag = true;
    	}
    	
	/*try{
	User user=userDao.findUserById(Long.parseLong(userId));
	List<ApproverMaster> approverListForATask=approverMasterRepository.findAll(ApproverMasterSpecifications.findIfUserIsAnyApproverOfParticularTask(user, taskId));
	return (approverListForATask.size()>0);
	}
	catch(Exception e)
	{
	    LOGGER.error("exception while findIfUserIsApproverForTaskId for user Id{},task Id{} is {}",userId,taskId,e.getMessage() );
	    return false;
	}*/
    	return flag;
 }

    
    /*
     * saving approvermaster to the database by calling addApproverMaster method of approverMasterrepository
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addApproverMaster(ApproverMaster approverMaster) {
	approverMasterRepository.save(approverMaster);
	LOGGER.info("ApproverMaster added successfully " + approverMaster.toString());
    }

    
    /*
     * deleting approvermaster data from database by calling delete method 
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteApproverMaster(Long approverMasterId) {
	approverMasterRepository.delete(approverMasterId);
	LOGGER.info("ApproverMaster with id " + approverMasterId + " deleted successfully ");
    }

    @Transactional
	public List<Integer> findUserApprovalLevel(long userId, long taskId) {
		int flag = 0;
		boolean multi = false;
		List<Integer> flags = new ArrayList<>();
		
		ApproverMaster approver1 = approverMasterRepository.findByUser1IdAndId(userId, taskId);
		ApproverMaster approver2 = approverMasterRepository.findByUser2IdAndId(userId, taskId);
		ApproverMaster approver3 = approverMasterRepository.findByUser3IdAndId(userId, taskId);
		ApproverMaster approver4 = approverMasterRepository.findByUser4IdAndId(userId, taskId);
		ApproverMaster approver5 = approverMasterRepository.findByUser5IdAndId(userId, taskId);
		
		if(
				(approver1!=null && approver2 !=null) ||
				(approver1!=null && approver3 !=null) ||
				(approver1!=null && approver4 !=null) ||
				(approver1!=null && approver5 !=null) ||
				(approver2!=null && approver3 !=null) ||
				(approver2!=null && approver4 !=null) ||
				(approver2!=null && approver5 !=null) ||
				(approver3!=null && approver4 !=null) ||
				(approver2!=null && approver5 !=null) ||
				(approver4!=null && approver5 !=null) 
				) {
			if(approver1 != null) {
				flag = 1;
				flags.add(flag);
			}
			if(approver2 != null) {
				flag = 2;
				flags.add(flag);
			}
			if(approver3 != null) {
				flag = 3;
				flags.add(flag);
			}
			if(approver4 != null) {
				flag = 4;
				flags.add(flag);
			}
			if(approver5 != null) {
				flag = 5;
				flags.add(flag);
			}
		}else {
			if(approver1 != null) {
				flag = 1;
				flags.add(flag);
			}else if(approver2 != null) {
				flag = 2;
				flags.add(flag);
			}else if(approver3 != null) {
				flag = 3;
				flags.add(flag);
			}else if(approver4 != null) {
				flag = 4;
				flags.add(flag);
			}else if(approver5 != null) {
				flag = 5;
				flags.add(flag);
			}
		}
		
		
		
		return flags;
	}

	public int findTaskApproverLevel(String taskId) {
		int flag = 0;
		
		ApproverMaster approver = approverMasterRepository.findById(Long.valueOf(taskId)).get();
		
		if(approver.getUser1() != null) {
			flag = 1;
			if(approver.getUser2() != null) {
				flag = 2;
				if(approver.getUser3() != null) {
					flag = 3;
					if(approver.getUser4() != null) {
						flag = 4;
						if(approver.getUser5() != null) {
							flag = 5;
						}
					}
				}
			}
		}
		
		return flag;
	}

}
