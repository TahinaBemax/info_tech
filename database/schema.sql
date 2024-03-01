CREATE DATABASE gestion_magasin;
\c gestion_magasin;

-- Table Produits
CREATE TABLE Produits (
    id_produit SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    description TEXT,
    prix NUMERIC(10, 2) NOT NULL DEFAULT 0,
    quantite INTEGER NOT NULL DEFAULT 1
);

-- Table Clients
CREATE TABLE Clients (
    id_client SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    adresse VARCHAR(255),
    email VARCHAR(100)
);

-- Table Commandes
CREATE TABLE Commandes (
    id_commande SERIAL PRIMARY KEY,
    id_client INTEGER REFERENCES Clients(id_client),
    date_commande TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table LignesCommande
CREATE TABLE LignesCommande (
    id_ligne SERIAL PRIMARY KEY,
    id_commande INTEGER REFERENCES Commandes(id_commande),
    id_produit INTEGER REFERENCES Produits(id_produit),
    quantite INTEGER
);

CREATE TABLE login(
    id_user SERIAL NOT NULL,
    password VARCHAR(40) NOT NULL,
    isAdmin CHAR(1),
    id_client INTEGER UNIQUE NOT NULL REFERENCES Clients(id_client)
);

INSERT INTO login VALUES(DEFAULT,'tahina','0',6);
INSERT INTO login VALUES(DEFAULT,'john','1',1);

