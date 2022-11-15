package com.example.log4shell;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.sun.deploy.net.HttpRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("uname");
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        if(userName.equals("lita") && password.equals("lita")){
            out.println("Bienvenue sur le site de LITA");
        }
        else{

            // vulnerable code
            Logger logger = LogManager.getLogger(com.example.log4shell.log4j.class);
            logger.error(userName);

            out.println("<code> Le mot de passe ou le nom d'utilisateur que vous avez saisi est incorrect, <u> nous sauvegardons vos informations. </u> </code>");
        }
    }

    public void destroy() {
    }
}