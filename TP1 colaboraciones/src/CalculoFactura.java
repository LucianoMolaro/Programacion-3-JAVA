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
        fc.abrirItemsFacturas(cantidadArticulos);

        mostrarArticulos();


        String[][]  items = fc.getItemsFacturas();
        for (int i=0; i<cantidadArticulos;i++){
            System.out.println("Ingrese el codigo del articulo que desea agregar: ");
            String  codigo = sc.nextLine();
            if (buscarCodigo(codigo)!=-1){
                int posicion = buscarCodigo(codigo);
                items[i][i]=articulos[posicion][0];
                items[i][i+1]=articulos[posicion][1];
                items[i][i+2]=articulos[posicion][2];


                String cantidad;
                double subtotal;
                while (true){
                    switch (articulos[posicion][3]){
                        case "U":
                            System.out.println("Ingrese la cantidad de unidades(solo enteros): ");
                            cantidad = sc.nextLine();
                            if (cantidad.contains(".")){
                                System.out.println("Numero incorrecto...");
                                continue;
                            }
                            items[i][3]=cantidad;
                            items[i][4]=String.valueOf(Integer.parseInt(cantidad)*Integer.parseInt(articulos[posicion][2]));
                            break;
                        case "Kg":
                            System.out.println("Ingrese la cantidad de Kg(decimales en Kg): ");
                            cantidad = sc.nextLine();
                            items[i][3]=cantidad;
                            items[i][4]=String.valueOf( Double.parseDouble(cantidad)*Integer.parseInt(articulos[posicion][2]));
                            break;

                    }

                    System.out.println("Producto agregado correctamente.");
                    break;
                }
                continue;
            }
            System.out.println("Codigo incorrecto, por  favor ingrese un codigo valido.");
            i--;
        }
        fc.setItemsFacturas(items);
        double ti=0;
        for (int i=0; i< items.length;i++) ti+= Double.parseDouble(items[i][4]);
        fc.setMontoTotaltems(ti);
        double recargo = ti*0.05;
        fc.setRecargo(recargo);
        fc.setMontoFinal(recargo+ti);






    }
    private static int buscarCodigo(String a){
        for (int i=0; i< articulos.length;i++){
            if (a.equals(articulos[i][0])){
                System.out.println("Producto encontrado...");
                return i;
            }
        }
        return -1;
    }
    private static void mostrarArticulos(){
        System.out.println("Articulos disponibles");
        System.out.println("Codigo articulo" + "\t" + "Nombre articulo" + "\t" + "Precio por Unidad/Kg");
        for (int i=0; i<articulos.length;i++){
            System.out.println(articulos[i][0] + "\t" + "\t"+ "\t"+ "\t"+ articulos[i][1] + "\t" + "\t"+ "\t"+ "\t"+ articulos[i][2]);
        }
    }
}
