/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import dao.AccountDAO;
import dao.IDAO;
import model.Account;

/**
 *
 * @author AnataArisa
 */
public class LoginControler {
    private final IDAO<Account> accountDAO = new AccountDAO();
    
    public boolean checkUserPass(Account data){
        if(data.getUsername() == null || data.getPassword() == null) return false;
        Account dataQuery  =  accountDAO.read(data.getUsername());
        if(dataQuery == null) return false;
        return dataQuery.getPassword().equals(data.getPassword());
    }
    
    public boolean createAccount(Account data){
        if(data.getUsername() == null || data.getPassword() == null || data.getUID() == null) return false;
        data.setRegisterDate();
        data.setLastLoginDate();
        data.setStatus(true);
        accountDAO.create(data);
        return true;
    }
    
}
