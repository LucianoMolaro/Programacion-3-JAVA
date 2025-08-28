package org.example;

import funciones.FuncionApp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import managers.ClienteManager;
import managers.FacturaDetalleManager;
import managers.FacturaManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp4jpql");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

//
//            UnidadMedida unidad1 =  new UnidadMedida("unidad");
//            em.persist(unidad1);
//            UnidadMedida unidad2 =  new UnidadMedida("Kilogramos");
//            em.persist(unidad2);
//
//            Articulo art1 = new Articulo("Fideos", "2223332225557", 799.99, unidad1);
//            em.persist(art1);
//            Articulo art2 = new Articulo("Arroz", "166666655599", 949.99, unidad1);
//            em.persist(art2);
//            Articulo art3 = new Articulo("Tomate", "77555517722", 6549.0, unidad2);
//            em.persist(art3);
//            HashSet<Articulo> pastas = new HashSet<>();
//            pastas.add(art1);
//
//            HashSet<Articulo> cereales = new HashSet<>();
//            cereales.add(art2);
//
//            HashSet<Articulo> verdura = new HashSet<>();
//            verdura.add(art3);
//
//            Categoria cat1 = new Categoria(false, "Pastas", pastas);
//            em.persist(cat1);
//            Categoria cat2 = new Categoria(false, "Verdura", verdura);
//            em.persist(cat2);
//            Categoria cat3 = new Categoria(false, "Cereales", cereales);
//            em.persist(cat3);
//
//            Cliente cliente1 = new Cliente("20429759650", "Consumidor final");
//            em.persist(cliente1);
//            Cliente cliente2 = new Cliente("20439869751", "Consumidor final");
//            em.persist(cliente2);
//            Cliente cliente3 = new Cliente("20419667749", "Tecnologías Rappi, S.A.P.I.");
//            em.persist(cliente3);
//
//            FacturaDetalle  facturaDetalle = new FacturaDetalle(5, art1);
//            FacturaDetalle facturaDetalle1 = new FacturaDetalle(3, art2);
//            FacturaDetalle  facturaDetalle2 = new FacturaDetalle(1.5, art3);
//            FacturaDetalle facturaDetalle3 = new FacturaDetalle(1, art1);
//            FacturaDetalle facturaDetalle4 = new FacturaDetalle(2, art2);
//            FacturaDetalle  facturaDetalle5 = new FacturaDetalle(2, art3);
//
//
//            Factura factura = new Factura(cliente1, FuncionApp.generateRandomDate(), LocalDateTime.now(), FuncionApp.generateRandomDate(), 2112354564821233L, 5);
//            factura.addDetalleFactura(facturaDetalle);
//            factura.addDetalleFactura(facturaDetalle1);
//            factura.calcularTotal();
//            em.persist(factura);
//
//            Factura factura1 = new Factura(cliente2, FuncionApp.generateRandomDate(), LocalDateTime.now(), FuncionApp.generateRandomDate(), 211894821233L, 4);
//            factura.addDetalleFactura(facturaDetalle2);
//            factura.addDetalleFactura(facturaDetalle3);
//            factura.calcularTotal();
//            em.persist(factura1);
//
//            Factura factura2 = new Factura(cliente3, FuncionApp.generateRandomDate(), LocalDateTime.now(), FuncionApp.generateRandomDate(), 24894156821233L, 3);
//            factura.addDetalleFactura(facturaDetalle4);
//            factura.addDetalleFactura(facturaDetalle5);
//            factura.calcularTotal();
//            em.persist(factura2);

            em.getTransaction().commit();
            FacturaManager facturaManager  = new FacturaManager(true);
            ClienteManager clienteManager = new ClienteManager(true);
            FacturaDetalleManager facturaDetalleManager = new FacturaDetalleManager(true);

            for (Cliente c : clienteManager.getClientes()){
                System.out.println("Cliente ID: " + c.getId() + "\n" +
                        "CUIT: " + c.getCuit() + "\n" +
                        "Razon social: " + c.getRazonSocial()+ "\n"
                );
            }

            for (Factura f : facturaManager.getFacturaDeUltimoMes()){
                System.out.println("N° comprobante: " + f.getNroComprobante() + "\n" +
                        "Cliente: " + f.getCliente().getId() + "\n" +
                        "Fecha: " + f.getFechaComprobante() + "\n"
                        );

            }

            System.out.println("Cliente ID con mas facturas: " + facturaManager.getClienteConMasFacturas().getId() + "\n");

            for (Articulo a : facturaDetalleManager.getArticulosMasVendidos()){
                System.out.println("Articulo: " + a.denominacion);
            }

            em.close();
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}