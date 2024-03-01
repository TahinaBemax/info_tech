package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.Client;

public class Login_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        if (req.getParameter("r") != null && req.getParameter("r").equals("log-out")) {
            HttpSession user = req.getSession();
            user.removeAttribute("user");
            resp.sendRedirect("/magasin/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String mail = "";
            String pwd = "";

            if (req.getParameter("email") != null && req.getParameter("pwd") != null) {
                mail = req.getParameter("email");
                pwd = req.getParameter("pwd");
                int id = Client.login(mail, pwd);
                if (id > 0) {
                    Client c = new Client();
                    c.getById(id);

                    HttpSession session = req.getSession();
                    session.setAttribute("user", c);

                    if (c.idAdmin(mail, pwd)) {
                        resp.sendRedirect("/magasin/pages/admin/produits?r=liste");
                    } else {
                        resp.sendRedirect("../user/home?r=liste");
                    }
                } else {
                    resp.getWriter().write("Adress mail ou mot de passe incorrect");
                }
            }
        } catch (Exception e) {
            resp.getWriter().write("<b>" + e.getMessage() + "</b>");
        }
    }
}
