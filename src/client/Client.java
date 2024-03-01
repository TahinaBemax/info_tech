package client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connexion.Db_connect;

public class Client {
    private int idClient;
    private String nom;
    private String adresse;
    private String email;

    public Boolean idAdmin(String mail, String pwd) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id_client FROM clients NATURAL JOIN login WHERE email = ? AND password = ? AND isAdmin = '0'";
            c = Db_connect.getConnection();
            if (c != null) {
                pStatement = c.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pStatement.setString(1, email);
                pStatement.setString(2, pwd);
                rs = pStatement.executeQuery();
                rs.last();
                int nbt_rows = rs.getRow();
                rs.beforeFirst();

                if (nbt_rows > 0) {
                    return true;
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
        return false;
    }
    
    //  login
    public static int login(String mail, String pwd) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id_client FROM clients NATURAL JOIN login WHERE email = ? AND password = ?";
            c = Db_connect.getConnection();

            if (c != null) {
                pStatement = c.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pStatement.setString(1, mail);
                pStatement.setString(2, pwd);

                rs = pStatement.executeQuery();
                rs.last();
                int nbt_rows = rs.getRow();
                rs.beforeFirst();

                if (nbt_rows > 0) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
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
        return 0;
    }
    
    public int insert(Client client) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        int affected_rows = 0;

        try {
            String sql = "INSERT INTO clients (nom, adresse, email) VALUES (?, ?, ?)";

            c = Db_connect.getConnection();
            if (c != null) {
                c.setAutoCommit(false);
                pStatement = c.prepareStatement(sql);

                pStatement.setString(1, client.getNom());
                pStatement.setString(2, client.getAdresse());
                pStatement.setString(3, client.getEmail());

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

    public void getById(int id) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM clients WHERE id_client = ?";
            c = Db_connect.getConnection();
            if (c != null) {
                pStatement = c.prepareStatement(sql);
                pStatement.setInt(1, id);
                rs = pStatement.executeQuery();

                if (rs.next()) {
                    this.idClient = rs.getInt("id_client");
                    this.nom = rs.getString("nom");
                    this.adresse =  rs.getString("adresse");
                    this.email = rs.getString("email");
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

    public static Client[] getAll() throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        Client[] clients = null;

        try {
            String sql = "SELECT * FROM clients";
            c = Db_connect.getConnection();

            if (c != null) {
                pStatement = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = pStatement.executeQuery();
                rs.last();
                clients = new Client[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0; rs.next(); i++) {
                    clients[i] = new Client(
                            rs.getInt("id_client"),
                            rs.getString("nom"),
                            rs.getString("adresse"),
                            rs.getString("email")
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

    public int update(Client client) throws Exception {
        Connection c = null;
        PreparedStatement pStatement = null;
        int affected_rows = 0;

        try {
            String sql = "UPDATE clients SET nom = ?, adresse = ?, email = ? WHERE id_client = ?";

            c = Db_connect.getConnection();
            if (c != null) {
                c.setAutoCommit(false);
                pStatement = c.prepareStatement(sql);

                pStatement.setString(1, client.getNom());
                pStatement.setString(2, client.getAdresse());
                pStatement.setString(3, client.getEmail());
                pStatement.setInt(4, client.getIdClient());

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
            String sql = "DELETE FROM clients WHERE id_client = ?";

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
    public Client(int idClient, String nom, String adresse, String email) {
        this.idClient = idClient;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
    }
    public Client() {
    }
    // Setters
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters
    public int getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }
}
