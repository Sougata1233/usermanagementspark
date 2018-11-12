package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.ApproverMasterDTO;

public interface ApproverMasterService {

    public ResponseEntity<ApproverMasterDTO> getApproverListByTaskId(String taskId);

    public ResponseEntity<ApproverMasterDTO> getApproverListByTaskDesc(String taskDesc);

    public List<ApproverMasterDTO> getAllDetailsOfApproverMaster();

    public ResponseEntity<ApproverMasterDTO> persistApproveMaster(ApproverMasterDTO approverMasterDTO);

    public List<ApproverMasterDTO> findApproverAuthoritiesOfUser(String userId);

    public Boolean findIfUserIsApproverForTaskId(String userId, String taskId);

    public void deleteApproveMaster(Long taskId);
    
    public List<Integer> findUserApprovalLevel(String userId, String taskId);
    
    public int findTaskApproverLevel(String taskId);

}
