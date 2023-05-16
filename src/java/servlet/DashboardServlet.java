/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import controler.DashboardControler;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author AnataArisa
 */
public class DashboardServlet extends HttpServlet {
    private final DashboardControler dc = new DashboardControler();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookieLists[] = req.getCookies();
        for(Cookie o: cookieLists){
            if(o.getName().equals("user")){
                String userString = o.getValue();
                try {
                    Account temp = new Account(userString);
                    req.setAttribute("username", temp.getUsername().toUpperCase());
                    if(!temp.getRoles().equals("admin")){
                        req.setAttribute("admin", "none");
                    }else{
                        req.setAttribute("admin", "inline-block");
                        List<Account> data = dc.getAllUserAccount();
                        req.setAttribute("accList", data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                req.getRequestDispatcher("view/dashboard.jsp").forward(req, resp);
                return;
            }
        }
        resp.sendRedirect("login");
    }
    
}
