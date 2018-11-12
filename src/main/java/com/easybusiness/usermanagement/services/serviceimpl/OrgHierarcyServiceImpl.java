package com.easybusiness.usermanagement.services.serviceimpl;

import static com.easybusiness.usermanagement.constant.UserManagementConstant.USER_HOST_SERVER;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.usermanagement.DTO.DepartmentDto;
import com.easybusiness.usermanagement.DTO.DesignationDto;
import com.easybusiness.usermanagement.DTO.GroupHeadDTO;
import com.easybusiness.usermanagement.DTO.HrManagerDTO;
import com.easybusiness.usermanagement.DTO.LocationMasterDTO;
import com.easybusiness.usermanagement.DTO.OrgDTO;
import com.easybusiness.usermanagement.DTO.OrgHeadDTO;
import com.easybusiness.usermanagement.DTO.OrganizationDto;
import com.easybusiness.usermanagement.DTO.ParentOrgDTO;
import com.easybusiness.usermanagement.DTO.PriSupervisorDTO;
import com.easybusiness.usermanagement.DTO.PrjSupervisorDTO;
import com.easybusiness.usermanagement.DTO.UserDTO;
import com.easybusiness.usermanagement.DTO.UserHDTO;
import com.easybusiness.usermanagement.DTO.UserHierarcyDTO;
import com.easybusiness.usermanagement.dao.LocationMasterDao;
import com.easybusiness.usermanagement.dao.OrganizationDao;
import com.easybusiness.usermanagement.dao.UserDao;
import com.easybusiness.usermanagement.dao.UserHierarcyDao;
import com.easybusiness.usermanagement.entity.LocationMaster;
import com.easybusiness.usermanagement.entity.Organization;
import com.easybusiness.usermanagement.entity.User;
import com.easybusiness.usermanagement.entity.UserHierarchy;
import com.easybusiness.usermanagement.services.OrgHierarcyService;

/*
 * Service and RestController class for UserHierarchy
 */
@RestController
@RequestMapping("/easybusiness/orghierarcy/")
public class OrgHierarcyServiceImpl implements OrgHierarcyService {
	
	@Autowired
	UserHierarcyDao hierarcyDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrganizationDao orgDao;
	
