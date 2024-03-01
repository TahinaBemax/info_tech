<%@ page import="produit.*" %>
<%@ page import="client.*" %>
<% 
    Produit[] produits = null;
    if(request.getAttribute("liste_prod") != null) {
        HttpSession sess = request.getSession();
        Client c = (Client) sess.getAttribute("user");

        produits = (Produit[]) request.getAttribute("liste_prod"); 
%>
      <div class="container p-3 d-flex align-items-center justify-content-center bg-white">
          <div class="row w-100">
            <% for (Produit p : produits) { %>
              <div class="col-12 col-md-6 col-lg-4 mb-3">
                  <div class="card w-100" style="width: 18rem; min-height: 376px;">
                      <img src="assets/images/samsung.jpeg" class="card-img-top" alt="...">
                      <hr>
                      <div class="card-body">
                        <h5 class="card-title"><%= p.getNom() %></h5>
                        <p class="card-text"><%= p.getDescription() %></p>
                        <p class="card-text"><%= p.getPrix() %> $</p>
                        <form method="POST" action="commande?r=insert">
                            <input type="hidden" value="<%= p.getIdProduit() %>" name="id_prod">
                            <input type="hidden" value="<%=  c.getIdClient() %>" name="id_client" >
                            <label>Qte : </label>
                            <input type="number" style="width:60px; margin-left:10px" value="1" min="1" max=<%= p.getQuantite() %> name="qte">
                            <input type="submit" class="btn btn-primary" value="Commander">
                        </form>
                      </div>
                  </div>
              </div>
            <% } %>
          </div>
      </div>
<% } else { response.sendRedirect("../home?r=liste"); } %> 