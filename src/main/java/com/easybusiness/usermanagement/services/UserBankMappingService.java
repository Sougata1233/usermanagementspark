package com.easybusiness.usermanagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.easybusiness.usermanagement.DTO.BankDTO;
import com.easybusiness.usermanagement.DTO.BranchDTO;
import com.easybusiness.usermanagement.DTO.UserBankMapDTO;

public interface UserBankMappingService {

    public List<UserBankMapDTO> getBankByUserId(Long userId);

    public ResponseEntity<UserBankMapDTO> persistUserBankDetails(UserBankMapDTO UserBankMapDTO);

    public void destroyUserBankDetails(Long mappingId);

    List<BranchDTO> getAllBanksAndBranches() throws Exception;

    BankDTO getBankById(Long bankId);

    BranchDTO getBranchById(Long branchId);

    List<BranchDTO> getBranchByBankId(Long bankId);

}
