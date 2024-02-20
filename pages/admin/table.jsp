<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS BOOTSTRAP -->
    <jsp:include page="../../inc/bootstrap_css.jsp" />
    <!--  -->
    <!-- CSS  -->
    <link rel="stylesheet" href="../../assets/css/tableau.css">
    <link rel="stylesheet" href="../../assets/css/top-3.css">
    <!--  -->
    <title>Home</title>
</head>

<body>
    <jsp:include page="top-3.jsp"/>

    <div class="row">
        <div class="table-responsive pt-3">
            <div class="title">
                <h1>
                    <center>CRUD</center>
                </h1>
            </div>
            <table class="table table-striped">
                <tr class="success">
                    <th class="success">Id</th>
                    <th>Marque</th>
                    <th>Prix</th>
                    <th>Couleur</th>
                    <th>autonomie</th>
                    <th>version</th>
                    <th>ram</th>
                    <th>memoire</th>
                    <th>graphique</th>
                    <th>processeur</th>
                    <th>cam_avant</th>
                    <th>cam_arriere</th>
                    <th>Modifier</th>
                    <th>Supprimer</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Vary</td>
                    <td>1000</td>
                    <td>800</td>
                    <td>Sakafo</td>
                    <td>Vary</td>
                    <td>1000</td>
                    <td>800</td>
                    <td>Sakafo</td>
                    <td>Vary</td>
                    <td>1000</td>
                    <td>800</td>
                    <td class="hover">
                        <a href="#">
                            <i class='bx bxs-pencil'></i>
                        </a>
                    </td>
                    <td class="hover">
                        <a href="#">
                            <i class='bx bxs-trash-alt'></i>
                        </a>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <!-- js bootstrap -->
    <jsp:include page="../../inc/bootstrap_js.jsp" />
    <!--  -->
</body>

</html>