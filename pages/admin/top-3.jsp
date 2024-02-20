<!-- Nav bar -->
<nav class="navbar sticky-top bg-body-tertiary">
    <div class="container-fluid">
        <div class="logo me-auto ms-3">
            <a class="navbar-brand fs-3" href="#">IT UNIVERSITY</a>
        </div>
        <div class="menu_btn">
            <button class="btn btn-white" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample"
                aria-controls="offcanvasExample">
                <i class="bi bi-list fs-2"></i>
            </button>
        </div>
        <div class="offcanvas offcanvas-start bg-dark text-white" tabindex="-1" id="offcanvasExample"
            aria-labelledby="offcanvasExampleLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title text-white" id="offcanvasExampleLabel">MENU</h5>
                <button type="button" class="btn-close" id="btn-close" data-bs-dismiss="offcanvas"
                    aria-label="Close"></button>
            </div>
            <div class="offcanvas-body left_offcanvas-body" id="">
                <hr>
                <h5 class="text-center text-grey mb-3 mt-2">Navigation</h5>
                <hr>
                <ul class="list-menu">
                    <li><a href="#"> <i class="bi bi-house-door-fill me-3"></i> Home</a></li>
                    <li class="dropdown">
                        <a href=""><i class="bi bi-three-dots-vertical me-3"></i> Telephones <i
                                class="bi bi-chevron-down d-inline-block ms-3 fs-10"></i></a>
                        <ul class="dropdown-list">
                            <li><a href="#">Listes</a></li>
                            <li><a href="#">Insertion</a></li>
                            <li><a href="#">Suppression</a></li>
                            <li><a href="#">Modification</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href=""><i class="bi bi-three-dots-vertical me-3"></i> Configurations <i
                                class="bi bi-chevron-down d-inline-block ms-3 fs-10"></i></a>
                        <ul class="dropdown-list">
                            <li><a href="#">Lister</a></li>
                            <li><a href="#">Insertion</a></li>
                            <li><a href="#">Suppression</a></li>
                            <li><a href="#">Modification</a></li>
                        </ul>
                    </li>
                    <!-- <hr>
                        <h5 class="text-center text-grey mb-3 mt-2">About Chart</h5> -->
                    <li><a href="#"><i class="bi bi-pie-chart-fill me-3"></i>Graphiques</a></li>
                    <hr>
                    <li><a href="#"><i class="bi bi-box-arrow-left me-3"></i> Log out</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<!-- Nav bar -->