package tienda.mapper;

import tienda.DTO.PedidoDTO;
import tienda.DTO.ProductoDTO;
import tienda.Repository.ClienteRepository;
import tienda.Repository.PedidoRepository;
import tienda.Repository.ProductoRepository;
import tienda.models.Cliente;
import tienda.models.Pedido;
import tienda.models.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionApp {
    public static String getFechaString(LocalDate fecha){
        return
                "Día " +
                String.valueOf(fecha.getDayOfMonth()) +
                " del mes " + String.valueOf(fecha.getMonth()) +
                " del año " + String.valueOf(fecha.getYear());
    }

    public static void crearPedidos(){
        ClienteRepository cr = new ClienteRepository();
        PedidoRepository pr = new PedidoRepository();
//        ProductoRepository pror = new ProductoRepository();

        Cliente cliente1 = Cliente.builder().nombre("Luciano").email("luciano@mail.com").telefono("3216549872").build();
        
        Cliente cliente2 = Cliente.builder().nombre("Facundo").email("facundo@mail.com").telefono("5649873213").build();
        
        Cliente cliente3 = Cliente.builder().nombre("Marcos").email("marcos@mail.com").telefono("9873216541").build();
        

        Pedido l1 = Pedido.builder().cliente(cliente1).fecha(LocalDate.of(2025,1,5)).build();
        Pedido l2 = Pedido.builder().cliente(cliente1).fecha(LocalDate.of(2025,2,6)).build();
        Pedido l3 = Pedido.builder().cliente(cliente1).fecha(LocalDate.of(2025,3,4)).build();
        

        Pedido f1 = Pedido.builder().cliente(cliente2).fecha(LocalDate.of(2024,4,10)).build();
        Pedido f2 = Pedido.builder().cliente(cliente2).fecha(LocalDate.of(2024,5,12)).build();
        Pedido f3 = Pedido.builder().cliente(cliente2).fecha(LocalDate.of(2024,6,11)).build();

        Pedido m1 = Pedido.builder().cliente(cliente3).fecha(LocalDate.of(2023,7,22)).build();
        Pedido m2 = Pedido.builder().cliente(cliente3).fecha(LocalDate.of(2023,8,20)).build();
        Pedido m3 = Pedido.builder().cliente(cliente3).fecha(LocalDate.of(2023,9,21)).build();

        Producto L1 = Producto.builder().nombre("Arroz").precio(980.25).categoria("Cereales").build();
        Producto L2 = Producto.builder().nombre("Crema de leche").precio(1920.4).categoria("Lacteos").build();
        Producto L3 = Producto.builder().nombre("Leche").precio(1000.8).categoria("Lacteos").build();
        // List<Producto> productos = new ArrayList<>();
        // productos.add(L1);
        // productos.add(L2);
        // productos.add(L3);
        l1.setProductos(List.of(
            L1,L2,L3
        ));
        l1.calcularTotal();
        l1.setCliente(cliente1);
        // pr.guardar(l1);


        Producto L4 = Producto.builder().nombre("Chocolate").precio(2100.6).categoria("Endulzantes").build();
        Producto L5 = Producto.builder().nombre("Oreos").precio(1340.5).categoria("Galletas").build();
        Producto L6 = Producto.builder().nombre("Hamburguesa").precio(2300.3).categoria("Congelados").build();
        // productos.clear();
        // productos.add(L4);
        // productos.add(L5);
        // productos.add(L6);
        l2.setProductos(List.of(
            L4,L5,L6
        ));
        l2.calcularTotal();
        l2.setCliente(cliente1);
        // pr.guardar(l2);

        Producto L7 = Producto.builder().nombre("Leche").precio(1156.1).categoria("Lácteos").build();
        Producto L8 = Producto.builder().nombre("Pan").precio(515.6).categoria("Panadería").build();
        Producto L9 = Producto.builder().nombre("Queso").precio(4505.2).categoria("Lácteos").build();
        // productos.clear();
        // productos.add(L7);
        // productos.add(L8);
        // productos.add(L9);
        l3.setProductos(List.of(
            L7,L8,L9
        ));
        l3.calcularTotal();
        l3.setCliente(cliente1);
        // pr.guardar(l3);
        cliente1.setPedidos(List.of(
            l1,l2,l3
        ));
        cr.guardar(cliente1);


        Producto F1 = Producto.builder().nombre("Manzana").precio(430.3).categoria("Frutas").build();
        Producto F2 = Producto.builder().nombre("Banana").precio(310.3).categoria("Frutas").build();
        Producto F3 = Producto.builder().nombre("Yogur").precio(980.8).categoria("Lácteos").build();
        // productos.clear();
        // productos.add(F1);
        // productos.add(F2);
        // productos.add(F3);
        f1.setProductos(List.of(
            F1,F2,F3
        ));
        f1.calcularTotal();
        f1.setCliente(cliente2);
        // pr.guardar(f1);

        Producto F4 = Producto.builder().nombre("Jamón").precio(2500.2).categoria("Carnes").build();
        Producto F5 = Producto.builder().nombre("Arroz").precio(1105.6).categoria("Despensa").build();
        Producto F6 = Producto.builder().nombre("Fideos").precio(651.8).categoria("Despensa").build();
        // productos.clear();
        // productos.add(F4);
        // productos.add(F5);
        // productos.add(F6);
        f2.setProductos(List.of(
            F4,F5,F6
        ));
        f2.calcularTotal();
        f2.setCliente(cliente2);
        // pr.guardar(f2);

        Producto F7 = Producto.builder().nombre("Carne").precio(4185.6).categoria("Carnes").build();
        Producto F8 = Producto.builder().nombre("Pollo").precio(4856.4).categoria("Carnes").build();
        Producto F9 = Producto.builder().nombre("Huevos").precio(3006.8).categoria("Lácteos").build();
        // productos.clear();
        // productos.add(F7);
        // productos.add(F8);
        // productos.add(F9);
        f3.setProductos(List.of(
            F7,F8,F9
        ));
        f3.calcularTotal();
        f3.setCliente(cliente2);
        // pr.guardar(f3);
        cliente2.setPedidos(List.of(
            f1,f2,f3
        ));
        cr.guardar(cliente2);

        Producto M1 = Producto.builder().nombre("Tomate").precio(1500.6).categoria("Verduras").build();
        Producto M2 = Producto.builder().nombre("Lechuga").precio(201.0).categoria("Verduras").build();
        Producto M3 = Producto.builder().nombre("Cereal").precio(950.6).categoria("Desayuno").build();
        // productos.clear();
        // productos.add(M1);
        // productos.add(M2);
        // productos.add(M3);
        m1.setProductos(List.of(
            M1,M2,M3
        ));
        m1.calcularTotal();
        m1.setCliente(cliente3);
        // pr.guardar(m1);

        Producto M4 = Producto.builder().nombre("Manteca").precio(3211.3).categoria("Lácteos").build();
        Producto M5 = Producto.builder().nombre("Azúcar").precio(1562.2).categoria("Despensa").build();
        Producto M6 = Producto.builder().nombre("Café").precio(4562.3).categoria("Bebidas").build();
        // productos.clear();
        // productos.add(M4);
        // productos.add(M5);
        // productos.add(M6);
        m2.setProductos(List.of(
            M4,M5,M6
        ));
        m2.calcularTotal();
        m2.setCliente(cliente3);
        // pr.guardar(m2);

        Producto M7 = Producto.builder().nombre("Té").precio(456.2).categoria("Bebidas").build();
        Producto M8 = Producto.builder().nombre("Galletas").precio(1565.2).categoria("Panadería").build();
        Producto M9 = Producto.builder().nombre("Aceite").precio(4568.3).categoria("Despensa").build();
        // productos.clear();
        // productos.add(M7);
        // productos.add(M8);
        // productos.add(M9);
        m3.setProductos(List.of(
            M7,M8,M9
        ));
        m3.calcularTotal();
        m3.setCliente(cliente3);
        // pr.guardar(m3);
        cliente3.setPedidos(List.of(
            m1,m2,m3
        ));
        cr.guardar(cliente3);
    }
}
