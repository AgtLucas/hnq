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
    
    private static void createUsers() throws Exception {
            System.out.println("Creating users...");
            UserDAO dao = new UserDAO();
            User admin = (User) dao.getNewInstance();
            admin.setName("Admin");
            
            User chief = (User) dao.getNewInstance();
            chief.setName("Chief");
            
            dao.create(admin);
            dao.create(chief);
            
            System.out.print("OK!");
        }
    
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
}
