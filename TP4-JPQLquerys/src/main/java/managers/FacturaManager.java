package managers;

import jakarta.persistence.*;
import org.example.Cliente;
import org.example.Factura;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacturaManager {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    EntityTransaction tx = null;

    public FacturaManager(boolean anularShowSQL) {
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

    public List<Factura> getFacturaDeUltimoMes(){
        String jpql = "SELECT f FROM Factura f WHERE f.fechaComprobante >= :fechaInicio";
        LocalDate haceUnMes = LocalDate.now().minusMonths(1);
        Query query = em.createQuery(jpql);
        query.setParameter("fechaInicio", haceUnMes);
        List<Factura> facturasDelUltimoMes = query.getResultList();
        return facturasDelUltimoMes;
    }


}
