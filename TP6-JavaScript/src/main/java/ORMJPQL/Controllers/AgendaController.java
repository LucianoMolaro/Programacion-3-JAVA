package ORMJPQL.Controllers;

import ORMJPQL.Models.Agenda;
import ORMJPQL.Services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda/contactos")
public class AgendaController {


    @Autowired
    private AgendaService as;


    @GetMapping
    public List<Agenda> mostrarTodos() {
        return as.mostrarTodos();
    }


    @GetMapping("/{id}")
    public Agenda buscarPorId(@PathVariable Long id) {
        return as.buscarPorId(id);
    }


    @GetMapping("/buscar")
    public List<Agenda> buscarNOA(@RequestParam String noa) {
        return as.buscarNombreOApellido(noa);
    }


    @PostMapping
    public void agregarContacto(@ModelAttribute Agenda agenda) {
        System.out.println("recibido: " + agenda);
        as.agregarContacto(agenda);
    }


    @PutMapping("/{id}")
    public Agenda actualizarContacto(@PathVariable Long id, @RequestBody Agenda agenda) {
        agenda.setId(id);
        return as.actualizarCompleto(agenda);
    }


    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id) {
        as.eliminarId(id);
    }



}
