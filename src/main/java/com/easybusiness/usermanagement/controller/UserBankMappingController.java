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

import com.easybusiness.usermanagement.DTO.BankDTO;
import com.easybusiness.usermanagement.DTO.BranchDTO;
import com.easybusiness.usermanagement.DTO.UserBankMapDTO;
import com.easybusiness.usermanagement.services.serviceimpl.UserBankMappingServiceImpl;

/*
 * Service and RestController class for UserBankMapping
 */
@RestController
@RequestMapping("/easybusiness/userbank/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class UserBankMappingController {
	
	@Autowired
	UserBankMappingServiceImpl userbankService;
	
	@GetMapping("getbankByUserId/{userid}")
	public List<UserBankMapDTO> getBankByUserId(@PathVariable("userid") Long userId){
		return userbankService.getBankByUserId(userId);
	}
	
	@GetMapping("getbankById/{bankid}")
	public BankDTO getBankById(@PathVariable("bankid") Long bankId) {
		return userbankService.getBankById(bankId);
	}
	
	@GetMapping("getbranchById/{branchid}")
	public BranchDTO getBranchById(@PathVariable("branchid") Long branchId) {
		return userbankService.getBranchById(branchId);
	}
	
	@GetMapping("getbranchByBankId/{bankid}")
	public List<BranchDTO> getBranchByBankId(@PathVariable("bankid") Long bankId){
		return userbankService.getBranchByBankId(bankId);
	}
	
	@GetMapping("getAllBanksAndBranches")
	public List<BranchDTO> getAllBanksAndBranches() throws Exception{
		return userbankService.getAllBanksAndBranches();
	}
	
	@PostMapping("mapUserBank")
	public ResponseEntity<UserBankMapDTO> persistUserBankDetails(@RequestBody UserBankMapDTO userBankMapDTO){
		return userbankService.persistUserBankDetails(userBankMapDTO);
	}
	
	@DeleteMapping("destroyUserBankDetails/{mappingid}")
	public void destroyUserBankDetails(@PathVariable("mappingid") Long mappingId) {
		userbankService.destroyUserBankDetails(mappingId);
	}

}
