import client.Client;
import produit.Commande;
import produit.LigneCommande;

public class Main {
    
    public static void main(String[] args) {
        try {
            Client c = new Client();
            c.login("john@example.com", "john");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
