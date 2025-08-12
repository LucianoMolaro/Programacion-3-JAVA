import java.util.Scanner;

public class CalculoFactura {
    private static String[][] articulos = {
            {"100","azucar","20","U"},
            {"101","Leche","30","U"},
            {"102","Aceite","50","U"},
            {"103","Sal","45","U"},
            {"104","Fideos","15","U"},
            {"105","Arroz","28","U"},
            {"106","Galletas","26","U"},
            {"107","Carne Molida","220","Kg"},
            {"108","Shampoo","42","U"},
            {"109","Queso mantecoso","178","Kg"},
            {"110","Jamon cocido","320","Kg"},
            {"111","Naranjas","80","Kg"}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cantidadArticulos=0;
        Factura fc = new Factura();
        System.out.println("Ingrese a continuacion los detalles de la factura:");
        System.out.println("Fecha: ");
        fc.setFecha(sc.nextLine());
        System.out.println("CUIT cliente: ");
        fc.setCuitCliente(Long.parseLong(sc.nextLine()));
        System.out.println("Razon social: ");
        fc.setRazonSocial(sc.next());
        String tipoPago;
        do {
            System.out.println("Tipo de pago(C/TC/TD): ");
            tipoPago= sc.nextLine();
        }while (!tipoPago.equalsIgnoreCase("C") && !tipoPago.equalsIgnoreCase("TC") && !tipoPago.equalsIgnoreCase("TD"));
        fc.setTipoPago(tipoPago);
        System.out.println("Numero de factura: ");
        fc.setNroFactura(Long.parseLong(sc.nextLine()));

        System.out.println("Ingrese la cantidad de articulos a agregar(mayor a 0): ");
        do {
            cantidadArticulos=Integer.parseInt(sc.nextLine());
        }while (cantidadArticulos<=0);
        fc.setItemsFacturas(cantidadArticulos);

        mostrarArticulos();





    }
    private static void mostrarArticulos(){
        System.out.println("Articulos disponibles");
        System.out.println("Codigo articulo" + "\t" + "Nombre articulo" + "\t" + "Precio por Unidad/Kg");
        for (int i=0; i<articulos.length;i++){
            System.out.println(articulos[i][0] + "\t" + "\t"+ "\t"+ "\t"+ articulos[i][1] + "\t" + "\t"+ "\t"+ "\t"+ articulos[i][2]);
        }
    }
}
