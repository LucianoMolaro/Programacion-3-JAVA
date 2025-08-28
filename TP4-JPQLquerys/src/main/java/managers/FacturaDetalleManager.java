package managers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.Articulo;
import org.example.FacturaDetalle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacturaDetalleManager {
    EntityManagerFactory emf = null;
    EntityManager em = null;

    public FacturaDetalleManager(boolean anularShowSQL) {
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

    public List<Articulo> getArticulosMasVendidos(){
        String jpql = "SELECT art FROM FacturaDetalle a JOIN a.articulo art GROUP BY art ORDER BY SUM(a.cantidad) DESC";
        Query query = em.createQuery(jpql);
        List<Articulo> articulos = query.getResultList();
        return articulos;
    }
}
