package tienda.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tienda.models.Cliente;

import java.util.List;


@Getter
@Setter
@Builder
public class PedidoDTO {
    private String clienteNombre;
    private List<ProductoDTO> productos;
    private String fechaPedido;
    private Double total;
}
