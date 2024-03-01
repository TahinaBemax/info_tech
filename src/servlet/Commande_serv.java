package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;
import produit.Commande;
import produit.LigneCommande;
import produit.Produit;

public class Commande_serv extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            if (req.getParameter("r") != null && req.getParameter("r").equals("liste")) {
                Commande[] commandes = Commande.getAll();
                req.setAttribute("liste_commande", commandes);
                req.getRequestDispatcher("index.jsp?page=command").forward(req, resp);
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
                if(LigneCommande.delete(id) > 0){
                    resp.sendRedirect("commande?r=liste");
                } else {
                    resp.getWriter().write("Une erreur est survenue lors de la suppression du commande");   
                }
            }

            if (req.getParameter("r") != null && req.getParameter("r").equals("modif")) {

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
                int qte = 1;
                int id_client = 0;
                int id_prod = 0;
                // on parse l'id en int
                try {
                    id_client = Integer.parseInt(req.getParameter("id_client"));
                    qte = Integer.parseInt(req.getParameter("qte"));
                    id_prod = Integer.parseInt(req.getParameter("id_prod"));
                } catch (Exception e) {
                    resp.getWriter().write("On ne peut pas parser la chaine : " + req.getParameter("id_client") + " ou " + req.getParameter("id_prod"));
                }

                LocalDate ld = LocalDate.now();
                Date cur_date = Date.valueOf(ld);

                Commande p = new Commande(0, id_client, cur_date);
                int id = p.insert(p); //id commande
                
                // On insert le nouveau produit
                if (id > 0) {
                    LigneCommande lc = new LigneCommande(0, id, id_prod, qte);
                    if(lc.insert(lc) > 0){
                        resp.sendRedirect("home?r=liste");
                    }
                } else {
                    resp.getWriter().write("Une erreur est survenue lors de l'insertion du produit"); 
                }
            }
            
            if (req.getParameter("r") != null && req.getParameter("r").equals("modif")) {
                int qte = 1;
                int id_client = 0;
                int id_prod = 0;
                int id_commande = 0;
                int id_ligne = 0;
                // on parse l'id_commande en int
                try {
                    id_commande = Integer.parseInt(req.getParameter("id_commande"));
                    id_ligne = Integer.parseInt(req.getParameter("id_ligne"));
                    id_client = Integer.parseInt(req.getParameter("id_client"));
                    qte = Integer.parseInt(req.getParameter("qte"));
                    id_prod = Integer.parseInt(req.getParameter("id_prod"));
                } catch (Exception e) {
                    resp.getWriter().write("On ne peut pas parser la chaine : " + req.getParameter("id_client") + " ou " + req.getParameter("id_prod"));
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date cur_date = new Date(sdf.parse(req.getParameter("date")).getTime());

                Commande commande = new Commande(id_commande, id_client, cur_date);

                // On insert le nouveau produit
                if (commande.update(commande) > 0) {
                    LigneCommande lc = new LigneCommande(id_ligne, id_commande, id_prod, qte);
                    LigneCommande.update(lc);
                    resp.sendRedirect("commande?r=liste");
                } else {
                    resp.getWriter().write("Une erreur est survenue lors du modification du commande"); 
                }
            }
        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }
    }

}
