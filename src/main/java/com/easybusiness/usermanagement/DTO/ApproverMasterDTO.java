package com.easybusiness.usermanagement.DTO;

import java.io.Serializable;
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

public class ApproverMasterDTO implements Serializable {

    private static final long serialVersionUID = -5300599187745769139L;

    private Long id;
    
    private String taskDesc;

    private UserDTO user1;
    
    private UserDTO user2;
    
    private UserDTO user3;
    
    private UserDTO user4;
    
    private UserDTO user5;

    private String modifiedBy;

    private Date modifiedOn;

    public ApproverMasterDTO() {
	super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }


    public UserDTO getUser1() {
        return user1;
    }

    public void setUser1(UserDTO user1) {
        this.user1 = user1;
    }

    public UserDTO getUser2() {
        return user2;
    }

    public void setUser2(UserDTO user2) {
        this.user2 = user2;
    }

    public UserDTO getUser3() {
        return user3;
    }

    public void setUser3(UserDTO user3) {
        this.user3 = user3;
    }

    public UserDTO getUser4() {
        return user4;
    }

    public void setUser4(UserDTO user4) {
        this.user4 = user4;
    }

    public UserDTO getUser5() {
        return user5;
    }

    public void setUser5(UserDTO user5) {
        this.user5 = user5;
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

    @Override
    public String toString() {
	return "ApproverMaster [id=" + id + ", taskDesc=" + taskDesc + ", user1=" + user1 + ", user2=" + user2
		+ ", user3=" + user3 + ", user4=" + user4 + ", user5=" + user5 + ", modifiedBy=" + modifiedBy
		+ ", modifiedOn=" + modifiedOn + "]";
    }

    


   

}
