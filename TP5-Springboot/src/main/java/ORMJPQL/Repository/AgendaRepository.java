package ORMJPQL.Repository;

import ORMJPQL.Models.Agenda;
import ORMJPQL.Services.AgendaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AgendaRepository {

    @PersistenceContext
    private EntityManager em;


    @Autowired
    AgendaService as;

    public AgendaRepository() {
    }

    @Transactional
    public void crearContacto(Agenda a){
        String jpql = "INSERT INTO agenda (nombre, apellido, domicilio, email, telefono) VALUES (?, ?, ?, ?, ?)";
        Query query = em.createNativeQuery(jpql);
        query.setParameter(1, a.getNombre());
        query.setParameter(2, a.getApellido());
        query.setParameter(3, a.getDomicilio());
        query.setParameter(4, a.getEmail());
        query.setParameter(5, a.getTelefono());
        query.executeUpdate();
    }

    public List<Agenda> mostrarTodosLosContactos(){
        return em.createQuery("SELECT a FROM agenda a", Agenda.class).getResultList();
    }

    public Agenda obtenerPorId(Long id){
        return em.find(Agenda.class, id);
    }

    public List<Agenda> buscarNombreOApellido(String noa) {
        String jpql = "SELECT a FROM Agenda a WHERE a.nombre LIKE :filtro OR a.apellido LIKE :filtro";
        TypedQuery<Agenda> query = em.createQuery(jpql, Agenda.class);
        query.setParameter("filtro", "%" + noa + "%");
        return query.getResultList();
    }


    public Agenda agregarContacto(Agenda a){
        String jpql = "INSERT INTO agenda (nombre, apellido, domicilio, email, telefono) VALUES (?, ?, ?, ?, ?)";
        Query query = em.createNativeQuery(jpql);
        query.setParameter(1, a.getNombre());
        query.setParameter(2, a.getApellido());
        query.setParameter(3, a.getDomicilio());
        query.setParameter(4, a.getEmail());
        query.setParameter(5, a.getTelefono());
        query.executeUpdate();
        return (Agenda) query.getSingleResult();
    }

    // a) Todos los ítems
    public List<Agenda> findAll() {
        return em.createQuery("SELECT a FROM Agenda a", Agenda.class).getResultList();
    }

    // b) Buscar por id
    public Agenda findById(Long id) {
        return em.find(Agenda.class, id);
    }

    // d) Insertar
    public void agregarAgenda(Agenda agenda) {
        em.persist(agenda);
    }

    // e) Actualizar
    public Agenda actualizarAgenda(Agenda agenda) {
        return em.merge(agenda);
    }

    // f) Eliminar
    public void eliminarPorId(Long id) {
        Agenda agenda = em.find(Agenda.class, id);
        if (agenda != null) {
            em.remove(agenda);
        }
    }
}
