package client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Client_servlet2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            if (req.getParameter("r") != null && req.getParameter("r").equals("modif")) {
                Client client = new  Client();
                int id = -1;
                try {
                    id = Integer.parseInt(req.getParameter("id"));
                } catch (Exception e) {
                    resp.getWriter().write("Impossible de convertir '" + req.getParameter("id") + "' en type Integer");
                    return;
                }
                
                client.getById(id);
                req.setAttribute("data_client", client);
                req.getRequestDispatcher("index.jsp?page=edit-client").forward(req, resp);
            }
        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            if (req.getParameter("r") != null && req.getParameter("r").equals("insert")) {
                if (checkData(req, resp)) {
                    Client client = new Client(0,
                        req.getParameter("nom"),
                        req.getParameter("adress"),
                        req.getParameter("email")
                    );
    
                    if (client.insert(client) > 0) {
                        resp.sendRedirect("client-servlet?r=liste");
                    } else {
                        resp.getWriter().write("Une erreur est survenue lors de l'insertion");
                    }
                } else {
                    resp.getWriter().write("Veuillez veririfier les parametres");
                }
            }
        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }
    }


    private boolean checkData(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        boolean reponse = true;
        if (req.getParameter("nom") == null) {
            resp.getWriter().write("La parametre 'nom' est n'existe pas\n");
            reponse = false;
        }

        if (req.getParameter("adress") == null) {
            resp.getWriter().write("La parametre 'adress' est n'existe pas\n");
            reponse = false;
        }

        if (req.getParameter("email") == null) {
            resp.getWriter().write("La parametre 'email' est n'existe pas\n");
            reponse = false;
        }
        return reponse;
    }
}
