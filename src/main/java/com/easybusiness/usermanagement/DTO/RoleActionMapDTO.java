package com.easybusiness.usermanagement.DTO;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class RoleActionMapDTO {
    
    private Long id;

    private RoleDTO role;
    
    private Long isEnable;

    private Date fromDate;

    private Date toDate;

    private String modifiedBy;

    private Date modifiedOn;
    
    private long createAllowed;
    
    private long updateAllowed;
    
    private long viewAllowed;
    
    private long deleteAllowed;
    
    private long downloadAllowed;
    
    private long uploadAllowed;
    
    private long printAllowed;
    
    private long selectAllowed;
    
    

    public RoleActionMapDTO() {
	super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public Long getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Long isEnable) {
        this.isEnable = isEnable;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public long getCreateAllowed() {
        return createAllowed;
    }

    public void setCreateAllowed(long createAllowed) {
        this.createAllowed = createAllowed;
    }

    public long getUpdateAllowed() {
        return updateAllowed;
    }

    public void setUpdateAllowed(long updateAllowed) {
        this.updateAllowed = updateAllowed;
    }

    public long getViewAllowed() {
        return viewAllowed;
    }

    public void setViewAllowed(long viewAllowed) {
        this.viewAllowed = viewAllowed;
    }

    public long getDeleteAllowed() {
        return deleteAllowed;
    }

    public void setDeleteAllowed(long deleteAllowed) {
        this.deleteAllowed = deleteAllowed;
    }

    public long getDownloadAllowed() {
        return downloadAllowed;
    }

    public void setDownloadAllowed(long downloadAllowed) {
        this.downloadAllowed = downloadAllowed;
    }

    public long getUploadAllowed() {
        return uploadAllowed;
    }

    public void setUploadAllowed(long uploadAllowed) {
        this.uploadAllowed = uploadAllowed;
    }

    public long getPrintAllowed() {
        return printAllowed;
    }

    public void setPrintAllowed(long printAllowed) {
        this.printAllowed = printAllowed;
    }

    public long getSelectAllowed() {
        return selectAllowed;
    }

    public void setSelectAllowed(long selectAllowed) {
        this.selectAllowed = selectAllowed;
    }

    @Override
    public String toString() {
	return "RoleActionMap [id=" + id + ", role=" + role + ", isEnable=" + isEnable + ", fromDate=" + fromDate
		+ ", toDate=" + toDate + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn
		+ ", createAllowed=" + createAllowed + ", updateAllowed=" + updateAllowed + ", viewAllowed="
		+ viewAllowed + ", deleteAllowed=" + deleteAllowed + ", downloadAllowed=" + downloadAllowed
		+ ", uploadAllowed=" + uploadAllowed + ", printAllowed=" + printAllowed + ", selectAllowed="
		+ selectAllowed + "]";
    }
    
   
    


}
