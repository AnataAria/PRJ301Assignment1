/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.text.ParseException;
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


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookieLists[] = req.getCookies();
        for(Cookie o: cookieLists){
            if(o.getName().equals("user")){
                String userString = o.getValue();
                try {
                    Account temp = new Account(userString);
                    req.setAttribute("username", temp.getUsername());
                } catch (ParseException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                req.getRequestDispatcher("view/dashboard.jsp").forward(req, resp);
                break;
            }
        }
        resp.sendRedirect("login");
    }
    
}
