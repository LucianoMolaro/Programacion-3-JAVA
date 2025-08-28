package managers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.Cliente;

import java.util.List;

public class ClienteManager {
    EntityManagerFactory emf = null;
    EntityManager em = null;

    public List<Cliente> getClientes(){
        String jpql = "FROM Cliente";
        Query query = em.createQuery(jpql);
        List<Cliente> clientes = query.getResultList();
        return clientes;
    }
}
