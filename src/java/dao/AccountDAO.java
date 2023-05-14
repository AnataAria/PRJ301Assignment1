/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import my.util.SQLConnection;

/**
 *
 * @author AnataArisa
 */
public class AccountDAO implements IDAO<Account> {
    
    @Override
    public List<Account> getAll() {
        Connection con = SQLConnection.Instance().getConnection();
        List<Account> accList = new ArrayList();
        try{
            Statement sm = con.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM Account;");
            ResultSet rs = sm.executeQuery(sb.toString());
            while(rs.next()){
                Account data= new Account(rs.getString("uid"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("roles"),
                        rs.getDate("registerdate"),
                        rs.getDate("lastregisterdate"),
                        rs.getBoolean("status"));
                accList.add(data);
            }
        }catch(SQLException e){
        }
        return accList;
    }

    @Override
    public void create(Account data) {
        //INSERT INTO TABLE() VALUES ()
        Connection con = SQLConnection.Instance().getConnection();
        try{
            Statement sm = con.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO Account VALUES (")
                    .append(data.getUID())
                    .append(",")
                    .append(data.getUsername())
                    .append(",")
                    .append(data.getPassword())
                    .append(",")
                    .append(data.getRegisterDate())
                    .append(",")
                    .append(data.getLastLoginDate())
                    .append(",")
                    .append(data.getRoles())
                    .append(",")
                    .append(data.getStatus())
                    .append(");");
            sm.executeUpdate(sb.toString());
        }catch(Exception e){
            System.out.println("Failed!!!");
        }
    }

    @Override
    public void update(Account data) {
        Connection con = SQLConnection.Instance().getConnection();
        try{
            Statement sm = con.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE Account SET password = '")
                    .append(data.getPassword())
                    .append("',registerdate = '")
                    .append(data.getRegisterDate())
                    .append("',lastlogindate = '")
                    .append(data.getLastLoginDate())
                    .append("',roles = '")
                    .append(data.getRoles())
                    .append("',status")
                    .append(data.getStatus())
                    .append("' WHERE uid = '")
                    .append(data.getUID())
                    .append("';");
            System.out.println(sb.toString());
            sm.executeUpdate(sb.toString());
        }catch(Exception e){
            System.out.println("Failed!!!");
        }
    }

    @Override
    public void delete(String UID) {
        Connection con = SQLConnection.Instance().getConnection();
        try{
            Statement sm = con.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM Account WHERE uid = '");
            sb.append(UID);
            sb.append("';");
            sm.executeUpdate(sb.toString());
        }catch(SQLException e){
            System.out.println("Failed!!!");
        }
        finally{
            if(con!= null) try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Account read(String username) {
        //SELECT * FROM Account WHERE ...
        Connection con = SQLConnection.Instance().getConnection();
        Account data = null;
        try{
            Statement sm = con.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM Account WHERE username =  '")
                    .append(username)
                    .append("';");
            ResultSet rs = sm.executeQuery(sb.toString());
            while(rs.next()){
                data = new Account(rs.getString("uid"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("roles"),
                        rs.getDate("registerdate"),
                        rs.getDate("lastlogindate"),
                        rs.getBoolean("status"));
            }
        }catch(SQLException e){
        }
        return data;
    }
    
}
