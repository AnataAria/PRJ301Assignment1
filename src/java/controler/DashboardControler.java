/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import dao.AccountDAO;
import dao.IDAO;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author AnataArisa
 */
public class DashboardControler {
    IDAO<Account> account = new AccountDAO();
    public List<Account> getAllUserAccount(){
        List<Account> temp = account.getAll();
        List<Account>data = new ArrayList();
        if(temp!= null){
            for(Account a: temp){
                if(a.getRoles().equals("user")) data.add(a);
            }
        }
        return data;
    }
}
