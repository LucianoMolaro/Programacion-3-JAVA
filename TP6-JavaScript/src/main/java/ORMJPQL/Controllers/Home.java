package ORMJPQL.Controllers;

import ORMJPQL.Models.Agenda;
import ORMJPQL.Services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Home {



    public String home() {
        return "index";
    }

/*    @PostMapping("/")
    public void guardar(){
        as.guardarTodos();
    };*/

}
