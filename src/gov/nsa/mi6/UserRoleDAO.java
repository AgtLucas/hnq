/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.nsa.mi6;

/**
 *
 * @author lucas.silva
 */
public class UserRoleDAO extends AbstractDAO {

    @Override
    protected String getNamedQueryToFindAll() {
        return "userrole.find.all";
    }

    @Override
    protected String getNamedQueryToFindById() {
        return "userole.id.equals";
    }

    @Override
    protected String getNamedQueryToFindByName() {
        return "userrole.name.equals";
    }

    @Override
    protected String getNamedQueryToCountAll() {
        return "userrole.count.all";
    }

    @Override
    protected String getNamedQueryToRemoveAll() {
        return "userrole.remove.all";
    }

    @Override
    protected String getNamedQueryToFindByRange() {
        return "userrole.find.range";
    }

    @Override
    public Object getNewInstance() {
        return new UserRole();
    }
    
    
    
}
