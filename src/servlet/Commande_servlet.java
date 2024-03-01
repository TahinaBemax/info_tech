package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;
import produit.Commande;
import produit.LigneCommande;
import produit.Produit;

public class Commande_servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            if (req.getParameter("r") != null && req.getParameter("r").equals("modif")) {
                int id = -1;
                // on parse l'id en int
                try {
                    id = Integer.parseInt(req.getParameter("id"));
                } catch (Exception e) {
                    resp.getWriter().write("On ne peut pas parser la chaine : " + req.getParameter("id"));
                }

                Commande commandes = new Commande();
                commandes.getById(id);

                Produit[] produits = Produit.getAll();
                Client[] clients = Client.getAll();

                LigneCommande lc = new LigneCommande();
                lc.getByCommandeId(id);

                req.setAttribute("commande", commandes);
                req.setAttribute("produits", produits);
                req.setAttribute("clients", clients);
                req.setAttribute("lc", lc);
                req.getRequestDispatcher("index.jsp?page=form-command").forward(req, resp);
            } 
            else if (req.getParameter("r") != null && req.getParameter("r").equals("liste")) {
                Produit[] produits = Produit.getAll();
                req.setAttribute("liste_prod", produits);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            if (req.getParameter("r") != null && req.getParameter("r").equals("search")) {
                double min = 0, max = 0;
                try {
                    min = Double.parseDouble(req.getParameter("min"));
                    max = Double.parseDouble(req.getParameter("max"));
                } catch (Exception e) {
                    resp.getWriter().write("Impossible de convertir les prix en double \n" + e.getMessage());
                    return;
                }

                Produit[] produits = Produit.getByPrices(min, max);
                req.setAttribute("liste_prod", produits);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }

            if (req.getParameter("r") != null && req.getParameter("r").equals("searchByName")) {
                if (req.getParameter("nom") != null) {
                    Produit[] produits = Produit.getByName(req.getParameter("nom"));
                    req.setAttribute("liste_prod", produits);
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                } else {
                    resp.getWriter().write("Le parametre nom est null");
                }
            }
        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }
    }
    
}
