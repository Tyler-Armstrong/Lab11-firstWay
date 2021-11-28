package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {
    
    
    
    public User login(String email, String password, String path) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {                
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
                
                // simple plain text email
                //GmailService.sendMail(email, "New Login to Notes App! ", "User has logged in", false);
                

                String to = user.getEmail();
                String subject = "Notes App Login";
                String template = path + "/emailtemplates/login.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString());
                
                GmailService.sendMail(to, subject, template, tags);

                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }

    public Boolean forgotPassword(String email, String path) {
        UserDB userdb = new UserDB();
        
        try {
        User user = userdb.get(email);
        
        if(email.equals(user.getEmail())) {
             Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
             
             String to = user.getEmail();
             String subject = "Password incoming";
             String template = path + "/emailtemplates/forgot.html";
              HashMap<String, String> tags = new HashMap<>();
              tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("password", user.getPassword());
                tags.put("email", user.getEmail());
                GmailService.sendMail(to, subject, template, tags);
                return true;
        }
              
        }catch (Exception e) {
        }
        return false;
        
        
    }
}
