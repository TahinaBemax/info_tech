<%@ page import="produit.*" %>
<% if(request.getAttribute("details_commande") != null) { 
    LigneCommande[] commandes = (LigneCommande[]) request.getAttribute("details_commande");
%>    
    <div class="table-responsive pt-3">
        <div class="title">
            <h1>
                <center>Details de tout les commandes</center>
            </h1>
        </div>
        <table class="table table-striped">
            <tr class="success">
                <th class="success">Id</th>
                <th>Nom client</th>
                <th>Nom produit</th>
                <th>Quantite</th>
                <th>Prix Unitaire</th>
                <th>Prix Total</th>
                <th>Modifier</th>
                <th>Supprimer</th>
            </tr>
            <% for(LigneCommande c: commandes ) { %>
            <tr>
                <td><%= c.getIdLigne() %></td>
                <td><%= c.getCommande().getClient().getNom() %></td>
                <td><%= c.getProduit().getNom() %></td>
                <td><%= c.getQuantite() %></td>
                <td><%= c.getProduit().getPrix() %>$</td>
                <td><%= c.getProduit().getPrix() * c.getQuantite() %>$</td>
                <td class="hover">
                    <a href="edit-detail-commande?r=modif&id<%= c.getIdLigne() %>">
                        <i class="bi bi-pen"></i>
                    </a>
                </td>
                <td class="hover">
                    <a href="detail-commande?r=delete&id<%= c.getIdLigne() %>">
                        <i class="bi bi-trash3-fill"></i>
                    </a>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
<% } else { response.sendRedirect("index.jsp"); }%>