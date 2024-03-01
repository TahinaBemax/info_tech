-- Insert data into Produits table
INSERT INTO Produits (nom, description, prix, quantite) VALUES
('Smartphone', 'High-end smartphone', 799.99, 100),
('Laptop', 'Powerful laptop', 1299.99, 50),
('Tablet', 'Portable tablet', 499.99, 75),
('Smartwatch', 'Fitness smartwatch', 199.99, 150);

-- Insert data into Clients table
INSERT INTO Clients (nom, adresse, email) VALUES
('John Doe', '123 Main St, Anytown', 'john@example.com'),
('Jane Smith', '456 Elm St, Othertown', 'jane@example.com'),
('David Johnson', '789 Oak St, Anycity', 'david@example.com'),
('Emily Brown', '101 Pine St, Othercity', 'emily@example.com');

-- Insert data into Commandes table
INSERT INTO Commandes (id_client, date_commande) VALUES
(1, '2024-02-01 10:00:00'),
(2, '2024-02-02 11:30:00'),
(3, '2024-02-03 09:45:00'),
(4, '2024-02-04 14:20:00');

-- Insert data into LignesCommande table
INSERT INTO LignesCommande (id_commande, id_produit, quantite) VALUES
(1, 1, 2),
(1, 2, 1),
(2, 3, 3),
(3, 1, 1),
(4, 4, 2);
