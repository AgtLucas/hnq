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
public class RoleDAO extends AbstractDAO {

    @Override
    protected String getNamedQueryToFindAll() {
        return "role.find.all";
    }

    @Override
    protected String getNamedQueryToFindById() {
        return "role.id.equals";
    }

    @Override
    protected String getNamedQueryToFindByName() {
        return "role.name.equals";
    }

    @Override
    protected String getNamedQueryToCountAll() {
        return "role.count.all";
    }

    @Override
    protected String getNamedQueryToRemoveAll() {
        return "role.remove.all";
    }

    @Override
    protected String getNamedQueryToFindByRange() {
        return "role.find.range";
    }

    @Override
    public Object getNewInstance() {
        return new Role();
    }
    
    
    
}
