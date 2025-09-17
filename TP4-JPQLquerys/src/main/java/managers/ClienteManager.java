package managers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.Cliente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteManager {
    EntityManagerFactory emf = null;
    EntityManager em = null;

    public ClienteManager(boolean anularShowSQL) {
        Map<String, Object> properties = new HashMap<>();
        if(anularShowSQL){
            // Desactivar el show_sql (si está activado en el persistence.xml o configuración por defecto)
            properties.put("hibernate.show_sql", "false");
        }else{
            properties.put("hibernate.show_sql", "true");
        }
        emf = Persistence.createEntityManagerFactory("tp4jpql", properties);
        em = emf.createEntityManager();

    }

    public List<Cliente> getClientes(){
        String jpql = "FROM Cliente";
        Query query = em.createQuery(jpql);
        List<Cliente> clientes = query.getResultList();
        return clientes;
    }


}
