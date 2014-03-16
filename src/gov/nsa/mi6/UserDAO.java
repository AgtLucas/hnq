/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.nsa.mi6;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author lucas.silva
 */
public class UserDAO extends AbstractDAO {
 
    @Override
    protected String getNamedQueryToFindAll() {
        return "user.find.all";
    }
    
    @Override
    protected String getNamedQueryToFindById() {
        return "user.id.equals";
    }

    @Override
    protected String getNamedQueryToFindByName() {
        return "user.name.equals";
    }    
 
    @Override
    protected String getNamedQueryToCountAll() {
        return "user.count.all";
    }     

    @Override
    protected String getNamedQueryToRemoveAll() {
        return "user.remove.all";
    }     

    @Override
    protected String getNamedQueryToFindByRange() {
        return "user.find.range";
    }     

    @Override
    public Object getNewInstance() {
        return new User();
    }
    
    protected String getNamedQueryToFindRoles() {
        return "Role.find.rolesUser";
    }
    
    public List<UserRole> findRoles(User user) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.getNamedQuery(getNamedQueryToFindRoles());
            q.setString("user", Integer.toString(user.getId()));
            List lt = q.list();
            session.getTransaction().commit();
            return lt;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getLocalizedMessage());
        } finally {
            releaseSession(session);
        }
    }
    
}
