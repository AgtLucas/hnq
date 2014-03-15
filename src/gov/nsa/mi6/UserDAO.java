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
    
}
