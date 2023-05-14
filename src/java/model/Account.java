/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;
import my.util.Validation;

/**
 *
 * @author AnataArisa
 */
public class Account {
    private String UID;
    private String username;
    private String password;
    private String roles;
    private Date registerDate;
    private Date lastLoginDate;
    private boolean status;
    
    public Account(){
        this.UID = UUID.randomUUID().toString();
        this.registerDate = Date.valueOf(LocalDate.now());
        this.lastLoginDate = Date.valueOf(LocalDate.now());
    }
    
    public Account(String username, String password, String roles, boolean status){
        this();
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    
    public Account(String username, String password){
        if(Validation.usernameValidation(username)) this.username = username;
        else this.username = null;
        if(Validation.passwordValidation(password)) this.password = password;
         else this.password = null;
    }
    
    public Account(String UID, String username, String password, String roles, Date registerDate, Date lastLoginDate, boolean status){
        this.UID = UID;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.registerDate = registerDate;
        this.lastLoginDate = lastLoginDate;
        this.status = status;
    }
    public void setUID(){
        this.UID = UUID.randomUUID().toString();
    }
    public String getUID(){
        return this.UID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(Validation.usernameValidation(username)) this.username = username;
        else this.username = null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
         if(Validation.passwordValidation(password)) this.password = password;
         else this.password = null;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    
    public void setRegisterDate(){
        this.registerDate = Date.valueOf(LocalDate.now());
    }
    
    public Date getRegisterDate(){
        return this.registerDate;
    }
    
    public void setLastLoginDate(){
        this.lastLoginDate = Date.valueOf(LocalDate.now());
    }
    
    public Date getLastLoginDate(){
        return this.lastLoginDate;
    }
    
    public boolean getStatus(){
        return this.status;
    }
    
    public void setStatus(boolean status){
        this.status = status;
    }
    
}
