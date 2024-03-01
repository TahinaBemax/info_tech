<%@ page import="produit.*" %>
<% if(request.getAttribute("liste_commande") != null) { 
    Commande[] commandes = (Commande[]) request.getAttribute("liste_commande");
%>    
    <div class="table-responsive pt-3">
        <div class="title">
            <h1>
                <center>Les clients qui ont fait un commande</center>
            </h1>
        </div>
        <table class="table table-striped">
            <tr class="success">
                <th class="success">Id</th>
                <th>Nom client</th>
                <th>E-mail</th>
                <th>Date commande</th>
                <th>Modifier</th>
                <th>Supprimer</th>
            </tr>
            <% for(Commande c: commandes ) { %>
            <tr>
                <td><%= c.getIdCommande() %></td>
                <td><%= c.getClient().getNom() %></td>
                <td><%= c.getClient().getEmail() %></td>
                <td><%= c.getDateCommandeToString() %></td>
                <td class="hover">
                    <a href="edit-commande?r=modif&id=<%= c.getIdCommande() %>">
                        <i class="bi bi-pen"></i>
                    </a>
                </td>
                <td class="hover">
                    <a href="commande?r=delete&id=<%= c.getIdCommande() %>">
                        <i class="bi bi-trash3-fill"></i>
                    </a>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
<% } else { response.sendRedirect("index.jsp"); }%>