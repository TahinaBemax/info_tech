<%
    HttpSession user = request.getSession();
    if(user.getAttribute("user") == null) {
        response.sendRedirect("/magasin/");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS BOOTSTRAP -->
    <jsp:include page="../../inc/bootstrap_css.jsp" />
    <!--  -->
    <!-- CSS  -->
    <link rel="stylesheet" href="../../assets/css/top-3.css">
    <link rel="stylesheet" href="assets/css/tableau.css">
    <link rel="stylesheet" href="assets/css/form-admin.css">
    <!--  -->
    <title>Home</title>
</head>

<body>
    <jsp:include page="top-3.jsp" />

    <!-- les formulaires -->
    <div class="container form-container border">
        <div class="btns mb-1 d-flex align-items-center border-bottom">
            <p class="border-end p-0"><button id="btn_prod" type="button" class="text-dark btn btn-link">Nouveau produit</button></p>
            <p class="p-0"><button id="btn_client" type="button" class=" text-dark btn btn-link">Nouveau client</button></p>
        </div>
        <!-- insertion Produits-->
        <div class="container-fluid form mb-1 hidden" id="form-produit">
            <h2 class="text-dark fw-normal">Produits</h2>
            <form action="produits?r=insert" method="post" class="d-flex flex-direction-column w-100">
                <input type="hidden" name="id_prod" value="0">
                <div class="form-floating mb-3">
                    <input type="text" name="nom" class="form-control" id="nom_produit" placeholder="ex:...">
                    <label for="nom_produit">Produit</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text"  name="description" class="form-control" id="description" placeholder="description">
                    <label for="description">Descritpion</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="number" name="prix" class="form-control" id="prix" placeholder="prix" aria-valuemin="0">
                    <label for="prix">Prix</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" name="qte" class="form-control" id="quantite" placeholder="quantite" aria-valuemin="0">
                    <label for="quantite">Quantite</label>
                </div>
                <div class="form-floating">
                    <input type="submit" class="btn btn-primary pt-3 pb-3 ms-3" id="submit" value="Ajouter">
                </div>
            </form>
        </div>
        <!--  -->
        <!-- insertion Client -->
        <div class="container-fluid form mb-1 hidden" id="form-client">
            <h2 class="text-dark fw-normal">Clients</h2>
            <form action="client-servlet?r=insert" method="post" class="d-flex flex-direction-column w-100">
                <div class="form-floating mb-3">
                    <input type="text" name="nom" class="form-control" id="nom" placeholder="nom">
                    <label for="nom">Nom client</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" name="adress" class="form-control" id="adress" placeholder="ex:">
                    <label for="adress">Adress</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="email" name="email" class="form-control" id="email" placeholder="Ex:">
                    <label for="email">E-mail</label>
                </div>
                <div class="form-floating">
                    <input type="submit" class="btn btn-primary pt-3 pb-3 ms-3" id="submit" value="Ajouter">
                </div>
            </form>
        </div>
        <!--  -->
    </div>

    <!-- container -->
    <div class="container border row ms-auto  me-auto mt-3">
        <% 
            if(request.getParameter("page") != null){
                // on import la page produit
                if(request.getParameter("page").equals("produit")){ %>
                    <jsp:include page="prod/liste_produits.jsp"/>
                <% }
                // on import le formulaire du produit
                 else if(request.getParameter("page").equals("edit-produit")){ %>
                    <jsp:include page="prod/form-produit.jsp"/>
                <% }

                // on import la page commande
                else if(request.getParameter("page").equals("command")){ %>
                    <jsp:include page="command/liste_commande.jsp"/>
                <% } else if(request.getParameter("page").equals("form-command")){ %>
                    <jsp:include page="command/form_commande.jsp"/>
                <% }

                // on import la page client
                else if(request.getParameter("page").equals("client")){ %>
                    <jsp:include page="client/client.jsp"/>
                <% }
                // on import le formulaire client
                else if(request.getParameter("page").equals("edit-client")){ %>
                    <jsp:include page="client/form_client.jsp"/>
                <% }

                // on import la page detail des commandes
                 else if(request.getParameter("page").equals("ligne_commande")){ %>
                    <jsp:include page="command/ligne_commande.jsp"/>
                <% }
            } else { %>
                <jsp:include page="prod/liste_produits.jsp"/>
        <% } %>
    </div>
    <!--  -->
    <!-- js -->
    <script src="assets/js/script-admin.js"></script>
    <!--  -->
    <!-- js bootstrap -->
    <jsp:include page="../../inc/bootstrap_js.jsp" />
    <!--  -->
</body>

</html>