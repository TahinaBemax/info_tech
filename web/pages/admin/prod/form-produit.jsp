<%@ page import="produit.*" %>
<% 
    if(request.getAttribute("produit") != null){ 
        Produit p = (Produit) request.getAttribute("produit");
%>
        <div class="container-fluid form mb-1 visible" id="form-produit">
            <h2 class="text-dark fw-normal">Produits</h2>
            <form action="produits?r=modif" method="post" class="d-flex flex-direction-column w-100">
                <input type="hidden" name="id_prod" value="<%= p.getIdProduit() %>">
                <div class="form-floating mb-3">
                    <input type="text" name="nom" value="<%= p.getNom() %>" class="form-control" id="nom_produit" placeholder="ex:...">
                    <label for="nom_produit">Produit</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" value="<%= p.getDescription() %>"  name="description" class="form-control" id="description" placeholder="description">
                    <label for="description">Descritpion</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="number" value="<%= p.getPrix() %>" name="prix" class="form-control" id="prix" placeholder="prix" aria-valuemin="0">
                    <label for="prix">Prix</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" value="<%= p.getQuantite() %>" name="qte" class="form-control" id="quantite" placeholder="quantite" aria-valuemin="0">
                    <label for="quantite">Quantite</label>
                </div>
                <div class="form-floating">
                    <input type="submit" class="btn btn-primary pt-3 pb-3 ms-3" id="submit" value="Modifier">
                </div>
            </form>
        </div>
<% } else { response.sendRedirect("produits?r=liste"); } %> 