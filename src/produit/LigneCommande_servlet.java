package produit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;

public class LigneCommande_servlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            if (req.getParameter("r") != null && req.getParameter("r").equals("liste")) {
                LigneCommande[] commandes = LigneCommande.getAll();
                req.setAttribute("details_commande", commandes);
                req.getRequestDispatcher("index.jsp?page=ligne_commande").forward(req, resp);
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
        } catch (ServletException se){
            resp.getWriter().write(se.getMessage());
        } catch (IOException ie){
            resp.getWriter().write(ie.getMessage());
        } catch (Exception e) {
            if (e != null) {
                resp.getWriter().write(e.getMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
