package produit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connexion.Db_connect;

public class Produit {
    private int idProduit;
    private String nom;
    private String description;
    private double prix;
    private int quantite;

    public Produit() {

    }

    // Méthode pour insérer un produit dans la base de données
    public int insert(Produit produit) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        int affected_rows = 0;

        try {
            String sql = "INSERT INTO Produits (nom, description, prix, quantite) VALUES (?, ?, ?, ?)";

            c = Db_connect.getConnection();
            if (c != null) {
                c.setAutoCommit(false);
                pStatement = c.prepareStatement(sql);

                pStatement.setString(1, produit.getNom());
                pStatement.setString(2, produit.getDescription());
                pStatement.setDouble(3, produit.getPrix());
                pStatement.setInt(4, produit.getQuantite());

                affected_rows = pStatement.executeUpdate();
                c.commit();
            }

        } catch (Exception e) {
            if (c != null) {
                c.rollback();
                throw e;
            }
        } finally {
            if (pStatement != null) {
                pStatement.close();
            }
            if (c != null) {
                c.close();
            }
        }
        return affected_rows;
    }

    // Méthode pour récupérer un produit par son identifiant
    public void getById(int id) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Produits WHERE id_produit = ?";
            c = Db_connect.getConnection();
            if (c != null) {
                pStatement = c.prepareStatement(sql);
                pStatement.setInt(1, id);
                rs = pStatement.executeQuery();

                if (rs.next()) {
                    this.setIdProduit(rs.getInt("id_produit"));
                    this.setNom(rs.getString("nom"));
                    this.description = rs.getString("description");
                    this.setPrix(rs.getDouble("prix"));
                    this.setQuantite(rs.getInt("quantite"));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pStatement != null) {
                pStatement.close();
            }
            if (c != null) {
                c.close();
            }
        }
    }
    // select all produit from database
    public static Produit[] getAll() throws Exception , IOException {
        Connection c = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        Produit[] produits = null;

        try {
            String sql = "SELECT * FROM Produits";
            c = Db_connect.getConnection();
            
            if (c != null) {
                pStatement = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = pStatement.executeQuery();
                rs.last();
                produits = new Produit[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0; rs.next() ; i++) {
                    Produit produit = new Produit(
                            rs.getInt("id_produit"),
                            rs.getString("nom"),
                            rs.getString("description"),
                            rs.getDouble("prix"),
                            rs.getInt("quantite")
                    );
                    produits[i] = produit;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pStatement != null) {
                pStatement.close();
            }
            if (c != null) {
                c.close();
            }
        }
        return produits;
    }

    // search by min and max
    public static Produit[] getByPrices(double min, double max) throws Exception , IOException {
        Connection c = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        Produit[] produits = null;

        try {
            String sql = "SELECT * FROM Produits WHERE prix BETWEEN ? AND ?";
            c = Db_connect.getConnection();
            
            if (c != null) {
                pStatement = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pStatement.setDouble(1, min);
                pStatement.setDouble(2, max);
                rs = pStatement.executeQuery();

                rs.last();
                produits = new Produit[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0; rs.next() ; i++) {
                    Produit produit = new Produit(
                            rs.getInt("id_produit"),
                            rs.getString("nom"),
                            rs.getString("description"),
                            rs.getDouble("prix"),
                            rs.getInt("quantite")
                    );
                    produits[i] = produit;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pStatement != null) {
                pStatement.close();
            }
            if (c != null) {
                c.close();
            }
        }
        return produits;
    }
    public static Produit[] getByName(String nom) throws Exception , IOException {
        Connection c = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        Produit[] produits = null;

        try {
            String sql = "SELECT * FROM Produits WHERE nom LIKE ? ";
            c = Db_connect.getConnection();
            
            if (c != null) {
                pStatement = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pStatement.setString(1, "%"+ nom + "%");
                rs = pStatement.executeQuery();
                
                rs.last();
                produits = new Produit[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0; rs.next() ; i++) {
                    Produit produit = new Produit(
                            rs.getInt("id_produit"),
                            rs.getString("nom"),
                            rs.getString("description"),
                            rs.getDouble("prix"),
                            rs.getInt("quantite")
                    );
                    produits[i] = produit;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pStatement != null) {
                pStatement.close();
            }
            if (c != null) {
                c.close();
            }
        }
        return produits;
    }

    // update a produit by his id
    public static int update(Produit produit) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        int affected_rows = 0;

        try {
            String sql = "UPDATE Produits SET nom = ?, description = ?, prix = ?, quantite = ? WHERE id_produit = ?";

            c = Db_connect.getConnection();
            if (c != null) {
                c.setAutoCommit(false);
                pStatement = c.prepareStatement(sql);

                pStatement.setString(1, produit.getNom());
                pStatement.setString(2, produit.getDescription());
                pStatement.setDouble(3, produit.getPrix());
                pStatement.setInt(4, produit.getQuantite());
                pStatement.setInt(5, produit.getIdProduit());

                affected_rows = pStatement.executeUpdate();
                c.commit();
            }

        } catch (Exception e) {
            if (c != null) {
                c.rollback();
                throw e;
            }
        } finally {
            if (pStatement != null) {
                pStatement.close();
            }
            if (c != null) {
                c.close();
            }
        }
        return affected_rows;
    }

    // delete a produit by his id
    public static int delete(int id) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        int affected_rows = 0;

        try {
            String sql = "DELETE FROM Produits WHERE id_produit = ?";

            c = Db_connect.getConnection();
            if (c != null) {
                c.setAutoCommit(false);
                pStatement = c.prepareStatement(sql);
                pStatement.setInt(1, id);

                affected_rows = pStatement.executeUpdate();
                c.commit();
            }

        } catch (Exception e) {
            if (c != null) {
                c.rollback();
                throw e;
            }
        } finally {
            if (pStatement != null) {
                pStatement.close();
            }
            if (c != null) {
                c.close();
            }
        }
        return affected_rows;
    }

    // constructors
    public Produit(int idProduit, String nom, String description, double prix, int quantite) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
    }

    // Setters
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Getters
    public int getIdProduit() {
        return idProduit;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }
}
