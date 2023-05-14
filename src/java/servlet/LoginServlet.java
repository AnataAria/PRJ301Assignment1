/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import controler.LoginControler;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
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
public class LoginServlet extends HttpServlet {

    private LoginControler lc = new LoginControler();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account reqdata = new Account(username, password);
        if (lc.checkUserPass(reqdata)) {
            reqdata = lc.searchAccount(username);
            reqdata.setLastLoginDate();
            lc.updateAccount(reqdata);
            Cookie user = new Cookie("user", reqdata.toString());
            System.out.println(user.getValue());
            resp.addCookie(user);
            resp.sendRedirect("dashboard");
            return;
        }
        req.setAttribute("note", "username or password isn't correct, please try again");
        req.getRequestDispatcher("view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookieLists = req.getCookies();
        if (cookieLists != null) {
            for (Cookie o : cookieLists) {
                if (o.getName().equals("user")) {
                    String userString = o.getValue();
                    try {
                        Account temp = new Account(userString);
                        if (lc.checkUsername(temp.getUsername())) {
                            resp.addCookie(o);
                            resp.sendRedirect("dashboard");
                            return;
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } 
        req.getRequestDispatcher("view/login.jsp").forward(req, resp);
    }

}
