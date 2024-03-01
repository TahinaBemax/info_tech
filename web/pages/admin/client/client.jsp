<%@ page import="client.*" %>
<% 
    if(request.getAttribute("liste_client") != null) { 
        Client[] clients = (Client[]) request.getAttribute("liste_client");
%>    
    <div class="table-responsive pt-3">
        <div class="title">
            <h1>
                <center>Tous les clients</center>
            </h1>
        </div>
        <table class="table table-striped">
            <tr class="success">
                <th class="success">Id</th>
                <th>Nom client</th>
                <th>E-mail</th>
                <th>Adresse</th>
                <th>Modifier</th>
                <th>Supprimer</th>
            </tr>
            <% for(Client c: clients ) { %>
            <tr>
                <td><%= c.getIdClient() %></td>
                <td><%= c.getNom() %></td>
                <td><%= c.getEmail() %></td>
                <td><%= c.getAdresse() %></td>
                <td class="hover">
                    <a href="edit-client-servlet?r=modif&id=<%= c.getIdClient() %>">
                        <i class="bi bi-pen"></i>
                    </a>
                </td>
                <td class="hover">
                    <a href="client-servlet?r=delete&id=<%= c.getIdClient() %>">
                        <i class="bi bi-trash3-fill"></i>
                    </a>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
<% } else { response.sendRedirect("client-servlet?r=liste"); }%>