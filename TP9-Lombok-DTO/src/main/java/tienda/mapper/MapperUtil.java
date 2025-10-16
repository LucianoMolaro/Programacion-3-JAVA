package tienda.mapper;

import jakarta.persistence.PersistenceException;
import tienda.DTO.PedidoDTO;
import tienda.DTO.ProductoDTO;
import tienda.models.Pedido;
import tienda.models.Producto;

import java.time.LocalDate;
import java.util.stream.Collectors;


public class MapperUtil {
    public static ProductoDTO toProductoDTO(Producto producto) {
        return ProductoDTO.builder()
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .build();
    }

    public static PedidoDTO toPedidoDTO(Pedido pedido) {
        return PedidoDTO.builder()
                .clienteNombre(pedido.getCliente().getNombre())
                .productos(pedido.getProductos().stream()
                        .map(MapperUtil::toProductoDTO)
                        .collect(Collectors.toList()))
                .total(pedido.getTotal())
                .fechaPedido(FuncionApp.getFechaString(pedido.getFecha()))
                .build();
    }
}


