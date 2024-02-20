<%
    HttpSession user = request.getSession();
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS BOOTSTRAP -->
    <jsp:include page="../inc/bootstrap_css.jsp" />
    <!--  -->
    <!-- my css -->
    <link rel="stylesheet" href="../assets/css/navbar-top.css">
    <!--  -->
    <title>Home</title>
</head>

<body>
    <!-- navbar top fix -->
    <jsp:include page="../inc/navbar-top.jsp" />
    <!--  -->
    <!-- container banner -->
    <div class="container-fluid mt-3 mb-3 h-100 ">
        <!-- BANNER -->
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="../assets/images/banner-1.png" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                  <h5>First slide label</h5>
                  <p>Some representative placeholder content for the first slide.</p>
                </div>
              </div>
              <div class="carousel-item">
                <img src="../assets/images/banner-2.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                  <h5>Second slide label</h5>
                  <p>Some representative placeholder content for the second slide.</p>
                </div>
              </div>
              <div class="carousel-item">
                <img src="../assets/images/banner-3.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                  <h5>Third slide label</h5>
                  <p>Some representative placeholder content for the third slide.</p>
                </div>
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
        </div>
        <!--  -->
    </div>
    <!--  -->

    <!-- filtre -->
    <section class="container mt-3 mb-3 p-3 w-100">
      <div class="filtre-container bg-white p-3 border-3 w-100">
        <h3 class="ml-5">Filtre</h3>
          <form action="" method="post w-100">
              <div class="form-floating prix ">
                <input type="text" class="form-control" id="floatingPassword" placeholder="">
                <label for="floatingPassword">Prix minimum</label>
              </div>
              <div class="form-floating prix">
                <input type="text" class="form-control" id="floatingPassword" placeholder="">
                <label for="floatingPassword">Prix maximum</label>
              </div>
              <div class="form-floating prix">
                  <input type="number" class="form-control" id="floatingInput" placeholder="name@example.com">
                  <label for="floatingInput">Ram</label>
                </div>
                <div class="form-floating prix">
                  <input type="number" class="form-control" id="floatingPassword" placeholder="Password">
                  <label for="floatingPassword">Stockage</label>
                </div>
                <div class="form-floating">
                  <select class="form-select text-align-center" aria-label="Default select example">
                    <option value="" selected>Choisir Marque</option>
                    <option value="0">Iphone</option>
                    <option value="1">Samsung</option>
                    <option value="2">Docomo</option>
                    <option value="3">Redmi</option>
                  </select>
                </div>
                <div class="ml-3">
                  <input type="submit" value="Search" class="btn p-3 pe-5 ps-5 btn-primary">
                </div>
              <!-- <label for="customRange3" class="form-label">A partir de quel prix ?</label>
              <input type="range" class="form-range" min="0" max="5" step="1000" id="customRange3" name="prix"> -->
          </form>
      </div>
    </section>
    <!--  -->
      <!-- Listes phones -->
      <div class="container p-3 d-flex align-items-center justify-content-center bg-white">
          <div class="row">
              <div class="col-12 col-md-6 col-lg-4">
                  <div class="card w-100" style="width: 18rem; height: 376px;">
                      <img src="../assets/images/samsung.jpeg" class="card-img-top" alt="...">
                      <hr>
                      <div class="card-body">
                        <h5 class="card-title">Samsung S20</h5>
                        <p class="card-text">8gb Ram, 250gb stockage</p>
                        <p class="card-text">250$</p>
                        <a href="#" class="btn btn-primary">Acheter</a>
                      </div>
                  </div>
              </div>
              <div class="col-12 col-md-6 col-lg-4">
                  <div class="card w-100" style="width: 18rem; height: 376px;">
                      <img src="../assets/images/samsung.jpeg" class="card-img-top" alt="...">
                      <hr>
                      <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                      </div>
                  </div>
              </div>
              <div class="col-12 col-md-6 col-lg-4 ">
                  <div class="card w-100" style="width: 18rem; height: 376px;">
                      <img src="../assets/images/samsung.jpeg" class="card-img-top" alt="...">
                      <hr>
                      <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                      </div>
                  </div>
              </div>
          </div>
      </div>
    <!--  -->
    <!-- js bootstrap -->
    <jsp:include page="../inc/bootstrap_js.jsp" />
    <!--  -->
</body>

</html>