package com.yx.po;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Myuser implements Serializable {
    private long userId;
    private String userName;
    private String userPwd;
    private String userEmail;
    private Long userAdmin;

    @Id
    @Column(name = "USER_ID", nullable = false, precision = 0)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_PWD", nullable = true, length = 50)
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "USER_EMAIL", nullable = true, length = 50)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "USER_ADMIN", nullable = true, precision = 0)
    public Long getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(Long userAdmin) {
        this.userAdmin = userAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Myuser myuser = (Myuser) o;

        if (userId != myuser.userId) return false;
        if (userName != null ? !userName.equals(myuser.userName) : myuser.userName != null) return false;
        if (userPwd != null ? !userPwd.equals(myuser.userPwd) : myuser.userPwd != null) return false;
        if (userEmail != null ? !userEmail.equals(myuser.userEmail) : myuser.userEmail != null) return false;
        if (userAdmin != null ? !userAdmin.equals(myuser.userAdmin) : myuser.userAdmin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPwd != null ? userPwd.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userAdmin != null ? userAdmin.hashCode() : 0);
        return result;
    }
}
