package client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Client_servlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            if (req.getParameter("r") != null && req.getParameter("r").equals("liste")) {
                Client[] produits = Client.getAll();
                req.setAttribute("liste_client", produits);
                req.getRequestDispatcher("index.jsp?page=client").forward(req, resp);
            }
            // delete
            if (req.getParameter("r") != null && req.getParameter("r").equals("delete")) {
                    int id = -1;
                    try {
                        id = Integer.parseInt(req.getParameter("id"));
                    } catch (Exception e) {
                        resp.getWriter().write("Impossible de convertir '" + req.getParameter("id") + "' en type Integer");
                        return;
                    }

                    if (Client.delete(id) > 0) {
                        resp.sendRedirect("client-servlet?r=liste");
                    } else {
                        resp.getWriter().write("Une erreur est survenue lors du suppression");
                    }
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

            // update
            if (req.getParameter("r") != null && req.getParameter("r").equals("update")) {
                if (checkData(req, resp)) {
                    int id = -1;
                    try {
                        id = Integer.parseInt(req.getParameter("id_client"));
                    } catch (Exception e) {
                        resp.getWriter().write("Impossible de convertir '" + req.getParameter("id") + "' en type Integer");
                        return;
                    }

                    Client client = new Client(
                        id,
                        req.getParameter("nom"),
                        req.getParameter("adress"),
                        req.getParameter("email")
                    );
    
                    if (client.update(client) > 0) {
                        resp.sendRedirect("client-servlet?r=liste");
                    } else {
                        resp.getWriter().write("Une erreur est survenue lors du modification");
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
