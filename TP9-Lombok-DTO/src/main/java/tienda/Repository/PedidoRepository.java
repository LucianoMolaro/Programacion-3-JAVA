package tienda.Repository;

import jakarta.persistence.*;
import tienda.models.Pedido;
import tienda.models.Producto;

import java.util.List;

public class PedidoRepository {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP9-lombok-dto");
    private EntityManager em=null;


    public PedidoRepository() {

    }

    public List<Pedido> getTodosLosPedidos(){
        em = emf.createEntityManager();
        TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido p", Pedido.class);
        return (List<Pedido>) query.getResultList();
    }

    public void guardar(Pedido p){
        em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }finally {
            em.close();
        }

    }

    public List<Producto> obtenerProductosDeId(String id){
        em = emf.createEntityManager();
        TypedQuery<Producto> query = em.createQuery("SELECT producto FROM Producto p WHERE p.id = :id", Producto.class);
        query.setParameter(":id", id);
        return (List<Producto>) query.getResultList();
    }


}
