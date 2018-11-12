package com.easybusiness.usermanagement.controller;

import static com.easybusiness.usermanagement.constant.UserManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.usermanagement.DTO.ApproverMasterDTO;
import com.easybusiness.usermanagement.services.serviceimpl.ApproverMasterServiceImpl;

/*
 * Service and RestController class for APPROVER_MASTER
 */
@RestController
@RequestMapping("/easybusiness/approverflow/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class ApproverMasterController {
	
	@Autowired
	ApproverMasterServiceImpl approverService;
	
	@GetMapping("getApproverMasterByTaskId/{taskid}")
	public ResponseEntity<ApproverMasterDTO> getApproverListByTaskId(
																@PathVariable("taskid") String taskId){
		return approverService.getApproverListByTaskId(taskId);
	}
	
	@GetMapping("getApproverMasterByTaskDesc/{taskdesc}")
	public ResponseEntity<ApproverMasterDTO> getApproverListByTaskDesc(
																	@PathVariable("taskdesc") String taskDesc) {
		return approverService.getApproverListByTaskDesc(taskDesc);
	}
	
	@GetMapping("findApproverAuthoritiesOfUser/{userId}")
	public List<ApproverMasterDTO> findApproverAuthoritiesOfUser(@PathVariable("userId") String userId){
		return approverService.findApproverAuthoritiesOfUser(userId);
	}
	
	@GetMapping("findAllDetailsOfApproverMaster")
	public List<ApproverMasterDTO> getAllDetailsOfApproverMaster() {
		return approverService.getAllDetailsOfApproverMaster();
	}
	
	@GetMapping("findIfUserIsApproverForTaskId/{userId}/{taskid}")
	public Boolean findIfUserIsApproverForTaskId(@PathVariable("userId") String userId,
		    @PathVariable("taskid") String taskId) {
		return approverService.findIfUserIsApproverForTaskId(userId, taskId);
	}
	
	@PostMapping("addUpdateApproveMaster")
	public ResponseEntity<ApproverMasterDTO> persistApproveMaster(
										@RequestBody ApproverMasterDTO approverMasterDTO) {
		return approverService.persistApproveMaster(approverMasterDTO);
	}
	
	@DeleteMapping("deleteApproveMaster/{taskid}")
	public void deleteApproveMaster(@PathVariable("taskid") Long taskId) {
		approverService.deleteApproveMaster(taskId);
	}
	
	@GetMapping("findUserApprovalLevel/{userId}/{taskId}")
	public List<Integer> findUserApprovalLevel(@PathVariable("userId") String userId, @PathVariable("taskId") String taskId) {
		return approverService.findUserApprovalLevel(userId, taskId);
	}
	
	@GetMapping("findTaskApproverLevel/{taskId}")
	public int findTaskApproverLevel(@PathVariable("taskId") String taskId) {
		return approverService.findTaskApproverLevel(taskId);
	}

}
