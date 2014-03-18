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
import gov.nsa.mi6.UserRole;
import gov.nsa.mi6.UserRoleDAO;
import java.util.List;

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
           UserDAO wtf = new UserDAO();
           wtf.removeAll();
           RoleDAO wth = new RoleDAO();
           wth.removeAll();
           User u = createUsers();
//           showAllUser();
           
           Role r = createRoles();
//           showAllRoles();
//           findRole();
           assigningRoleToUser(u, r);
//           findUser(r);
//           createUsersRoles();
       } catch (Exception ex) {
           System.out.println("The system has failed! Kick the chair! " + ex.getMessage());
       }
        
    }
    
    // Create Users
    private static User createUsers() throws Exception {
            System.out.println("Creating users...");
            UserDAO dao = new UserDAO();
            dao.removeAll();
            
            User bourne = (User) dao.getNewInstance();
            bourne.setName("Jason Bourne");
            
//            User cross = (User) dao.getNewInstance();
//            cross.setName("Aaron Cross");
//            
            dao.create(bourne);
//            dao.create(cross);
            
            System.out.println("Users created!");
            
            return bourne;
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
    
    // Find user
    private static void findUser(Role r) throws Exception {
        
        RoleDAO rd = new RoleDAO();
//        UserDAO ud = new UserDAO();
//        User user = (User) ud.findById(u.getId());
        List<User> ur = rd.findUser(r);
//        UserRole o;
//        Role role;
        System.out.println("User's roles " + r.getName() + ": ");
        User u;
        for (int i = 0; i < ur.size(); i++) {
            u = (User) ur.get(i);
            System.out.println(u);
//            role = (Role) rd.findById(o.getRoleid());
//            System.out.println(i + " - " + role.getName());
        }
        
        
    }
    
    // Show all roles
    private static void showAllRoles() throws Exception {
        RoleDAO dao = new RoleDAO();
        ArrayList users = (ArrayList) dao.findAll();
        Role o;
        
        System.out.println("Listing roles...");
        
        for (int i = 0; i < users.size(); i++) {
            o = (Role) users.get(i);
            System.out.println("ID: " + o.getId() + " - " + "Role: " + o.getName());
        }
        
        Role admin = (Role) dao.getNewInstance();
        
    }
    
    // Create Roles
    private static Role createRoles() throws Exception {
        
        System.out.println("Stand by, creating roles...");
        RoleDAO dao = new RoleDAO();
//        dao.removeAll();
        Role r1 = (Role) dao.getNewInstance();
        r1.setName("Spy");
        
//        Role r2 = (Role) dao.getNewInstance();
//        r2.setName("Recon");
        
        dao.create(r1);
//        dao.create(r2);
        
        System.out.println("Roles created!");
        
        return r1;
        
    }
    
    // Assign role
    private static void assigningRoleToUser(User user, Role role) throws Exception {
        
        System.out.println("Assigning role to user");
//        UserDAO ud = new UserDAO();
//        RoleDAO rd = new RoleDAO();
        
//        User user = (User) ud.findById(1);
//        Role role = (Role) rd.findById(2);
        
        UserRoleDAO urd = new UserRoleDAO();
        UserRole admin = (UserRole) urd.getNewInstance();
        admin.setRoleid(role.getId());
        admin.setUserid(user.getId());
        urd.create(admin);
        
    }
    
    // Find role
//    private static void findRole() throws Exception {
//        
//        RoleDAO rd = new RoleDAO();
//        UserDAO ud = new UserDAO();
//        Role r = (Role) rd.findById(1);
//        System.out.println(r.getName());
//        
//        List<UserRole> ur = rd.findUser(r);
//        UserRole o;
//        User user = new User();
//        System.out.println("Users with role " + r.getName()+ ": ");
//        for (int i = 0; i < ur.size(); i++) {
//            o = (UserRole) ur.get(i);
//            user = (User) ud.findById(o.getRoleid());
//            System.out.println(i +" - " + user.getName());
//        }
//        
//    }
    
    // Remove role
    private static void removeRole() throws Exception {
        UserDAO ud = new UserDAO();
        RoleDAO rd = new RoleDAO();
        Role role = (Role) rd.findById(2);
        User user = (User) ud.findById(2);
        ud.removeRole(user, role);
    }
    
    // Has role?
    private static void hasRole() throws Exception {
        UserDAO ud = new UserDAO();
        RoleDAO rd = new RoleDAO();
        Role role = (Role) rd.findById(2);
        User user = (User) ud.findById(2);
        boolean itHasRole = ud.hasRole(role, user);
        if (itHasRole == true) {
            System.out.println("Yep! :)");
        } else {
            System.out.println("Nop! :(");
        }
    }
    
}
