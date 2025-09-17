package EjercicioD;

public class Main {
    public static void main(String[] args) {
        try {
            Barrio barrio1 = new Barrio(1, "Barrio Centro", "Constructora XYZ");

            Vivienda viv1 = new Vivienda(1, "Calle A", 123, 120.0, barrio1);
            Vivienda viv2 = new Vivienda(2, "Calle B", 456, 90.0, barrio1);

            barrio1.addVivienda(viv1);
            barrio1.addVivienda(viv2);

            viv1.addHabitacion(new Habitacion(1, "Dormitorio", 20));
            viv1.addHabitacion(new Habitacion(2, "Cocina", 15));
            viv1.addHabitacion(new Habitacion(3, "Living", 25));

            viv2.addHabitacion(new Habitacion(4, "Dormitorio", 30));
            viv2.addHabitacion(new Habitacion(5, "Baño", 10));

            System.out.println("Superficie total del terreno del barrio: " + barrio1.getSuperficieTotalTerreno());
            System.out.println("Metros cuadrados cubiertos vivienda 1: " + viv1.getMetrosCuadradosCubiertos());
            System.out.println("Metros cuadrados cubiertos vivienda 2: " + viv2.getMetrosCuadradosCubiertos());
            System.out.println("Superficie total cubierta del barrio: " + barrio1.getSuperficieTotalCubierta());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}