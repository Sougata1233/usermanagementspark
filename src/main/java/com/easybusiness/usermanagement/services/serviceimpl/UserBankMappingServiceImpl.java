package com.easybusiness.usermanagement.services.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.easybusiness.usermanagement.DTO.BankDTO;
import com.easybusiness.usermanagement.DTO.BranchDTO;
import com.easybusiness.usermanagement.DTO.DepartmentDto;
import com.easybusiness.usermanagement.DTO.DesignationDto;
import com.easybusiness.usermanagement.DTO.LocationMasterDTO;
import com.easybusiness.usermanagement.DTO.OrganizationDto;
import com.easybusiness.usermanagement.DTO.UserBankMapDTO;
import com.easybusiness.usermanagement.DTO.UserDTO;
import com.easybusiness.usermanagement.dao.BankDao;
import com.easybusiness.usermanagement.dao.BranchDao;
import com.easybusiness.usermanagement.dao.UserBankMapDao;
import com.easybusiness.usermanagement.dao.UserDao;
import com.easybusiness.usermanagement.entity.Bank;
import com.easybusiness.usermanagement.entity.Branch;
import com.easybusiness.usermanagement.entity.Department;
import com.easybusiness.usermanagement.entity.Designation;
import com.easybusiness.usermanagement.entity.LocationMaster;
import com.easybusiness.usermanagement.entity.Organization;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserBankMap;
import com.easybusiness.usermanagement.services.UserBankMappingService;

/*
 * Service and RestController class for UserBankMapping
 */
@Service
public class UserBankMappingServiceImpl implements UserBankMappingService {

    @Autowired
    UserBankMapDao userBankDao;

    @Autowired
    UserDao userDao;

    @Autowired
    BankDao bankDao;

