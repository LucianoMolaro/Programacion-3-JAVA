package ORMJPQL;


import ORMJPQL.Services.AgendaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
            SpringApplication.run(ORMJPQL.Main.class, args);
    }
}