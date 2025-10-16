package tienda.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tienda.models.Cliente;

public class ClienteRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP9-lombok-dto");
    private EntityManager em=null;


    public ClienteRepository() {
    }

    public void guardar(Cliente c){
        em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }  finally {
            em.close();
        }

    }
}
