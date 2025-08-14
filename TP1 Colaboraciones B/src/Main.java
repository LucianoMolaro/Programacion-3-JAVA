import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public  static ArrayList<Articulo> articulos = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Articulo azucar = new Articulo(100,"Azucar","u", 20);
        Articulo leche = new Articulo(101,"Leche","u", 30);
        Articulo aceite = new Articulo(102,"Aceite","u", 50);
        Articulo sal = new Articulo(103,"Sal","u", 45);
        Articulo fideos = new Articulo(104,"Fideos","u", 15);
        Articulo arroz = new Articulo(105,"Arroz","u", 28);
        Articulo galletas = new Articulo(106,"Galletas","u", 26);
        Articulo carneMolida = new Articulo(107,"Carne Molida","kg", 220);
        Articulo shampoo = new Articulo(108,"Shampoo","u", 42);
        Articulo quesoMantecoso = new Articulo(109,"Queso Mantecoso","kg", 178);
        Articulo jamonCocido = new Articulo(110,"Jamon Cocido","kg", 320);
        Articulo naranjas = new Articulo(111,"Naranjas","kg", 80);

        articulos.add(azucar);
        articulos.add(leche);
        articulos.add(aceite);
        articulos.add(sal);
        articulos.add(fideos);
        articulos.add(jamonCocido);
        articulos.add(arroz);
        articulos.add(galletas);
        articulos.add(carneMolida);
        articulos.add(shampoo);
        articulos.add(quesoMantecoso);
        articulos.add(naranjas);

        System.out.println("--------------------------------------------------------------------------"+"\n"+ "                                        BIENVENIDO                                            " +  "\n"  + "--------------------------------------------------------------------------");
        while (true){
            Cliente cliente = new Cliente();
            System.out.println("Por favor ingrese sus datos a continuacion.");
            System.out.print("Nombre: ");
            cliente.setNombre(sc.nextLine());
            System.out.print("C.U.I.L: ");
            cliente.setCUIL(Long.parseLong(sc.nextLine()));
            System.out.print("Razon social: ");
            cliente.setRazonSocial(sc.nextLine());

            Factura factura=  new Factura();
            System.out.println("Ahora ingrese los detalles para la facturacion:");
            System.out.print("Tipo de factura(A/B/C): ");
            factura.validarTipo(sc.nextLine());
            System.out.println("Fecha de facturación");
            System.out.print("Dia: ");
            int dia = Integer.parseInt(sc.nextLine());
            System.out.print("Mes: ");
            int mes = Integer.parseInt(sc.nextLine());
            System.out.print("Año: ");
            int anio = Integer.parseInt(sc.nextLine());
            factura.setFecha(new Date(anio, mes, dia));
            System.out.print("Numero de factura: ");
            factura.setNumero(Integer.parseInt(sc.nextLine()));
            System.out.print("Tipo de pago(C/TC/TD): ");
            factura.validarPago(sc.nextLine());



            System.out.println("A continuacion se muestran los articulos disponibles:");
            System.out.println("Codigo" + "\t" + "Denominacion" + "\t"  +  "Precio"  + "\t" + "Medida");
            for (Articulo a : articulos){
                a.mostrarArticulo();
            }

            DetalleFactura detalle = new DetalleFactura();
            System.out.println("Ingrese por código los articulos que desea cargar a la facturación: ");
            int cdg;
            while (true){
                cdg = Integer.parseInt(sc.nextLine());
               if (validarArticulo(cdg)==null){
                   continue;
                };
               Articulo a = validarArticulo(cdg);
                if (a != null) {
                    detalle.setArticulo(a);
                }
                double cantidad = Double.parseDouble(detalle.validacionUnidad(detalle.getArticulo()));
               double subtotal = cantidad * detalle.getArticulo().getPrecio();

               detalle.setCantidad(cantidad);
               detalle.setSubtotal(subtotal);
               factura.agregarDetalle(detalle);
               factura.setTotalItems();
               factura.setTotalFinal();
               cliente.agregarFactura(factura);

                System.out.println("Desea continuar cargando articulos? Escriba no para terminar");
                if(sc.nextLine().equalsIgnoreCase("no")){
                    System.out.println("Cerrando la carga de articulos...");
                    break;
                }
            }
            System.out.println("Carga de articulos finalizada. A continuacion se mostrara la factura.");

            System.out.println("-------------------------------------------- " + factura.getLetra().toUpperCase() + " --------------------------------------------");
            System.out.println("Detalle de facturacion:");
            System.out.println("Fecha: " + factura.getFecha().toString());
            System.out.println("Numero: " + factura.getNumero());
            System.out.println("Tipo de cancelación: " +factura.getTipoPago());
            System.out.println("Recargo: " + factura.getRecargo()*100 + "%");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("Detalle del cliente:");
            System.out.println("Numero de cliente: " + factura.getCliente().getNumero());
            System.out.println("Nombre  del cliente: " + factura.getCliente().getNombre());
            System.out.println("CUIL: " + factura.getCliente().getCUIL());
            System.out.println("Razon social: " + factura.getCliente().getRazonSocial());
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("Detalles de articulos facturados:");
            System.out.println("Articulo" + "\t" + "Denominacion" + "\t" + "Preccio u/kg" + "\t" + "Subtotal");

            break;

        }

    }
    public static Articulo validarArticulo(int cdg){
            for (Articulo a : articulos){
                if (a.getCodigo()==cdg){
                    return a;
                }
            }
            System.out.print("Codigo no encontrado. Ingrese uno válido: ");
            return null;
    }
}
