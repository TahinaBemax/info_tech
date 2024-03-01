package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import produit.Produit;


public class Produit_s extends HttpServlet{
    public static void liste_produits(HttpServletRequest req, HttpServletResponse resp) throws ServletException, Exception{
        try {
            Produit[] produits = Produit.getAll();
            req.setAttribute("liste_prod", produits);
            req.getRequestDispatcher("index.jsp?r=produit").forward(req, resp);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            if (req.getParameter("r") != null && req.getParameter("r").equals("liste")) {
                liste_produits(req, resp);
            }
            if (req.getParameter("r") != null && req.getParameter("r").equals("delete")) {
                int id = -1;
                // on parse l'id en int
                try {
                    id = Integer.parseInt(req.getParameter("id"));
                } catch (Exception e) {
                    resp.getWriter().write("On ne peut pas parser la chaine : " + req.getParameter("id"));
                }
                // on supprime
                if(Produit.delete(id) > 0){
                    resp.sendRedirect("produits?r=liste");
                } else {
                    resp.getWriter().write("Une erreur est survenue lors de la suppression du produit");   
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
                double prix = 0;
                int qte = 0;
                // on parse l'id en int
                try {
                    prix = Double.parseDouble(req.getParameter("prix"));
                    qte = Integer.parseInt(req.getParameter("qte"));
                } catch (Exception e) {
                    resp.getWriter().write("On ne peut pas parser la chaine : " + req.getParameter("prix") + " ou " + req.getParameter("qte"));
                }

                Produit p = new Produit(
                    0, 
                    req.getParameter("nom"), 
                    req.getParameter("description"), 
                    prix, 
                    qte
                );

                // On insert le nouveau produit
                if (p.insert(p) > 0) {
                    resp.sendRedirect("produits?r=liste");
                } else {
                    resp.getWriter().write("Une erreur est survenue lors de l'insertion du produit"); 
                }
            }
            
            if (req.getParameter("r") != null && req.getParameter("r").equals("modif")) {
                double prix = 0;
                int qte = 0;
                int id = -1;
                // on parse l'id en int
                try {
                    prix = Double.parseDouble(req.getParameter("prix"));
                    qte = Integer.parseInt(req.getParameter("qte"));
                    id = Integer.parseInt(req.getParameter("id_prod"));
                } catch (Exception e) {
                    resp.getWriter().write("On ne peut pas parser la chaine : " + req.getParameter("prix") + " ou " + req.getParameter("qte"));
                }

                Produit p = new Produit(
                    id, 
                    req.getParameter("nom"), 
                    req.getParameter("description"), 
                    prix, 
                    qte
                );

                // On insert le nouveau produit
                if (Produit.update(p) > 0) {
                    resp.sendRedirect("produits?r=liste");
                } else {
                    resp.getWriter().write("Une erreur est survenue lors du modification du produit"); 
                }
            }
        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }
    }

}
