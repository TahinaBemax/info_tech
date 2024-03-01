window.addEventListener("load" , () => {
    var form_produit = document.getElementById("form-produit");
    var form_client = document.getElementById("form-client");

    if (form_produit != null && form_client != null) {
        const btn_form_prod = document.getElementById("btn_prod");
        const btn_form_client = document.getElementById("btn_client");

        if (btn_form_prod != null) {
            btn_form_prod.addEventListener("click", function() {
                display_form(form_produit);
                hide_form(form_client);
            });
        }
        
        if (btn_form_client != null) {
            btn_form_client.addEventListener("click", function() {
                display_form(form_client);
                hide_form(form_produit);
            });
        }
    }

    // Sélectionnez le tableau
    var table = document.getElementById('produits');
    if (table != null) {
        update(table);
    }
});

function display_form(form) {
    if (form.classList.contains("hidden")) {
        // Show the form
        form.classList.remove("hidden");
        form.classList.add("visible");
    } else {
        // Hide the form
        form.classList.remove("visible");
        form.classList.add("hidden");
    }
}

function hide_form(form) {
    if (form.classList.contains("visible")) {
        // Show the form
        form.classList.remove("visible");
        form.classList.add("hidden");
    }
}

function update(table) {
    // Ajoutez un écouteur d'événements pour le double-clic sur le tableau
    table.addEventListener('dblclick', function(event) {
      // Vérifiez si la cible du clic est une cellule de tableau
      if (event.target.tagName === 'TD') {
        // Obtenez la ligne parente de la cellule cliquée
        var row = event.target.parentNode;
    
        // Créez un formulaire pré-rempli avec les valeurs actuelles de la ligne
        // var form = document.createElement('form');
        var form = `<form action="" method="post" id="form_update">`;
        var i = 0;

        var theader = document.getElementById("head");
        var theader_th = theader.querySelectorAll("th");

        row.querySelectorAll('td').forEach(function(cell, index) {
            if (cell.getAttribute("class") != "hover") {
                form += `<td><input type="text" value="${cell.textContent}" name="${theader_th[i].textContent}"></td>`
            }
            i++;
        });
        form +="</form>";
    
        // Remplacez la ligne par le formulaire
        row.innerHTML = form;
        // row.appendChild(form);
      }
    });
}
