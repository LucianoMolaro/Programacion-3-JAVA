import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Sector
        Sector sector1 = new Sector(101, "Informática", "Técnico");

        // Persona
        Persona persona1 = new Persona("Marcos Vega", "DNI", 123456, 1122334455, "marcos@mail.com", "11223344",sector1);
        persona1.setSector(sector1);

        // Tipo de actividades
        TipoActividad tipo1 = new TipoActividad(1, "Capacitación", 10.5);
        TipoActividad tipo2 = new TipoActividad(2, "Reunión", 5.0);
        TipoActividad tipo3 = new TipoActividad(3, "Proyecto Especial", 20.0);

        // Actividades
        Actividad act1 = new Actividad(new Date(), new Date(), "Curso Java", "Capacitación intensiva",persona1, tipo1);
        Actividad act2 = new Actividad(new Date(), new Date(), "Reunión semanal", "Planificación",persona1, tipo2);
        Actividad act3 = new Actividad(new Date(), new Date(), "Implementación sistema", "Proyecto clave",persona1, tipo3);

        List<Actividad> actividades = new ArrayList<>();

        actividades.add(act1);
        actividades.add(act2);
        actividades.add(act3);

        persona1.setActividades(actividades);

        // Subsectores
        Sector sub1 = new Sector(102, "Soporte", "Técnico");
        Sector sub2 = new Sector(103, "Desarrollo", "Técnico");
        Sector sub3 = new Sector(104, "Testing", "Técnico");

        sector1.addSubsector(sub1);
        sector1.addSubsector(sub2);

        // Probar el método
        System.out.println("Total de puntos asignados: " + persona1.totalPuntosAsignados());
        System.out.println(persona1.totalPuntosAsignados(1));
        System.out.println(persona1.totalPuntosAsignados(2,2025));
        System.out.println(sector1.obtenerTotalSubsectores());
    }
}
