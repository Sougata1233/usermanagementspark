package com.easybusiness.usermanagement.entity;

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

@Entity
@Table(name = "APPROVER_MASTER")
public class ApproverMaster implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5300599187745769139L;

    @Id
    @Column(name = "TASK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "TASK_DESC")
    private String taskDesc;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "USER_1")
    private User user1;
    
    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "USER_2")
    private User user2;
    
    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "USER_3")
    private User user3;
    
    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "USER_4")
    private User user4;
    
    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "USER_5")
    private User user5;


    @Column(name = "MOD_BY")
    private String modifiedBy;

    @Column(name = "MOD_ON")
    private Date modifiedOn;

    public ApproverMaster() {
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

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public User getUser3() {
        return user3;
    }

    public void setUser3(User user3) {
        this.user3 = user3;
    }

    public User getUser4() {
        return user4;
    }

    public void setUser4(User user4) {
        this.user4 = user4;
    }

    public User getUser5() {
        return user5;
    }

    public void setUser5(User user5) {
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
