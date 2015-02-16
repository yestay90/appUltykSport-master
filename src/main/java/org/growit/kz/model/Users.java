package org.growit.kz.model;


import javax.persistence.*;

/**
 * Created by ymuratov on 2/12/15.
 */
@Entity
@Table(name="users")
public class Users {
    private int userid;
    private String username;
    private String userpassword;
    private String userrole;
    private String userfirstname;
    private String userlastname;

    @Id
    @Column(name = "userid", nullable = false, insertable = true, updatable = true)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userpassword", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Basic
    @Column(name = "userrole", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    @Basic
    @Column(name = "userfirstname", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUserfirstname() {
        return userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }

    @Basic
    @Column(name = "userlastname", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userid != users.userid) return false;
        if (userfirstname != null ? !userfirstname.equals(users.userfirstname) : users.userfirstname != null)
            return false;
        if (userlastname != null ? !userlastname.equals(users.userlastname) : users.userlastname != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (userpassword != null ? !userpassword.equals(users.userpassword) : users.userpassword != null) return false;
        if (userrole != null ? !userrole.equals(users.userrole) : users.userrole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userpassword != null ? userpassword.hashCode() : 0);
        result = 31 * result + (userrole != null ? userrole.hashCode() : 0);
        result = 31 * result + (userfirstname != null ? userfirstname.hashCode() : 0);
        result = 31 * result + (userlastname != null ? userlastname.hashCode() : 0);
        return result;
    }
}
