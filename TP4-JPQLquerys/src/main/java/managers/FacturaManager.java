package managers;

import com.mysql.cj.xdevapi.Client;
import jakarta.persistence.*;
import org.example.Articulo;
import org.example.Cliente;
import org.example.Factura;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class FacturaManager {
    EntityManagerFactory emf = null;
    EntityManager em = null;

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

    public Cliente getClienteConMasFacturas(){
        String jpql = "SELECT f.cliente FROM Factura f  GROUP BY f.cliente ORDER BY COUNT(f) DESC";
        Query query = em.createQuery(jpql);
        query.setMaxResults(1);
        Cliente cliente = (Cliente) query.getSingleResult();
        return cliente;
    }

    public List<Factura> getFacturasUltimos3mesesxId(int id){
        String jpql = "SELECT c FROM Factura c WHERE c.cliente.id= :idcliente AND c.fechaComprobante >= :fechaInicio";
        Query query = em.createQuery(jpql);
        LocalDate fechaA = LocalDate.now().minusMonths(3);
        query.setParameter("idcliente", id);
        query.setParameter("fechaInicio", fechaA);
        List<Factura> facturas = query.getResultList();
        return facturas;


    }
}
