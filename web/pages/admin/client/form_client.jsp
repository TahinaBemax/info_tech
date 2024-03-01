<%@ page import="client.*" %>
<% 
    if(request.getAttribute("data_client") != null) { 
        Client c = (Client) request.getAttribute("data_client");
%>  
    <!-- insertion Client -->
    <div class="container-fluid form mb-1 visible" id="form-client">
        <h2 class="text-dark fw-normal">Clients</h2>
        <form action="client-servlet?r=update" method="post" class="d-flex flex-direction-column w-100">
            <input type="hidden" name="id_client" value="<%= c.getIdClient() %>" class="form-control" id="id_client">
            <div class="form-floating mb-3">
                <input type="text" name="nom" value="<%= c.getNom() %>" class="form-control" id="nom" placeholder="nom">
                <label for="nom">Nom client</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" name="adress" value="<%= c.getAdresse() %>" class="form-control" id="adress" placeholder="ex:">
                <label for="adress">Adress</label>
            </div>
            <div class="form-floating mb-3">
                <input type="email" name="email" value="<%= c.getEmail() %>" class="form-control" id="email" placeholder="Ex:">
                <label for="email">E-mail</label>
            </div>
            <div class="form-floating">
                <input type="submit" class="btn btn-primary pt-3 pb-3 ms-3" id="submit" value="Modifier">
            </div>
        </form>
    </div>
    <!--  -->
<% } else { response.sendRedirect("client-servlet?r=liste"); }%>