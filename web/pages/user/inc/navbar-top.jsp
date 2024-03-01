<nav class="navbar sticky-top shadow-lg navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="B" width="30" height="24">
        </a>

        <a class="navbar-brand" href="#">INFO-TECH</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse top-nav" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="home?r=liste">Home</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                        Marque
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Iphone</a></li>
                        <li><a class="dropdown-item" href="#">Samsung</a></li>
                        <li><a class="dropdown-item" href="#">Honor</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/magasin/pages/login/login?r=log-out">Deconnexion</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true"></a>
                </li>
            </ul>
            <form method="POST" action="home?r=searchByName" class="d-flex" role="search">
                <input class="form-control me-2" name="nom" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>