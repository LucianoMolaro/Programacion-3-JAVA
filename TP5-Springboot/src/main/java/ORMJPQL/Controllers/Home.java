package ORMJPQL.Controllers;

import ORMJPQL.Models.Agenda;
import ORMJPQL.Services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Home {
    @GetMapping("/")
    public String home() {
        return "Bienvenido a la API REST!";
    }
}
