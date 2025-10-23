import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) {
        List<Alumno> alumnos = Arrays.asList(
                new Alumno(1001, "Ana", "Pérez", "ana.perez@mail.com",
                        "261-5551111"),
                new Alumno(1002, "Juan", "Gómez", "juan.gomez@mail.com",
                        "261-5552222"),
                new Alumno(1003, "María", "López",
                        "maria.lopez@mail.com", "261-5553333"),
                new Alumno(1004, "Pedro", "Ruiz", "pedro.ruiz@mail.com",
                        "261-5554444"),
                new Alumno(1005, "Lucía", "Fernández",
                        "lucia.fernandez@mail.com", "261-5555555"),
                new Alumno(1006, "Andrés", "Pérez",
                        "andres.perez@mail.com", "261-5556666")
        );

        //Ejercicio 1
        System.out.println("---------------------------------For each de alumnos-----------------------------------");
        alumnos.forEach(a -> System.out.println(a));


        //Ejercicio 2
        System.out.println("----------------------Alumnos de apellido comenzado con P--------------------------");
        alumnos.stream().filter(a->a.getApellido().startsWith("P")).forEach(System.out::println);

        //Ejercicio 3
        System.out.println("--------------------------------Ordenados por nombre-------------------------------------");
        alumnos.stream().sorted(Comparator.comparing(Alumno::getNombre)).forEach(System.out::println);

        //Ejercicio 4
        System.out.println("-----------------------------------------Emails----------------------------------------------");
        alumnos.stream().map(Alumno::getEmail).forEach(System.out::println);

        //Ejercicio 5
        System.out.println("-----------------------------------------Cantidad----------------------------------------------");
        System.out.println("La cantidad de alumnos es de: " + alumnos.stream().count());

        //Ejercicio 6
        System.out.println("------------------------------------------------------------------------------------------------");
        int legajo = 1010;
        Optional<Alumno> alumnoLegajo = alumnos.stream().filter(a->a.getLegajo()==legajo).findFirst();
        if (alumnoLegajo.isPresent()){
            System.out.println("Alumno de legajo: " + legajo);
            System.out.println(alumnoLegajo);
        }else {
            System.out.println("No se econtro el alumno con legajo: " + legajo);
        }
    }
}