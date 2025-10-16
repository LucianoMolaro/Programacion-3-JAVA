package tienda.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import tienda.models.Producto;

public class ProductoRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP9-lombok-dto");
    EntityManager em = null;

    public ProductoRepository() {
    }

    public void guardar(Producto p){
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }finally {
            em.close();
        }

    }
}
