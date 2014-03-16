/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.nsa.mi6;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author lucas.silva
 */
@Entity
@Table(name="userrole")
@NamedQueries({
    @NamedQuery(name = "userrole.id.equals", query = "SELECT o FROM userrole o WHERE o.roleid=:roleid"),
    @NamedQuery(name = "userrole.name.equals", query = "SELECT o FROM userrole o WHERE o.roleid=:roleid"),
    @NamedQuery(name = "userrole.find.all", query = "SELECT o FROM userrole o"),
    @NamedQuery(name = "userrole.count.all", query = "SELECT COUNT(o.roleid) FROM userrole o"),
    @NamedQuery(name = "userrole.remove.all", query = "DELETE FROM userrole o"),
    @NamedQuery(name = "userrole.find.range", query = "SELECT o FROM userrole o WHERE o.roleid BETWEEN :minId and :maxId")
})
public class UserRole implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "userid")
    private int userid;
    @Column(name = "roleid")
    private int roleid;

    public UserRole() {
        setRoleid(0);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
    
    public void setUser(int name) {
        this.userid = name;
    }

    @Override
    public String toString() {
        return "Roles {" + "id=" + roleid + ", name=" + userid + "}";
    }
    
}
