/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controler.LoginControler;
import java.io.IOException;
import java.io.PrintWriter;
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
public class RegisterServlet extends HttpServlet {
    private LoginControler lc = new LoginControler();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String note = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repass = request.getParameter("repass");
        if(username.isEmpty() || password.isEmpty() || repass.isEmpty()){
            note = "username, password or repass is empty, please check again !!!";
        }else if(lc.checkUsername(username)){
            note = "username is already existed, please choice other name";
        }else if(password.equals(repass)){
            Account acc = new Account();
            acc.setUsername(username);
            acc.setPassword(password);
            acc.setRoles("user");
            acc.setStatus(true);
            lc.createAccount(acc);
            String cookieString = acc.toString();
            Cookie o = new Cookie("user",cookieString);
            response.addCookie(o);
            response.sendRedirect("dashboard");
            return;
        }
        request.setAttribute("note", note);
        request.getRequestDispatcher("view/register.jsp").forward(request, response);
    }

}
