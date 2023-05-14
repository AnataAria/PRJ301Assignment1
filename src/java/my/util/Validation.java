/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.util;

/**
 *
 * @author AnataArisa
 */
public class Validation {
    public static boolean usernameValidation(String username){
        if(username.isEmpty()) return false;
        return !username.matches("[^a-zA-Z0-9]");
    }
    public static boolean regexValidation(String datain, String regex){
        return datain.matches(regex);
    }
    
    public static boolean passwordValidation(String password){
        if(password.isEmpty()) return false;
        return !password.matches("[^a-zA-Z0-9_]");
    }
}