	@Autowired
	LocationMasterDao locationDao;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrgHierarcyServiceImpl.class);

	
	/*
	 * (non-Javadoc)
	 * @see com.easybusiness.usermanagement.services.userhierarcy.UserHierarcyService#getHierarcyById(java.lang.Long)
	 * fetching hierarchy by hierarchy ID
	 * GET method for user_hierarcy table with param hierarcyId
	 */
	@Override
	public ResponseEntity<UserHierarcyDTO> getHierarcyById(Long hierarcyId) {
		UserHierarchy hierarcy = hierarcyDao.getHierarchyById(hierarcyId);
		return new ResponseEntity<UserHierarcyDTO>(prepareUserHierarchyDTO(hierarcy), HttpStatus.OK);
	}

	
	/*
	 * preparing hierarchy DTO for fetching data
	 */
	private UserHierarcyDTO prepareUserHierarchyDTO(UserHierarchy hierarcy) {
		UserHierarcyDTO hierarcyDTO = new UserHierarcyDTO();
		
		
		hierarcyDTO.setFromDate(hierarcy.getFromDate());
		hierarcyDTO.setModBy(hierarcy.getModBy());
		hierarcyDTO.setModOn(hierarcy.getModOn());
		hierarcyDTO.setPracticeMaster(hierarcy.getPracticeMaster());
		hierarcyDTO.setPrjAllocDate(hierarcy.getPrjAllocDate());
		hierarcyDTO.setPrjReleaseDate(hierarcy.getPrjReleaseDate());
		hierarcyDTO.setProjectMaster(hierarcy.getProjectMaster());
		hierarcyDTO.setStatus(hierarcy.getStatus());
		hierarcyDTO.setToDate(hierarcy.getToDate());
		
		User user = userDao.findUserById(hierarcy.getUser().getId());
		
		
		hierarcyDTO.setUser(prepareUserDTO(user));
		
		//setting priSupervisor
		User priSupervisor = userDao.findUserById(hierarcy.getPriSupervisor().getId());
		hierarcyDTO.setPriSupervisor(prepareUserDTO(priSupervisor));
		
		User hrManager = userDao.findUserById(hierarcy.getHrManager().getId());
		hierarcyDTO.setHrManager(prepareUserDTO(hrManager));
		
		hierarcyDTO.setHierarcyId(hierarcy.getHierarcyId());
		
		Organization org = orgDao.findOrganizationById(hierarcy.getUser().getOrganization().getId()).get();
		hierarcyDTO.setOrgId(org);
		
		Organization parentOrg = orgDao.findOrganizationById(hierarcy.getUser().getOrganization().getId()).get();
		hierarcyDTO.setParentOrgId(parentOrg);
		
		if(hierarcy.getGroupHead() != null) {
			User groupHeadEntity = userDao.findUserById(hierarcy.getGroupHead().getId());
			long groupHeadDesigId = groupHeadEntity.getDesignation().getId();
			if(groupHeadDesigId == 6) {		//checking if the user is chairman or not
//				hierarcyDTO.setGroupHead(groupHeadEntity.getFirstName()+" "+groupHeadEntity.getLastName());
				hierarcyDTO.setGroupHead(prepareUserDTO(groupHeadEntity));
			}
		}
		
		
		
		/*List<User> orgHeadEntityList = userDao.findByUserNameStream(hierarcy.getOrgHead().getUserName());
		List<UserDTO> orgHeadDTOList = new ArrayList<>();
		orgHeadEntityList.forEach(orgHead->{
			long orgHeadDesigId = orgHead.getDesignation().getId();
			if(orgHeadDesigId == 1) {
				orgHeadDTOList.add(prepareUserDTO(orgHead));
			}
		});
		hierarcyDTO.setOrgHead(orgHeadDTOList);*/
		
		if(hierarcy.getOrgHead() != null) {
			User orgHeadEntity = userDao.findUserById(hierarcy.getOrgHead().getId());
			long orgHeadDesigID = orgHeadEntity.getDesignation().getId();
			if(orgHeadDesigID == 1) {	//checking if the user is director or not
				hierarcyDTO.setOrgHead(prepareUserDTO(orgHeadEntity));
			}
		}
		
		
		/*List<User> orgHeadEntity = userDao.findByUserNameStream(hierarcy.getUser().getUserName());
		orgHeadEntity.forEach(orgHead->{
			hierarcyDTO.setOrgHead(orgHead.getFirstName()+" "+orgHead.getLastName());
		});*/
		
		return hierarcyDTO;
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.easybusiness.usermanagement.services.userhierarcy.UserHierarcyService#persistHierarcy(com.easybusiness.usermanagement.DTO.UserHierarcyDTO)
	 * saving hierarchy to DB
	 * POST method for user_hierarcy table with request body UserHierarcyDTO
	 */
	@Override
	public UserHierarcyDTO persistHierarcy(UserHierarcyDTO hierarcy) {
		
		UserHierarchy hierarchyEntity = new UserHierarchy();
		
		/*hierarchyEntity.setFromDate(hierarcy.getFromDate());
		hierarchyEntity.setHrManager(hierarcy.getHrManager());
		hierarchyEntity.setModBy(hierarcy.getModBy());
		hierarchyEntity.setModOn(hierarcy.getModOn());
		hierarchyEntity.setPracticeMaster(hierarcy.getPracticeMaster());
		hierarchyEntity.setPriSupervisor(hierarcy.getPriSupervisor());
		hierarchyEntity.setPrjAllocDate(hierarcy.getPrjAllocDate());
		hierarchyEntity.setPrjReleaseDate(hierarcy.getPrjReleaseDate());
		hierarchyEntity.setProjectMaster(hierarcy.getProjectMaster());
		hierarchyEntity.setStatus(hierarcy.getStatus());
		hierarchyEntity.setToDate(hierarcy.getToDate());
		hierarchyEntity.setUser(hierarcy.getUser());
		hierarchyEntity.setOrgHead(hierarcy.getOrgHead());
		hierarchyEntity.setGroupHead(hierarcy.getGroupHead());
		hierarchyEntity.setOrgId(hierarcy.getOrgId());
		hierarchyEntity.setParentOrgId(hierarcy.getParentOrgId());*/
		
		hierarcyDao.saveHierarcy(hierarchyEntity);
		
		return hierarcy;
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.easybusiness.usermanagement.services.userhierarcy.UserHierarcyService#populateHierarcyList()
	 * fetching all hierarchies
	 * GET method for user_hierarcy table
	 */
	@Override
	public List<UserHierarcyDTO> populateHierarcyList() {
		List<UserHierarcyDTO> hierarcyEmpList = new ArrayList<>();
		try {
			List<UserHierarchy> hierarcyList = hierarcyDao.getAllHierarcy();
			hierarcyList.forEach(hierarcy->{
				hierarcyEmpList.add(prepareUserHierarchyDTO(hierarcy));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return hierarcyEmpList;
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.easybusiness.usermanagement.services.userhierarcy.UserHierarcyService#destroyHierarcy(long)
	 * deleting hierarchy by hierarchy id
	 * DELETE method for user_hierarcy table with param hierarcyId
	 */
	@Override
	public void destroyHierarcy(long hierarcyId) {
		hierarcyDao.deleteHierarcy(hierarcyId);

	}
	

	/*
	 * (non-Javadoc)
	 * @see com.easybusiness.usermanagement.services.userhierarcy.UserHierarcyService#updateHierarcy(long, com.easybusiness.usermanagement.DTO.UserHierarcyDTO)
	 * updating hierarchy
	 * PUT method for user_hierarcy table param hierarcyId and request body UserHierarcyDTO
	 */
	@Override
	public UserHierarcyDTO updateHierarcy(long hierarcyId, UserHierarcyDTO hierarchyDTO) {
		
		UserHierarchy hierarcyEntity = hierarcyDao.getHierarchyById(hierarcyId);	//getting hierarchy by hierarchy id
		
		/*hierarcyEntity.setFromDate(hierarchyDTO.getFromDate());
		hierarcyEntity.setHrManager(hierarchyDTO.getHrManager());
		hierarcyEntity.setModBy(hierarchyDTO.getModBy());
		hierarcyEntity.setModOn(hierarchyDTO.getModOn());
		hierarcyEntity.setPracticeMaster(hierarchyDTO.getPracticeMaster());
		hierarcyEntity.setPriSupervisor(hierarchyDTO.getPriSupervisor());
		hierarcyEntity.setPrjAllocDate(hierarchyDTO.getPrjAllocDate());
		hierarcyEntity.setPrjReleaseDate(hierarchyDTO.getPrjReleaseDate());
		hierarcyEntity.setProjectMaster(hierarchyDTO.getProjectMaster());
		hierarcyEntity.setStatus(hierarchyDTO.getStatus());
		hierarcyEntity.setToDate(hierarchyDTO.getToDate());
		hierarcyEntity.setUser(hierarchyDTO.getUser());
		hierarcyEntity.setOrgHead(hierarchyDTO.getOrgHead());
		hierarcyEntity.setGroupHead(hierarchyDTO.getGroupHead());
		hierarcyEntity.setOrgId(hierarchyDTO.getOrgId());
		hierarcyEntity.setParentOrgId(hierarchyDTO.getParentOrgId());*/
		
		hierarcyDao.update(hierarcyEntity);
		return hierarchyDTO;
	}
	
	/*@CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getorgHead/{orgHead}", method = RequestMethod.GET)
    @ResponseBody
	public List<OrgHeadDTO> orgHead(@PathVariable("orgHead") long orgHead) {
//		List<UserHierarchy> hierarcyList = hierarcyDao.getAllHierarcy();
		List<UserHierarchy> hierarcyList = hierarcyDao.getHierarchyByOrgHead(orgHead);
		OrgHeadDTO hierarchyList = new OrgHeadDTO();
		hierarcyList.forEach(orgHeadEntity->{
			//List<UserHierarchy> hierarcyOrgHeads = hierarcyDao.getHierarchyByOrgHead(orgHeadEntity.getOrgHead().getId());
			hierarchyList.setOrgHead(orgHeadEntity.getOrgHead());
			hierarchyList.setHrManager(orgHeadEntity.getHrManager());
		});
		return null;
	}*/
	
	
	/*
	 * (non-Javadoc)
	 * @see com.easybusiness.usermanagement.services.userhierarcy.UserHierarcyService#groupHead()
	 * fetching hierarchy in nested manner
	 */
	@Override
	public ParentOrgDTO groupHead() {
		
		List<UserHierarchy> hierarchyList = hierarcyDao.getAllHierarcy();	//fetching all hierarchies
		
		ParentOrgDTO parentOrg = new ParentOrgDTO();
		OrgDTO orgDTO = new OrgDTO();
		
		GroupHeadDTO groupHeadList = new GroupHeadDTO();
//		List<GroupHeadDTO> groupHeadDTOList = new ArrayList<>();
		
		
		hierarchyList.forEach(hierarchy->{
			OrgDTO orgDto = new OrgDTO();
			List<OrgDTO> orgDtos = new ArrayList<>();
			List<UserHierarchy> forOrgId = hierarcyDao.getHierarchyByOrgId(hierarchy.getOrgId().getId());
			
			parentOrg.setParentOrg(hierarchy.getParentOrgId());
			
			forOrgId.forEach(orgId->{
				GroupHeadDTO groupheadDTO = new GroupHeadDTO();
				List<GroupHeadDTO> groupheads = new ArrayList<>();
				List<UserHierarchy> forGroupHead = hierarcyDao.getHierarchyByGroupHead(orgId.getGroupHead().getId());
				
				orgDto.setOrg(orgId.getOrgId());
				
				forGroupHead.forEach(grouphead->{
					OrgHeadDTO orgheadDto = new OrgHeadDTO();
					List<OrgHeadDTO> orgheads = new ArrayList<>();
					List<UserHierarchy> forOrgHead = hierarcyDao.getHierarchyByOrgHead(grouphead.getOrgHead().getId());
					
					groupheadDTO.setGroupHead(prepareUserDTO(grouphead.getGroupHead()));
					
					
					forOrgHead.forEach(orghead->{
						HrManagerDTO hrmanagerDto = new HrManagerDTO();
						List<HrManagerDTO> hrmanagers = new ArrayList<>();
						List<UserHierarchy> forHrManager = hierarcyDao.getHierarchyByHrManager(orghead.getHrManager().getId()); 
						
						orgheadDto.setOrgHead(prepareUserDTO(orghead.getOrgHead()));
						
						forHrManager.forEach(hrmanager->{
							PriSupervisorDTO prisupervisorDTO = new PriSupervisorDTO();
							List<PriSupervisorDTO> prisupervisors = new ArrayList<>();
							List<UserHierarchy> forPriSupervisor = hierarcyDao.getHierarchyByPriSupervisor(hrmanager.getPriSupervisor().getId());
							
							hrmanagerDto.setHrManager(prepareUserDTO(hrmanager.getHrManager()));
							
							forPriSupervisor.forEach(prisupervisor->{
								PrjSupervisorDTO prjsupervisorDto = new PrjSupervisorDTO();
								List<PrjSupervisorDTO> prjsupervisors = new ArrayList<>();
								List<UserHierarchy> forprjsupervisor = hierarcyDao.getHierarchyByPrjSupervisor(prisupervisor.getPrjSupervisor().getId());
								
								
								prisupervisorDTO.setPriSupervisor(prepareUserDTO(prisupervisor.getPriSupervisor()));
								
								forprjsupervisor.forEach(prjsupervisor->{
									UserHDTO userDto = new UserHDTO();
									List<UserHDTO> users = new ArrayList<>();
									List<UserHierarchy> forUser = hierarcyDao.getHierarchyByUser(prjsupervisor.getUser().getId());
									
									prjsupervisorDto.setPrjSupervisor(prepareUserDTO(prjsupervisor.getPrjSupervisor()));
									
									forUser.forEach(user->{
										userDto.setUser(prepareUserDTO(user.getUser()));
										users.add(userDto);
									});
									
									prjsupervisorDto.setUser(users);
									prjsupervisors.add(prjsupervisorDto);
									
								});
								
								prisupervisorDTO.setPrjSupervisor(prjsupervisors);
								prisupervisors.add(prisupervisorDTO);
								
							});
							
							hrmanagerDto.setPriSuperviser(prisupervisors);
							hrmanagers.add(hrmanagerDto);
							
						});
						
						orgheadDto.setHrManager(hrmanagers);
						orgheads.add(orgheadDto);
						
					});
					
					groupheadDTO.setOrgHeadList(orgheads);
					groupheads.add(groupheadDTO);
					
				});
				System.out.println(groupheads);
				orgDto.setGroupHead(groupheads);
				System.out.println(orgDto);
				orgDtos.add(orgDTO);
				System.out.println("orgdtos "+orgDtos);
			});
			
			parentOrg.setOrg(orgDto);
			
			System.out.println(parentOrg);
		});
		
		return parentOrg;
	}
	
	/*@CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getuser/{id}", method = RequestMethod.GET)
    @ResponseBody
	public List<UserHierarchy> getUser(@PathVariable("id") long id) {
		List<UserHierarchy> hierarcyList = hierarcyDao.getHierarchyByUser(id);
		List<UserHierarchy> hierarchyList = new ArrayList<>();
		
		hierarcyList.forEach(groupHeadEntity->{
			hierarchyList.add(groupHeadEntity);
		});
		
		return hierarchyList;
	}*/
	
	
	//preparing user DTO
	private UserDTO prepareUserDTO(User userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setAlternateEmail(userEntity.getAlternateEmail());
		userDTO.setDateOfBirth(userEntity.getDateOfBirth());
		DepartmentDto deptDO = new DepartmentDto();
		try {
		    deptDO.setDeptName(userEntity.getDepartment().getDeptName());
		    deptDO.setId(userEntity.getDepartment().getId());

		    OrganizationDto orgDTO = new OrganizationDto();

		    orgDTO.setId(userEntity.getDepartment().getOrganization().getId());
		    orgDTO.setHierarchyId(userEntity.getDepartment().getOrganization().getHierarchyId());
		    orgDTO.setOrgName(userEntity.getDepartment().getOrganization().getOrgName());
		    deptDO.setOrganization(orgDTO);
		    userDTO.setDepartment(deptDO);
		    userDTO.setOrganization(orgDTO);
		} catch (Exception e) {
		    LOGGER.error("error in getting organization/department of user {} {}", userEntity.getUserName(),
			    e.getMessage());
		}
		try {
		    DesignationDto desigDTO = new DesignationDto();

		    desigDTO.setDesig(userEntity.getDesignation().getDesig());
		    desigDTO.setId(userEntity.getDesignation().getId());
		    desigDTO.setModBy(userEntity.getDesignation().getModBy());
		    desigDTO.setModOn(userEntity.getDesignation().getModOn());

		    userDTO.setDesignation(desigDTO);
		} catch (Exception e) {
		    LOGGER.error("error in getting designation of user {} {}", userEntity.getUserName(), e.getMessage());
		}
		
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

		
		
		userDTO.setTypeOfEmployment(userEntity.getTypeOfEmployment());
		
		//getting user image
		int usrImgLength;
		try {
			if(userEntity.getUserImg() != null) {
			usrImgLength = (int) userEntity.getUserImg().length();
			System.out.println(usrImgLength);
			if(0 != usrImgLength) {
				userDTO.setUserImg(userEntity.getUserImg().getBytes(1, usrImgLength));
			}else {
				userDTO.setUserImg(null);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		userDTO.setUserName(userEntity.getUserName());
		userDTO.setPermAddr(userEntity.getPermAddr());
		userDTO.setState(userEntity.getState());
		userDTO.setCity(userEntity.getCity());
		userDTO.setCountry(userEntity.getCountry());
		userDTO.setZip(userEntity.getZip());
		userDTO.setFatherName(userEntity.getFatherName());
		userDTO.setSpouseName(userEntity.getSpouseName());
		userDTO.setPassport(userEntity.getPassport());
		
		LocationMaster location = locationDao.getLocationById(userEntity.getDepartment().getOrganization().getLocationId());
		userDTO.setLocation(null == location ? null : prepareLocationDTO(location));
		
		return userDTO;
	    }
	
	private LocationMasterDTO prepareLocationDTO(LocationMaster location) {
		LocationMasterDTO locationMaster = new LocationMasterDTO();
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


	/*@Override
	@RequestMapping(value = "getuser", method = RequestMethod.GET)
    @ResponseBody
	public List<JsonNode> getHierarchy() {
		ObjectMapper mapper = new ObjectMapper();
		List<UserHierarchy> hierarchy = hierarcyDao.getAllHierarcy();
		JsonNode node = mapper.createObjectNode();
		List<JsonNode> nodes = new ArrayList<>();
		hierarchy.forEach(h->{
			JsonNode node1 = mapper.valueToTree(h);
			nodes.add(node1);
		});
		
		return nodes;
	}*/

	
	
	

}
