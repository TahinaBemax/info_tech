package produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import client.Client;
import connexion.Db_connect;

public class Commande {
    private int idCommande;
    private Client client;
    private Date dateCommande;

    public Commande() {
    }

    public int insert(Commande commande) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        int last_insertedId = 0;

        try {
            String sql = "INSERT INTO commandes (id_client, date_commande) VALUES (?, ?)";

            c = Db_connect.getConnection();
            if (c != null) {
                c.setAutoCommit(false);
                pStatement = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                pStatement.setInt(1, client.getIdClient());
                pStatement.setTimestamp(2, new java.sql.Timestamp(commande.getDateCommande().getTime()));

                if (pStatement.executeUpdate() > 0) {
                    ResultSet rs = pStatement.getGeneratedKeys();
                    c.commit();
                    
                    if (rs.next()) {
                        last_insertedId = rs.getInt(1);
                    }
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
        return last_insertedId;
    }

    public void getById(int id) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM commandes WHERE id_commande = ?";
            c = Db_connect.getConnection();
            if (c != null) {
                pStatement = c.prepareStatement(sql);
                pStatement.setInt(1, id);
                rs = pStatement.executeQuery();

                if (rs.next()) {
                    this.idCommande = rs.getInt("id_commande");
                    this.client = new Client();
                    this.client.getById(rs.getInt("id_client"));
                    this.setDateCommande(rs.getTimestamp("date_commande"));
                }
            }
        } 
        catch (Exception e){
            throw e;
        }
        finally {
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

    public static Commande[] getAll() throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        Commande[] commandes = null;

        try {
            String sql = "SELECT * FROM commandes";
            c = Db_connect.getConnection();

            if (c != null) {
                pStatement = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = pStatement.executeQuery();
                rs.last();
                commandes = new Commande[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0; rs.next(); i++) {
                    commandes[i] = new Commande(
                            rs.getInt("id_commande"),
                            rs.getInt("id_client"),
                            rs.getTimestamp("date_commande")
                    );
                }
            }
        } 
        catch (Exception e){
            throw e;
        }
        finally {
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
        return commandes;
    }

    public int update(Commande commande) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        int affected_rows = 0;

        try {
            String sql = "UPDATE commandes SET id_client = ?, date_commande = ? WHERE id_commande = ?";

            c = Db_connect.getConnection();
            if (c != null) {
                c.setAutoCommit(false);
                pStatement = c.prepareStatement(sql);

                pStatement.setInt(1, client.getIdClient());
                pStatement.setDate(2,(java.sql.Date) commande.getDateCommande());
                pStatement.setInt(3, commande.getIdCommande());

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
            String sql = "DELETE FROM commandes WHERE id_commande = ?";

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
    public Commande(int idCommande, int idClient, Date dateCommande) throws Exception {
        this.idCommande = idCommande;
        this.client = new Client();
        this.client.getById(idClient);
        this.dateCommande = new Date();
        this.dateCommande = dateCommande;
    }
    // Setters
    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public void setIdClient(Client client) {
        this.client = client;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    // Getters
    public int getIdCommande() {
        return idCommande;
    }

    public Client getClient() {
        return this.client;
    }

    public String getDateCommandeToString() {
        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
        return sdt.format(dateCommande);
    }
    public Date getDateCommande() {
        return dateCommande;
    }
}
