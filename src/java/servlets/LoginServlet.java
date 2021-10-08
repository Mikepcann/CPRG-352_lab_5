package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.AccountService;
import models.User;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // check for logout param 
        // if so invalidate the session and display a message telling the user they were logged out
        String logout = request.getParameter("logout");
        if (logout != null && logout.equals("")) {
            // invalidate the session
            session.invalidate();
            
            //display a message telling the user they were logged out
            request.setAttribute("message", "You have been successfully logged out");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        //if one field is missing reload the page and retain the current values
        if((username == null || username.equals("")) ||(password == null ||password.equals("") )){
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
        }
            
        // pass arguments to the account services page
        AccountService ac = new AccountService();
        User user = ac.login(username, password);
        
        if(user != null){
            session.setAttribute("username", username);
            response.sendRedirect("home");
            return;
        } else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            
            request.setAttribute("message", "Invalid Login Credentials");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
            
        }
        
        

    }

}
