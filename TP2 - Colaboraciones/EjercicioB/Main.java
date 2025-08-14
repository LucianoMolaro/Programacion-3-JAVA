package EjercicioB;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Luciano", 212313546, "Cordoba 38", "luciano@gmail.com");
        Empleado empleado2 = new Empleado("Facundo", 15648646, "san juan 38", "facundo@gmail.com");

        RegimenHorario regimen1 = new RegimenHorario(19,30,3,0);
        RegimenHorario regimen2 = new RegimenHorario(8,0,15,0);

        empleado.setRegimenHorario(regimen1);
        empleado2.setRegimenHorario(regimen2);


        Asistencia asistencia2 = new Asistencia(19, 50, "I", new Date(2025,6,10));
        Asistencia asistencia4 = new Asistencia(19, 35, "I", new Date(2025,6,11));
        Asistencia asistencia5 = new Asistencia(19, 30, "I", new Date(2025,6,12));
        Asistencia asistencia3 = new Asistencia(19, 45, "I", new Date(2025,7,28));


        empleado.agregarAsistencia(asistencia3);

        empleado2.agregarAsistencia(asistencia2);
        empleado2.agregarAsistencia(asistencia4);
        empleado2.agregarAsistencia(asistencia5);


        System.out.println(asistencia2.getAsistenciasXMesXanio(6,2025));
        System.out.println(empleado2.getDiasConTardanza(6,2025));

    }
}