    @Autowired
    BranchDao branchDao;

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertobank.UserBankMappingService#getBankByUserId(java.lang.Long)
     * fetching bank details by userid
     * GET method for USER_BANK_MAP_MASTER table with param userId
     */
    @Override
    public List<UserBankMapDTO> getBankByUserId(Long userId) {

	User user = userDao.findUserById(userId);
	List<UserBankMap> userBankEntityList = userBankDao.findByUser(user);
	List<UserBankMapDTO> userBankMapList = new ArrayList<UserBankMapDTO>();
	userBankEntityList.forEach(userBankEntity -> {
	    UserBankMapDTO userBankMapDTO = prepareUserbankMapDTO(userBankEntity);
	    userBankMapList.add(userBankMapDTO);
	});

	return userBankMapList;

    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertobank.UserBankMappingService#getBankById(java.lang.Long)
     * Fetching Bank Details by bankId
     * GET method for USER_BANK_MAP_MASTER table with param bankid
     */
    @Override
    public BankDTO getBankById(Long bankId) {

	Bank bank = bankDao.findBankById(bankId).get(0);
	BankDTO bankDTO = new BankDTO();
	bankDTO.setAddress(bank.getAddress());
	bankDTO.setBankName(bank.getBankName());
	bankDTO.setId(bank.getId());
	bankDTO.setLocation(bank.getLocation());
	return bankDTO;

    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertobank.UserBankMappingService#getBranchById(java.lang.Long)
     * Fetching branch details by branchId
     * GET method for USER_BANK_MAP_MASTER table with param branchId
     */
    @Override
    public BranchDTO getBranchById(Long branchId) {

	Branch branch = branchDao.findBranchById(branchId).get(0);
	BranchDTO branchDTO = new BranchDTO();
	branchDTO.setAddress(branch.getAddress());
	Bank bank = branch.getBank();
	BankDTO bankDTO = new BankDTO();
	bankDTO.setAddress(bank.getAddress());
	bankDTO.setBankName(bank.getBankName());
	bankDTO.setId(bank.getId());
	bankDTO.setLocation(bank.getLocation());
	branchDTO.setBank(bankDTO);
	branchDTO.setBranchName(branch.getBranchName());
	branchDTO.setId(branch.getId());
	branchDTO.setIfscCode(branch.getIfscCode());
	return branchDTO;

    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertobank.UserBankMappingService#getBranchByBankId(java.lang.Long)
     * Fetching Branch details by bankid
     * GET method for USER_BANK_MAP_MASTER table with param bankid
     */
    @Override
    public List<BranchDTO> getBranchByBankId(Long bankId) {

	Bank bank = bankDao.findBankById(bankId).get(0);

	List<Branch> branch = branchDao.findByBank(bank);
	List<BranchDTO> branchDTOList = new ArrayList<BranchDTO>();
	branch.forEach(branchEntity -> {
	    BranchDTO branchDTO = new BranchDTO();
	    branchDTO.setAddress(branchEntity.getAddress());
	    BankDTO bankDTO = new BankDTO();
	    bankDTO.setAddress(branchEntity.getBank().getAddress());
	    bankDTO.setBankName(branchEntity.getBank().getBankName());
	    bankDTO.setId(branchEntity.getBank().getId());
	    bankDTO.setLocation(branchEntity.getBank().getLocation());
	    bankDTO.setModifiedBy(branchEntity.getBank().getModifiedBy());
	    bankDTO.setModifiedOn(branchEntity.getBank().getModifiedOn());
	    branchDTO.setBank(bankDTO);
	    branchDTO.setBranchName(branchEntity.getBranchName());
	    branchDTO.setId(branchEntity.getId());
	    branchDTO.setModifiedBy(branchEntity.getModifiedBy());
	    branchDTO.setModifiedOn(branchEntity.getModifiedOn());
	    branchDTO.setIfscCode(branchEntity.getIfscCode());
	    branchDTOList.add(branchDTO);
	});
	return branchDTOList;

    }

    
    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertobank.UserBankMappingService#getAllBanksAndBranches()
     * Fetching All Banks and Branchs details
     * GET method for USER_BANK_MAP_MASTER table
     */
    @Override
    public List<BranchDTO> getAllBanksAndBranches() throws Exception {

	List<Branch> branchList = branchDao.findAll();
	List<BranchDTO> branchDTOList = new ArrayList<BranchDTO>();
	branchList.forEach(branchEntity -> {
	    BranchDTO branchDTO = new BranchDTO();
	    branchDTO.setAddress(branchEntity.getAddress());
	    BankDTO bankDTO = new BankDTO();
	    bankDTO.setAddress(branchEntity.getBank().getAddress());
	    bankDTO.setBankName(branchEntity.getBank().getBankName());
	    bankDTO.setId(branchEntity.getBank().getId());
	    bankDTO.setLocation(branchEntity.getBank().getLocation());
	    bankDTO.setModifiedBy(branchEntity.getBank().getModifiedBy());
	    bankDTO.setModifiedOn(branchEntity.getBank().getModifiedOn());
	    branchDTO.setBank(bankDTO);
	    branchDTO.setBranchName(branchEntity.getBranchName());
	    branchDTO.setId(branchEntity.getId());
	    branchDTO.setModifiedBy(branchEntity.getModifiedBy());
	    branchDTO.setModifiedOn(branchEntity.getModifiedOn());
	    branchDTO.setIfscCode(branchEntity.getIfscCode());
	    branchDTOList.add(branchDTO);
	});
	return branchDTOList;

    }

    
    /*
     * Preparing UserBankMapDTO from UserBankMap
     */
    private UserBankMapDTO prepareUserbankMapDTO(UserBankMap userBankEntity) {
	UserBankMapDTO userBankMapDTO = new UserBankMapDTO();
	userBankMapDTO.setAccountNum(userBankEntity.getAccountNum());
	BankDTO bankDTO = prepareBankDTO(userBankEntity);
	userBankMapDTO.setBank(bankDTO);
	BranchDTO branchDTO = prepareBranchDTO(userBankEntity, bankDTO);

	userBankMapDTO.setBranch(branchDTO);
	userBankMapDTO.setId(userBankEntity.getId());
	userBankMapDTO.setIfscCode(userBankEntity.getIfscCode());
	userBankMapDTO.setModifiedBy(userBankEntity.getModifiedBy());
	userBankMapDTO.setModifiedOn(userBankEntity.getModifiedOn());
	userBankMapDTO.setUser(prepareUserDTO(userBankEntity.getUser()));
	userBankMapDTO.setAccountType(userBankEntity.getAccountType());
	return userBankMapDTO;
    }

    
    /*
     * Preaparing BranchDTO from UserBankEntity and BankDTO
     */
    private BranchDTO prepareBranchDTO(UserBankMap userBankEntity, BankDTO bankDTO) {
	BranchDTO branchDTO = new BranchDTO();
	branchDTO.setAddress(userBankEntity.getBranch().getAddress());
	branchDTO.setBank(bankDTO);
	branchDTO.setBranchName(userBankEntity.getBranch().getBranchName());
	branchDTO.setId(userBankEntity.getBranch().getId());
	branchDTO.setModifiedBy(userBankEntity.getBranch().getModifiedBy());
	branchDTO.setModifiedOn(userBankEntity.getBranch().getModifiedOn());
	branchDTO.setIfscCode(userBankEntity.getBranch().getIfscCode());
	return branchDTO;
    }

    /*
     * Preparing BankDTO from UserBankMap
     */
    private BankDTO prepareBankDTO(UserBankMap userBankEntity) {
	BankDTO bankDTO = new BankDTO();
	bankDTO.setAddress(userBankEntity.getBank().getAddress());
	bankDTO.setBankName(userBankEntity.getBank().getBankName());
	bankDTO.setId(userBankEntity.getBank().getId());
	bankDTO.setLocation(userBankEntity.getBank().getLocation());
	bankDTO.setModifiedBy(userBankEntity.getBank().getModifiedBy());
	bankDTO.setModifiedOn(userBankEntity.getBank().getModifiedOn());
	return bankDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertobank.UserBankMappingService#persistUserBankDetails(com.easybusiness.usermanagement.DTO.UserBankMapDTO)
     * Mapping User with Bank
     * POST method for USER_BANK_MAP_MASTER table with UserBankMapDTO request body
     */
    @Override
    public ResponseEntity<UserBankMapDTO> persistUserBankDetails(UserBankMapDTO userBankMapDTO) {

	UserBankMap userBankMapEntity = new UserBankMap();
	userBankMapEntity.setAccountNum(userBankMapDTO.getAccountNum());
	userBankMapEntity.setBank(bankDao.findBankById(userBankMapDTO.getBank().getId()).get(0));
	userBankMapEntity.setBranch(branchDao.findBranchById(userBankMapDTO.getBranch().getId()).get(0));
	userBankMapEntity.setIfscCode(userBankMapDTO.getIfscCode());
	userBankMapEntity.setModifiedBy(userBankMapDTO.getModifiedBy());
	userBankMapEntity.setModifiedOn(userBankMapDTO.getModifiedOn());
	userBankMapEntity.setAccountType(userBankMapDTO.getAccountType());
	User user = userDao.findUserById(userBankMapDTO.getUser().getId());
	userBankMapEntity.setUser(user);
	
	userBankDao.addUserBankMap(userBankMapEntity);
	return new ResponseEntity<UserBankMapDTO>(userBankMapDTO, HttpStatus.CREATED);

    }

    /*
     * (non-Javadoc)
     * @see com.easybusiness.usermanagement.services.usertobank.UserBankMappingService#destroyUserBankDetails(java.lang.Long)
     * Destroying User Bank mapping
     * DELETE method for USER_BANK_MAP_MASTER table with param mappingid
     */
    @Override
    public void destroyUserBankDetails(Long mappingId) {

	userBankDao.deleteUserBankMap(mappingId);
    }

    
    /*
     * Preparing UserDTO from User entity
     */
    private UserDTO prepareUserDTO(User userEntity) {
	UserDTO userDTO = new UserDTO();
	userDTO.setAlternateEmail(userEntity.getAlternateEmail());
	userDTO.setDateOfBirth(userEntity.getDateOfBirth());
	DepartmentDto deptDO = new DepartmentDto();
	deptDO.setDeptName(userEntity.getDepartment().getDeptName());
	deptDO.setId(userEntity.getDepartment().getId());
	OrganizationDto orgDTO = new OrganizationDto();
	orgDTO.setId(userEntity.getDepartment().getOrganization().getId());
	orgDTO.setHierarchyId(userEntity.getDepartment().getOrganization().getHierarchyId());
	orgDTO.setOrgName(userEntity.getDepartment().getOrganization().getOrgName());
	deptDO.setOrganization(orgDTO);
	userDTO.setDepartment(deptDO);
	DesignationDto desigDTO = new DesignationDto();
	desigDTO.setDesig(userEntity.getDesignation().getDesig());
	desigDTO.setId(userEntity.getDesignation().getId());
	userDTO.setDesignation(desigDTO);
	userDTO.setEmail(userEntity.getEmail());
	userDTO.setEndDate(userEntity.getEndDate());
	userDTO.setFirstName(userEntity.getFirstName());
	userDTO.setFromDate(userEntity.getFromDate());
	userDTO.setGender(userEntity.getGender());
	userDTO.setId(userEntity.getId());
	userDTO.setIsEnabled(userEntity.getIsEnabled());
	userDTO.setLastName(userEntity.getLastName());
	userDTO.setMobile(userEntity.getMobile());
	userDTO.setModifiedBy(userEntity.getModifiedBy());
	userDTO.setModifiedOn(userEntity.getModifiedOn());
	userDTO.setOrganization(orgDTO);
	userDTO.setPassword(userEntity.getPassword());
	userDTO.setTypeOfEmployment(userEntity.getTypeOfEmployment());
	userDTO.setUserName(userEntity.getUserName());
	userDTO.setPermAddr(userEntity.getPermAddr());
	userDTO.setState(userEntity.getState());
	userDTO.setCity(userEntity.getCity());
	userDTO.setCountry(userEntity.getCountry());
	userDTO.setZip(userEntity.getZip());
	userDTO.setFatherName(userEntity.getFatherName());
	userDTO.setSpouseName(userEntity.getSpouseName());
	userDTO.setPassport(userEntity.getPassport());
	userEntity.setLocation(null == userDTO.getLocation() ? null : prepareLocationEntity(userDTO.getLocation()));
	
	return userDTO;
    }

    /*
     * Preparing LocationEntity from LocationMasterDTO
     */
    private LocationMaster prepareLocationEntity(LocationMasterDTO location) {
	LocationMaster locationMaster = new LocationMaster();
	locationMaster.setCreatedBy(location.getCreatedBy());
	locationMaster.setCreatedOn(location.getCreatedOn());
	locationMaster.setId(location.getId());
	locationMaster.setLocationArea(location.getLocationArea());
	locationMaster.setLocationCity(location.getLocationCity());
	locationMaster.setLocationCountry(location.getLocationCountry());
	locationMaster.setLocationPin(location.getLocationPin());
	locationMaster.setLocationState(location.getLocationState());
	locationMaster.setModifiedBy(location.getModifiedBy());
	locationMaster.setModifiedOn(location.getModifiedOn());
	return locationMaster;
    }
    
    private User prepareUserEntity(UserDTO userEntity) {
    	User userDTO = new User();
    	userDTO.setAlternateEmail(userEntity.getAlternateEmail());
    	userDTO.setDateOfBirth(userEntity.getDateOfBirth());
    	Department deptDO = new Department();
    	deptDO.setDeptName(userEntity.getDepartment().getDeptName());
    	deptDO.setId(userEntity.getDepartment().getId());
    	Organization orgDTO = new Organization();
    	orgDTO.setId(userEntity.getDepartment().getOrganization().getId());
    	orgDTO.setHierarchyId(userEntity.getDepartment().getOrganization().getHierarchyId());
    	orgDTO.setOrgName(userEntity.getDepartment().getOrganization().getOrgName());
    	deptDO.setOrganization(orgDTO);
    	userDTO.setDepartment(deptDO);
    	Designation desigDTO = new Designation();
    	desigDTO.setDesig(userEntity.getDesignation().getDesig());
    	desigDTO.setId(userEntity.getDesignation().getId());
    	userDTO.setDesignation(desigDTO);
    	userDTO.setEmail(userEntity.getEmail());
    	userDTO.setEndDate(userEntity.getEndDate());
    	userDTO.setFirstName(userEntity.getFirstName());
    	userDTO.setFromDate(userEntity.getFromDate());
    	userDTO.setGender(userEntity.getGender());
    	userDTO.setId(userEntity.getId());
    	userDTO.setIsEnabled(userEntity.getIsEnabled());
    	userDTO.setLastName(userEntity.getLastName());
    	userDTO.setMobile(userEntity.getMobile());
    	userDTO.setModifiedBy(userEntity.getModifiedBy());
    	userDTO.setModifiedOn(userEntity.getModifiedOn());
    	userDTO.setOrganization(orgDTO);
    	userDTO.setPassword(userEntity.getPassword());
    	userDTO.setTypeOfEmployment(userEntity.getTypeOfEmployment());
    	userDTO.setUserName(userEntity.getUserName());
    	userDTO.setPermAddr(userEntity.getPermAddr());
    	userDTO.setState(userEntity.getState());
    	userDTO.setCity(userEntity.getCity());
    	userDTO.setCountry(userEntity.getCountry());
    	userDTO.setZip(userEntity.getZip());
    	userDTO.setFatherName(userEntity.getFatherName());
    	userDTO.setSpouseName(userEntity.getSpouseName());
    	userDTO.setPassport(userEntity.getPassport());
//    	userEntity.setLocation(null == userDTO.getLocation() ? null : prepareLocationEntity(userDTO.getLocation()));
    	
    	return userDTO;
        }

}
