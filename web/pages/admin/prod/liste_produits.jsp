<%@ page import="produit.*" %>
<% 
    Produit[] produits = null;
    if(request.getAttribute("liste_prod") != null) {
        produits = (Produit[]) request.getAttribute("liste_prod"); 
%>
    <div class="table-responsive pt-3">
        <div class="title">
            <h1>
                <center>Tous les produits</center>
            </h1>
        </div>
        <table class="table table-striped" id="produits">
            <tr class="success" id="head">
                <th class="success">Id</th>
                <th>Nom produit</th>
                <th>Descritpion</th>
                <th>Prix</th>
                <th>Quantite</th>
                <th>Modifier</th>
                <th>Supprimer</th>
            </tr>
            <% for (Produit p : produits) { %>
                <tr>
                    <td><%= p.getIdProduit() %></td>
                    <td><%= p.getNom() %></td>
                    <td><%= p.getDescription() %></td>
                    <td><%= p.getPrix() %> $</td>
                    <td><%= p.getQuantite() %></td>
                    <td class="hover">
                        <a href="edit-produit?r=modif&id=<%= p.getIdProduit() %>">
                            <i class="bi bi-pen"></i>
                        </a>
                    </td>
                    <td class="hover">
                        <a href="produits?r=delete&id=<%= p.getIdProduit() %>">
                            <i class="bi bi-trash3-fill"></i>
                        </a>
                    </td>
                </tr>
                
            <% } %>
        </table>
    </div>
<% } else { response.sendRedirect("produits?r=liste"); } %> 
