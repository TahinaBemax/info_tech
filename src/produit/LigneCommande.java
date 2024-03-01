package produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import connexion.Db_connect;

public class LigneCommande {
    private int idLigne;
    private Commande commande;
    private Produit produit;
    private int quantite;

    public int insert(LigneCommande ligneCommande) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        int affected_rows = 0;

        try {
            String sql = "INSERT INTO LignesCommande (id_commande, id_produit, quantite) VALUES (?, ?, ?)";

            c = Db_connect.getConnection();
            if (c != null) {
                c.setAutoCommit(false);
                pStatement = c.prepareStatement(sql);

                pStatement.setInt(1, ligneCommande.getCommande().getIdCommande());
                pStatement.setInt(2, ligneCommande.getProduit().getIdProduit());
                pStatement.setInt(3, ligneCommande.getQuantite());

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

    public void getByCommandeId(int idCommande) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM LignesCommande WHERE id_commande = ?";
            c = Db_connect.getConnection();
            if (c != null) {
                pStatement = c.prepareStatement(sql);
                pStatement.setInt(1, idCommande);
                rs = pStatement.executeQuery();

                while (rs.next()) {
                    this.idLigne = rs.getInt("id_ligne");
                    this.commande = new Commande();
                    this.commande.getById(rs.getInt("id_commande"));
                    this.produit = new Produit();
                    this.produit.getById(rs.getInt("id_produit"));
                    this.quantite = rs.getInt("quantite");
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
    
    public static LigneCommande[] getAll() throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        LigneCommande[] clients = null;

        try {
            String sql = "SELECT * FROM LignesCommande";
            c = Db_connect.getConnection();
            if (c != null) {
                pStatement = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = pStatement.executeQuery();
                rs.last();
                clients = new LigneCommande[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0; rs.next(); i++) {
                    clients[i] = new LigneCommande(
                        rs.getInt("id_ligne"),
                        rs.getInt("id_commande"),
                        rs.getInt("id_produit"),
                        rs.getInt("quantite")
                    );
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
        return clients;
    }
    public static int update(LigneCommande ligneCommande) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        int affected_rows = 0;

        try {
            String sql = "UPDATE LignesCommande SET id_commande = ?, id_produit = ?, quantite = ? WHERE id_ligne = ?";

            c = Db_connect.getConnection();
            if (c != null) {
                c.setAutoCommit(false);
                pStatement = c.prepareStatement(sql);

                pStatement.setInt(1, ligneCommande.getCommande().getIdCommande());
                pStatement.setInt(2, ligneCommande.getProduit().getIdProduit());
                pStatement.setInt(3, ligneCommande.getQuantite());
                pStatement.setInt(4, ligneCommande.getIdLigne());

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

    public static int delete(int id) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        int affected_rows = 0;

        try {
            String sql = "DELETE FROM LignesCommande WHERE id_commande = ?";

            c = Db_connect.getConnection();
            if (c != null) {
                c.setAutoCommit(false);
                pStatement = c.prepareStatement(sql);
                pStatement.setInt(1, id);

                affected_rows = pStatement.executeUpdate();

                if (affected_rows > 0) {
                    c.commit();
                    Commande.delete(id);
                }
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
    public LigneCommande(int idLigne, int commande, int produit, int quantite) throws Exception{
        this.idLigne = idLigne;

        this.commande = new Commande();
        this.commande.getById(commande);

        this.produit = new Produit();
        this.produit.getById(produit);
        this.quantite = quantite;
    }
    
    public LigneCommande() {
        //TODO Auto-generated constructor stub
    }

    // Setters
    public void setIdLigne(int idLigne) {
        this.idLigne = idLigne;
    }

    public void setcommande(Commande commande) {
        this.commande = commande;
    }

    public void setproduit(Produit produit) {
        this.produit = produit;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Getters
    public int getIdLigne() {
        return idLigne;
    }

    public Commande getCommande() {
        return commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public int getQuantite() {
        return quantite;
    }
}
