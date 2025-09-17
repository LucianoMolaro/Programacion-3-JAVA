package EjercicioA;

public class Main {
    public static void main(String[] args) {
        Expediente exp1 = new Expediente(1001, "A", 27, "aliens", "denuncia", "policial");
        Expediente exp2 = new Expediente(1002, "C", 24, "atentados", "seguimiento", "policial");
        Expediente exp3 = new Expediente(1003, "B", 18, "Pablitox", "desapariciones", "policial");

        EstadoControl estado = new EstadoControl(2, true);
        Control control1 = new Control(100, "Control Legal", true);
        Control control2 = new Control(101, "Control Técnico", false);
        exp1.agregarControl(control1);
        exp2.agregarControl(control2);

        System.out.println("Expediente ID: " + exp1.getId());
        for (Control c : exp1.getControles()) {
            System.out.println("- Control: " + c.getDenominacion() + " (Obligatorio: " + c.isObligatorio() + ")");
        }
        System.out.println("Expediente ID: " + exp2.getId());
        for (Control c : exp2.getControles()) {
            System.out.println("- Control: " + c.getDenominacion() + " (Obligatorio: " + c.isObligatorio() + ")");
        }
    }
}
