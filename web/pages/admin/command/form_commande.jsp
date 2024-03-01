<%@ page import="commande.*" %>
<%@ page import="produit.*" %>
<%@ page import="client.*" %>
<% 
    if(request.getAttribute("commande") != null && request.getAttribute("produits") != null && request.getAttribute("clients") != null){ 
        Commande commande = (Commande) request.getAttribute("commande");
        LigneCommande p = (LigneCommande) request.getAttribute("lc");
        Produit[] produits = (Produit[]) request.getAttribute("produits");
        Client[] clients = (Client[]) request.getAttribute("clients");
%>
        <div class="container-fluid form mb-1 visible" id="form-produit">
            <h2 class="text-dark fw-normal">Produits</h2>
            <form action="commande?r=modif" method="post" class="d-flex flex-direction-column w-100">
                <input type="hidden" name="id_commande" value="<%= commande.getIdCommande() %>">
                <input type="hidden" name="id_ligne" value="<%= p.getIdLigne() %>">
                <div class="mb-3">
                    <label for="client">Client</label> <br>
                    <select name="id_client" id="client">
                        <% for(Client c : clients) { 
                        if(commande.getClient().getIdClient() == c.getIdClient() ){ %>
                            <option selected value="<%= c.getIdClient() %>"><%= c.getNom() %></option>
                        <% } else { %>
                        <option value="<%= c.getIdClient() %>"><%= c.getNom() %></option>
                        <% } } %>
                    </select>
                </div>
                <div class=" mb-3">
                    <label for="nom_produit">Produit</label> <br>
                    <select name="id_prod">
                        <% for(Produit prod : produits) { 
                            if(p.getProduit().getIdProduit() == prod.getIdProduit()) { %>
                                <option selected value="<%= prod.getIdProduit() %>"><%= prod.getNom() %></option>
                        <%  } else { %>
                        <option value="<%= prod.getIdProduit() %>"><%= prod.getNom() %></option>
                        <% } } %>
                    </select>
                </div>
                <div class="form-floating mb-3">
                    <input type="date" value="<%= commande.getDateCommandeToString() %>"  name="date" class="form-control" id="date" placeholder="Date">
                    <label for="date">Date du commande</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="number" value="<%= p.getQuantite() %>" name="qte" class="form-control" id="qte" placeholder="qte" aria-valuemin="0">
                    <label for="qte">Quantite</label>
                </div>
                <div class="form-floating">
                    <input type="submit" class="btn btn-primary pt-3 pb-3 ms-3" id="submit" value="Modifier">
                </div>
            </form>
        </div>
<% } else { response.sendRedirect("produits?r=liste"); } %> 