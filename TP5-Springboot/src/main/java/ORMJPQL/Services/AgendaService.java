package ORMJPQL.Services;

import ORMJPQL.Repository.AgendaRepository;
import ORMJPQL.Models.Agenda;
//import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
//import org.slf4j.LoggerFactory;
//import ch.qos.logback.classic.Level;
//import ch.qos.logback.classic.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository ar;

    private List<Agenda> contactos = new ArrayList<>();

    public AgendaService() {
        contactos.add(new Agenda("Messi", "Calle 1", "lionel@mail.com", "Lionel", 111111111L));
        contactos.add(new Agenda("Gomez", "Calle 2", "alejandro@mail.com", "Alejandro", 222222222L));
        contactos.add(new Agenda("Paredes", "Calle 3", "leandro@mail.com", "Leandro", 333333333L));
        contactos.add(new Agenda("Alvarez", "Calle 4", "Julian@mail.com", "Julian", 444444444L));
        contactos.add(new Agenda("Yamal", "Calle 5", "lamine@mail.com", "Lamine", 555555555L));
        contactos.add(new Agenda("Busquets", "Calle 6", "sergio@mail.com", "Sergio", 666666666L));
    }

    @Transactional
    public void guardarTodos(){
        for (Agenda a : contactos){
            ar.crearContacto(a);
        }
    }

    @Transactional //no necesito obbtener conexion gettransaction ni cerrar emclose
    public List<Agenda> listar(){
        return contactos;
    }

    @Transactional
    public List<Agenda> mostrarTodos(){
        return ar.mostrarTodosLosContactos();
    }


    @Transactional()
    public Agenda buscarPorId(Long id) {
        return ar.obtenerPorId(id);
    }

    @Transactional()
    public List<Agenda> buscarNombreOApellido(String noa) {
        return ar.buscarNombreOApellido(noa);
    }

    @Transactional
    public void agregarContacto(Agenda agenda) {
        ar.agregarAgenda(agenda);
    }

    @Transactional
    public Agenda actualizarCompleto(Agenda agenda) {
        return ar.actualizarAgenda(agenda);
    }

    @Transactional
    public void eliminarId(Long id){
        ar.eliminarPorId(id);
    }



}
