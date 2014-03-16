/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import gov.nsa.mi6.User;
import gov.nsa.mi6.UserDAO;
import gov.nsa.mi6.Role;
import gov.nsa.mi6.RoleDAO;

/**
 *
 * @author lucas.silva
 */
public class TestarPersistence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       try {
//           createUsers();
           showAllUser();
       } catch (Exception ex) {
           System.out.println("The system has failed! Kick the chair!" + ex.getMessage());
       }
        
    }
    
    // Create Users
    private static void createUsers() throws Exception {
            System.out.println("Creating users...");
            UserDAO dao = new UserDAO();
            User bourne = (User) dao.getNewInstance();
            bourne.setName("Jason Bourne");
            
            User cross = (User) dao.getNewInstance();
            cross.setName("Aaron Cross");
            
            dao.create(bourne);
            dao.create(cross);
            
            System.out.print("OK!");
        }
    
    // Show all Users
    private static void showAllUser() throws Exception {
        
        System.out.println("Users...");
        UserDAO dao = new UserDAO();
        ArrayList users = (ArrayList) dao.findAll();
        User o;
        
        for (int i = 0; i < users.size(); i++) {
            o = (User) users.get(i);
            System.out.println("ID: " + o.getId() + " - " + "Name: " + o.getName());
        }
        
        User admin = (User) dao.getNewInstance();
        
    }
    
    // Create Roles
    private static void createRoles() throws Exception {
        
        System.out.println("Stand by, creating roles...");
        RoleDAO dao = new RoleDAO();
        Role r1 = (Role) dao.getNewInstance();
        r1.setName("");
        
    }
}
