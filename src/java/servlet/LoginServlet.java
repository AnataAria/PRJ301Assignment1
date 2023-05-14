/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import controler.LoginControler;
import java.io.IOException;
import java.time.LocalDate;
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
public class LoginServlet extends HttpServlet{
    private LoginControler lc = new LoginControler();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account reqdata = new Account(username, password);
        if(lc.checkUserPass(reqdata)){
            Cookie userck = new Cookie("userck",username);
            Cookie passck = new Cookie("passck", password);
            
            resp.sendRedirect("dashboard");
            return;
        }
        req.setAttribute("note", LocalDate.now());
        
        req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookieLists =  req.getCookies();
        for(Cookie o: cookieLists){
            if(o.getName().equals("userck")){
                req.setAttribute("username", o.getValue());
                
            }
        }
        req.getRequestDispatcher("view/login.jsp").forward(req, resp);
    }
    
}
